# video_resource_playback_site

#### 介绍
支持本地资源视频文件上传在线播放，同时支持在线资源链接上传（ed2k、迅雷、等资源）下载，登录注册、会员授权管理，支付功能、后台权限管理。


#### 软件架构
1. 采用了最简洁、最流程的SpringBoot(2.1.3.RELEASE)作为基础整合框架
2. MyBatis作为ORM数据库持久化框架
3. 视图解析器采用了thymeleaf 
4. 前段UI框架采用BootStrap4.0.0, 配合Layui UI经典模块化前端框架
5. 在线播放器采用CkPlayer6.7
6. 百度多平台分享插件

#### 工程结构
- mybatis-generator-plugins-sply：为该项目需要生成底层dao、mapper、model时的附加插件

#### 安装教程

1. 下载代码
2. maven方式导入项目
3. 配置maven settings文件下载依赖：settings_sply.xml, 不同软件配置方式自行百度
4. 执行Maven Reimport 刷新maven相关依赖下载，等待完成
5. 执行maven插件:mvn spring-boot:run,也可软件工具方式执行

#### 使用说明

1. 数据库脚本
2. xxxx
3. xxxx

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### 博客
我的CSDN：https://blog.csdn.net/xzpdskll