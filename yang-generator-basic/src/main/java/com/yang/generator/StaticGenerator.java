package com.yang.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");      // 获取当前项目路径
        System.out.println("当前项目路径：" + projectPath);
        String inputPath = projectPath + File.separator + "yang-generator-demo-projects" + File.separator + "acm-template";
        System.out.printf("输入路径：%s\n", inputPath);
        String outputPath = projectPath;
        System.out.printf("输出路径：%s\n", outputPath);

        copyFilesByHutool(inputPath, outputPath);
        //copyFilesByRecursive(inputPath, outputPath);

    }

    /**
     * 使用Hutool工具类复制文件
     * @param inputPath 输入文件路径
     * @param outputPath 输出文件路径
     */
    public static void  copyFilesByHutool( String inputPath, String outputPath) {

        FileUtil.copy(inputPath, outputPath, false);
    }

    /**
     * 递归复制文件
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFilesByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.out.println("文件复制失败");
            e.printStackTrace();
        }
    }

    // 递归复制文件
    private static void copyFilesByRecursive(File inputFile, File outputFile) throws IOException {

        // 区分是文件还是目录
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，首先创建目录
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }

            //获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            //没有子文件或者子目录,结束递归
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归拷贝下一层文件
                copyFilesByRecursive(file, destOutputFile);
            }
        } else {
            // 是文件, 直接复制到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}



