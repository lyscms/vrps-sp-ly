package com.ly.imp4m.user.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ly.imp4m.common.constants.ReturnStatusConstant;
import com.ly.imp4m.common.model.SysRole;
import com.ly.imp4m.user.service.SysRolePermissionRelationService;
import com.ly.imp4m.user.service.SysRoleService;
import com.ly.imp4m.user.web.vo.SysRoleInfoVo;
import com.ly.imp4m.user.web.vo.SysRolePermissionRelationQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户信息控制层
 * @author sunkl
 * @date 2018/12/5
 */
@Controller
@Api(tags = "角色信息管理{用户管理:/user-manager}")
@RequestMapping("/user/role")
public class UserRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRolePermissionRelationService sysRolePermissionRelationService;

    @ApiOperation(value = "获取角色列表")
    @GetMapping
    public String sysRoleInfo(){
        return "user/sys-role-info";
    }

    @ApiOperation(value = "查询指定角色信息")
    @GetMapping("/get-sys-role-info/{id}")
    @ResponseBody
    public SysRole getSysRoleInfo(@PathVariable("id") @ApiParam(name = "id",value = "主键id") String id){
        return sysRoleService.getSysRoleInfo(id);
    }

    @ApiOperation(value = "查询所有角色信息")
    @GetMapping("/get-all-sys-role-info")
    @ResponseBody
    public List<SysRole> getAllSysRoleInfo(){
        return sysRoleService.selectSysRoleInfo(new SysRole());
    }

    @ApiOperation(value = "分页查询角色信息")
    @GetMapping("/select-sys-role-info")
    @ResponseBody
    public SysRoleInfoVo selectSysRoleInfo(SysRole sysRole, int page, int limit){
        PageHelper.startPage(page,limit);
        List<SysRole> sysRoleInfos = sysRoleService.selectSysRoleInfo(sysRole);
        PageInfo pageInfo1 = new PageInfo(sysRoleInfos);
        SysRoleInfoVo sysRoleInfoVo = new SysRoleInfoVo();
        sysRoleInfoVo.setCode("0");
        sysRoleInfoVo.setCount(Long.valueOf(pageInfo1.getTotal()).intValue());
        sysRoleInfoVo.setData(sysRoleInfos);
        return sysRoleInfoVo;
    }

    @ApiOperation(value = "添加/编辑用户角色信息")
    @PostMapping("/add-or-update-sys-role-info")
    @ResponseBody
    public ReturnStatusConstant addOrUpdateSysRoleInfo(@RequestBody SysRole sysRole){
        ReturnStatusConstant ReturnStatusConstant = new ReturnStatusConstant();
        try {
            if(StringUtils.hasText(sysRole.getId())){
                sysRole.beforeUpdate();
                sysRoleService.update(sysRole);
            }else{
                sysRole.beforeInsert();
                sysRoleService.insert(sysRole);
            }
            ReturnStatusConstant.setCode(ReturnStatusConstant.SUCCESS);
            ReturnStatusConstant.setMessage(ReturnStatusConstant.SUCCESS_MESSAGE);
        }catch (Exception e){
            ReturnStatusConstant.setCode(ReturnStatusConstant.FAIL);
            ReturnStatusConstant.setMessage(ReturnStatusConstant.SUCCESS_FAIL);
        }
        return ReturnStatusConstant;
    }


    @ApiOperation(value = "保存角色权限信息")
    @PostMapping("/add-role-permission-relation")
    @ResponseBody
    public ReturnStatusConstant addRolePerMissionRelation(@RequestBody SysRolePermissionRelationQueryVo sysRolePermissionRelationQueryVo){
        ReturnStatusConstant ReturnStatusConstant = new ReturnStatusConstant();
        try {
            sysRolePermissionRelationService.addRolePerMissionRelation(sysRolePermissionRelationQueryVo);
            ReturnStatusConstant.setCode(ReturnStatusConstant.SUCCESS);
            ReturnStatusConstant.setMessage(ReturnStatusConstant.SUCCESS_MESSAGE);
        }catch (Exception e){
            ReturnStatusConstant.setCode(ReturnStatusConstant.FAIL);
            ReturnStatusConstant.setMessage(ReturnStatusConstant.SUCCESS_FAIL);
        }
        return ReturnStatusConstant;
    }

    @ApiOperation(value = "删除用户角色信息")
    @PostMapping("/delete-sys-role-info")
    @ResponseBody
    public ReturnStatusConstant deleteSysRoleInfo(@RequestParam("id") @ApiParam(name = "id",value = "主键id") String id){
        ReturnStatusConstant ReturnStatusConstant = new ReturnStatusConstant();
        try {
            sysRoleService.deleteByPrimaryKey(id);
            ReturnStatusConstant.setCode(ReturnStatusConstant.SUCCESS);
            ReturnStatusConstant.setMessage(ReturnStatusConstant.SUCCESS_MESSAGE);
        }catch (Exception e){
            ReturnStatusConstant.setCode(ReturnStatusConstant.FAIL);
            ReturnStatusConstant.setMessage(ReturnStatusConstant.SUCCESS_FAIL);
        }
        return ReturnStatusConstant;
    }
}

