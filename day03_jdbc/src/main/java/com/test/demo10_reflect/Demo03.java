package com.test.demo10_reflect;

import com.test.pojo.Student;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;


/**
 * @Author: Jface
 * @Date: 2021/5/22 10:08
 * @Desc: 案例: 演示反射操作类中的成员变量.
 * <p>
 * 涉及到的成员方法:
 * Class类中相关的成员方法:
 * public static Class forName(String classname);      根据全类名, 获取该类对应的 字节码文件对象.
 * public Object newInstance();                根据类中的公共的空参构造方法, 获取该类的实例(对象)
 * <p>
 * public Field getField(String name);
 * 根据字段名, 获取指定的字段对象(不包含私有)
 * public Field getDeclaredField(String name);
 * 根据字段名, 获取指定的字段对象(包含私有)
 * public Field[] getFields();
 * 获取类中, 所有的字段对象(不包含私有)
 * public Field[] getDeclaredFields();
 * 获取类中, 所有的字段对象(包含私有)
 * <p>
 * Field类中的相关方法:
 * public void set(Object obj, Object value);  设置obj对象的指定属性为指定的值(value)
 * public void setAccessible(boolean flag);  设置暴力反射, 如果为true, 说明设置暴力反射.
 */
public class Demo03 {

    //需求1: 如何获取类中所有的 字段对象(包括私有)
    @Test
    public void show1() throws Exception {
        //1. 获取Student类的字节码文件对象.
        Class<?> clazz = Class.forName("com.test.pojo.Student");
        //2. 获取该类的 所有的字段对象, 不包含私有
//        Field[] fields = clazz.getFields();//不包含私有
        Field[] fields1 = clazz.getDeclaredFields();//包含私有

        //3. 遍历, 打印每一个字段对象.
//        for (Field a : fields) {
//            System.out.println(a);
//        }
        for (Field a : fields1) {
            System.out.println(a);
        }

    }

    //需求2: 如何操作类中 私有的成员变量.
    @Test
    public void show2() throws Exception {
        //需求: 创建学生对象, 高圆圆, 0
        //1. 获取字节码文件对象.
        Class<?> clazz = Class.forName("com.test.pojo.Student");
        //2. 获取该类的实例对象, 通过 公共的空参实现.
        Student s = (Student) clazz.newInstance();
        //3. 根据字节码文件, 获取该类中指定的 字段对象.
        Field name = clazz.getDeclaredField("name");
        //细节: 因为是私有, 记得: 暴力反射.
        name.setAccessible(true);
        //4. 设置指定对象s 的指定属性name 为指定的值 高圆圆.
        name.set(s, "高圆圆");
        //5. 设置年龄
        Field age = clazz.getField("age");
        age.set(s, 35);
        //age.setAccessible(true);      如果是私有, 记得暴力反射
        //6. 打印结果.
        System.out.println(s);


    }


}
