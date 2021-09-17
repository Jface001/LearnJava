package com.test.base.day04;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/7 23:27
 * @Desc: 7. 定义Demo07类, 在main方法中调用printHelloWorld()方法, 用来打印3次HelloWorld.
 * 目的: 本题主要考察两点.
 * 1. 无参无返回的方法 的定义和调用.
 * 2. 方法的功能越单一越好.
 * <p>
 * 简单版:
 * 提示:
 * 1. 在main方法外边定义printHelloWorld()方法.
 * 2. 在printHelloWorld()方法内部打印一次: "Hello World"
 * 3. 在main方法内部: 通过for循环, 调用三次 printHelloWorld()方法.
 * <p>
 * 升级版:
 * 1. 定义方法printHelloWorld2(), 该方法接收一个整数.
 * 2. 在方法内部实现, 根据传入的整数, 打印对应次数的"Hello World!"
 * 3. 在main方法中调用 printHelloWorld2()方法.
 */
public class Demo07 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
//            printHelloWorld();
            System.out.println("请输入你要需要循环输出的次数:");
            Scanner sc = new Scanner(System.in);// 新建键盘输入
            int num = sc.nextInt(); //新建一个参数,方便调入下放的方法
            printHelloWorld2(num);// num传入方法
        }

    }

    //    1.新建一个方法printHelloWorld()
    public static void printHelloWorld() {
        System.out.println("Hello World!");
    }

    //    2.新建一个方法printHelloWorld2()
    public static void printHelloWorld2(int a) {// 调用该方法需要输入一个整数值a
        for (int i = 0; i < a; i++) {
            System.out.println("Hello World!");
        }

    }
}
