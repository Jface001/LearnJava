package com.test.base.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Jface
 * @Date: 2021/5/16 10:48
 * @Desc: 第六题: 通过代码, 完成如下需求:
 * 1. 定义ArrayList<HashMap<String, String>>集合, 存储三个元素, 每个元素都是一个双列集合, 具体如下:
 * 2. 第一个双列集合, 记录的信息如下:
 * 孙策	大乔
 * 周瑜	小乔
 * 3. 第二个双列集合, 记录的信息如下:
 * 郭靖	黄蓉
 * 杨过	小龙女
 * 4. 第三个双列集合, 记录的信息如下:
 * 令狐冲	任盈盈
 * 林平之	岳灵珊
 * 5. 把上述的三个双列集合当做元素对象, 添加到ArrayList集合中.
 * 6. 遍历ArrayList集合, 输出每个元素.
 */
public class Demo06 {
    public static void main(String[] args) {
//        集合的使用步骤:
//        1. 创建集合对象.
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
//        2. 创建元素对象.
        HashMap<String, String> sgyy = new HashMap<>();
        sgyy.put("孙策", "大乔");
        sgyy.put("周瑜", "小乔");
        HashMap<String, String> sdxl = new HashMap<>();
        sdxl.put("郭靖", "黄蓉");
        sdxl.put("杨过", "小龙女");
        HashMap<String, String> xajh = new HashMap<>();
        xajh.put("令狐冲", "任盈盈");
        xajh.put("林平之", "岳灵珊");
//        3. 添加元素到集合中.
        list.add(sgyy);
        list.add(sdxl);
        list.add(xajh);
//        4. 遍历集合.
        //方法1:通过健求值
        for (HashMap<String, String> s : list) {//外循环获取s,s就是hashmap集合对象
            Set<String> ss = s.keySet();
            for (String s1 : ss) {//内循环获取s里面的键和值
                System.out.println(s1 + "," + s.get(s1));
            }
            System.out.println();
        }
        System.out.println("-----------------");
        //方法2:通过健值求健和值.
        for (HashMap<String, String> s : list) {
            Set<Map.Entry<String, String>> entrySet = s.entrySet();
            for (Map.Entry<String, String> ss : entrySet) {
                System.out.println(ss.getKey() + "," + ss.getValue());
            }
            System.out.println();
        }

    }
}
