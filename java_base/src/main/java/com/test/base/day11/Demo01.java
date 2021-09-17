package com.test.base.day11;


import com.test.base.pojo.Student;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: Jface
 * @Date: 2021/5/16 9:50
 * @Desc: 第一题: 通过代码, 完成如下需求:
 * 1. 自定义一个学生类，给出成员变量name和age.
 * 2. 使用HashSet集合存储学生对象并遍历.
 * 3. 最后在控制台输出学生对象的成员变量值。
 * //格式为: 姓名: 张三, 年龄: 23
 * 4. 通过两种方式遍历.
 * //提示: 普通迭代器, 增强for.
 * 集合的使用步骤:
 * 1. 创建集合对象.
 * 2. 创建元素对象.
 * 3. 添加元素到集合中.
 * 4. 遍历集合.
 */
public class Demo01 {
    public static void main(String[] args) {
//        集合的使用步骤:
//        1. 创建集合对象.
        HashSet<Student> hs = new HashSet<>();
//        2. 创建元素对象.
        Student s1 = new Student("李白", 16);
        Student s2 = new Student("杜甫", 20);
        Student s3 = new Student("猪皮", 18);
//        3. 添加元素到集合中.
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
//        4. 遍历集合.
        //方法1: 增强for循环
        for (Student s : hs) {
            System.out.println(s);
        }
        System.out.println("-------------------------");
        //方法2:普通迭代器
        Iterator<Student> it = hs.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s);
        }


    }
}
