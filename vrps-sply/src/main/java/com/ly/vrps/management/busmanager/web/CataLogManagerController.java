package com.ly.vrps.management.busmanager.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ly.vrps.common.model.*;
import com.ly.vrps.foreign.service.*;
import com.ly.vrps.management.busmanager.vo.CataLogTree;
import com.ly.vrps.management.busmanager.vo.CataLogVo;
import com.ly.vrps.management.busmanager.vo.DecadeInfoVo;
import com.ly.vrps.management.busmanager.vo.LocInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@Api(tags = "目录管理{影视管理:/videoManager}")
@RequestMapping("/catalog/manager")
public class CataLogManagerController {

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

    /**
     * 目录
     */
    @GetMapping(value = {"/catalog.html",""})
    @ApiOperation(value = "目录管理界面")
    public String catalog() {
        return "manager/catalog";
    }


    /**
     * 获取目录树形结构数据
     * @return
     */
    @GetMapping(value = "/cataLog-list.html",produces = "text/html;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取目录树形结构数据")
    public String getCataLogListByTree() {
        String result = JSONArray.fromObject(getCatalog()).toString();
        return result;
    }


    /**
     * 获取分类信息
     * @return
     */
    @PostMapping(value = "/catalog",produces = "text/html;charset=UTF-8")
    @ResponseBody
    @ApiOperation(value = "获取分类信息")
    public String listCatalog() {
        List<CataLog> cataLogs = cataLogService.listIsUse();
        String result = JSONArray.fromObject(cataLogs).toString();
        return result;
    }


    /**
     * 删除分类
     * @return
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    @ApiOperation(value = "删除所有的分类")
    public String delete(@RequestBody CataLogVo cataLogVo) {
        List<String> ids = cataLogVo.getCataIds();
        if(CollectionUtils.isEmpty(ids)){
            return "0";
        }
        for (int i = 0; i < ids.size(); i++) {
            cataLogService.deleteById(ids.get(i));
            subClassService.deleteById(ids.get(i));
            typeService.deleteById(ids.get(i));
        }
        return "1";
    }

    /**
     * 删除地区
     * @return
     */
    @PostMapping(value = "/delete-loc")
    @ResponseBody
    @ApiOperation(value = "删除地区")
    public String deleteLoc(String id) {
        if(StringUtils.isEmpty(id)){
            return "0";
        }
        locService.deleteById(id);
        return "1";
    }

    /**
     * 删除年代
     * @return
     */
    @PostMapping(value = "/delete-decade")
    @ResponseBody
    @ApiOperation(value = "删除地区")
    public String deleteDecade(String id) {
        if(StringUtils.isEmpty(id)){
            return "0";
        }
        decadeService.deleteById(id);
        return "1";
    }

    /**
     * 更新地区
     * @return
     */
    @PostMapping(value = "/update-loc")
    @ResponseBody
    @ApiOperation(value = "更新地区")
    public String updateLoc(Location location) {
        if(StringUtils.isEmpty(location.getId()) || StringUtils.isEmpty(location.getName())){
            return "0";
        }
        locService.update(location);
        return "1";
    }

    /**
     * 更新年代
     * @return
     */
    @PostMapping(value = "/update-decade")
    @ResponseBody
    @ApiOperation(value = "更新地区")
    public String updateDecade(Decade decade) {
        if(StringUtils.isEmpty(decade.getId()) || StringUtils.isEmpty(decade.getName())){
            return "0";
        }
        decadeService.update(decade);
        return "1";
    }


    /**
     * 增加目录
     * @param cataLog
     * @return
     */
    @PostMapping(value = "/addCataLog.html")
    @ResponseBody
    @ApiOperation(value = "增加目录")
    public String addCataLog(CataLog cataLog) {
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
    public String addSubClass(SubClass subClass, String cataLogId) {
        /**
         * 初始化参数
         */
        subClass.setIsUse(1);//设置默认在使用

        //设置上级目录
        subClass.setCatalogId(cataLogId);

        //添加二级子类目录
        String id = subClassService.add(subClass);

        return id;
    }

    @PostMapping(value = "/addType.html")
    @ResponseBody
    @ApiOperation(value = "添加类型")
    public String addType(Type type, String subClassId) {
        /**
         * 初始化参数
         */
        type.setIsUse(1);//设置默认在使用

        //设置上级目录
        type.setSubclassId(subClassId);

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
        return decadeService.add(decade);
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

    @GetMapping(value = "/loc-list")
    @ResponseBody
    @ApiOperation(value = "获取地区信息")
    public LocInfoVo getLoc(Location location, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Location> locations = locService.listIsUse();
        LocInfoVo locInfoVo = new LocInfoVo();
        locInfoVo.setCode("0");
        PageInfo<Location> pageInfo = new PageInfo<>(locations);
        locInfoVo.setCount(Long.valueOf(pageInfo.getTotal()).intValue());
        locInfoVo.setData(locations);
        return locInfoVo;
    }


    @GetMapping(value = "/decade-list")
    @ResponseBody
    @ApiOperation(value = "获取年代信息")
    public DecadeInfoVo getDecade(Decade decade, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Decade> decades = decadeService.listIsUse();
        DecadeInfoVo decadeInfoVo = new DecadeInfoVo();
        decadeInfoVo.setCode("0");
        PageInfo<Decade> pageInfo = new PageInfo<>(decades);
        decadeInfoVo.setCount(Long.valueOf(pageInfo.getTotal()).intValue());
        decadeInfoVo.setData(decades);
        return decadeInfoVo;
    }

    private Collection<CataLogTree> getCatalog() {

        List<CataLogTree> cataLogTrees = new ArrayList<>();

        /**
         * 获取目录节点信息
         */
        List<CataLog> cataLogList = cataLogService.listIsUse();
        List<CataLogTree> cataLogTreeList = cataLogList.stream().map(cataLog -> {
            CataLogTree cataLogTree = new CataLogTree();
            cataLogTree.setId(cataLog.getId());
            cataLogTree.setParentId("0");
            cataLogTree.setName(cataLog.getName());
            return cataLogTree;
        }).collect(Collectors.toList());
        cataLogTrees.addAll(cataLogTreeList);


        /**获取二级目录树形结构*/
        List<SubClass> subClassList = subClassService.listIsUse();
        List<CataLogTree> subClassTreeList = subClassList.stream().map(subClass -> {
            CataLogTree cataLogTree = new CataLogTree();
            cataLogTree.setId(subClass.getId());
            cataLogTree.setParentId(subClass.getCatalogId());
            cataLogTree.setName(subClass.getName());
            return cataLogTree;
        }).collect(Collectors.toList());
        cataLogTrees.addAll(subClassTreeList);

        /**获取类型树形结构*/
        List<Type> typeList = typeService.listIsUse();
        List<CataLogTree> typeTreeList = typeList.stream().map(type -> {
            CataLogTree cataLogTree = new CataLogTree();
            cataLogTree.setId(type.getId());
            cataLogTree.setParentId(type.getSubclassId());
            cataLogTree.setName(type.getName());
            return cataLogTree;
        }).collect(Collectors.toList());
        cataLogTrees.addAll(typeTreeList);


        /*Map<String,CataLogTree> root = new HashMap<>();
        cataLogTrees.forEach(cataLogTree -> {
            if(cataLogTree.getParentId()==null){
                root.put(cataLogTree.getId(),cataLogTree);
            }
        });
        cataLogTrees.removeAll(root.values());*/

        /**
         * 遍历所有子节点
         */
        /*addChildNode(cataLogTrees,root);*/
        return cataLogTrees;
    }

    private void addChildNode(List<CataLogTree> cataLogTrees,Map<String,CataLogTree> parent) {
        Map<String,CataLogTree> tempParent = new HashMap<>();

        List<CataLogTree> oldTree = new ArrayList<>();
        oldTree.addAll(cataLogTrees);

        //如果子节点存在父级节点
        if(!CollectionUtils.isEmpty(cataLogTrees) && !parent.isEmpty()){
            for (int i = 0; i < cataLogTrees.size(); i++) {
                CataLogTree cataLogTree = cataLogTrees.get(i);
                CataLogTree tree = parent.get(cataLogTree.getParentId());
                if (tree != null) {
                    List<CataLogTree> children = parent.get(cataLogTree.getParentId()).getChildren();
                    if (CollectionUtils.isEmpty(children)) {
                        parent.get(cataLogTree.getParentId()).setChildren(new ArrayList<>());
                    }
                    parent.get(cataLogTree.getParentId()).getChildren().add(cataLogTree);
                    tempParent.put(cataLogTree.getId(), cataLogTree);
                    oldTree.remove(cataLogTree);
                }
            }
            addChildNode(oldTree, tempParent);
        }
    }
}
