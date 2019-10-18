/**
 * Copyright 2019 bejson.com
 */
package com.ly.vrps.management.busmanager.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * 目录树形结构数据
 *
 * @author sunkl
 * @date 2019/4/15 21:40
 */
@Data
@ApiModel("目录树形结构数据")
public class CataLogTree {


    /**当前节点id*/
    private String id;

    /**节点名称*/
    private String name;

    /**父节点id*/
    private String parentId;

    /**节点链接（可选），未设则不会跳转*/
    private String href;

    private List<CataLogTree> children;
}