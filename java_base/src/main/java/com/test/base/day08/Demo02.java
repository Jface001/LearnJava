package com.test.base.day08;

import java.util.Scanner;

/**
 * @Author: Jface
 * @Date: 2021/5/11 19:53
 * @Desc:
 * 需求2:
 * 1.模拟用户登录, 只给3次机会, 登录成功则提示"欢迎您, ***".
 * 2.登录失败则判断是否还有登录机会, 有则提示剩余登录次数, 没有则提示"您的账号已被锁定".
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.定义2个字符串常量,用于对比账户密码是否一致.
        String username = "天王盖地虎";
        String password = "宝塔镇河妖";
        //2.新建键盘录入
        Scanner sc = new Scanner(System.in);
        //3.提示用户输入账户密码,并接收
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入您的账号:");
            String user = sc.nextLine();
            System.out.println("请输入您的账号:");
            String pwd = sc.nextLine();
        //4.比较输入账户密码是否正确,正确就提示"欢迎您,xxx"
            if (username.equals(user) && password.equals(pwd)) { //String已经重写方法,这里比较的是属性值
                System.out.println("欢迎您," + user);
                break;//结束循环,结束循环
            }

        //5.不正确,如果是第 1, 2,输入错误,就提示剩余登陆次数
            else {
                if (i != 2) {
                    System.out.println("账户密码错误,请重新输入,您还剩" + (2 - i) + "次登陆机会");
        //6.不正确,如果是第三次错误,就返回提示"您的账户已被锁定"
                } else {
                    System.out.println("您的账号已被锁定");
                }

            }


        }
    }
}
