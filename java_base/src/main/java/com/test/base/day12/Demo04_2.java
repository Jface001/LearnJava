package com.test.base.day12;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: Jface
 * @Desc:
需求：
创建输入流，读取这两行数据，每行数据都可以看做是一个ArrayList<String>集合，而每行的字母就是该集合中的元素。
对两个集合中的元素合并后去重，然后将去重后的结果写入到项目下的b.txt文本文件中, 格式如下:
//可以不是如下的顺序, 但是要一个字符占一行.
a
b
c
d
e
...
 */
public class Demo04_2 {
        public static void main(String[] args) throws IOException {
            //分析
            //1.创建高效字符输入流,关联数据源文件
            BufferedReader br = new BufferedReader(new FileReader("D:test/work/a.txt"));
            //2.定义变量,保存读取到的数据
            String s;
            //3.定义HashSet集合用于存储字符,会自动去重
            HashSet<String> hs = new HashSet<>();
            //4.循环逐行读取数据,切割读取到的数据,并转换成存入集合
            while ((s = br.readLine()) != null)
            hs.addAll(Arrays.asList(s.split(",")));
            //5.释放读取资源
            br.close();
            //6.创建高效字符输出流,关联目的地文件.
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:test/work/b.txt"));
            for (String h : hs) {
                bw.write(h);
                bw.newLine();
            }
            //7.释放资源
            bw.close();
        }

    }

