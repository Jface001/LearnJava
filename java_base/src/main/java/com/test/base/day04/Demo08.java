package com.test.base.day04;

/**
 * @Author: Jface
 * @Date: 2021/5/7 23:35
 * @Desc: 8. 定义Demo08类, 在main中调用getSum()方法, 用来获取两个整数的和.
 * 目的: 本题主要考察 有参有返回的方法 的定义和调用.
 * 提示:
 */
public class Demo08 {
    public static void main(String[] args) {
        //直接调用
        getSum(12, 13);//没有结果,因为没有打印输出
        // 输入调用
        System.out.println(getSum(12, 13));
//        赋值调用
        int a = 12;
        int b = 13;
        int sum = getSum(a, b);
        System.out.println(sum);
    }

    //1. 定义getSum()方法.
    public static int getSum(int a, int b) {  // 有参数输入,需要返回参数
        int sum = a + b;//实现求两个整数和, 并返回结果.
        return sum; //返回整数之和
    }


}
