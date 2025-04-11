# Yang Generator

## 项目简介
Yang Generator 是一个基于 Java 和 FreeMarker 的代码生成器项目，支持动态模板生成和静态文件复制。项目主要用于快速生成代码模板和文件，提升开发效率。

## 功能特性
1. **动态文件生成**：
   - 使用 FreeMarker 模板引擎，根据模板和数据模型生成动态文件。
   - 示例模板文件路径：`src/main/resources/templates/MainTemplate.java.ftl`。

2. **静态文件复制**：
   - 支持递归复制文件夹及其内容。
   - 示例输入路径：`yang-generator-demo-projects/acm-template`。

3. **核心生成器**：
   - 集成动态文件生成和静态文件复制功能，统一调用。
