package com.test.base.day10;


import com.test.base.pojo.Student;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/14 20:22
 * @Desc:
第四题: 通过代码, 完成如下需求:
1. 自定义一个学生类，给出成员变量name和age.
2. 定义ArrayList集合, 用来存储学生对象.
3. 键盘录入3个学生的信息, 将他们封装成学生对象后, 添加到ArrayList集合中.
4. 判断集合中是否有姓名叫 刘亦菲 的学生, 如果有, 就往集合中添加学生对象: 糖糖, 18
5. 遍历集合. 	//用任意一种方式遍历即可.
 分析
 1.新建键盘录入
 2.for循环提示键盘录入
 3.新建学生类对象,用于存储录入学生对象
 4. 创建集合对象.
 5创建元素对象.
 6.添加元素到集合中.
 7.判断是否
 8.遍历集合.
 * 方式1:普通迭代器
 * 方式2:列表迭代器
 * 方式3:普通for循环
 * 方式4:增强for循环
 * 方式5:转数组,再遍历

 */
public class Demo04 {
    public static void main(String[] args) {
//        1.新建键盘录入
        Scanner sc =new Scanner(System.in);
        //2.创建集合对象
        ArrayList<Student> list = new ArrayList<Student>();
        //3.for循环提示键盘录入
        for (int i = 1; i <=3; i++) {
            //3.创建学生对象,接收键入数值
            Student s = new Student();
            System.out.println("请输入第"+i+"个学生的姓名:");
            s.setName(sc.nextLine());
            //4.把age输入的String类型转换成int类型
            System.out.println("请输入第"+i+"个学生的年龄:");
            s.setAge(Integer.parseInt(sc.nextLine()));
            //添加元素到集合
            list.add(s);
        }
        System.out.println(list);
        System.out.println("-----------------------");
        //需求1:判断集合中是否有姓名叫 刘亦菲 的学生, 如果有, 就往集合中添加学生对象: 糖糖, 18
        ListIterator<Student> lit = list.listIterator();
        while (lit.hasNext()) {
            Student s =  lit.next();//s就是集合中每个元素
            if("刘亦菲".equals(s.getName())){
                lit.add(new Student("糖糖",18));
            }

        }
        System.out.println("-----------------------");
        //需求2:遍历集合. 	//用任意一种方式遍历即可.
        for (Student s : list) {
            System.out.println(s);
        }





    }
}
