package com.test.base.day11;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: Jface
 * @Date: 2021/5/16 12:12
 * @Desc: 第1题: 模拟斗地主发牌.
 * 版本1: 无序的牌.
 * 版本2: 有序的牌.
 * <p>
 * 规则:
 * 1. 一副牌 54 张,  花色: 红桃, 黑桃, 方片, 梅花.  点数: A-K  小王, 大王
 * 2. 三个玩家(每人17张) 和 底牌(3张)
 * 3. 这个案例, 只管发, 不管排序.
 */
public class Demo09_Poker01 {
    public static void main(String[] args) {
        //1.造牌
        //1.1新建一个ArrayList<String>集合,用于存牌,相当于牌盒
        ArrayList<String> list = new ArrayList<>();
        //1.2新建2个数组,分别存上花色和点数
        String[] colors = {"♣", "♠", "♦", "♥"};//4个花色
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};//13个数字
        //1.3通过嵌套for循环,造牌并添加到集合
        for (String s : numbers) {//遍历数字
            for (String c : colors) {//遍历花色
                list.add(s + c);//添加到拍盒
            }
        }
        list.add("小王");//添加大小王
        list.add("大王");
        //2.洗牌 使用Collections#shuffle 方法
        Collections.shuffle(list);
        System.out.println("-----------------------");
        //3.发牌
        //3.1新建3个ArrayList<String>, 就是打牌的3个人,外加底牌
        ArrayList<String> libai = new ArrayList<>();
        ArrayList<String> dufu = new ArrayList<>();
        ArrayList<String> zhupi = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        //3.2.循环遍历集合,把牌添加给3个人
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (i >= list.size() - 3) {
                dipai.add(s);
            } else if (i % 3 == 0) {
                libai.add(s);
            } else if (i % 3 == 1) {
                dufu.add(s);
            } else {
                zhupi.add(s);
            }
        }

        //4.看牌
        System.out.println(list);
        //打印3个人的牌
        System.out.println("李白:" + libai);
        System.out.println("杜甫:" + dufu);
        System.out.println("猪皮:" + zhupi);
        System.out.println("底牌:" + dipai);

    }
}
