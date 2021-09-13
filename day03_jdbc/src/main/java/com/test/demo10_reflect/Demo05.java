package com.test.demo10_reflect;

import com.test.pojo.Student;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author: Jface
 * @Date: 2021/5/22 10:56
 * @Desc: 反射案例: 反射越过泛型检查.
 * 需求: 给ArrayList<Integer>集合中添加 字符串.
 * 细节:
 * 泛型只在程序编写期间有效, 在编译, 运行期间无效.
 * 解题思路:
 * 因为泛型在程序运行期间无效, 所以我们要在程序的运行期间 往集合中加元素, 这就要用: 反射技术.
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        //1.创建集合对象
        ArrayList<Integer> list = new ArrayList<>();
        //2.往集合里面添加元素
        list.add(23);
        list.add(12);
        list.add(37);
        list.add(49);
        list.add(65);
        //3.获取该类的字节码文件
        Class<?> clazz = Class.forName("java.util.ArrayList");
        //4.获取指定的成员方法
        Method add = clazz.getMethod("add", Object.class);
        //5.调用成员方法,添加元素
        add.invoke(list, "厉害了");
        add.invoke(list, 23.32);
        add.invoke(list, false);
        add.invoke(list, new Student("李白", 16));
        //6.打印集合
        System.out.println(list);


    }
}
