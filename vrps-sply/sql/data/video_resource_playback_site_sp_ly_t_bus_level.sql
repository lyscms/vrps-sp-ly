create table t_bus_level
(
    id          varchar(255) not null comment '主键'
        primary key,
    is_use      int          not null comment '是否在使用',
    name        varchar(255) null comment '等级名称',
    create_by   varchar(64)  null comment '创建人',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '修改人',
    update_time datetime     null comment '修改时间',
    remark      text         null comment '备注'
)
    comment '影片级别' charset = utf8;

