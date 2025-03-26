package com.yang.generator;

import com.yang.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * 动态文件生成
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
       String projectPath = System.getProperty("user.dir") + File.separator + "yang-generator-basic";
       String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
       String outputPath = projectPath + File.separator + "MainTemplate.java";
       MainTemplateConfig config = new MainTemplateConfig();
       config.setAuthor("yang");
       config.setLoop(true);
       config.setOutputText("求和结果");
       DoGenerator(inputPath, outputPath, config);
    }

    /**
     * 生成文件
     *
     * @param inputPath
     * @param outputPath
     * @param model
     * @throws IOException
     * @throws TemplateException
     */

    public static void DoGenerator(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new出 Configuration对象, 参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置字符集
        configuration.setDefaultEncoding("UTF-8");

        // 创建模板对象, 加载指定模板文件
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Yang");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果");

        // 生成
        Writer out = new FileWriter(outputPath);
        template.process(model, out);

        // 关闭流
        out.close();



    }
}