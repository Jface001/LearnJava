package com.test.base.day05;

/**
 * @Author: Jface
 * @Date: 2021/5/7 18:08
 * @Desc: 1. 定义手机类Phone, 属性和行为如下, 并在测试类PhoneTest中, 创建手机类的对象, 然后访问类中的成员.
 * 属性:
 * 品牌: brand
 * 价格: price
 * 颜色: color
 * 行为:
 * 打电话: call(String name)			//该方法接收一个"姓名"参数, 输出格式为:  给张三打电话...
 * 发短信: sendMessage(String name)	//该方法接收一个"姓名"参数, 输出格式为:  给张三发短信...
 */
public class Phone {
    //    1.定义一个类
//    1.1 设置属性,属性:名词,又叫成员变量
    private String brand;// 加上private 成员私有化
    private double price;
    private String color;

    //    行为:动词,又叫成员方法,成员方法不要写static
    public String getBrand() {  // 获取品牌名字
        return brand;
    }

    public void setBrand(String a) {// 设置品牌名字 不需要返回值所以void
        brand = a;
    }

    public double getPrice() {//获取价格
        return price;
    }

    public void setPrice(double a) { //设置价格
        price = a;
    }

    public String getColor() {// 获取颜色
        return color;
    }

    public void setColor(String a) { //设置颜色
        color = a;
    }

    //2.设置行为 行为又叫成员方法
    public void call(String name) {//
        System.out.println("给" + name + "打电话");
    }

    public void sendMessage(String name) {
        System.out.println("给" + name + "发短信");
    }
}
