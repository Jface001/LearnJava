package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 21:11
 * @Desc: 需求:打印1~100之间的所有质数,按照3个一行的格式输出
 * 质数(素数) :只能被1和自身整除的自然数,不包括1,2是最小的质数
 */
public class Demo01 {
    public static void main(String[] args) {
//        1.求出1~100的质数
//        1.1 偶数肯定不是质数,所有循环可以去掉偶数
//        1.2 如果n 在2~n之间 只能被2和n整除 即只有2和n和n相除余数为0
        //用来统计因子数
        int tmp = 0; //用来统计每行个数
        for (int i = 2; i <= 100; i++) {//外循环,n逐个验证是否符合条件
            int count = 0;// 需要写到外循环里面,因为每次对比都需要初始化,从0开始统计.
            for (int j = 1; j <= i; j++) {//内循环,将确定的数n逐个和小于n的数相除,通过count得出n有几个因子数
                if (i % j == 0)
                    count++;
            }
//            System.out.println(count);// 测试一下count是否符合要求
            if (count == 2) {  //判断n的因子数是否为2, 如果是2,符合要求打印输出
                System.out.print(i + "\t");//外条件 每次都打印
                tmp++;// 增加一个计数变量,用于统计目前到底打印到第几个
                if (tmp % 3 == 0) // 当n打印到第3个,就输出一个换行符,实现换行
                    System.out.println();
            }
        }
    }
}



