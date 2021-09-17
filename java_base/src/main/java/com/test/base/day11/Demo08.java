package com.test.base.day11;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/16 11:32
 * @Desc: 第八题: 通过代码, 完成如下需求:
 * 1. 键盘录入一个字符串，要求统计字符串中每个字符串出现的次数。
 * 2. 举例：键盘录入“aababcabcdabcde”  在控制台输出：“a(5)b(4)c(3)d(2)e(1)”
 */
public class Demo08 {
    public static void main(String[] args) {
        //1.新建键盘录入,提示输入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入的一个字符串:");
        //2.接收录入字符串,并转化成字符数组
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        //3.新建一个HashMap集合, 健是出现的字符,值就是字符出现的次数
        HashMap<Character, Integer> hm = new HashMap<>();
        //4.遍历字符数组并做判断,如果字符出现过就值+1 ,如果没有出现过就添加 健和值(1)
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);//自动拆装箱
            } else {
                hm.put(c, 1);
            }
        }
        //遍历集合,按照要求拼接
        for (Character c : hm.keySet()) {
            System.out.print(c + "(" + hm.get(c) + ")");
        }


    }
}
