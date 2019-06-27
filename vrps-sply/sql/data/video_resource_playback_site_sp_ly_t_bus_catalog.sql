create table t_bus_catalog
(
    id          varchar(255)  not null comment '主键'
        primary key,
    is_use      int           not null comment '是否在使用',
    name        varchar(255)  null comment '目录名称',
    sort        int default 0 null comment '排序',
    is_vip      int default 0 null comment '是否vip',
    create_by   varchar(64)   null comment '创建人',
    create_time datetime      null comment '创建时间',
    update_by   varchar(64)   null comment '修改人',
    update_time datetime      null comment '修改时间',
    remark      text          null comment '备注'
)
    comment '目录' charset = utf8;

INSERT INTO video_resource_playback_site_sp_ly.t_bus_catalog (id, is_use, name, sort, is_vip, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4874a0157a4a6a4fe0000', 1, '电影', 1, 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_catalog (id, is_use, name, sort, is_vip, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a8ea80700018', 1, '电视剧', 1, 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_catalog (id, is_use, name, sort, is_vip, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a8eaaee30019', 1, '动漫', 2, 0, null, null, null, null, null);