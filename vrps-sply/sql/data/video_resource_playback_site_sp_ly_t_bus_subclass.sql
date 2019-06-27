create table t_bus_subclass
(
    id          varchar(255) not null comment '主键'
        primary key,
    is_use      int          not null comment '是否使用',
    name        varchar(255) null comment '名称',
    catalog_id  varchar(255) null comment '目录id',
    create_by   varchar(64)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '修改人',
    update_time datetime     null comment '修改时间',
    remark      text         null comment '备注'
)
    comment '子分类' charset = utf8;

INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('9800261fc99c48af9474a5a083b4874c', 1, '4243', '010', null, '2019-04-17 00:00:00', null, '2019-04-17 00:00:00', null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('a559754ef20fda71b8dbf8ea1f6c8e94', 1, '动作片', '2f8382c4b6e863668d62bda4f0518c7f', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4874a0157a4a723560001', 1, '动作片', 'f39c979857a4874a0157a4a6a4fe0000', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157a8fe00ff001a', 1, '剧情片', 'f39c979857a4874a0157a4a6a4fe0000', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857a4c8c50157ac76b5140027', 1, '恐怖片', 'f39c979857a4874a0157a4a6a4fe0000', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857ad7e8c0157ae8927290011', 1, '喜剧片', 'f39c979857a4874a0157a4a6a4fe0000', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857ad7e8c0157af45971a0018', 1, '科幻片', 'f39c979857a4c8c50157a8ea80700018', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157b7b0974e0024', 1, '剧情片', 'f39c979857a4c8c50157a8ea80700018', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157b83af6940044', 1, '科幻片', 'f39c979857a4874a0157a4a6a4fe0000', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157bdd983220054', 1, '爱情片', 'f39c979857a4874a0157a4a6a4fe0000', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157be5f224f007a', 1, '剧情片', 'f39c979857a4c8c50157a8eaaee30019', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157c2c386d600b1', 1, '古装片', 'f39c979857a4c8c50157a8ea80700018', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857b48a2a0157c3053fdc010a', 1, '喜剧片', 'f39c979857a4c8c50157a8ea80700018', null, null, null, null, null);
INSERT INTO video_resource_playback_site_sp_ly.t_bus_subclass (id, is_use, name, catalog_id, create_by, create_time, update_by, update_time, remark) VALUES ('f39c979857c72e810157c74e89a8002e', 1, '动画片', 'f39c979857a4c8c50157a8eaaee30019', null, null, null, null, null);