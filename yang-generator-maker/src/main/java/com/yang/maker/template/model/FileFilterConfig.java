package com.yang.maker.template.model;

import lombok.Builder;
import lombok.Data;

/**
 * 文件过滤配置
 */

@Data
@Builder
public class FileFilterConfig {
    /**
     * 过滤范围
     */
    private String range;

    /**
     * 过滤规则
     */
    private String ruler;

    /**
     * 过滤值
     */
    private String value;
}
