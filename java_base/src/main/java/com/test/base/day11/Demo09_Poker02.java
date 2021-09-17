package com.test.base.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @Author: Jface
 * @Date: 2021/5/16 14:43
 * @Desc: 案例: 模拟斗地主发牌案例,   无序的牌.
 * 规则:
 * 1. 一副牌 54 张,  花色: 红桃, 黑桃, 方片, 梅花.  点数: A-K  小王, 大王
 * 2. 三个玩家(每人17张) 和 底牌(3张)
 * 3. 这个案例, 需要考虑排序
 * 思路:
 * 1. 买牌.
 * 2. 洗牌.
 * 3. 发牌.
 * 4. 看牌.
 */
public class Demo09_Poker02 {
    public static void main(String[] args) {
        //1.造牌
        //1.1.定义2个牌盒,牌盒1是记录牌和对应数字的HashMap集合, 牌盒2是记录牌对应数字ArrayList
        HashMap<Integer, String> hm = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        //1.2 新建2个数组,存储花色和数字
        String[] colors = {"♣", "♠", "♦", "♥"};//4个花色
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};//13个数字
        //1.3 通过遍历造牌, 并把牌装入拍盒1和拍盒2
        int index = 0;//给到一个序列,用于对应牌
        for (String s : numbers) {
            for (String c : colors) {
                hm.put(index, s + c);//牌盒1
                list.add(index++);//牌盒2,index每次循环+1
            }
        }
        hm.put(index, "小王");//添加小王
        list.add(index++);//牌盒2,index每次循环+1
        hm.put(index, "大王");//添加大王
        list.add(index++);//牌盒2,index每次循环+1
//        System.out.println(hm);//测试一下
//        System.out.println(list);//测试一下
        //2.洗牌,通过Collections#shuffle洗牌盒2
        Collections.shuffle(list);
//        System.out.println(list);//测试一下,是否重新洗牌了
        //3.发牌
        //3.1新建3个ArrayList<String>, 就是打牌的3个人,外加底牌
        //TreeSet会自动排序
        TreeSet<Integer> libai = new TreeSet<>();
        TreeSet<Integer> dufu = new TreeSet<>();
        TreeSet<Integer> zhupi = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();
        //3.2 把牌盒2数字发给玩家
        for (int i = 0; i < list.size(); i++) {
            Integer a = list.get(i);
            if (i >= list.size() - 3) {
                dipai.add(a);
            } else if (i % 3 == 0) {
                libai.add(a);
            } else if (i % 3 == 1) {
                dufu.add(a);
            } else {
                zhupi.add(a);
            }
        }
//        System.out.println(libai);//测试一下

        //4.看牌,定义一个看牌的方法方法lookPoker()
        lookPoker("李白", libai, hm);
        lookPoker("杜甫", dufu, hm);
        lookPoker("猪皮", zhupi, hm);
        lookPoker("底牌", dipai, hm);
    }

    /**
     * 这个方法用于看牌,即根据输入的姓名,牌盒即玩家获取的数字翻译成玩家的牌并打印输出
     *
     * @param name 玩家的名字
     * @param al   玩家手里的数字集合
     * @param hm   牌盒,即数字对应的牌,
     */
    public static void lookPoker(String name, TreeSet<Integer> al, HashMap<Integer, String> hm) {
        System.out.println(name + "手里的牌是:");
        for (Integer i : al) {
            String s = hm.get(i);
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

