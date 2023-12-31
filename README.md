# video_resource_playback_site_sp_ly

#### 介绍
支持本地资源视频文件上传在线播放，同时支持在线资源链接上传（ed2k、迅雷、等资源）下载，登录注册、会员授权管理，支付功能、后台权限管理。


#### 软件架构
1. 采用了最简洁、最流程的SpringBoot(2.1.3.RELEASE)作为基础整合框架
2. MyBatis作为ORM数据库持久化框架,配合TkMapper使用
3. 视图解析器采用了thymeleaf 
4. 前段UI框架采用BootStrap4.0.0, 配合Layui UI经典模块化前端框架
5. 在线播放器采用CkPlayer6.7
6. 百度多平台一键分享插件，帮助你拓展内容圈
7. 数据采用轻量级Mysql5.7.26+
8. 数据源连接池采用主流的阿里Druid，自带监控系统，系统运行情况一览无余

#### 工程结构
- mybatis-gen-plugins：为该项目需要生成底层dao、mapper、model时的附加插件
- vrps-sply: 为该项目的主项目代码

#### 安装使用教程

1. 下载代码
2. maven方式导入项目
3. 配置maven settings文件下载依赖：settings_sply.xml, 不同软件配置方式自行百度
4. 执行maven reimport 刷新maven相关依赖下载，等待完成
5. 新建Mysql数据库名称为:video_resource_playback_site_sp_ly
6. 执行vrps-sply子模块sql目录下数据库脚本
7. 修改application-loc.properties中的数据库连接信息
8. 执行maven插件:mvn spring-boot:run,也可软件工具方式启动或者执行vrps-sply子模块com.ly.vrps包下的VrpsSpLyApplication.main方法
9. 前台访问地址：http://localhost:8080
10. 后台访问地址：http://localhost:8080/manager   sply-admin 123456

#### 博客
我的CSDN博客：https://blog.csdn.net/xzpdskll

#### 版本升级说明

##### v1.0.4

````
  1.修复文件文件上传问题，更换上传控件
  2.修复添加影片主题问题
````

##### v1.0.3
````
  1.修复后台目录界面引入外部js错误
````

##### v1.0.2
````
  1.修改目录页面改为LaYui界面
  2.其它部分bug修复
````
