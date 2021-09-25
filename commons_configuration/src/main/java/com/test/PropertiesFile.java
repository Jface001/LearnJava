package com.test;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

/**
 * @Author: Jface
 * @Desc: 测试 Commons Configuration 的使用
 */
public class PropertiesFile {
    public static void main(String[] args) {
        //1.初始化配置文件
        Configurations configs = new Configurations();
        Configuration config = null;
        //2.读取配置文件内容
        try {
            config = configs.properties(new File("commons_configuration/src/main/resources/test.properties"));

        } catch (ConfigurationException cex) {
            cex.printStackTrace();
        }

        //2.获取使用配置文件信息,打印测试
        System.out.println(config.getString("database.host"));


    }
}
