package com.test.base.day12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * @Author: Jface
 * @Desc: 5. 已知有一个Map集合,里面存储的是学生的姓名和年龄，内容如下:
 * {张三丰=21, 灭绝师太=38, 柳岩=28, 刘德华=40, 老鬼=36, 王二麻子=38}.
 * 需求: 将年龄大于24的学生姓名，存入到D:\\student.txt中
 */
public class Demo05 {
    public static void main(String[] args) throws IOException {
        //分析
        //1.定义一个指定内容的Map集合
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("张三丰", 21);
        hm.put("灭绝师太", 38);
        hm.put("柳岩", 28);
        hm.put("刘德华", 40);
        hm.put("老鬼", 36);
        hm.put("王二麻子", 38);
        //2.新建高效字符输出流,关联目的地文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:test/work/student.txt"));
        //3.获取Map集合的键,即一个Set集合
        Set<String> list = hm.keySet();
        //4.遍历Set集合,如果值大于24就获取健,并写入到目的地文件
        for (String s : list) {
            if (hm.get(s) > 24) {
                bw.write(s);
                bw.newLine();
            }
        }
        //5.释放资源
        bw.close();


    }
}
