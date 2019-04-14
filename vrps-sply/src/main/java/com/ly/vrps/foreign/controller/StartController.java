package com.ly.vrps.foreign.controller;


import com.ly.vrps.common.model.CataLog;
import com.ly.vrps.common.model.Film;
import com.ly.vrps.foreign.service.CataLogService;
import com.ly.vrps.foreign.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

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
@ApiIgnore
public class StartController {
    @Resource
    private FilmService filmService;

    @Resource
    private CataLogService cataLogService;

    @RequestMapping(value = {"/index.html",""})
    public String index(ModelMap map) {
        List<CataLog> cataLogList = cataLogService.listIsUse();
        map.addAttribute("cataLogList", cataLogList);
        /**
         * 查询推荐
         */

        List<List<Film>> list = new ArrayList<>();
        for (int i = 0; i < cataLogList.size(); i++) {

            List<Film> film = filmService.listByCataLogId(cataLogList.get(i).getId());
            if (film.size() != 0) {
                list.add(film);
            }
        }
        map.addAttribute("filmTuijian", list);

        List<Object> list1 = new ArrayList<Object>();
        for (int i = 0; i < cataLogList.size(); i++) {

            List<Film> film = filmService.listByEvaluation(cataLogList.get(i).getId());
            if (film.size() != 0) {
                list1.add(film);
            }
        }
        map.addAttribute("filmPaiHang", list1);
        return "index/home";
    }

    @RequestMapping(value = "/note.html")
    public String note(ModelMap map) {
        List<CataLog> cataLogList = cataLogService.listIsUse();
        map.addAttribute("cataLogList", cataLogList);
        return "index/note";
    }

    @RequestMapping(value = "/error.html")
    public String error() {
        return "index/error";
    }

}
