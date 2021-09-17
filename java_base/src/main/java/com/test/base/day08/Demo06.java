package com.test.base.day08;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/11 21:34
 * @Desc:
 * 需求6:	//两种思路: 思路1: String, 思路二: StringBuilder
 * 1.定义方法reverse(), 实现字符串的反转.
 * 2.在main方法中键盘录入一个字符串, 调用上述的方法后, 在控制台输出结果.
 * 3.例如: 键盘录入abc, 输出结果cba.
 * 提示: 用for循环, 倒序遍历数组, 然后拼接每一个元素即可.
 */
public class Demo06 {
    public static void main(String[] args) {


        //方法1: 使用StringBuilder
        //1.新建键盘录入
        Scanner sc = new Scanner(System.in);
        //2.提示键盘录入字符串
        System.out.println("请输入一个字符串,我们会将其反转输出打印:");
        String str = sc.nextLine();
        //3.把字符串转换成字符串缓冲区
        StringBuilder sb = new StringBuilder(str);
        //4.反转字符串缓冲区
        sb.reverse();
        //5.把字符串缓冲区还原成字符串
        String str2 = sb.toString();
        System.out.println("方法1反转之后的结果是:" + str2);
        System.out.println("----------");
        //合并版:
        //链式编程
        String str3 = new StringBuilder(str).reverse().toString();
        System.out.println("合并版反转之后的结果是:" + str3);
        System.out.println("----------");

        //方法2:使用String类实现,先自定义一个方法,然后调用.
        reverse(str);

    }

    // 定义一个reverse方法,用于反转字符串,不需要返回值,输入数值是String.
    public static void reverse(String a) {
        //1.把字符串转换成数组
        char[] arr = a.toCharArray();
        //2.反转数组,并打印输出
        System.out.println("使用reverse方法调用结果是:");
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            System.out.print(c);

        }


    }


}
