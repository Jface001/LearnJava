package com.test.base.day10;

import com.test.base.pojo.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: Jface
 * @Date: 2021/5/14 19:57
 * @Desc: 第一题: 通过代码, 完成如下需求:
 * 1. 自定义一个学生类，给出成员变量name和age.
 * 2. 使用Collection集合存储学生对象并遍历.
 * 3. 最后在控制台输出学生对象的成员变量值。
 * //格式为: 姓名: 张三, 年龄: 23
 * 4. 通过两种方式遍历.
 * //提示: 普通迭代器, 增强for.
 * <p>
 * Collection<Student> list = new ArrayList<>();
 */
public class Demo01 {
    public static void main(String[] args) {
//        集合的使用步骤:
//        1. 创建集合对象.
        Collection<Student> list = new ArrayList<Student>();
//        2. 创建元素对象.
        Student s1 = new Student("高圆圆", 35);
        Student s2 = new Student("赵丽颖", 33);
        Student s3 = new Student("刘亦菲", 31);
//        3. 添加元素到集合中.
        list.add(s1);
        list.add(s2);
        list.add(s3);
//        4. 遍历集合.
//        方式1:普通迭代器
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s);
        }
        System.out.println("--------------------");
//        方式2:增强for循环
        for (Student s : list) {
            System.out.println(s);
        }


    }

}
