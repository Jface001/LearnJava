package com.test;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/10/9 21:19
 * @Desc: 数字颠倒
 * https://www.nowcoder.com/practice/ae809795fca34687a48b172186e3dafe
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextInt()+"";
        StringBuffer buffer = new StringBuffer(str);
        System.out.println(buffer.reverse());
    }
}
