package com.test.base.day12;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author: Jface
 * @Date: 2021/5/18 20:52
 * @Desc: 4. 已知项目下有个a.txt文本文件，里边有两行数据，如下：
 * a,c,d,e,g,h
 * a,g,b,o,q,r
 * 需求：
 * 创建输入流，读取这两行数据，每行数据都可以看做是一个ArrayList<String>集合，而每行的字母就是该集合中的元素。
 * 对两个集合中的元素合并后去重，然后将去重后的结果写入到项目下的b.txt文本文件中, 格式如下:
 * //可以不是如下的顺序, 但是要一个字符占一行.
 * a
 * b
 * c
 * d
 * e
 * ...
 */
public class Demo04 {
    public static void main(String[] args) throws IOException {
        //分析
        //1.创建高效字符输入流,关联数据源文件
        BufferedReader br = new BufferedReader(new FileReader("D:test/work/a.txt"));
        //2.创建高效字符输出流,关联目的地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:test/work/b.txt"));
        //3.定义变量,保存读取到的数据
        String s;
        //4.定义ArrayList集合用于存储字符
        ArrayList<String> list = new ArrayList<>();
        //5.循环逐行读取数据,切割读取到的数据,并转换成字符串数组
        while ((s = br.readLine()) != null) {
            String[] str = s.split(",");
            //6.遍历字符串数组,判断集合是否已存在该元素,不存在就添加到集合,存在就跳过
            for (int i = 0; i < str.length; i++) {
                String s1 = str[i];
                if (list.contains(s1)==false) {
                    list.add(s1);
                }
            }
        }
        //7.遍历集合,将字符串逐行写入目的地文件
        for (int i = 0; i < list.size(); i++) {
            String s1 = list.get(i);
            bw.write(s1);
            bw.newLine();
        }
        //8.释放资源
        br.close();
        bw.close();
    }

}
