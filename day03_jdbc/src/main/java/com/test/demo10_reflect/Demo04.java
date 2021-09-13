package com.test.demo10_reflect;

import com.test.pojo.Student;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Author: Jface
 * @Date: 2021/5/22 10:41
 * @Desc: 案例: 反射操作类中的成员方法.
 * <p>
 * <p>
 * Class类中相关的成员方法:
 * public static Class forName(String classname);      根据全类名, 获取该类对应的 字节码文件对象.
 * public Object newInstance();                根据类中的公共的空参构造方法, 获取该类的实例(对象)
 * <p>
 * public Method[] getMethods();
 * //根据字节码文件对象, 获取该类中所有的成员方法对象, 包括继承过来的方法.
 * public Method[] getDeclaredMethods();
 * //根据字节码文件对象, 获取该类中所有的成员方法对象, 不包括继承过来的方法..
 * public Method getMethod(String name, Class... params);
 * //根据字段名, 获取该类中指定的成员方法对象, 包括继承过来的方法.
 * public Method getDeclaredMethod(String name, Class... params);
 * //根据字段名, 获取该类中指定的成员方法对象, 不包括继承过来的方法.
 * <p>
 * Method类中的相关方法:
 * public void setAccessible(boolean flag);        	如果为true, 表示: 暴力反射.
 * public Object invoke(Object obj, Object... value);	执行方法.
 */
public class Demo04 {
    //需求1: 反射操作类中的公共的 无参无返回值方法
    @Test
    public void show1() throws Exception {
        //1.获取字节码文件
        Class<?> clazz = Class.forName("com.test.pojo.Student");
        //2.创建该类的实例,空参
        Student s = (Student) clazz.newInstance();
        //3.获取指定的方法对象
        Method eat = clazz.getMethod("eat");
        //4.调用方法
        s.eat();
        //5.打印返回值,如果有的话.

    }


    //需求2: 反射操作类中的私有的 有参有返回值.
    @Test
    public void show2() throws Exception {
        //1.获取字节码文件
        Class<?> clazz = Class.forName("com.test.pojo.Student");
        //2.创建该类的实例,空参
        Student s = (Student) clazz.newInstance();
        //3.获取指定的方法对象
        Method getSum = clazz.getDeclaredMethod("getSum", int.class, int.class);
        //记得暴力反射
        getSum.setAccessible(true);
        //4.调用方法
        int sum = (int) getSum.invoke(s, 23, 27);
        //5.打印返回值,如果有的话.
        System.out.println(sum);



    }

}
