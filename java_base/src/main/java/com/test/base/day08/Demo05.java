package com.test.base.day08;

import java.util.Arrays;

/**
 * @Author: Jface
 * @Date: 2021/5/11 20:41
 * @Desc:
需求5  	//两种思路: 思路1: String, 思路二: StringBuilder
1.定义方法arrayToString(), 把int数组的元素按照指定的格式拼接成一个字符串, 并返回.
2.在main方法中, 调用上述的方法.
3.例如: 数组为int[] arr = {1, 2, 3}, 则拼接后, 结果为: [1, 2, 3]
 */
public class Demo05 {
    public static void main(String[] args) {
        //1.定义一个数组Int
        int[] arr ={1,2,3};
        //方法1:使用String,自定义方法
        //2.调用arrayToString方法
        String b = Demo05.arrayToString(arr);// 是静态方法,所以通过类名.的方式调用,可以省略
        System.out.println(b);
        System.out.println("----------------");

        //方法2:使用StringBuilder方法
        String c = arrayToString2(arr);// 是静态方法,所以通过类名.的方式调用,可以省略
        System.out.println(c);
        System.out.println("----------------");
        //方法3:通过 Arrays#toString()方法实现
        System.out.println(Arrays.toString(arr));
    }


    //3.设计封装自定义的arrayToString 方法
    public static String arrayToString (int[] arr){
        //3.1先做非法值校验.
        if(arr == null || arr.length == 0){
            return "[]";
        }
        //3.2 定义一个字符串,用来接收拼接结果,数组最开始是"["
        String a ="[";
        //3.3遍历数组的值,判断是否是最后一个值
        for (int i = 0; i < arr.length; i++) {
            if ((i == arr.length - 1)) {
                a += arr[i] + "]";
            } else {
                a += arr[i] + ",";
            }
        }
        return a;
    }

    public static String arrayToString2 (int[] arr){
        //2.1先做非法值校验.
        if (arr == null || arr.length == 0) {
            return "[]";
        }
        //2.2 定义字符串缓冲区变量,用来接收和记录结果
        StringBuilder sb = new StringBuilder("[");
        //2.3遍历数组,获取每个元素
        for (int i = 0; i < arr.length; i++) {
            int c = arr[i];
            if (i == arr.length - 1) {
        //2.4判断是否是最后一个元素,是就加"]"
                sb.append(arr[i] + "]");
            }
        //2.5 不是加","
            else {
                sb.append(arr[i] + ",");
            }

        }

        return sb.toString();
    }

}
