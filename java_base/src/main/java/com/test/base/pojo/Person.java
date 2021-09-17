package com.test.base.pojo;

/**
 * @Author: Jface
 * @Date: 2021/5/14 20:10
 * @Desc:
第三题: 通过代码, 完成如下需求:
1. 自定义一个人类，给出成员变量name和age.
2. 使用ArrayList集合存储人类对象并遍历.
3. 最后在控制台输出人类对象的成员变量值。
//格式为: 姓名: 张三, 年龄: 23
4. 通过四种方式遍历.
//提示: 普通迭代器, 增强for, 列表迭代器, 普通for
 */
public class Person {
    //1.成员属性,全部私有
    private String name;
    private int age;
    //2.构造方法,全参和空参

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //3.getXxx() setXxx()

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //4.成员方法和重写

    @Override
    public String toString() {
        return "姓名:"+name+", 年龄:" +age;
    }
}
