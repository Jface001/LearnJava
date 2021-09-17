package com.test.base.day11;

import com.test.base.pojo.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Jface
 * @Date: 2021/5/16 10:31
 * @Desc: 第四题: 通过代码, 完成如下需求:
 * 1. 创建HashMap集合, 键是学号(String), 值是学生对象(Student).		//姓名, 年龄.
 * 2. 往HashMap集合中添加3组数据.
 * 3. 通过两种方式, 遍历HashMap集合.
 * //方式一: 根据键获取值.
 * //方式二: 根据键值对对象获取键和值.
 */
public class Demo04 {
    public static void main(String[] args) {
//        集合的使用步骤:
//        1. 创建集合对象.
        HashMap<String, Student> hm = new HashMap<>();
//        2. 创建元素对象.
        Student s1 = new Student("李白", 16);
        Student s2 = new Student("杜甫", 18);
        Student s3 = new Student("猪皮", 20);
//        3. 添加元素到集合中.
        hm.put("heima001", s1);
        hm.put("heima002", s2);
        hm.put("heima003", s3);
//        4. 遍历集合.
        //方式1:通过健求值
        Set<String> keySet = hm.keySet();
        for (String s : keySet) {
            System.out.println(s + "," + hm.get(s));
        }
        System.out.println("-----------------------");
        //方式2:通过键值求健和值
        Set<Map.Entry<String, Student>> entrySet = hm.entrySet();
        for (Map.Entry<String, Student> s : entrySet) {
            System.out.println(s.getKey() + "," + s.getValue());
        }

    }
}
