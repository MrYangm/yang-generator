package com.yang.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * @Author: yang
 * @Date: 2025/08/23/13:16
 */
public class StaticFileGenerator {

    /**
     * 使用 Hutool 工具类复制文件
     * @param inputPath
     * @param outputPath
     */

    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
