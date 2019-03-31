package com.ly.imp4m.foreign.controller;

import com.imp4m.entity.CataLog;
import com.imp4m.entity.Film;
import com.imp4m.service.ICataLogService;
import com.imp4m.service.IFilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 开始
 *
 * @author 10589
 * @date 2016/10/6
 * @time 23:34
 */
@Controller
public class Start {
    @Resource
    private IFilmService filmService;

    @Resource
    private ICataLogService cataLogService;

    @RequestMapping(value = "index.html")
    public String index(ModelMap map){
        List<CataLog> cataLogList =  cataLogService.listIsUse();
        map.addAttribute("cataLogList",cataLogList);
        /**
         * 查询推荐
         */

        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < cataLogList.size(); i++) {

            List<Film> film = filmService.listByCataLog_id(cataLogList.get(i).getId());
            if(film.size()!=0){
                list.add(film);
            }
        }
        map.addAttribute("filmTuijian",list);

        List<Object> list1 = new ArrayList<Object>();
        for (int i = 0; i < cataLogList.size(); i++) {

            List<Film> film = filmService.listByEvaluation(cataLogList.get(i).getId());
            if(film.size()!=0){
                list1.add(film);
            }
        }
        map.addAttribute("filmPaiHang",list1);
        return "index/index";
    }

    @RequestMapping(value = "note.html")
    public String note(ModelMap map){
        List<CataLog> cataLogList =  cataLogService.listIsUse();
        map.addAttribute("cataLogList",cataLogList);
        return "index/note";
    }

    @RequestMapping(value = "error.html")
    public String error(ModelMap map){
        return "index/error";
    }

}
