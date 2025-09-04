package com.yang.maker.generator;

import java.io.*;

public class JarGenerator {
    public static void doGenerate(String projectDir) throws IOException, InterruptedException {

        //清理之前的构建并打包
        String winMavenCommand = "man.cmd clean package -DskipTests";
        String otherMavenCommand = "mvn clean package -DskipTests";
        String mavenCommand = otherMavenCommand;

        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();

        //读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 等待命令执行完成
        int exitCode = process.waitFor();
        System.out.println("命令执行完成，退出码：" + exitCode);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("/Users/yang/Desktop/Project/Java/yang-generator/yang-generator-maker/generated/acm-template-pro-generator");
    }
}
