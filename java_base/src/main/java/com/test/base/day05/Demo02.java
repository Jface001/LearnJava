package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/8 18:13
 * @Desc: 需求:打印1~100之间的所有质数,按照3个一行的格式输出
 * 质数(素数) :只能被1和自身整除的自然数,不包括1,2是最小的质数
 */
public class Demo02 {
    public static void main(String[] args) {
        // 外循环遍历从2到N的自然数
        A:
        for (int i = 2, count = 0; i <= 100; i++) {
            // 内循环从2开始将n和2到n/2的自然数逐个相除,如果余数为0则表示符合要求
            //  这里定义count 方便统计输出个数,以便按照要求换行
            for (int j = 2; j <= i / 2; j++) {
                //  在内循环有符合条件的i ,说明不是质数, A循环马上跳过到下一个数,继续对比
                if (i % j == 0) continue A;
            }
            // 打印输出语句需要在A循环里,因为每个符合要求的i都要循环输出
            // "\r\n"表示换行  "\t"表示tab缩进
            System.out.print((++count % 3 == 0) ? i + "\r\n" : i + "\t");
        }
    }
}
