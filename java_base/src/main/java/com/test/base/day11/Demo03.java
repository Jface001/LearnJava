package com.test.base.day11;

/**
 * @Author: Jface
 * @Date: 2021/5/16 10:21
 * @Desc: 第三题: 通过代码, 完成如下需求:
 * 1. 定义方法getSum(), 用来获取n个整数的和.
 * 2. 在main方法中调用getSum()方法.
 * 3. 要求: 通过可变参数实现.
 */
public class Demo03 {
    public static void main(String[] args) {
        //倒推思路
        //1.调用方法getSum
        int sum = getSum(22, 22, 22, 22, 22);
        //2.打印输出
        System.out.println(sum);
    }

    //0.定义方法
    private static int getSum(int... a) {
        //0.1明确方法名:getSum()
        //0.2明确返回值类型:int
        //0.3明确参数列表:可变参数 数据类型...变量名
        int tmp = 0;//定义一个变量,用于接收返回值
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            tmp += i1;//求和,每次循环都把i1的值+给tmp.

        }
        return tmp;
    }
}
