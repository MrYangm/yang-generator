package com.yang.generator;



import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @Author: yang
 * @Date: 2025/08/23/13:16
 */
public class StaticGenerator {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new  File(projectPath).getAbsolutePath();
        String outputPath = parentFile.getAbsolutePath() + File.separator + "yang-generator-static";
        copyFilesByHutool(inputPath, outputPath);
        System.out.println("Static files copied successfully!");

    }

    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);

    }

}
