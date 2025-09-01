package com.yang.maker.main;


import com.yang.maker.meta.Meta;
import com.yang.maker.meta.MetaManager;

import java.io.File;

public class MainGenerator {
    public static void main(String[] args) {
        Meta meta = MetaManager.getMetaObject();
        System.out.println(meta);

        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generator" + File.separator + meta.getName();
    }
}
