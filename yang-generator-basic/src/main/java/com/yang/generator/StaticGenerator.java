package com.yang.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");      // 获取当前项目路径
        System.out.println("当前项目路径：" + projectPath);
        String inputPath = projectPath + File.separator + "Yang-generator-dome-projects" + File.separator + "acm-template";
        String outputPath = projectPath;
        copyFilesByHutool(inputPath, outputPath);

    }

    /**
     * 使用Hutool工具类复制文件
     * @param inputPath 输入文件路径
     * @param outputPath 输出文件路径
     */
    public static void  copyFilesByHutool( String inputPath, String outputPath) {

        FileUtil.copy(inputPath, outputPath, false);
    }


}
