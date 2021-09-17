package com.test.base.day08;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/11 20:12
 * @Desc:
 * 需求3:
 * 键盘录入一个字符串, 使用程序实现在控制台遍历打印该字符串.
 */
public class Demo03 {
    public static void main(String[] args) {
        //1.新建键盘录入
        Scanner sc = new Scanner(System.in);
        //2.提示输入
        System.out.println("请输入一个字符串:");
        //3.接收字符串
        String str = sc.nextLine();
//        System.out.println(str); 测试一下字符串是否接收成功
        //4.遍历字符串
        //方法一: 使用chatAt() 和length()方法,字符串底层上就是一个数组
        for (int i = 0; i < str.length(); i++) {
            char cha = str.charAt(i);
            System.out.println(cha);
        }
        System.out.println("------------");
        //方法二: 使用toCharArray()方法,先把字符串转成数组,在再遍历
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            System.out.println(c);
        }

    }
}
