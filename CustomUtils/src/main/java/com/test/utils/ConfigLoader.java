package com.test.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @Author: Jface
 * @Desc:
 工具类
 *读取resources资源目录下的配置文件 conf.properties 文件中的键值对
 */
public class ConfigLoader {
    private static Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    //1.读取资源目录下的文件并生成输入流 InputStream
    //2.创建配置文件并将输入流加载进来
    static Properties props =new Properties();
    static {
        InputStream resourceAsStream = ConfigLoader.class.getClassLoader().getResourceAsStream("conf.properties");
        try {
            props.load(resourceAsStream);
        } catch (IOException e) {
            logger.warn("当前加载配置文件夹出错："+e.getMessage());
        }
    }
    //3.定义get获取对象，类型：字符串或整数
    //3.1.获取字符串
    public static String get (String key){
        String properties = props.getProperty(key);
        return properties;
    }
    //3.2.获取数字类型的值
    public static int getInt (String key) {
        int props = Integer.parseInt(ConfigLoader.props.getProperty(key));
        return props;

    }
}
