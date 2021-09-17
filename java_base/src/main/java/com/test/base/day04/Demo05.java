package com.test.base.day04;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/6 14:09
 * @Desc: 5. 在编程竞赛中, 有6个评委为参赛的选手打分, 分数在0~100之间.
 * 假设小明参加比赛后, 评委对其进行打分, 求小明的平均分是多少, 并将结果打印到控制台上.
 * 提示: 选手的最后得分为: 去掉(一个最高分 + 去掉一个) , 然后和4取余即可.
 * 打印格式:
 * 请录入第一个评委的分数:
 * 90
 * 请录入第二个评委的分数:
 * 100
 * ...  //这里要接收6个教练的评分.
 * <p>
 * 选手的最终得分情况为: 去掉最高分**, 去掉最低分**, 求出平均分为: **
 */
public class Demo05 {
    public static void main(String[] args) {
//        1.获取评委6个评委的分数,用数列存储
        int[] arr = getScore(6);
//        2.求出数组最大值和最小值
        int max = getMax(arr);
        int min = getMin(arr);
//        3.求出数组之和
        int sum = getSum(arr);
//        4.求出平均分
        double avg = (sum - min - max) / (arr.length - 2);
//        5.打印输出
        System.out.println("选手的最终得分情况为:去掉最高分" + max + ",去掉最低分" + min + ",求出平均分为:" + avg);

    }


    //     1.定义方法getScore ,获取6个评委分数
    public static int[] getScore(int len) {
//        1.1创建数组,存储评委评分
        int[] arr = new int[len];
//        1.2循环提示输入评委评分
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个评委的打分:");
            arr[i] = getNumber();

        }
        return arr;// 获取len个分数,组成数列
    }

    //         1.3 数据校验,加上限制在[0,100]之间
    public static int getNumber() {
        Scanner sc = new Scanner(System.in); //
        while (true) {
            int num = sc.nextInt();
            System.out.println("请输入一个0~100之间的分数,若输入不正确,则需要重新输入,您的打分是:");
            if (num >= 0 && num <= 100) {
                return num;
            }

            }

    }

    //    2.1获取数组最大值的方法
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    //   2.2获取数组最小值的方法
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    //    3.求数组之和的方法
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

        }
        return sum;
    }


}
