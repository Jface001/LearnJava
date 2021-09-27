package com.test.offer;

/**
 * @Author: Jface
 * @Date: 2021/7/23 12:15
 * @Desc:
 * 斐波那契数列: 这个数列从第3项开始，每一项都等于前两项之和。
 *
 */
public class JZ7 {
    public static void main(String[] args) {

    }


    public int Fibonacci(int n) {
        if (n==0 || n==1) {
            return  n;
        }
        int a= 0;
        int b= 1;
        int sum =0;
        for (int i = 2; i <=n; i++) {
            sum=a+b;
            a=b;
            b=sum;
        }
        return  sum;
    }

}


