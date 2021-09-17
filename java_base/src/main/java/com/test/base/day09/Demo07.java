package com.test.base.day09;

/**
 * @Author: Jface
 * @Date: 2021/5/13 18:41
 * @Desc:
 * 1. 已知字符串"woaiheima,buguanheimahaishibaima,zhaodaogongzuojiushihaoma",
 * 将"heima"字符串在上述字符串中出现的次数打印到控制台上.
 * 分析:
 * 1.定义已知的字符串
 * 2.把'heima'替换成A字母
 * 3.把字符串转换成数组
 * 4.求数组中A出现的次数
 * 5.打印输出结果

 方式1:截取字符串
 方式2:切割(有弊端)
 方式3:替换(弊端)
 方式4:计算长度
 */
public class Demo07 {
    public static void main(String[] args) {
        //方式3:
//        1.定义已知的字符串
        String s ="woaiheima,buguanheimahaishibaima,zhaodaogongzuojiushihaoma";
        int count3 = method01(s);
//        5.打印输出结果
        System.out.println("字符串中出现'heima'的次数为:"+count3);
        //方式4:计算长度
        String min ="heima";
        int count4 =(s.length()-s.replace(min,"").length()) / min.length();
    }


    private static int method01(String s) {
        //2.把"heima"替换成A字母
        String s1 =s.replace("heima","A");
//        3.把字符串转换成数组
        char[] arr =s1.toCharArray();
//        4.求数组中A出现的次数
        int count = 0;
        for (char c : arr) {
            if (c == 'A')
                count++;
        }
        return count;
    }
}
