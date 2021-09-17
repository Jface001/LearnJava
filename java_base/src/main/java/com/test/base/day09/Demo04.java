package com.test.base.day09;

import com.test.base.utils.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author: Jface
 * @Date: 2021/5/13 16:32
 * @Desc: 4. 定义工具类DateUtils, 该类有两个方法: date2String(), string2Date(), 分别用来格式化, 解析日期.
 * 在测试类中, 测试上述的两个方法.
 */
public class Demo04 {
    public static void main(String[] args) throws ParseException {
        //需求1:测试格式化方法是起效
        //1.1定义一个Date变量
        Date d = new Date();
        //1.2调用date2String方法格式化
        //这里的模板是你可以自定义的,方法是静态方法,所以可以通过类名.方式调用
        String s = DateUtils.date2String(d, "yyyy年MM月dd日 HH:mm:ss");
        //1.3打印输出返回值
        System.out.println("格式化日期之后返回的值是" + s);
        System.out.println("----------------------------");

        //需求2:测试解析方法是否起效
        //2.1定义一个字符串,需要符合日期格式
        String s1 = "2021-05-12 18";
        //2.2 调用string2Date 方法解析
        //这里的模板是传入的字符串对应的日期格式,不能自定义
        Date d1 = DateUtils.string2Date(s1, "yyyy-MM-dd HH");
        //2.3打印输出返回值
        System.out.println("解析之后返回的值是" + d1);
    }
}
