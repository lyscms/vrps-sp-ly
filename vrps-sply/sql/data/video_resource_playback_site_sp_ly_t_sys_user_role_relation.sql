create table t_sys_user_role_relation
(
    id          varchar(64)  not null comment '主键id'
        primary key,
    user_id     varchar(64)  null comment '用户角色',
    role_id     varchar(64)  null comment '角色id',
    create_by   varchar(64)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '修改人',
    update_time datetime     null comment '修改时间',
    remark      varchar(255) null comment '备注'
)
    comment '用户角色关联表' collate = utf8_unicode_ci;

