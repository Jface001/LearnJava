package com.test.base.day10;

import com.test.base.pojo.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @Author: Jface
 * @Date: 2021/5/14 20:09
 * @Desc: 第三题: 通过代码, 完成如下需求:
 * 1. 自定义一个人类，给出成员变量name和age.
 * 2. 使用ArrayList集合存储人类对象并遍历.
 * 3. 最后在控制台输出人类对象的成员变量值。
 * //格式为: 姓名: 张三, 年龄: 23
 * 4. 通过四种方式遍历.
 * //提示: 普通迭代器, 增强for, 列表迭代器, 普通for
 * <p>
 * 集合的核心操作步骤:
 * 1. 创建集合对象.
 * 2. 创建元素对象.
 * 3. 添加元素到集合中.
 * 4. 遍历集合.
 * 方式1:普通迭代器
 * 方式2:列表迭代器
 * 方式3:普通for循环
 * 方式4:增强for循环
 * 方式5:转数组,再遍历
 */
public class Demo03 {
    public static void main(String[] args) {
//        集合的核心操作步骤:
//        1. 创建集合对象.
        ArrayList<Person> p = new ArrayList<Person>();
//        2. 创建元素对象.
        Person p1 = new Person("李白", 3);
        Person p2 = new Person("杜甫", 5);
        Person p3 = new Person("猪皮", 2);
//        3. 添加元素到集合中.
        p.add(p1);
        p.add(p2);
        p.add(p3);
//        4. 遍历集合.
//        方式1:普通迭代器
        System.out.println("----------------");
        Iterator<Person> it = p.iterator();
        while (it.hasNext()) {
            Person pp = it.next();
            System.out.println(pp);
        }
        System.out.println("----------------");
//        方式2:列表迭代器
        ListIterator<Person> lit = p.listIterator();
        while (lit.hasNext()) {
            Person pp = lit.next();
            System.out.println(pp);
        }
        System.out.println("----------------");
//        方式3:普通for循环
        for (int i = 0; i < p.size(); i++) {
            Person pp = p.get(i);
            System.out.println(pp);
        }
        System.out.println("----------------");
//        方式4:增强for循环
        for (Person pp : p) {
            System.out.println(pp);
        }
        System.out.println("----------------");
//        方式5:转数组,再遍历
        Object[] objs = p.toArray();
        for (Object obj : objs) {
            System.out.println(obj);
        }

    }
}
