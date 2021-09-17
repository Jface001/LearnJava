package com.test.base.pojo;

/**
 * @Author: Jface
 * @Date: 2021/5/14 20:00
 * @Desc:
 */
public class Student {
    //1.成员属性,全部私有
    private String name;
    private int age;
    //2.构造方法,空参和全参

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //3. getXxx() 和setXxx()

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

    //4.成员方法,重写方法
    public void study() {
        System.out.println("好好学习,天天向上");
    }


    @Override
    public String toString() {
        return "姓名:" + name + ",年龄:" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}


