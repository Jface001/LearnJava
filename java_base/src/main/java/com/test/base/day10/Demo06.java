package com.test.base.day10;

import java.util.ArrayList;

/**
 * @Author: Jface
 * @Date: 2021/5/14 20:46
 * @Desc:
第六题: 通过代码, 完成如下需求: 234都有5种解题思路
1. 定义ArrayList集合，存入多个字符串, 例如: "ab1", "123ad", "def", "bca", "def", "def", "dadfadf"  "dddaaa"  "你好啊"  "我来啦"  "别跑啊"
2. 遍历集合, 删除长度大于5的字符串, 打印删除后的集合对象
3. 基于上一步, 删除集合中元素包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串), 打印删除后的集合对象.
4. 基于上一步, 删除集合中所有的"def"字符串, 打印删除后的集合对象.

分析
1.定义集合并存入数据
2.普通for循环--删除长度大于5的字符串  String#length()方法
2.1普通迭代器
2.2增强迭代器
2.3普通for循环正向删除,细节注意i--
2.4普通for循环逆向删除,
CopyonWriteArrayList
3.普通for循环--删除集合中元素包含0-9数字的字符串 ArrayList#toString()
思路1: for循环嵌套  思路2: 正则表达式
也有5种方式,一起10种解决方案
4.普通for循环--删除集合中所有的"def"字符串 String#equals()方法
 */
public class Demo06 {
    public static void main(String[] args) {
//         1. 创建集合对象.
        ArrayList<String> list = new ArrayList<String>();
//         2. 添加元素到集合中.
        list.add("ab1");
        list.add("123ad");
        list.add("def");
        list.add("bca");
        list.add("def");
        list.add("def");
        list.add("dadfadf");
        list.add("dddaaa");
        list.add("你好啊");
        list.add("我来啦");
        list.add("别跑啊");
        //3.for循环--删除长度大于5的字符串  String#length()方法
        for (int i = 0; i < list.size(); i++) {
            String s =  list.get(i);
            if(s.length()>5) {
                list.remove(s);
            }
        }
        System.out.println(list);
        System.out.println("-----------------------");
        //3.普通for循环--删除集合中元素包含0-9数字的字符串 ArrayList#toString()
//        for (int i = 0; i < list.size(); i++) {
//            String s =  list.get(i);
//            if(s.endsWith(0))
//        }
        //4.普通for循环--删除集合中所有的"def"字符串 String#equals()方法
        for (int i = 0; i < list.size(); i++) {
            String s =  list.get(i);
            if("def".equals(s)){
                list.remove(s);
            }
        }
        System.out.println(list);

    }
}
