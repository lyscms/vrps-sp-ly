create table t_bus_decade
(
    id          varchar(255)       not null comment '主键'
        primary key,
    is_use      int                not null comment '是否在使用',
    name        varchar(255)       null comment '名称',
    sort        int(255) default 0 null comment '排序',
    create_by   varchar(64)        null comment '创建人',
    create_time datetime           null comment '创建时间',
    update_by   varchar(64)        null comment '修改人',
    update_time datetime           null comment '修改时间',
    remark      varchar(100)       null comment '备注'
)
    comment '年份' charset = utf8;

INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('0769f574327540e4a2baf47afe08af91', 1, '2020', null, null, '2019-04-18 00:00:00', null, '2019-04-18 00:00:00', null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('0993064b423f4985ac7fa0f5c753877f', 1, '2023', null, null, '2019-04-18 00:00:00', null, '2019-05-04 00:00:00', null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('2a396ba38f1448f0a4ccd0f273a21f17', 1, '2019', null, null, '2019-04-08 00:00:00', null, '2019-04-08 00:00:00', null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('4702098e298048359f619efb46ba1d92', 1, '2021', null, null, '2019-04-18 00:00:00', null, '2019-04-18 00:00:00', null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('6a00ed72db736178d2d9cf7ddb8cf1dd', 1, '2018', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('c345a405419e18670d089c8ba7074987', 1, '2017', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('c89a512220164f1e9f801bd8a65f21c7', 1, '2022', null, null, '2019-04-28 00:00:00', null, '2019-05-04 00:00:00', null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e936970000', 1, '1994', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e94e650001', 1, '1995', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e95d780002', 1, '1996', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e96d380003', 1, '1997', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e97e9d0004', 1, '1998', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e98c490005', 1, '1999', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e99ded0006', 1, '2000', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e9af810007', 1, '2001', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e9bf8f0008', 1, '2002', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e9d2f80009', 1, '2003', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e9e15f000a', 1, '2004', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e9f005000b', 1, '2005', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4e9fe1f000c', 1, '2006', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4ea17e1000d', 1, '2007', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4ea2c25000e', 1, '2008', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4ea6c99000f', 1, '2009', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4ea7d240010', 1, '2010', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4ea8a530011', 1, '2011', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4ea980f0012', 1, '2012', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4eaa6090013', 1, '2013', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4eab4900014', 1, '2014', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4eac3a30015', 1, '2015', 0, null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_decade (id, is_use, name, sort, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a4eacf0d0016', 1, '2016', 0, null, null, null, null, null);