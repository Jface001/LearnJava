package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 17:57
 * @Desc: 1. 定义手机类Phone, 属性和行为如下, 并在测试类PhoneTest中, 创建手机类的对象, 然后访问类中的成员.
 * 属性:
 * 品牌: brand
 * 价格: price
 * 颜色: color
 * 行为:
 * 打电话: call(String name)			//该方法接收一个"姓名"参数, 输出格式为:  给张三打电话...
 * 发短信: sendMessage(String name)	//该方法接收一个"姓名"参数, 输出格式为:  给张三发短信...
 */
public class PhoneTest {
    public static void main(String[] args) {
        Phone p = new Phone();
//        System.out.println(p.brand);// 打印输出不成功,因为设置了private 私有化
//        没有赋值前的默认值
        System.out.println(p.getBrand());//null
        System.out.println(p.getPrice());//0.0
        System.out.println(p.getColor());//null
        System.out.println("-------------------");
//      给属性赋值
        p.setBrand("小米");
        p.setPrice(2499);
        p.setColor("静夜白");
        System.out.println(p.getBrand());// 小米
        System.out.println(p.getPrice());//  2499.0
        System.out.println(p.getColor());// 静夜白
//        调用方法
        p.call("张三");
        p.sendMessage("张三");


    }

}
