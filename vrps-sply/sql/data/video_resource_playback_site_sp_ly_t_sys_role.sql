create table t_sys_role
(
    id          varchar(64)  not null comment '主键id'
        primary key,
    alias       varchar(100) null comment '角色别名',
    name        varchar(100) null comment '角色名',
    create_by   varchar(64)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '修改人',
    update_time datetime     null comment '修改时间',
    remark      varchar(255) null comment '备注'
)
    comment '用户角色表' collate = utf8_unicode_ci;

INSERT INTO video_resource_playback_site_sp_ly.t_sys_role (id, alias, name, create_by, create_time, update_by, update_time, remark) VALUES ('4d0c081c86d443929f7825dc3cfc3be2', '采集', '采集管理员', 'e354cf56072b422c9b68e83fa82afd6e', '2018-12-11 17:44:37', 'e354cf56072b422c9b68e83fa82afd6e', '2019-04-14 14:53:07', '采集备注');
INSERT INTO video_resource_playback_site_sp_ly.t_sys_role (id, alias, name, create_by, create_time, update_by, update_time, remark) VALUES ('96dd75eadca94862987bb0ac89af20af', '超级', '超级管理员', 'admin', '2018-12-20 17:51:05', 'admin', '2018-12-20 17:51:05', '超级管理员');
INSERT INTO video_resource_playback_site_sp_ly.t_sys_role (id, alias, name, create_by, create_time, update_by, update_time, remark) VALUES ('9c4bd9d7d79045088237615d60fd42b8', '审计', '审计管理员', 'e354cf56072b422c9b68e83fa82afd6e', '2018-12-11 17:44:58', 'e354cf56072b422c9b68e83fa82afd6e', '2018-12-11 17:44:58', '审计备注');
INSERT INTO video_resource_playback_site_sp_ly.t_sys_role (id, alias, name, create_by, create_time, update_by, update_time, remark) VALUES ('d4bbc45e5f544c38b62cd5339abd9a7a', '系统员', '系统管理员', 'e354cf56072b422c9b68e83fa82afd6e', '2018-12-11 17:42:25', 'e354cf56072b422c9b68e83fa82afd6e', '2018-12-11 17:47:08', '系统备注');
INSERT INTO video_resource_playback_site_sp_ly.t_sys_role (id, alias, name, create_by, create_time, update_by, update_time, remark) VALUES ('dd2a5e3d4b0b408980e9f9cb66dd3528', '日志', '日志管理员', 'e354cf56072b422c9b68e83fa82afd6e', '2018-12-11 17:45:28', 'e354cf56072b422c9b68e83fa82afd6e', '2018-12-11 17:45:43', '日志备注');