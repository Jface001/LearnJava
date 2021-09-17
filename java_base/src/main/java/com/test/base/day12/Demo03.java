package com.test.base.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: Jface
 * @Date: 2021/5/18 20:43
 * @Desc: 3. 随机点名器案例.
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        //1.创建一个高效字符流输入流,关联数据源文件
        BufferedReader br = new BufferedReader(new FileReader("D:test/name.txt"));
        //2.定义变量,用于记录读取到的数据
        String name;
        //3.定义一个ArrayList集合,用于存储读取到的名字集合
        ArrayList<String> list = new ArrayList<String>();
        //4.循环读取数据,按行读取,并写入到集合中
        while ((name = br.readLine()) != null) {
            list.add(name);
        }
        //5.关闭输入流
        br.close();
        //6.通过随机数获取集合的随机索引
        int a = (int) (Math.random() * list.size());//Math.random()结果double类型,需要向下转型
        //7.通过索引获取集合的元素并打印输出
        System.out.println(list.get(a));


    }
}
