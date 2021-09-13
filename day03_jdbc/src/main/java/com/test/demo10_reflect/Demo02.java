package com.test.demo10_reflect;

import com.test.pojo.Student;
import org.junit.After;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author: Jface
 * @Date: 2021/5/22 9:35
 * @Desc: 案例: 演示反射操作类中的构造方法.
 * <p>
 * 涉及到的成员方法:
 * Class类中相关的成员方法:
 * public static Class forName(String classname);      根据全类名, 获取该类对应的 字节码文件对象.
 * public Object newInstance();                根据类中的公共的空参构造方法, 获取该类的实例(对象)
 * <p>
 * public Constructor getConstructor(Class... clazz);
 * 根据字节码文件类型, 获取指定的构造方法(不包含私有)
 * public Constructor getDeclaredConstructor(Class... clazz);
 * 根据字节码文件类型, 获取指定的构造方法(包含私有)
 * public Constructor[] getConstructors();
 * 获取类中, 所有的构造器对象(不包含私有)
 * public Constructor[] getDeclaredConstructors();
 * 获取类中, 所有的构造器对象(包含私有)
 * <p>
 * Constructor类中的相关方法:
 * public T newInstance(Object... values);   根据指定的参数值, 获取该类的对象.
 * public void setAccessible(boolean flag);  设置暴力反射, 如果为true, 说明设置暴力反射.
 */
public class Demo02 {
    //需求1: 获取类中所有的构造方法, 不包含私有.    理解
    @Test
    public void show1() throws Exception {
        //1. 获取Student类的字节码文件对象.
        Class<?> clazz1 = Class.forName("com.test.pojo.Student");
        //2. 获取该类的 所有的构造方法对象, 不包含私有
        Constructor<?>[] ct = clazz1.getConstructors();
        //3. 遍历, 打印每一个构造器对象.
        for (Constructor<?> c : ct) {
            System.out.println(c);
        }

    }

    //需求2: 获取类中所有的构造方法, 包含私有.      理解
    @Test
    public void show2() throws Exception {
        //1. 获取Student类的字节码文件对象.
        Class<?> clazz2 = Class.forName("com.test.pojo.Student");
        //2. 获取该类的 所有的构造方法对象, 包含私有
        Constructor<?>[] ct = clazz2.getDeclaredConstructors();
        //3. 遍历, 打印每一个构造器对象.
        for (Constructor<?> c : ct) {
            System.out.println(c);
        }
    }

    //需求3: 通过类中公共的空参构造方法创建对象.
    @Test
    public void show3() throws Exception {
        //标准版
        //1. 获取该类的字节码文件对象.
        Class<?> clazz3 = Class.forName("com.test.pojo.Student");
        //2. 获取指定的构造器对象.
        Constructor<?> ct = clazz3.getConstructor();
        //3. 通过 Constructor#newInstance()方法, 创建对象.
        Student s1 = (Student) ct.newInstance();
        //4. 打印对象.
        System.out.println(s1);


        //优化版: 注意, 该方式只针对于 类中的 公共的, 空参构造有效.
        //即: 通过Class#newInstance()方法实现.
        //1. 获取该类的字节码文件对象.
        Class<?> clazz4 = Class.forName("com.test.pojo.Student");
        //2. 通过Class#newInstance()方法实现.
        Student s = (Student) clazz3.newInstance();
        //4. 打印对象.
        System.out.println(s);
    }

    //需求4: 通过类中的公共的带参构造 创建该类的对象.
    @Test
    public void show4() throws Exception {
        //1. 获取该类的字节码文件对象.
        Class<?> clazz = Class.forName("com.test.pojo.Student");
        //2. 获取指定的构造器对象.
        Constructor<?> ct = clazz.getConstructor(String.class, int.class);
        //3. 通过 Constructor#newInstance()方法, 创建对象.
        Student s = (Student) ct.newInstance("李白", 18);
        //4. 打印对象
        System.out.println(s);
    }

    //需求5: 通过类中的私有的带参构造 创建该类的对象.
    @Test
    public void show5() throws Exception {
        //1. 获取该类的字节码文件对象.
        Class<?> clazz = Class.forName("com.test.pojo.Student");
        //2. 获取指定的构造器对象.
        Constructor<?> ct = clazz.getDeclaredConstructor(String.class);
        //细节: 反射但凡操作私有成员, 用它之前一定要先进行: 暴力反射,true就是暴力反射
        ct.setAccessible(true);
        //3. 通过 Constructor#newInstance()方法, 创建对象.
        Student s = (Student) ct.newInstance("杜甫");
        //4. 打印对象.
        System.out.println(s);


    }
}
