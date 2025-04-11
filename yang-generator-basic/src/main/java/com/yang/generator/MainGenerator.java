package com.yang.generator;



import com.yang.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;


/**
 * 核心生成器
 */
public class MainGenerator {



    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");      // 获取当前项目路径
        //输入路径
        String inputPath = projectPath + File.separator + "yang-generator-demo-projects" + File.separator + "acm-template";
        //输出路径
        String outputPath = projectPath;
        //生成静态文件
        StaticGenerator.copyFilesByRecursive(inputPath, outputPath);
        //生成动态文件
        String dynamicInputPath = projectPath + File.separator + "yang-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yang/acm/MainTemplate.java";
        DynamicGenerator.doGenerator(dynamicInputPath, dynamicOutputPath, model);
    }


    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yang");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果");
        doGenerate(mainTemplateConfig);

    }

}
