package com.test.base.day10;

import java.util.LinkedList;

/**
 * @Author: Jface
 * @Date: 2021/5/14 20:34
 * @Desc: 第五题: 通过代码, 完成如下需求:
 * 1. 定义LinkedList集合, 存储字符串数据, 例如: "hello", "world", "java".
 * 2. 测试LinkedList集合中常用的方法.
 * //addFirst(), addLast(), removeFirst(), removeLast(), getFirst(), getLast()
 */
public class Demo05 {
    public static void main(String[] args) {
//        1. 创建集合对象
        LinkedList<String> list = new LinkedList<String>();
//        2.存储字符串数据
        list.add("hello");
        list.add("world");
        list.add("java");
        System.out.println(list);
        System.out.println("-----------------");
//        3.测试list集合常用的方法.
//        addFirst(),添加元素到首尾
        list.addFirst("hadoop");
        System.out.println(list);

        System.out.println("-----------------");
//        addLast(),添加元素到末尾
        list.addLast("hive");
        System.out.println(list);

        System.out.println("-----------------");
//        removeFirst(),移除首位元素,并返回被移除的元素
        System.out.println(list.removeFirst());//hadoop
        System.out.println(list);

        System.out.println("-----------------");
//        removeLast(),移除末尾元素,并返回被移除的元素
        System.out.println(list.removeLast());//hive
        System.out.println(list);

        System.out.println("-----------------");
//        getFirst(),获取首尾元素
        System.out.println(list.getFirst());//hello

        System.out.println("-----------------");
//        getLast(),获取末尾元素
        System.out.println(list.getLast());//java


    }
}
