package com.test.demo10_reflect;

import com.test.pojo.Student;

/**
 * @Author: Jface
 * @Date: 2021/5/21 20:42
 * @Desc: 案例: 演示反射入门.
 * <p>
 * 反射简介:
 * 概述:
 * 反射指的就是在程序的运行期间, 通过 类的字节码文件对象 来操作 类中的成员(成员变量, 构造方法, 成员方法)等.
 * 步骤:
 * 1. 获取指定类的字节码文件对象.
 * 2. 根据字节码文件对象, 获取指定的要操作的 成员对象.
 * 3. 操作指定的成员即可.
 * <p>
 * 如何获取类的字节码对象:
 * 方式1: 通过 类的class属性获取.
 * 格式: Student.class
 * 应用场景:  一般用作 锁对象 使用.
 * <p>
 * 方式2: 通过 对象名.getClass()方法获取.
 * 格式: new Student().getClass();
 * 应用场景: 一般用来 判断两个对象是否是同一个类型的对象.
 * <p>
 * 方式3: 通过 反射方式, 强制加载某个类的字节码文件进内存, 并获取它对应的Class对象.
 * 格式: Class.forName("com.test.pojo.Student")
 * 应用场景: 强制加载某个类的字节码文件进内存, 一般结合反射使用.
 * <p>
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
 * <p>
 * public Field getField(String name);
 * 根据字段名, 获取指定的字段对象(不包含私有)
 * public Field getDeclaredField(String name);
 * 根据字段名, 获取指定的字段对象(包含私有)
 * public Field[] getFields();
 * 获取类中, 所有的字段对象(不包含私有)
 * public Field[] getDeclaredFields();
 * 获取类中, 所有的字段对象(包含私有)
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
 * Constructor类中的相关方法:
 * public T newInstance(Object... values);   根据指定的参数值, 获取该类的对象.
 * public void setAccessible(boolean flag);  设置暴力反射, 如果为true, 说明设置暴力反射.
 * <p>
 * Field类中的相关方法:
 * public void set(Object obj, Object value);  设置obj对象的指定属性为指定的值(value)
 * public void setAccessible(boolean flag);  设置暴力反射, 如果为true, 说明设置暴力反射.
 * <p>
 * Method类中的相关方法:
 * public void setAccessible(boolean flag);        	如果为true, 表示: 暴力反射.
 * public Object invoke(Object obj, Object... value);	执行方法.
 * <p>
 * 案例:
 * 1. 如何通过反射技术操作类的构造方法, 无参构造.
 * 2. 如何通过反射技术操作类的构造方法, 有参构造.
 * 3. 如何通过反射技术操作类的构造方法, 私有构造.
 * <p>
 * 4. 如何通过反射技术操作类的成员变量, 私有的变量.
 * <p>
 * 5. 如何通过反射技术操作类的成员方法, 公共的成员方法.
 * <p>
 * 6. 如何往ArrayList<Integer>集合中添加字符串.
 * 7. 如何运行执行配置文件中的指定类的指定方法.
 * <p>
 * 反射小技巧, 掌握如下单词:
 * get(获取), declared(包含私有), Constructor(构造器, 构造方法), Field(字段, 成员变量),
 * method(方法), newInstance(创建实例), set(设置), invoke(表示调用方法), accessible(权限)
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //需求: 如何获取类的字节码文件对象.
        //方式1: 通过 类的class属性获取.
        Class<Student> clazz1 = Student.class;
        //方式2: 通过 对象名.getClass()方法获取.
        Class<? extends Student> clazz2 = (new Student()).getClass();
        //方式3: 通过 反射方式, 强制加载某个类的字节码文件进内存, 并获取它对应的Class对象.
        Class<?> clazz3 = Class.forName("com.test.pojo.Student");
        //结论: 一个.java文件对应一个.class文件, 且对应一个 Class对象.
        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true
        System.out.println(clazz2 == clazz3);//true
        //结论:一个.java文件对应一个.class文件,且对应一个 Class对象.
    }
}
