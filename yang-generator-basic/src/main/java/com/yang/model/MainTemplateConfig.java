package com.yang.model;


/**
 * 动态模板配置
 */

import lombok.Data;

@Data
public class MainTemplateConfig {

    /**
     * 是否生成循环
     */

    private Boolean loop;

    /**
     * 作者注释
     */

    private String author = "Yang";

    /**
     * 输出信息
     */

    private String outputText = "输出结果";


}
