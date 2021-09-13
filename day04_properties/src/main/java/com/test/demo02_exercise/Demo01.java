package com.test.demo02_exercise;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Author: Jface
 * @Date: 2021/5/23 14:32
 * @Desc: 案例: 反射加载配置文件, 并执行指定的方法.
 * 需求:
 1. 已知在项目(模块)下有一个 config.properties, 文件中记录的有: 类名 和 方法名两组属性.
 2. 请用所学, 根据配置文件中的类名和方法名, 调用指定类的指定方法.
 */
public class Demo01 {
    public static void main(String[] args) throws Exception{
        //1.创建Properties集合类
        Properties pp = new Properties();
        //2.读取配置文件中的信息到集合中
        pp.load(new FileInputStream("day16/src/config.properties"));
        //3.获取具体的类名和方法名
        Object obj = pp.getProperty("className");
        String method = pp.getProperty("methodName");
        //4.根据类名,获取该类的字节码文件对象

        //5.创建该类的实体对象

        //6.根据方法名,获取具体的方法对象

        //7.调用方法.


    }
}
