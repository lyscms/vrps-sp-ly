create table t_sys_user
(
    id                    varchar(64) default '' not null comment '主键id'
        primary key,
    name                  varchar(64)            null comment '用户名称',
    org_id                varchar(64)            null comment '所属组织id',
    account               varchar(64)            null comment '账户',
    password              varchar(64)            null comment '密码',
    status                int(1)                 null comment '状态, 0：离线 1：在线',
    enable                int(1)                 null comment '是否启用，0：禁用 1：启用',
    last_login_time       datetime               null comment '最后登录时间',
    last_login_ip_address varchar(20)            null comment '最后登录ip地址',
    login_count           int(100)               null comment '登录次数',
    create_by             varchar(64)            null comment '创建人',
    create_time           datetime               null comment '创建时间',
    update_by             varchar(64)            null comment '修改人',
    update_time           datetime               null comment '修改时间',
    remark                varchar(255)           null comment '备注'
)
    collate = utf8_unicode_ci;

INSERT INTO video_resource_playback_site_sp_ly.t_sys_user (id, name, org_id, account, password, status, enable, last_login_time, last_login_ip_address, login_count, create_by, create_time, update_by, update_time, remark) VALUES ('e354cf56072b422c9b68e83fa82afd6e', '超级管理员', 'top', 'sply-admin', '$2a$10$m0FUP5DAY8eEE/K0.M2MXO8pZDlvI3g0lkB9Q8G5IRDEw8VhZJ54a', 1, 1, '2019-04-14 11:07:56', '0:0:0:0:0:0:0:1', 84, null, '2018-12-20 17:48:46', 'e354cf56072b422c9b68e83fa82afd6e', '2019-01-04 15:50:15', '超级管理员');