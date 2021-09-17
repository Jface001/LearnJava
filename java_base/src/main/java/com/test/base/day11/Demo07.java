package com.test.base.day11;

import java.util.*;

/**
 * @Author: Jface
 * @Date: 2021/5/16 11:10
 * @Desc: 第七题: 通过代码, 完成如下需求:		//HashMap<String, ArrayList<String>>  hm.put("三国演义", sgyy);
 * 1. 创建一个HashMap集合，存储三个键值对元素，键表示书名(String)，值是书中人物名(ArrayList<String>)
 * 2. 第一个ArrayList集合的元素: (三国演义)
 * 诸葛亮
 * 赵云
 * 3. 第二个ArrayList集合的元素: (西游记)
 * 唐僧
 * 孙悟空
 * 4. 第三个ArrayList集合的元素: (水浒传)
 * 武松
 * 鲁智深
 * 5. 遍历HashMap集合, 输出每一个元素.
 */
public class Demo07 {
    public static void main(String[] args) {
//        集合的使用步骤:
//        1. 创建集合对象.
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
//        2. 创建元素对象.
        ArrayList<String> sgyy = new ArrayList<>();
        sgyy.add("诸葛亮");
        sgyy.add("赵云");
        ArrayList<String> xyj = new ArrayList<>();
        xyj.add("唐僧");
        xyj.add("孙悟空");
        ArrayList<String> shz = new ArrayList<>();
        shz.add("武松");
        shz.add("鲁智深");
//        3. 添加元素到集合中.
        hm.put("三国演义", sgyy);
        hm.put("西游记", xyj);
        hm.put("水浒传", shz);
//        4. 遍历集合.
        //方法1:通过健求值
        for (String s : hm.keySet()) {
            System.out.println(s);//外循环获取书名,是就是键值, 书名
            for (String s1 : hm.get(s)) {//外循环获取ArrayList,遍历获取任务
                System.out.println("\t" + s1);//加个缩进,好看
            }
            System.out.println();//加个换行,好看
        }
        System.out.println("-----------------------");
        //方式2:通过健值求健和值
        Set<Map.Entry<String, ArrayList<String>>> entrySet = hm.entrySet();
        Iterator<Map.Entry<String, ArrayList<String>>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, ArrayList<String>> s = it.next();
            System.out.println(s.getKey());//s.getKey()就是书名
            for (String s1 : s.getValue()) {//s.getValue()就是ArrayList对象,内循序遍历
                System.out.println("\t" + s1);//加个缩进,方便识别
            }

            System.out.println();//换行好看
        }

    }
}
