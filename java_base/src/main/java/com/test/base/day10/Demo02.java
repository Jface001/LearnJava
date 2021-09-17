package com.test.base.day10;


import com.test.base.pojo.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author: Jface
 * @Date: 2021/5/14 20:04
 * @Desc: 第二题: 通过代码, 完成如下需求:
 * 1. 自定义一个学生类，给出成员变量name和age.
 * 2. 使用List集合存储学生对象并遍历.
 * 3. 最后在控制台输出学生对象的成员变量值。
 * //格式为: 姓名: 张三, 年龄: 23
 * 4. 通过两种方式遍历.
 * //提示: 普通迭代器, 增强for.
 * List<Student> list = new ArrayList<>();
 * 集合的核心操作步骤:
 *         1. 创建集合对象.
 *         2. 创建元素对象.
 *         3. 添加元素到集合中.
 *         4. 遍历集合.
 */
public class Demo02 {
    public static void main(String[] args) {
//        集合的使用步骤:
//        1. 创建集合对象.
        List<Student> list = new ArrayList<Student>();
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
//        方式2:列表迭代器
        ListIterator<Student> lit = list.listIterator();
        while (lit.hasNext()) {
            Student s = lit.next();
            System.out.println(s);
        }

        System.out.println("--------------------");
        //方式3:普通for循环
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s);
        }
        System.out.println("--------------------");
        //方式4:增强for循环
        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println("--------------------");
        //方式5:转数组,再遍历
        Object[] objs = list.toArray();
        for (Object obj : objs) {
            System.out.println(obj);
        }
    }


}
