package com.test.base.day04;

/**
 * @Author: Jface
 * @Date: 2021/5/7 23:46
 * @Desc:
 * 10. 定义Demo10类, 在main中调用getMax()方法, 用来获取两个整数的最大值.
 * 		目的: 本题主要考察 有参有返回的方法 的定义和调用.
 *
 * 		提示:
 * 			1. 在main方法外边定义getMax()方法.
 * 			2. getMax()方法接收两个int类型的变量.
 * 			3. 在getMax()方法内部实现获取两个整数的最大值, 并返回结果.
 * 			4. 在main方法中调用getMax()方法.
 */
public class Demo10 {
    public static void main(String[] args) {
/*2.调用方法3步
  2.1 方法名();
  2.2 传参
  2.3 接收返回值
* */
//        输出调用
        System.out.println(getSum(3,2));
//        赋值调用
        int a=5;
        int b=6;
        int sum=getSum(a,b);
        System.out.println(sum);
    }

    /**
     * 该方法用来求输入的两个整数的最大值
     * @param a 输入的第一个整数
     * @param b 输出的第二个整数
     * @return 输入的两个整数的最大值
     */
//    1.定义方法3步
//    2.1 明确方法名 getSum
//    3.2 明确参数类型 int a, int b
//    4.3 确认返回值类型 return int
    public static int getSum(int a,int b) { //形式参数 int a= ?  int b= ?
//        方法1：if else
//        if (a > b)
//            return a;
//        else
//            return b;
//        方法2：三元
        return a > b ? a : b;// 牢记不用写"="!! return 接收一个int 值，三元运算结果就是这个
    }
}
