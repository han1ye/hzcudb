[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/AK0LlHJv)

# 项目名称：竞赛管理系统

## 项目简介

本项目为基于 Java Swing 的竞赛管理系统，支持学生、教师、管理员等多角色登录，涵盖竞赛、奖项、队伍、成员、教师、教练等信息的增删改查与统计分析。适用于高校竞赛信息化管理。

## 主要依赖

- JDK 8 及以上
- Eclipse IDE（推荐）
- MySQL 数据库
- 依赖 jar 包（位于 lib 目录，或需自行下载并配置到 Eclipse Build Path）：
  - c3p0-0.9.2.1.jar（数据库连接池）
  - mchange-commons-java-0.2.3.4.jar（c3p0 依赖）
  - mysql-connector-java-5.1.27-bin.jar（MySQL 驱动）
  - miglayout-core.jar、miglayout-swing.jar（界面布局）
  - DateTimePicker.jar（日期选择控件）

## 所需插件

- IntelliJ IDEA（推荐，支持 GUI Designer 插件进行 Swing 可视化设计）
- IntelliJ IDEA GUI Designer 插件（用于可视化编辑 .jfd 等 Swing 界面文件）
- MySQL 数据库（需提前建库建表，表结构可参考 model 包下实体类）

## 代码目录结构说明

```
project-han1ye/
├── src/
│   └── cn/ljh/db/
│       ├── control/   # 控制器，处理业务逻辑
│       ├── model/     # 实体类，对应数据库表
│       ├── ui/        # Swing 界面及窗口
│       ├── util/      # 工具类与异常定义
│       └── startMain.java  # 程序入口
├── lib/               # 第三方依赖 jar 包
├── bin/               # 编译输出目录
├── imag/              # 图片资源（如有）
├── .classpath         # Eclipse 类路径配置
├── .project           # Eclipse 项目配置
```

## 启动方式

1. 用 IntelliJ IDEA 导入本项目（File -> Open 选择项目根目录）。
2. 配置 JDK 及依赖，确保 lib 下所有 jar 包已添加到项目依赖中。
3. 配置数据库连接（如有 DBUtil.java 需修改数据库地址、用户名、密码）。
4. 运行 `startMain.java` 即可启动系统。

## 其他说明

- 数据库表结构可参考 model 包下实体类字段。
- 部分界面支持可视化编辑（.jfd 文件为 WindowBuilder 设计文件）。
- 若遇到界面乱码，请设置 JVM 启动参数：`-Dfile.encoding=UTF-8`。

---

如有问题请联系开发者或查阅源代码注释。
