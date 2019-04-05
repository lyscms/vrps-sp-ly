package com.ly.imp4m.management.busmanager;

import com.github.pagehelper.PageInfo;
import com.ly.imp4m.common.model.*;
import com.ly.imp4m.foreign.service.*;
import com.ly.imp4m.util.FileOperate;
import com.ly.imp4m.util.Tools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 管理处理
 *
 * @author 10589
 * @date 2016/10/6
 * @time 23:23
 */
@Controller
@Api(value = "业务后台处理")
public class ManagerController {


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
    private VipCodeService vipCodeService;


    /**
     * 目录
     */
    @GetMapping(value = "/catalog.html")
    @ApiOperation(value = "查询目录界面")
    public String catalog(ModelMap map) {
        getCatalog(map);
        return "manager/catalog";
    }

    /**
     * Vip管理
     */
    @GetMapping(value = "/vipCode.html")
    @ApiOperation(value = "Vip管理页面")
    public String vipCode(ModelMap map) {
        getCatalog(map);
        List<VipCode> list = vipCodeService.listIsUse();
        map.addAttribute("vip_codes", list);
        return "manager/vip-manager";
    }

    /**
     * 列表页面
     * @param map
     * @param request
     */
    @ApiOperation(value = "列表页面")
    @GetMapping(value = "/list.html")
    public String list(ModelMap map, HttpServletRequest request) {
        getFilmList(map, request, 0);
        return "manager/list";
    }


    /**
     * 影片管理
     *
     * @param map
     * @param film_id
     * @param session
     * @return
     */
    @GetMapping(value = "/film.html")
    @ApiOperation(value = "影片管理")
    public String film(ModelMap map, String film_id, HttpSession session) {
        if (film_id != null && !"".equals(film_id)) {
            map.addAttribute("film", filmService.load(film_id));
            List<Res> list = resService.listByFilmId(film_id);
            if (list.size() == 0) {
                map.addAttribute("res", null);
            } else {
                map.addAttribute("res", list);
            }
        }
        getCatalog(map);
        return "manager/film";
    }

    /**
     * 影片管理异步操作
     *
     * @param cataLog
     * @param session
     * @return
     */
    @PostMapping(value = "/addCataLog.html")
    @ResponseBody
    @ApiOperation(value = "影片管理异步操作")
    public String addCataLog(CataLog cataLog, HttpSession session) {
        /**
         * 初始化参数
         */
        cataLog.setIsUse(1);

        String id = cataLogService.add(cataLog);

        return id;
    }


    @PostMapping(value = "/addSubClass.html")
    @ResponseBody
    @ApiOperation(value = "添加二级目录")
    public String addSubClass(SubClass subClass, String cataLog_id, HttpSession session) {
        /**
         * 初始化参数
         */
        subClass.setIsUse(1);//设置默认在使用

        //设置上级目录
        subClass.setCatalogId(cataLog_id);

        //添加二级子类目录
        String id = subClassService.add(subClass);

        return id;
    }

    @PostMapping(value = "/addType.html")
    @ResponseBody
    @ApiOperation(value = "添加类型")
    public String addType(Type type, String subClass_id, HttpSession session) {
        /**
         * 初始化参数
         */
        type.setIsUse(1);//设置默认在使用


        //设置上级目录
        type.setSubclassId(subClass_id);

        //添加二级子类目录
        String id = typeService.add(type);
        return id;
    }

    @PostMapping(value = "/addDecade.html")
    public @ResponseBody
    @ApiOperation(value = "添加年代")
    String addDecade(Decade decade) {
        /**
         * 初始化参数
         */
        decade.setIsUse(1);//设置默认在使用

        /**
         * 添加年代
         */
        String id = decadeService.add(decade);
        return id;
    }

    @PostMapping(value = "/addLevel.html")
    @ResponseBody
    @ApiOperation(value = "添加级别")
    public String addLevel(Level level) {
        /**
         * 初始化参数
         */
        level.setIsUse(1);//设置默认在使用

        /**
         * 添加级别
         */
        String id = levelService.add(level);
        return id;
    }


    @PostMapping(value = "/addLoc.html")
    @ResponseBody
    @ApiOperation(value = "添加地区")
    public String addLoc(Location loc) {
        /**
         * 初始化参数
         */
        loc.setIsUse(1);//设置默认在使用

        /**
         * 添加地区
         */
        String id = locService.add(loc);
        return id;
    }

    @PostMapping(value = "/addFilm.html")
    @ResponseBody
    @ApiOperation(value = "添加影片")
    public String addFilm(Film film) {
        /**
         * 初始化参数
         */
        film.setIsUse(1);//设置默认在使用

        /**
         * 添加地区
         */
        String id = filmService.add(film);
        return id;
    }


    /**
     * 添加资源
     *
     * @param res
     * @param filmId
     * @return
     */
    @PostMapping(value = "/addRes.html")
    @ResponseBody
    @ApiOperation(value = "添加资源")
    public String addRes(Res res, String filmId) {
        /**
         * 初始化参数
         */
        res.setIsUse(1);//设置默认在使用

        Film film = filmService.load(filmId);
        res.setFilmId(filmId);
        res.setUpdateTime(new Date());
        /**
         * 多资源上传
         */
        String id = "";
        if (res.getName().contains("@@")) {
            //多资源上传
            String resName[] = res.getName().trim().split("##");//xxxx@@集&集数开始&集数结束&分割符号
            String name = resName[0];
            int begin = Integer.parseInt(resName[1]);
            int end = Integer.parseInt(resName[2]);
            String flag = resName[3];
            String res_link_valArray[] = res.getLink().replaceAll("\\n", "").split(flag);
            int cz = begin - 1;
            for (int x = begin; x <= end; x++) {
                res.setName(name.replace("@@", x + ""));
                res.setEpisodes(x);
                res.setLink(flag + res_link_valArray[x - cz]);
                id = resService.add(res);
            }
        } else {
            /**
             * 添加地区
             */
            id = resService.add(res);
        }

        /**最近更新时间*/
        film.setUpdateTime(new Date());
        filmService.update(film);
        return id;
    }

    /**
     * 更改影片信息
     *
     * @param film_id
     * @param key
     * @param val
     * @return
     */
    @PutMapping(value = "/updateFilmInfo.html")
    @ResponseBody
    @ApiOperation(value = "更改影片信息")
    public String updateFilmInfo(String film_id, String key, String val, HttpSession session) {
        Film film = filmService.load(film_id);
        switch (key) {
            case "name":
                film.setName(val);
                break;
            case "image":
                FileOperate.delFile(session.getServletContext().getRealPath("/" + film.getImage()));
                film.setImage(val);
                break;
            case "onDecade":
                film.setOnDecade(val);
                break;
            case "status":
                film.setStatus(val);
                break;
            case "resolution":
                film.setResolution(val);
                break;
            case "typeName":
                film.setTypeName(val);
                break;
            case "type_id":
                film.setTypeId(val);
                Type type = typeService.load(val);

                SubClass subClass = subClassService.load(type.getSubclassId());
                film.setSubClassId(type.getSubclassId());
                film.setSubClassName(subClass.getName());

                CataLog cataLog = cataLogService.load(subClass.getCatalogId());
                film.setCataLogId(cataLog.getId());
                film.setCataLogName(cataLog.getName());
                break;
            case "actor":
                film.setActor(val);
                break;
            case "locName":
                film.setLocName(val);
                break;
            case "loc_id":
                film.setLocId(val);
                break;
            case "plot":
                film.setPlot(val);
                break;
            case "isVip":
                film.setIsVip(Integer.valueOf(val));
                break;
        }
        boolean isOK = filmService.update(film);
        if (isOK) {
            return "1";
        } else {
            return "0";
        }
    }


    /**
     * 删除资源
     *
     * @param res_id
     * @return
     */
    @DeleteMapping(value = "/delRes.html")
    @ResponseBody
    @ApiOperation(value = "删除资源")
    public  String delRes(String res_id) {
        if (resService.delete(res_id)) {
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * 更新资源在离线
     *
     * @param res_id
     * @return
     */
    @PutMapping(value = "/updateIsUse.html")
    @ResponseBody
    @ApiOperation(value = "更新资源在离线")
    public String updateIsUse(String res_id) {
        if (resService.updateIsUse(res_id)) {
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * 获取subClass二级目录信息
     *
     * @param cataLogId
     * @return
     */
    @GetMapping(value = "/getSubClass.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取subClass二级目录信息")
    public String getSubClass(String cataLogId) {
        List<SubClass> subClasses = subClassService.listByCataLogId(cataLogId);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter((o, s, o1) -> {
            if ("id".equals(s) || "name".equals(s)) {
                return false;
            } else {
                return true;
            }
        });
        JSONArray jsonArray = JSONArray.fromObject(subClasses, jsonConfig);
        return jsonArray.toString();
    }


    /**
     * 获取type类型
     *
     * @param subClass_id
     * @return
     */
    @ApiOperation(value = "获取type类型")
    @GetMapping(value = "/getType.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getType(String subClass_id) {
        List<Type> types = typeService.listBySubClassId(subClass_id);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            @Override
            public boolean apply(Object o, String s, Object o1) {
                if ("id".equals(s) || "name".equals(s)) {
                    return false;
                } else {
                    return true;
                }
            }
        });

        JSONArray jsonArray = JSONArray.fromObject(types, jsonConfig);
        return jsonArray.toString();
    }

    private void getFilmList(ModelMap map, HttpServletRequest request, int flag) {
        String name = request.getParameter("name");
        if (Tools.notEmpty(name)) {
            map.addAttribute("name", name);
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
        if (url != null) {
            int index = url.lastIndexOf("&pc=");
            if (index == -1) {

            } else {
                url = url.substring(0, index);
            }
        }

        /**
         * 1. 得到pc
         *   如果pc参数不存在，说明pc=1
         *   如果pc参数存在，需要转换成int类型即可
         */
        String value = request.getParameter("pc");
        int pc = 1;
        if (!Tools.isEmpty(value)) {
            pc = Integer.parseInt(value);
        }
        /**
         * 2.给定ps值，每页10行记录
         */
        /**=================需求修改的每页记录数，默认10记录========================*/
        int ps = 56;                                                                     /**1.修改*/

        /**
         * 3. 使用pc和ps调用service方法，得到PageBean，保存到request域
         */

        /**=================需求修改对象参数======================================*/          /**2.修改*/
        // 获取页面传递的查询条件
        Film ob = Tools.toBean(request.getParameterMap(), Film.class);
        if (flag != 0) {
            ob.setIsUse(1);
        }
        PageInfo<Film> page = filmService.getPage(ob, pc, ps);

        /*存入到request域中*/
        map.addAttribute("pb", page);
        /**
         * 4. 转发到list.jsp
         */
    }

    private void getCatalog(ModelMap map) {
        List<CataLog> cataLogList = cataLogService.listIsUse();
        List<Type> typeList = typeService.listIsUse();
        List<Location> locList = locService.listIsUse();
        List<Level> levelList = levelService.listIsUse();
        List<Decade> decadeList = decadeService.listIsUse();

        //读取路径下的文件返回UTF-8类型json字符串
        map.addAttribute("cataLogList", cataLogList);
        map.addAttribute("typeList", typeList);
        map.addAttribute("locList", locList);
        map.addAttribute("levelList", levelList);
        map.addAttribute("decadeList", decadeList);
    }


    /**
     * 创建VIPCODE
     *
     * @param num
     * @return
     */
    @PostMapping(value = "/createVipCode.html")
    @ResponseBody
    @ApiOperation(value = "创建VIP CODE")
    public String createVipCode(String num) {
        JSONObject jsonObject = new JSONObject();
        /**生成VIP号*/
        if (StringUtils.isNotBlank(num)) {
            int n = Integer.parseInt(num);
            VipCode vipCode;
            List<VipCode> vipCodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                vipCode = new VipCode();
                vipCode.setCode(Tools.UUID());
                vipCode.setIsUse(1);
                vipCode.setId(Tools.UUID());
                vipCode.setCreateTime(new Date());
                vipCode.setExpireTime(new Date());
                vipCodes.add(vipCode);
            }
            int rtn = vipCodeService.saveAll(vipCodes);
            if (rtn != 0) {
                jsonObject.put("code", "1");
                jsonObject.put("data", vipCodes);
            }
        } else {
            jsonObject.put("code", "0");
        }
        return jsonObject.toString();
    }
}
