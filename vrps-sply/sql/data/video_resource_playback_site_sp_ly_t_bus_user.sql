create table t_bus_user
(
    id          varchar(50)  not null comment '主键',
    is_vip      int(10)      null comment '是否vip',
    create_time datetime     null comment '创建时间',
    expire_time datetime     null comment '过期时间',
    user_email  varchar(255) null comment '用户邮箱',
    user_name   varchar(255) null comment '用户名称',
    user_passwd varchar(255) null comment '用户密码',
    is_use      int          null comment '是否使用',
    create_by   varchar(64)  null comment '创建人',
    update_by   varchar(64)  null comment '修改人',
    update_time datetime     null comment '修改时间',
    remark      text         null comment '备注'
)
    comment '用户' charset = latin1;

INSERT INTO video_resource_playback_site_sp_ly.t_bus_user (id, is_vip, create_time, expire_time, user_email, user_name, user_passwd, is_use, create_by, update_by, update_time, remark) VALUES ('312d4a0da1ff4e109a1fefda1cfa2a1a', 0, '2019-04-14 16:26:41', '2019-04-14 16:26:41', '1058980664@qq.com', 'xlosy', '9673983F159E93B4A2D3CD6306D56CF7', null, null, null, '2019-04-14 00:00:00', null);