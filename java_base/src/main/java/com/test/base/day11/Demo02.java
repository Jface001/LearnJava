package com.test.base.day11;

import java.util.HashSet;

/**
 * @Author: Jface
 * @Date: 2021/5/16 10:00
 * @Desc: 第二题: 通过代码, 完成如下需求:
 * 1. 编写一个程序, 获取10个 20~50 之间的随机数.  Math.random()
 * 20~50 -> 0 - 30 -> Math.random(), 0.0 1.0
 * (int)(Math.random() * 31) + 20
 * 包含20, 50
 * 2. 要求随机数不能重复, 并将结果打印到控制台上.
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.新建集合,用于存储随机数
        HashSet<Integer> hs = new HashSet<>();
        //2.while循环 把随机数存入hashset集合
        while(hs.size() < 10){
            int num = (int)(Math.random()*31)+20;
            hs.add(num);
        }
        System.out.println(hs);//测试一下是否成功.
        //3.遍历集合,打印随机数
        for (Integer i : hs) {
            System.out.println(i);
        }

    }
}
