package com.test.base.day09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/13 17:38
 * @Desc:
6. 提示用户录入他的出生年月日, 计算这个用户一共活了多少天, 并将结果打印到控制台上.
 分析:
 1.获取出生年月日的毫秒时间
 2.获取当前时间的毫秒时间
 3.获取这两个时间的差
 4.把毫秒差转换成日 /24/60/60/1000
 5.打印输出
 涉及到的知识点
currentTimeMillis() 当前时间毫秒值
SimpleDateFormat#parse String --> date



 */
public class Demo06 {
    public static void main(String[] args) throws ParseException {
        //1.新建键盘录入
        Scanner sc = new Scanner(System.in);
        //2.提示用户输入出生年月日
        System.out.println("请输入你的出生年月日,格式为年/月/日.");
        //3.接收输入的字符串,并转换成日期对象
        String s =sc.nextLine();
        //使用parse()方法解析字符串成日期
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
        Date d1 =sdf.parse(s);
        //4.把日期转换成毫秒值
        long start =d1.getTime();
        //5.比较日期时间和当前日期之间的毫秒值
        long end =(System.currentTimeMillis()-start)/24/60/60/1000;
        //6.打印输出结果
        System.out.println("你已经存在于地球上已经"+end+"天");
        System.out.println("------------");
        // 方法2:拆分年月日,分别求之间的天数只差,然后合并输出.

    }
}
