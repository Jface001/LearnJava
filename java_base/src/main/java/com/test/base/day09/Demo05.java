package com.test.base.day09;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/13 16:50
 * @Desc: 步骤:
 * 5. 提示用户录入年份, 计算该年的2月有多少天, 并将结果打印到控制台上.
 * 1. 提示用户录入年份, 并接收.   Scanner#nextInt();	 2020
 * 2. 创建日历类对象Calendar对象, 用于操作时间.
 * Calendar#getInstance();    抽象类		   Calendar类的子类对象
 * Calendar c = Calendar.getInstance();		//多态
 * 3. 把时间设置为该年的3月1日. 	Calendar#set(int year, int month, int day);  月份: 0-11
 * 4. 把当前时间往前推一天.			Calendar#add(日历字段, 数字);   负数往前, 正数往后.
 * 5. 获取改天是月中的哪一天即可.	Calendar#get(Calendar.DATE);
 */
public class Demo05 {
    public static void main(String[] args) {
        //1.新建键盘录入
        Scanner sc = new Scanner(System.in);
        //2.提示用户输入一个年份数字
        System.out.println("请输入一个年份,我们会判断该年份2月有多少天:");
        //3.接收输入的数值
        int a = sc.nextInt();
        //方法1:
        //1.1创建一个日历对象,用于设定时间
        Calendar cal = Calendar.getInstance();//日历类多态
        //1.2.把日历时间设置为年3月1日
        cal.set(a, 2, 1);//月份的范围是0~11 ,所以3月是 2
        //1.3把时间往前推1天
        cal.add(Calendar.DAY_OF_MONTH, -1);
        //1.4获取当前时间(2月) 有多少天,并打印输出
        //Calendar#get方法获取当前时间的某些字段
        System.out.println("该年份2月一共有" + cal.get(Calendar.DAY_OF_MONTH) + "天");
        System.out.println("-----------------------------");
        // 方法2:if条件方法:能被4整除的2月就有29天,不能的就有28天.
        if (a % 4 == 0) System.out.println("该年份2月一共有29天");
        else System.out.println("该年份2月一共有28天");
        System.out.println("-----------------------------");
        // 方法2三元优化版
        System.out.println("该年份2月一共有" + ((a % 4 == 0) ? "29天" : "28天"));


    }
}
