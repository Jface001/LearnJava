package com.test.base.day04;

/**
 * @Author: Jface
 * @Date: 2021/5/7 23:14
 * @Desc:
 * 6. 已知序列1, 1, 2, 3, 5, 8, 13..., 求第12个数字是多少.
 * 	公式/规律: 从第3个数字开始, 它 =  前两个数字之和.
 *又称 不死神兔(递归案例) 斐波那契数列
 */
public class Demo06 {
    public static void main(String[] args) {// 增加代码的复用性,能不写死就不要写死
//        1.新建数组,定义数组长度12
        int[] arr=new int[12];
//        2.从第三个数开始,i等于前两个数之和
        arr[0]=1;
        arr[1]=1;
//        3.确认规律,通过循环获取后面的数
        for (int i = 2; i <arr.length ; i++) {
            arr[i]= arr[i-1]+arr[i-2];
        }
//        4.打印输出结果
        System.out.println("第"+arr.length+"个数是:"+arr[arr.length-1]);//下标需要-1,牢记在心
    }
}
