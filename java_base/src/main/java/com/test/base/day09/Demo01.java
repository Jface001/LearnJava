package com.test.base.day09;

import java.util.Arrays;

/**
 * @Author: Jface
 * @Date: 2021/5/12 20:43
 * @Desc: 1. 已知数组int[] arr = {25, 69, 80, 57, 13}, 请编写代码对齐进行升序排序.
 * 即: 排序后结果为: arr = {13, 25, 57, 69, 80};
 * /两种思路实现.
 */
public class Demo01 {
    public static void main(String[] args) {
        //方法1,通过冒泡排序进行排序
        //1.定义要排序的数组
        int[] arr = {25, 69, 80, 57, 13};
        //2.两层for循环进行排序
        //外循环,控制总对比的次数,-1因为最后一个不用再对比了,节约资源
        for (int i = 0; i < arr.length - 1; i++) {
            //内循环,控制每次对比的次数, -1是为不数组越界,-i是减少每次对比次数,已经选定的值不用再对比一次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //越大的越往后走
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];// 牢记公式  tmp =a  a=b  b=tmp
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        //3.按照格式打印输出
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            System.out.print(i1 + (i == arr.length - 1 ? "]" + "\r\n" : ", "));
        }

        System.out.println("---------------------");
        // 方法2: 使用Arrays工具类中的方法
        // 使用sort()升序排序
        Arrays.sort(arr);//需要导包
        //使用toString()方法,直接打印输出
        System.out.println(Arrays.toString(arr));
    }
}
