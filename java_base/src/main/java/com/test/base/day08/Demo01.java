package com.test.base.day08;

/**
 * @Author: Jface
 * @Date: 2021/5/11 18:23
 * @Desc:
 * 需求1:
 * 1.定义字符数组chs, 初始化值为: 'a, 'b', 'c', 这三个字符 .
 * 2.将其分别封装成s1, s2这两个字符串对象.
 * 3.直接通过""的方式创建两个字符串对象s3和s4.
 * 4.通过==分别判断s1和s2, s1和s3, s3和s4是否相同.
 * 5.通过equals()分别判断s1和s2, s1和s3, s3和s4是否相同.
 * 6.通过equalsIgnoreCase()判断字符串abc和ABC是否相同.
 */
public class Demo01 {
    public static void main(String[] args) {
//        1.定义字符数组chs, 初始化值为: 'a, 'b', 'c', 这三个字符 .
        char[] chs = {'a', 'b', 'c'};// char用单引号 ,String用双引号, 单引号和双引号用法不同.
//        2.将其分别封装成s1, s2这两个字符串对象.
        String s1 = new String(chs);
        String s2 = new String(chs);
//        3.直接通过""的方式创建两个字符串对象s3和s4.
        String s3 = "abc";
        String s4 = "bcd";
        System.out.println("-------------");
//        4.通过==分别判断s1和s2, s1和s3, s3和s4是否相同.
        //"=="基本数据类型比较数值, 引用数据类型比较地址值
        System.out.println(s1 == s2);// false,new一个对象开辟一个空间,有不同的地址值
        System.out.println(s1 == s3);//false, s3数值存在常量池,地址值和在堆区的s1不同
        System.out.println(s3 == s4);//false, 在常量池中的地址值不同.
        System.out.println("-------------");
//        5.通过equals()分别判断s1和s2, s1和s3, s3和s4是否相同.
        System.out.println(s1.equals(s2));
        ;//true // String类重写了继承自Object#equals()方法,比较的是属性值,下同
        System.out.println(s1.equals(s3));
        ;//true //
        System.out.println(s3.equals(s4));
        ;//false //
        System.out.println("-------------");
//        6.通过equalsIgnoreCase()判断字符串abc和ABC是否相同.
        String s5 = "ABC";
        System.out.println(s1.equalsIgnoreCase(s5));//true,重写了equalsIgnoreCase()方法,比较的是属性值

    }

}
