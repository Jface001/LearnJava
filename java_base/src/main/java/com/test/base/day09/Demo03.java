package com.test.base.day09;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/13 15:26
 * @Desc: 3. 键盘录入一个纯数字形式的字符串, 中间用, 隔开, 获取该字符串中, 所有的数字之和.
 * 例如:
 * 用户录入: 11, 22, 33, 44, 55
 * 则计算结果为: 165
 */
public class Demo03 {
    public static void main(String[] args) {
        //1.新建键盘录入
        Scanner sc = new Scanner(System.in);
        //2.提示录入纯数字的形式的字符串
        System.out.println("请输入一组整数字,数字与数字之间请用','隔开: ");
        //3.接收输入的字符串并去除"," 转换成字符串数组
        String s = sc.nextLine();
        String[] arrStr = s.split(",");
        //4.定义一个整数数组, 用来接收转换之后的数组.
        int[] arrInt = new int[arrStr.length];
        //5.用for循环,获取字符数
        for (int i = 0; i < arrInt.length; i++) {
            //arrStr[i]代表字符串数组的元素,arrInt[i]代表整数数组的元素
            arrInt[i] = Integer.parseInt(arrStr[i]);
        }
        //.求数组之和
        int sum = arrInt[0];//定义成数组第一个元素,可以少+一次,节约资源,提高效率
        for (int i = 1; i < arrInt.length; i++) {//从数组第2个元素开始相加,因为第1个是sum
            sum += arrInt[i];
        }
        //.打印输出
        System.out.println("输入的字符串中所有数字之和是:" + sum);
    }
}
