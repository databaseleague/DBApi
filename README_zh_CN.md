# DBApi

![](https://gitee.com/freakchicken/db-api/badge/star.svg)
![](https://gitee.com/freakchicken/db-api/badge/fork.svg?theme=gvp)
![](https://img.shields.io/github/stars/freakchick/DBApi.svg?logo=GitHub)
![](https://img.shields.io/github/forks/freakchick/DBApi.svg?logo=GitHub)
![](https://img.shields.io/github/watchers/freakchick/DBApi.svg?logo=GitHub)


[![EN doc](https://img.shields.io/badge/document-English-blue.svg)](README.md)
[![CN doc](https://img.shields.io/badge/文档-中文版-blue.svg)](README_zh_CN.md)

![](https://freakchicken.gitee.io/images/dbApi//logo.png)


## 介绍

- 狭义上说，DBAPI是一个面向数仓开发人员的低代码工具，只需在页面上编写sql，并配置好参数，就可以自动生成http接口。它可以帮助程序员快速的开发后端数据接口，尤其适用于BI报表、数据可视化大屏的后端接口开发。
- 广义上说，DBAPI是整个企业数据接口的管理中心，是企业对外提供数据服务的管理平台。它提供了数据接口的动态创建发布功能，对接口的统一管理，并提供了对客户端的管理能力，可以监控客户端对接口的调用、控制客户端对接口的权限。


## 特点
- 开箱即用，不需要编程，单机模式不需要依赖其他软件（只需要java运行环境）
- 支持单机模式、集群模式，支持`windows` `Linux` `Mac`
- 支持动态创建、修改API；动态创建、修改数据源。热部署全程无感。
- 支持API级别的访问权限控制，支持IP白名单、黑名单控制
- 支持所有类型数据库（JDBC协议），包括mysql/sqlserver/postgreSql/hive/oracle等等
- 支持动态sql，类似mybatis的动态sql，支持sql编辑、运行、调试
- 丰富的插件扩展，支持缓存、数据转换、失败告警
- 支持API配置导入导出，方便测试环境到生产环境的API迁移
- 支持一个接口内多条SQL执行（例如分页功能），支持事务开启关闭
- 支持复杂嵌套json传参
- 支持接口调用记录查询，接口访问信息统计

## 安装包下载
[安装包下载](https://www.51dbapi.com/v4.0.0/download/)

## 安装文档
[安装文档](https://www.51dbapi.com/v4.0.0/install/)

## 官方文档
[官方文档](https://www.51dbapi.com)


## 软件截图
![](https://freakchicken.gitee.io/images/dbApi/20230523/create_ds_page.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/ds_page.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/group_more.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/api_basic.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/api_executor.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/api_plugin.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/sql_debug.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/private_api_request.png)

![](https://freakchicken.gitee.io/images/dbApi/20230523/create_client_page.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/client_auth_page.png)

![](https://freakchicken.gitee.io/images/dbApi/20230523/ip_firewall.png)

![](https://freakchicken.gitee.io/images/dbApi/20230523/monitor.png)
![](https://freakchicken.gitee.io/images/dbApi/20230523/api_record_search.png)