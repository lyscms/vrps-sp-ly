create table t_bus_catalog
(
  id     varchar(255)  not null comment '主键' primary key,
  is_use int           not null comment '是否在使用',
  name   varchar(255)  null comment '目录名称',
  sort   int default 0 null comment '排序',
  is_vip int default 0 null comment '是否vip'
)
  comment '目录' charset = utf8;

create table t_bus_decade
(
  id     varchar(255)       not null comment '主键' primary key,
  is_use int                not null comment '是否在使用',
  name   varchar(255)       null comment '名称',
  sort   int(255) default 0 null comment '排序'
)
  comment '年份' charset = utf8;

create table t_bus_film
(
  id             varchar(255)     not null comment '主键	' primary key,
  actor          varchar(255)     null comment '演员',
  cata_log_name  varchar(255)     null comment '目录名称',
  cata_log_id    varchar(255)     null comment '目录id',
  evaluation     double           not null comment '评价',
  image          varchar(255)     null comment '海报',
  is_use         int(1)           not null comment '是否在使用',
  loc_name       varchar(255)     null comment '地区名称',
  loc_id         varchar(255)     null comment '地区id',
  name           varchar(255)     null comment '影片名称',
  on_decade      varchar(255)     null comment '年代',
  plot           text             null comment '情节',
  resolution     varchar(255)     null comment '分辨率',
  status         varchar(255)     null comment '状态',
  sub_class_name varchar(255)     null comment '子分类名称',
  sub_class_id   varchar(255)     null comment '子分类id',
  type_name      varchar(255)     null comment '类型名称',
  type_id        varchar(255)     null comment '类型id',
  update_time    varchar(255)     null comment '更新时间',
  is_vip         int(1) default 0 null comment '是否vip'
)
  comment '影片' charset = utf8;

create table t_bus_level
(
  id     varchar(255) not null comment '主键' primary key,
  is_use int          not null comment '是否在使用',
  name   varchar(255) null comment '等级名称'
)
  comment '影片级别' charset = utf8;

create table t_bus_loc
(
  id     varchar(255) not null comment '主键' primary key,
  is_use int          not null comment '是否在使用',
  name   varchar(255) null comment '名称'
)
  comment '地区' charset = utf8;

create table t_bus_raty
(
  id      varchar(255) not null comment '主键	' primary key,
  en_time varchar(255) null comment '时间	',
  film_id varchar(255) null comment '影片id',
  score   varchar(255) null comment '分数'
)
  comment '评分' charset = utf8;

create table t_bus_res
(
  id          varchar(255) not null comment '主键' primary key,
  episodes    int          not null comment '集数',
  is_use      int          not null comment '是否使用',
  link        text         null comment '链接',
  link_type   varchar(255) null comment '链接类型',
  name        varchar(255) null comment '资源名称',
  update_time varchar(255) null comment '更新时间',
  film_id     varchar(255) null comment '影片名称',
  constraint FK_knc69bmssxu89jk9lmj736yhd
    foreign key (film_id) references t_bus_film (id)
)
  comment '资源' charset = utf8;

create table t_bus_subclass
(
  id         varchar(255) not null comment '主键' primary key,
  is_use     int          not null comment '是否使用',
  name       varchar(255) null comment '名称',
  catalog_id varchar(255) null comment '目录id',
  constraint FK_dui4eygakshpow7ia82sf0wff
    foreign key (catalog_id) references t_bus_catalog (id)
)
  comment '子分类' charset = utf8;

create table t_bus_type
(
  id          varchar(255) not null comment '主键' primary key,
  is_use      int          not null comment '是否在使用',
  name        varchar(255) null comment '类型名称',
  subclass_id varchar(255) null comment '子分类id',
  constraint FK_1bgyfw3vyq0tadn4wuyykopak
    foreign key (subclass_id) references t_bus_subclass (id)
)
  comment '类型' charset = utf8;

create table t_bus_user
(
  id          varchar(50)  not null comment '主键' primary key,
  is_vip      int(10)      null comment '是否vip',
  create_time datetime     null comment '创建时间',
  expire_time datetime     null comment '过期时间',
  user_email  varchar(255) null comment '用户邮箱',
  user_name   varchar(255) null comment '用户名称',
  user_passwd varchar(255) null comment '用户密码',
  is_use      int          null comment '是否使用'
)
comment '用户' charset = latin1;

create table t_bus_vip_code
(
  id          varchar(225) not null comment '主键' primary key,
  code        varchar(255) null comment '编码',
  is_use      varchar(255) null comment '是否使用',
  create_time datetime     null comment '创建时间',
  expire_time datetime     null comment '过期时间'
)
  comment 'vip编码' charset = latin1;

create table t_sys_permission
(
  id          varchar(64)  not null primary key,
  name        varchar(100) null comment '权限名称',
  url         varchar(100) null comment '权限路径',
  description varchar(255) null comment '权限描述',
  pid         varchar(64)  null comment '父权限id',
  type        varchar(20)  null comment '权限类型：1:菜单 2:接口',
  method      varchar(40)  null,
  create_by   varchar(64)  null comment '创建人',
  create_time datetime     null comment '创建时间',
  update_by   varchar(64)  null comment '修改人',
  update_time datetime     null comment '修改时间',
  remark      varchar(255) null comment '备注',
  constraint `unique`
    unique (name, url, type, method)
)
  collate = utf8_unicode_ci;

create table t_sys_role
(
  id          varchar(64)  not null comment '主键id' primary key,
  alias       varchar(100) null comment '角色别名',
  name        varchar(100) null comment '角色名',
  create_by   varchar(64)  null comment '创建人',
  create_time datetime     null comment '创建时间',
  update_by   varchar(64)  null comment '修改人',
  update_time datetime     null comment '修改时间',
  remark      varchar(255) null comment '备注'
)
  comment '用户角色表' collate = utf8_unicode_ci;

create table t_sys_role_permission_relation
(
  id            varchar(64)  not null comment '主键id' primary key,
  role_id       varchar(64)  null comment '角色id',
  permission_id varchar(64)  null comment '权限id',
  create_by     varchar(64)  null comment '创建人',
  create_time   datetime     null comment '创建时间',
  update_by     varchar(64)  null comment '修改人',
  update_time   datetime     null comment '修改时间',
  remark        varchar(255) null comment '备注'
)
  collate = utf8_unicode_ci;

create table t_sys_user
(
  id                    varchar(64) default '' not null comment '主键id' primary key,
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

create table t_sys_user_role_relation
(
  id          varchar(64)  not null comment '主键id' primary key,
  user_id     varchar(64)  null comment '用户角色',
  role_id     varchar(64)  null comment '角色id',
  create_by   varchar(64)  null comment '创建人',
  create_time datetime     null comment '创建时间',
  update_by   varchar(64)  null comment '修改人',
  update_time datetime     null comment '修改时间',
  remark      varchar(255) null comment '备注'
)
  comment '用户角色关联表' collate = utf8_unicode_ci;

