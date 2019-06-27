create table t_bus_loc
(
    id          varchar(255) not null comment '主键'
        primary key,
    is_use      int          not null comment '是否在使用',
    name        varchar(255) null comment '名称',
    create_by   varchar(64)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '修改人',
    update_time datetime     null comment '修改时间',
    remark      text         null comment '备注'
)
    comment '地区' charset = utf8;

INSERT INTO video_resource_playback_site_sp_ly.t_bus_loc (id, is_use, name, create_by, create_time, update_by, update_time, remark) VALUES ('73b19abab20143d68fa8e46cfa1a2f59', 1, '台湾', null, '2019-04-28 00:00:00', null, '2019-05-04 17:15:30', null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_loc (id, is_use, name, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a9002ff9001c', 1, '欧美', null, null, null, '2019-05-04 17:15:26', null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_loc (id, is_use, name, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857ad7e8c0157ae4cbcd20001', 1, '大陆', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_loc (id, is_use, name, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857ad7e8c0157ae5dd0450009', 1, '韩国', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_loc (id, is_use, name, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857ad7e8c0157af44b2a40017', 1, '美国', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_loc (id, is_use, name, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157b798a5540009', 1, '加拿大', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_loc (id, is_use, name, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157b98c59330049', 1, '法国', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_loc (id, is_use, name, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157be611374007c', 1, '日本', null, null, null, null, null);