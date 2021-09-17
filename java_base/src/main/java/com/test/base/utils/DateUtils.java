package com.test.base.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Jface
 * @Date: 2021/5/13 16:33
 * @Desc: 4. 定义工具类DateUtils, 该类有两个方法: date2String(), string2Date(), 分别用来格式化, 解析日期.
 * 在测试类中, 测试上述的两个方法.
 */
public class DateUtils {
    //1.成员属性 全部私有,静态属性和静态方法,方便调用
    private static SimpleDateFormat sdf;

    //2.构造方法,私有化
    private DateUtils() {
    }

    ;

    //3.成员方法 1 :date2String()
    // 定义方法的3个步骤
    // 1. 明确方法名, getSum
    // 2. 明确参数列表, int a,int b
    // 3. 明确返回值的数据类型  int

    /**
     * 用于把日期格式化成字符串
     *
     * @param d       输入的日期
     * @param pattern 格式化时的模板
     * @return 格式化返回的字符串对象
     */
    public static String date2String(Date d, String pattern) {
        sdf = new SimpleDateFormat(pattern);//静态常量,可以直接通过类名. 的方法调用
        return sdf.format(d);
    }

    /**
     * @param str     需要解析的字符串值,注意需要符合日期格式
     * @param pattern 解析时需要的格式魔板
     * @return 解析后返回的日期值.
     * @throws ParseException
     */
    //4.成员方法2 :string2Date()
    public static Date string2Date(String str, String pattern) throws ParseException {//抛出异常
        sdf = new SimpleDateFormat(pattern);//静态常量,可以直接通过类名. 的方法调用
        return sdf.parse(str);
    }
}
