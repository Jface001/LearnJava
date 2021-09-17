package com.test.base.day07;


/**
 * @Author: Jface
 * @Date: 2021/5/9 20:58
 * @Desc: 3. 已知学校有基础班老师(BasicTeacher)和就业班老师(WorkTeacher), 基础班学生(BasicStudent)和就业班学生(WorkStudent).
 * 他们都有姓名, 年龄, 都要吃饭, 不同的是学生吃牛肉, 老师喝牛肉汤.
 * 老师有自己的额外属性: 工资(salary), 且老师需要讲课(基础班老师讲JavaSE, 就业班老师讲JavaEE, Hadoop, Hive, Scala, Flink, Spark等).
 * 基础班学生学习JavaSE, 就业班学生学习JavaEE, Hadoop, Hive, Scala, Flink, Spark等.
 * 为了扩大就业市场, 跟就业班相关的人员都需要学习英语.
 * 请用所学, 模拟该知识.
 * 分析
 * 1.人类
 * 关系:作为父类
 * 属性: name age
 * 方法: 抽象eat()
 * 2.学生类
 * 关系 :继承人类,作为子类
 * 属性:
 * 方法:抽象study()
 * 3.老师类
 * 关系: 继承人类,作为紫薇路
 * 属性:salary
 * 方法:抽象teach()
 * 4.接口
 * SpeakEnglish-学习英语
 * 5.BasicTeacher
 * 关系:继承老师类
 * 属性
 * 方法 重写eat 重写teach
 * 6.WorkTeacher
 * 关系 继承老师类,实现SpeakEnglish-接口
 * 属性
 * 方法 重写eat 重写teach
 * 7.BasicStudent
 * 关系 继承学生类
 * 属性
 * 方法 重写eat 重写study
 * 8.WorkStudent
 * 关系 继承学生类,实现SpeakEnglish-接口
 * 属性
 * 方法 重写eat 重写study
 */
public class Demo03 {
    public static void main(String[] args) {
        //1.测试就业办老师全参
        WorkTeacher w1 = new WorkTeacher("罗翔", 35, 25000);
        System.out.println(w1.getName() + ".." + w1.getAge() + ".." + w1.getSalary());
        w1.eat();
        w1.teach();
        w1.speak_english();
        System.out.println("---------------------------------------------");
        //2.测试学生类多态
        Student s1 = new WorkStudent("张三", 18);
        System.out.println(s1.getName() + ".." + s1.getAge());
        s1.eat();
        s1.study();
        System.out.println("---------------------------------------------");
        //3.测试接口多态
        SpeakEnglish en = new WorkStudent();
        en.speak_english();
    }
}
