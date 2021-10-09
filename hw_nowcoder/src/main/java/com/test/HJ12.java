package com.test;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/10/9 21:13
 * @Desc: 字符串反转
 * https://www.nowcoder.com/practice/e45e078701ab4e4cb49393ae30f1bb04
 */
public class HJ12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer buffer = new StringBuffer(str);
        StringBuffer result = buffer.reverse();
        System.out.println(result);


    }
}
