package com.test.base.day11;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/16 11:51
 * @Desc:
第八题: 通过代码, 完成如下需求:
 * 1. 键盘录入一个字符串，要求统计字符串中每个字符串出现的次数。
 * 2. 举例：键盘录入“aababcabcdabcde”  在控制台输出：“a(5)b(4)c(3)d(2)e(1)”
 * 优化版!
 */
public class Demo08_2 {
    public static void main(String[] args) {
        //新建键盘录入
        System.out.println("请输入一个字符串:");
        //接收录入字符串,并转化成字符数组
        //新建一个HashMap集合, 健是出现的字符,值就是字符出现的次数
        HashMap<Character, Integer> hm = new HashMap<>();
        //遍历字符数组并做判断,如果字符出现过就值+1 ,如果没有出现过就添加 (字符,1)
        for (Character c : new Scanner(System.in).nextLine().toCharArray()) {
            hm.put(c,(hm.containsKey(c)?hm.get(c)+1:1 ));
        }
        //为啥普通数组循环不能简化???
//        for (int i = 0; i < new Scanner(System.in).nextLine().toCharArray().length; i++) {
//            char c = new Scanner(System.in).nextLine().toCharArray()[i];
//            //c自动拆装箱,在char 和Character之间转换
//            hm.put(c,(hm.containsKey(c)?hm.get(c)+1:1 ));
//        }
        //遍历集合,按照要求拼接
        for (Character c : hm.keySet()) {
            System.out.print(c + "(" + hm.get(c) + ")");
        }
    }
}
