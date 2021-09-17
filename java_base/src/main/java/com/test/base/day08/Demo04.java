package com.test.base.day08;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/11 20:27
 * @Desc:
 * 需求4:
 * 键盘录入一个字符串, 统计该字符串中大写字母字符, 小写字母字符, 数字字符出现的次数.
 * 注意: 不考虑其他字符, 例如@, !, \, /等
 */
public class Demo04 {
    public static void main(String[] args) {
        //1.新建键盘录入
        Scanner sc = new Scanner(System.in);
        //2.提示输入字符串
        System.out.println("请输入一个字符串,我们会判断字符串中,大写字母字,符小写字母字符和数字字符出现的次数.");
        //3.接收字符串
        String str = sc.nextLine();
        //4.定义3个count,用于接收3类字符出现的次数
        int bigCount = 0;
        int smallCount = 0;
        int numCount = 0;
        //5.遍历字符串,获取各个字符
        char[] cha = str.toCharArray();
        for (int i = 0; i < cha.length; i++) {
            char c = cha[i];
            //6.使用 if 判断3种字符出现的次数,用对应的count接收
            //牢记,char 用单引号, String 用双引号
            if ((c >= 'A') && (c <= 'Z')) {
                bigCount++;
            } else if ((c >= 'a') && (c <= 'z')) {
                smallCount++;
            } else if ((c >= '0') && (c <= '9')) {
                numCount++;
            }
        }
        //7.输出对应count
        System.out.println("该字符串大写字母字符出现次数是:" + bigCount);
        System.out.println("该字符串小写字母字符出现次数是:" + smallCount);
        System.out.println("该字符串数字字符出现次数是:" + numCount);


    }
}
