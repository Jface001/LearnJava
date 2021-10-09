package com.test;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/10/9 21:43
 * @Desc: 字符串逆序
https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b
 *
 */
public class HJ106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            StringBuffer buffer = new StringBuffer(sc.nextLine());
            System.out.println(buffer.reverse());
        }
    }
}
