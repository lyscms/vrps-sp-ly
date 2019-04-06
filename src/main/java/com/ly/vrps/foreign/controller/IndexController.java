package com.ly.vrps.foreign.controller;

import com.github.pagehelper.PageInfo;
import com.ly.vrps.common.model.*;
import com.ly.vrps.common.util.DateUtil;
import com.ly.vrps.common.util.Tools;
import com.ly.vrps.foreign.service.*;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 主页
 *
 * @author 10589
 * @date 2016/10/3
 * @time 19:51
 */
@Controller
@RequestMapping("/xl")
@ApiIgnore
public class IndexController {

    @Resource
    private CataLogService cataLogService;

    @Resource
    private SubClassService subClassService;

    @Resource
    private DecadeService decadeService;

    @Resource
    private LevelService levelService;

    @Resource
    private LocService locService;

    @Resource
    private TypeService typeService;

    @Resource
    private FilmService filmService;

    @Resource
    private ResService resService;

    @Resource
    private RatyService ratyService;

    @RequestMapping(value = "/1.html")
    public String index(ModelMap map, HttpServletRequest request){
        getFilmList(map, request,1);
        String cataLog_id = request.getParameter("cataLog_id");
        if(Tools.notEmpty(cataLog_id)){
            List<SubClass> subClassList =  subClassService.listIsUse(cataLog_id);
            map.addAttribute("subClassList",subClassList);
            map.addAttribute("cataLog_id",cataLog_id);
        }

        String subClass_id = request.getParameter("subClass_id");
        if(Tools.notEmpty(subClass_id)){
            List<Type> typeList = typeService.listIsUseBySubClassId(subClass_id);
            map.addAttribute("typeList",typeList);
        }
        getCatalog(map);
        return "index/1";
    }

    @RequestMapping(value = "/pc.html")
    public String pc(ModelMap map, HttpServletRequest request){
        return "index/pc";
    }

    @RequestMapping(value = "/detail.html")
    public String detail(ModelMap map, String film_id, String src, String j, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes){

        Film film = filmService.load(film_id);
        /**判断是否是VIP资源进行VIP身份校验*/
        if(film.getIsVip()==1){
            /**获取当前登录用户*/
            User u_skl = (User)session.getAttribute(AuthenticationController.USER_KEY);
            String referer = request.getHeader("referer");
            if(u_skl!=null){
                if(u_skl.getIsVip()==0){
                    redirectAttributes.addFlashAttribute("error_info","not_vip");
                    return "redirect:"+referer;
                }
            }else{
                redirectAttributes.addFlashAttribute("error_info","not_login");
                return "redirect:"+referer;
            }
        }

        if(Tools.notEmpty(src)){
            map.addAttribute("src",src);
        }
        if(Tools.notEmpty(j)){
            map.addAttribute("j",j);
        }

        List<CataLog> cataLogList =  cataLogService.listIsUse();
        map.addAttribute("cataLogList",cataLogList);
        map.addAttribute("film",film);

        /**
         * 获取该影片总的评分人数
         */
        map.addAttribute("totalRatys",ratyService.getCountByFilm_id(film_id));

        /**
         * 根据类型查询影片
         */

        List<Film> films = filmService.listByTypeId(film.getTypeId());
        map.addAttribute("films",films);

        /**
         * 获取资源
         */
        List<Res> res = resService.listByFilmId(film.getId());


        /**
         * 获取资源
         */
        List<Res> resListEd2k = new ArrayList<>();
        List<Res> resListThunder= new ArrayList<>();
        List<Res> resListHttp= new ArrayList<>();
        List<Res> resListDupan= new ArrayList<>();
        List<Res> resListFlh= new ArrayList<>();
        List<Res> resListOther= new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if("ed2k".equals(res.get(i).getLinkType())&&res.get(i).getIsUse()==1){
                resListEd2k.add(res.get(i));
            }else if("thunder".equals(res.get(i).getLinkType())&&res.get(i).getIsUse()==1){
                resListThunder.add(res.get(i));
            }else if("http".equals(res.get(i).getLinkType())&&res.get(i).getIsUse()==1){
                resListHttp.add(res.get(i));
            }else if("dupan".equals(res.get(i).getLinkType())&&res.get(i).getIsUse()==1){
                resListDupan.add(res.get(i));
            }else if("Flh".equals(res.get(i).getLinkType())&&res.get(i).getIsUse()==1){
                resListFlh.add(res.get(i));
            }else if(res.get(i).getIsUse()==1){
                resListOther.add(res.get(i));
            }
        }
        Collections.sort(resListEd2k, Comparator.comparingInt(Res::getEpisodes));
        Collections.sort(resListThunder, Comparator.comparingInt(Res::getEpisodes));
        Collections.sort(resListHttp, Comparator.comparingInt(Res::getEpisodes));
        Collections.sort(resListDupan, Comparator.comparingInt(Res::getEpisodes));
        Collections.sort(resListFlh, Comparator.comparingInt(Res::getEpisodes));
        Collections.sort(resListOther, Comparator.comparingInt(Res::getEpisodes));

        map.addAttribute("resListEd2k",resListEd2k);
        map.addAttribute("resListThunder",resListThunder);
        map.addAttribute("resListHttp",resListHttp);
        map.addAttribute("resListDupan",resListDupan);
        map.addAttribute("resListFlh",resListFlh);
        map.addAttribute("resListOther",resListOther);
        return "index/detail";
    }


    @RequestMapping(value = "/addRaty.html")
    public  @ResponseBody
    String addRaty(Raty raty){
        JSONObject jsonObject = new JSONObject();
        /*设置时间*/
        raty.setEnTime(DateUtil.getTime());
        if(ratyService.add(raty)!="0"){
            /**
             *  1. 查询出所有该影片的评分
             */
            List<Raty> list = ratyService.listALLByFilmId(raty.getFilmId());
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                count = count+Integer.parseInt(list.get(i).getScore());
            }

            /**
             * 2.总分除于总评分人数
             */
            long tem = count/list.size();

            double evaluation = Math.floor(tem*10d)/10;

            /**
             * 3.更改film的评分
             */
            Film film = filmService.load(raty.getFilmId());
            film.setEvaluation(evaluation);
            if(filmService.update(film)){
                jsonObject.put("code","1");
            }else{
                jsonObject.put("code","0");
            }
        }else{
            jsonObject.put("code","0");
        }
        return jsonObject.toString();

    }
    private void getFilmList(ModelMap map, HttpServletRequest request, int flag) {
        String name = request.getParameter("name");
        if(Tools.notEmpty(name)){
            map.addAttribute("name",name);
        }

        /**
         * 需要修改 3 处地方
         */


        /**
         * 1. 获取页面传递的pc
         * 2. 给定ps的值
         * 3. 使用pc和ps调用service方法，得到PageBean，保存到request域
         * 4. 转发到list.jsp
         */

        /**
         * 把条件截取出来，保存到pb.url中！
         */
        String url = request.getQueryString();
        /**
         * url中有可能存在pc，这需要把pc截取下去，不要它！
         */
        if(url!=null){
            int index = url.lastIndexOf("&pc=");
            if(index == -1) {

            }else{
                url =  url.substring(0, index);
            }
        }

        /**
         * 1. 得到pc
         *   如果pc参数不存在，说明pc=1
         *   如果pc参数存在，需要转换成int类型即可
         */
        String value = request.getParameter("pc");
        int pc = 1;
        if(!Tools.isEmpty(value)){
            pc = Integer.parseInt(value);
        }
        /**
         * 2.给定ps值，每页10行记录
         */
        /**=================需求修改的每页记录数，默认10记录========================*/
        int ps = 18;                                                                     /**1.修改*/

        /**
         * 3. 使用pc和ps调用service方法，得到PageBean，保存到request域
         */

        /**=================需求修改对象参数======================================*/          /**2.修改*/
        // 获取页面传递的查询条件
        Film ob = Tools.toBean(request.getParameterMap(),Film.class);
        if(flag!=0){
            ob.setIsUse(1);
        }
        PageInfo<Film> pb = filmService.getPage(ob, pc, ps);

        //pb.setUrl(url);
             /*存入到request域中*/
        map.addAttribute("pb",pb);
        /**
         * 4. 转发到list.jsp
         */}

    private void getCatalog(ModelMap map) {
        List<CataLog> cataLogList =  cataLogService.listIsUse();
        List<Location> locList = locService.listIsUse();
        List<Level> levelList = levelService.listIsUse();
        List<Decade> decadeList = decadeService.listIsUse();

        //读取路径下的文件返回UTF-8类型json字符串
        map.addAttribute("cataLogList",cataLogList);
        map.addAttribute("locList",locList);
        map.addAttribute("levelList",levelList);
        map.addAttribute("decadeList",decadeList);
    }

}
