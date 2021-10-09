package com.test;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/10/9 21:45
 * @Desc: 尼科彻斯定理
https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b
找规律，经观察：第一项为n(n-1)+1，最后一项为n(n+1)-1，把中间的数print一下就ok
 */
public class HJ76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int start = n*(n-1)+1;
            int end = n*(n+1)-1;
            for (int i = start; i <= end; i+=2) {
                if(i==end){
                    System.out.println(i);
                }
                else{
                    System.out.print(i+"+");
                }

            }
        }
    }
}
