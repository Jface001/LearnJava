package com.test.base.day12;

import java.io.*;

/**
 * @Author: Jface
 * @Date: 2021/5/17 20:57
 * @Desc: 2. 复制文本文件.			//要求, 用11种方式实现.
 * 1. 普通的字节流一次读写一个字节.
 * 2. 普通的字节流一次读写一个字节数组.			//必须掌握.
 * 3. 高效的字节流一次读写一个字节.				//必须掌握.
 * 4. 高效的字节流一次读写一个字节数组.
 * 5. 转换流一次读取一个字符.				//InputStreamReader 和 OutputStreamWriter
 * 6. 转换流一次读取一个字符数组.
 * 7. 普通的字符流一次读写一个字符.		//FileReader 和 FileWriter
 * 8. 普通的字符流一次读写一个字符数组.
 * 9. 高效的字符流一次读写一个字符. 		//BufferedReader 和 BufferedWriter
 * 10. 高效的字符流一次读写一个字符数组.
 * 11. 高效的字符流一次读写一行. 					//必须, 必须, 必须掌握.
 * IO流的核心操作步骤:
 * 1. 创建输入流对象, 关联: 数据源文件.
 * 2. 创建输出流对象, 关联: 目的地文件.
 * 3. 定义变量, 记录读取到的数据(字节, 有效字节数, 字符, 有效字符数,字符串)
 * 4. 循环读取, 只要条件满足就一直读, 并将读取到的数据赋值给 变量
 * 5. 将读取到的内容写入到目的地文件中.
 * 6. 释放资源.
 */
public class Demo02 {
    public static void main(String[] args) throws IOException {
//        方法1. 普通的字节流一次读写一个字节.
//        method01();

//        方法.2. 普通的字节流一次读写一个字节数组.
        //method02();

        //方法11.高效的字符流一次读写一行
        method11();



    }

    private static void method11() throws IOException {
        //        IO流的核心操作步骤:
//        1. 创建输入流对象, 关联: 数据源文件.
        BufferedReader br = new BufferedReader(new FileReader("D:test/name.txt"));
//        2. 创建输出流对象, 关联: 目的地文件.
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:test/11.txt"));
//        3. 定义变量, 记录读取到的数据(字节, 有效字节数, 字符, 有效字符数,字符串)
        String name;
//        4. 循环读取, 只要条件满足就一直读, 并将读取到的数据赋值给 变量
        while((name = br.readLine())!= null){
//        5. 将读取到的内容写入到目的地文件中.
            bw.write(name);
            bw.newLine();//换行,按你的操作系统换行方式换行.
        }
//        6. 释放资源.
        br.close();
        bw.close();
    }

    private static void method02() throws IOException {
        //1. 创建输入流对象, 关联: 数据源文件.
        FileInputStream fis = new FileInputStream("D:test/AA.txt");
//        2. 创建输出流对象, 关联: 目的地文件.
        FileOutputStream fos = new FileOutputStream("D:test/1.txt");
//        3. 定义变量, 记录读取到的数据(字节, 有效字节数, 字符, 有效字符数,字符串)
        int len;
        byte[] bys = new byte[8192];
//        4. 循环读取, 只要条件满足就一直读, 并将读取到的数据赋值给 变量
        while ((len =fis.read()) != -1) {
//        5. 将读取到的内容写入到目的地文件中.
            fos.write(bys,0,bys.length);
        }
//        6. 释放资源.
        fis.close();
        fos.close();
    }


    private static void method01() throws IOException {
        //        1. 创建输入流对象, 关联: 数据源文件.
        FileInputStream fis = new FileInputStream("D:test/AA.txt");
//        2. 创建输出流对象, 关联: 目的地文件.
        FileOutputStream fos = new FileOutputStream("D:test/1.txt");
//        3. 定义变量, 记录读取到的数据(字节, 有效字节数, 字符, 有效字符数,字符串)
        int len;
//        4. 循环读取, 只要条件满足就一直读, 并将读取到的数据赋值给 变量
        while ((len = fis.read()) != -1) {
//        5. 将读取到的内容写入到目的地文件中.
            fos.write(len);
        }
//        6. 释放资源.
        fis.close();
        fos.close();
    }
}
