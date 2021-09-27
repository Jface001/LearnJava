package com.test.entity;

/**
 * @Author: Jface
 * @Desc:
 * 用于常量的定义，枚举值列表，固定范围的值
 * yyyy-MM-dd HH:mm:ss
 * yyyy-MM-dd
 * yyyyMMdd
 */
public enum DateFormatDefine {
    /**
     * 构建 yyyy-MM-dd HH:mm:ss 格式的时间
     */
    DATE_TIME_FORMAT("yyyy-MM-dd HH:mm:ss"),
    /**
     * 构建 yyyy-MM-dd 格式的日期
     */
    DATE_FORMAT("yyyyMMdd"),
    /**
     * 构建 yyyyMMdd 格式的日期
     */
    DATE2_FORMAT("yyyy-MM-dd");

    private String format;

    DateFormatDefine(String _format){
        format = _format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
