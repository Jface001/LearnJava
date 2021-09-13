package com.test.demo07_junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: Jface
 * @Date: 2021/5/21 20:34
 * @Desc:
案例: 演示Junit的用法.

需求:
定义show()方法, 然后测试它.

Junit单元测试简介:
概述:
它属于白盒测试的内容, 简单理解就是用来替代main方法的, 即: 代码不用往main()方法中放, 也能实现直接运行.
它使用Java语言编写的第三方的框架, 用之前需要先导包.
具体步骤:
1. 在项目(模块)下新建一个文件夹, 名字叫: lib
2. 把要使用的jar包拷贝进去.
3. 配置运行环境.
选中jar包, 右键 -> Add as Library
Junit单元测试涉及到的注解:
 @Before   被它标注的方法, 会在@Test标注的方法执行之前, 自动调用.
 @Test     被它标注的方法, 可以进行Junit单元测试.
 @After    被它标注的方法, 会在@Test标注的方法执行之后, 自动调用.
 细节:
 Junit单元测试只针对于 非静态的无参无返回值的方法有效.

 扩展: 一个完整的JavaWeb项目的开发流程:
 1. 需求调研.
 2. 编写需求(调研)文档.      //产品经理.
 3. 编写静态页面.           //UI工程师.
 4. 技术选型, 框架选定, 统一工具.
 5. 数据库建模, 数据表设计.  //架构师, 项目经理, 你
 6. 软件开发.              //程序员.
 7. 测试, 部署, 运维.      //测试人员, 运维人员.
 */
public class Demo01 {

    @Before
    public void show1(){
        System.out.println("我是初始化数据的, 我会在@Test之前, 自动被调用");
    }

    @Test
    public void eat(){
        System.out.println("我想吃冰淇淋!");
    }

    @Test
    public void study(){
        System.out.println("我永远喜欢Java");
    }

    @After
    public void show2(){
        System.out.println("我是释放资源的, 我会在@Test之后, 自动被调用");
    }

}
