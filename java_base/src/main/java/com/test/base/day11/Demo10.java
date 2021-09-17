package com.test.base.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/16 15:32
 * @Desc: 第2题: 通过代码, 完成如下需求:
 * 1. 循环接收用户键盘输入的多个字符串，直到用户录入“end”时循环结束，并将所有已输入的字符串按字典顺序倒序打印。
 * 2. 按照3个字符串一行的格式输出.
 * ArrayList<String> list
 * Scanner sc = ...
 * while(true) {
 * String s = sc.nextLine();
 * if("end".equals(s))
 * break;
 * else
 * list.add(s);
 * }
 * Collections.sort(list);
 * Collections.reverse(list);
 * //遍历.
 */
public class Demo10 {
    public static void main(String[] args) {
        //1.新建键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入多个字符串,输入end结束输入,我们会输入的字符串进行排序 ");
        //2.新建ArrayList集合,接收用户录入的字符串
        ArrayList<String> list = new ArrayList<>();
        //3.循环判断是否有end,有就结束, 没有就添加到集合
        while (true) {
            String s = sc.nextLine();
            if ("end".equals(s)) {
                System.out.println("输入结束!排序好的字符串结果是:");
                break;
            } else list.add(s);
        }
        //4.给集合排序然后反转
        //升序排序
        Collections.sort(list);
        System.out.println(list);
        //反转变成降序排序
//        Collections.reverse(list);
//        System.out.println(list);
        //5.遍历集合数组
        //需求1:全部遍历
        for (String s : list) {
            System.out.println(s+" ");
        }
        System.out.println("-------------------------");
        //需求2:按照3个字符串一行格式输出
        for (int i = 1; i <= list.size(); i++) {
            String s =  list.get(i-1);//0/3余数为0,为了排除这个,从1开始循环.
            System.out.print(s + ((i % 3==0)?"\n\r":"\t"));
        }

    }
}
