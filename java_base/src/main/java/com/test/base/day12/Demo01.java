package com.test.base.day12;

import java.io.*;

/**
 * @Author: Jface
 * @Date: 2021/5/17 20:53
 * @Desc: 1. 复制图片, 或者视频.		//要求, 用4种方法实现.
 * 1. 普通的字节流一次读写一个字节.
 * 2. 普通的字节流一次读写一个字节数组.			//必须掌握.
 * 3. 高效的字节流一次读写一个字节.				//必须掌握.
 * 4. 高效的字节流一次读写一个字节数组.
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //方式2.基本的字节流一次读写一个 字节数组. 32Ms
        //method02();

        //方法1.高效的字节流一次读写一个 字节数组.  35Ms
        //method01();

        //方法3高效的字节流一次读写一个 字节. 710Ms
        method03();

        //方法4.基本的字节流一次读写一个 字节. 60450Ms
        //method04();
        long end = System.currentTimeMillis();
        System.out.println("程序总执行时间是:" + (end - start) + "毫秒");


    }

    private static void method04() throws IOException {
        //1. 创建输入流对象, 关联: 数据源文件.
        FileInputStream fis = new FileInputStream("D:test/1.avi");
//        2. 创建输出流对象, 关联: 目的地文件.
        FileOutputStream fos = new FileOutputStream("D:test/2.avi");
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

    private static void method03() throws IOException {
        //1. 创建输入流对象, 关联: 数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:test/1.avi"));
//        2. 创建输出流对象, 关联: 目的地文件.
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:test/2.avi"));
//        3. 定义变量, 记录读取到的数据(字节, 有效字节数, 字符, 有效字符数,字符串)
        int len;
//        4. 循环读取, 只要条件满足就一直读, 并将读取到的数据赋值给 变量
        while ((len = bis.read()) != -1) {
//        5. 将读取到的内容写入到目的地文件中.
            bos.write(len);
        }
//        6. 释放资源.
        bis.close();
        bos.close();
    }

    private static void method02() throws IOException {
        //1. 创建输入流对象, 关联: 数据源文件.
        FileInputStream fis = new FileInputStream("D:test/1.avi");
//        2. 创建输出流对象, 关联: 目的地文件.
        FileOutputStream fos = new FileOutputStream("D:test/2.avi");
//        3. 定义变量, 记录读取到的数据(字节, 有效字节数, 字符, 有效字符数,字符串)
        int len;
        byte[] bys = new byte[8192];
//        4. 循环读取, 只要条件满足就一直读, 并将读取到的数据赋值给 变量
        while ((len = fis.read(bys)) != -1) {
//        5. 将读取到的内容写入到目的地文件中.
            fos.write(bys);
        }
//        6. 释放资源.
        fis.close();
        fos.close();
    }

    private static void method01() throws IOException {
        // 1. 创建输入流对象, 关联: 数据源文件.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:test/1.avi"));
//        2. 创建输出流对象, 关联: 目的地文件.
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:test/2.avi"));
//        3. 定义变量, 记录读取到的数据(字节, 有效字节数, 字符, 有效字符数,字符串)
        int len;
        byte[] bys = new byte[8192];
//        4. 循环读取, 只要条件满足就一直读, 并将读取到的数据赋值给 变量
        while ((len = bis.read(bys)) != -1) {
//        5. 将读取到的内容写入到目的地文件中.
            bos.write(bys, 0, len);
        }
//        6. 释放资源.
        bis.close();
        bos.close();
    }


}

