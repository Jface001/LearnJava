package com.test.base.day09;

import java.util.Arrays;

/**
 * @Author: Jface
 * @Date: 2021/5/12 21:02
 * @Desc: 2. 已知字符串String s = "91 27 45 38 50";
 * 请通过代码实现最终输出结果是: "27, 38, 45, 50, 91"
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.定义要操作的字符串
        String s = "91 27 45 38 50";
        //2.把字符串切割成 各个字符
        String[] arr = s.split(" ");
        //3.for循环,获取每个字符
        //定义一个整数数组,接收切割之后的数组,
        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            // 把字符数组的每个字符转成int类型,然后存到新数组中
            //arrInt[i]是新数组的元素,arr[i]是字符数组里面的元素
            //Integer()方法,
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        //4.整数数组进行排序
        // sort()方法,给数组排序,静态类方法,直接类名. 方法调用
        Arrays.sort(arrInt);
        //5.把整数数组拼接成字符串
        String s1 = Arrays.toString(arrInt);
        //方法1:截取
        String result1 = s1.substring(1, s1.length() - 1);
        System.out.println(result1);
        System.out.println("---------------------");
        // 方法2:替换
        String result2 = s1.replace("[", "").replace("]", "");
        //6.打印输出
        System.out.println(result2);


    }
}
