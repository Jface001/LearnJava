package com.test.base.day11;

import com.test.base.pojo.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Jface
 * @Date: 2021/5/16 10:40
 * @Desc: 第五题: 通过代码, 完成如下需求:
 * 1. 创建HashMap集合, 键是学生对象(Student), 值是居住地(String).
 * 2. 往HashMap集合中添加3组数据.
 * 3. 通过两种方式, 遍历HashMap集合.
 * //细节: Map集合的的特点是: 无序, 键具有唯一性, 元素无索引.
 * //Set集合的底层依赖的也是Map集合.
 * //代码只要做一件事儿: 让Student类去重写: hashCode(), equals().
 */
public class Demo05 {
    public static void main(String[] args) {
//        集合的使用步骤:
//        1. 创建集合对象.
        HashMap<Student, String> hm = new HashMap<>();
//        2. 创建元素对象.
        Student s1 = new Student("李白", 16);
        Student s2 = new Student("杜甫", 18);
        Student s3 = new Student("猪皮", 20);
//        3. 添加元素到集合中.
        hm.put(s1, "吉尔吉吉斯坦");
        hm.put(s2, "河南");
        hm.put(s3, "成都");
        hm.put(s1,"峨眉山");
//        4. 遍历集合.
        //方式1:通过健求值
        Set<Student> keySet = hm.keySet();
        for (Student s : keySet) {
            System.out.println(s + ",居住地:" + hm.get(s));
        }
        System.out.println("---------------");
        //方式2:通过键值求健和值
        Set<Map.Entry<Student, String>> entrySet = hm.entrySet();
        for (Map.Entry<Student, String> ss : entrySet) {
            System.out.println(ss.getKey() +",居住地:"+ss.getValue());
        }
    }
}
