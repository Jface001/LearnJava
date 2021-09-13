package com.test.demo06_upload_receipt;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: Jface
 * @Date: 2021/5/21 19:30
 * @Desc: 案例: 演示TCP协议之文件上传案例.
 * <p>
 * TCP协议客户端代码步骤:
 * 1. 创建客户端的Socket对象,指定: 服务器端ip, 端口号.
 * 2. 通过Socket#getOutputStream()方法, 获取输出流, 可以往服务器端写数据.
 * 3. 通过转换流 和 字符高效流, 将上一步获取的字节输出流封装成: 字符高效输出流.
 * 4. 创建字符高效输入流, 关联: 数据源文件(具体要上传的文件)
 * 5. 具体的上传文件的动作(其实就是IO流的读写代码).
 * 6. 核心步骤: 给服务器端一个结束标记, 意思是: 我上传完毕了, 你该干嘛干嘛.
 * 7. 通过Socket#getInputStream(), 可以读取服务器端写过来的回执信息.
 * 8. 将上一步获取到的流对象, 封装成: 字符高效输入流.
 * 9. 具体的读取服务器端写过来的回执信息的动作, 并打印.
 * 10. 释放资源.
 * <p>
 * Socket类中的成员方法:
 * public OutputStream getOutputStream();  获取输出流, 可以往服务器端写数据.
 * public InputStream getInputStream();    获取输入流, 可以读取服务器端写过来的数据.
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
//        1. 创建客户端的Socket对象,指定: 服务器端ip, 端口号.
        Socket socket = new Socket("192.168.16.48", 12306);
//        2. 通过Socket#getOutputStream()方法, 获取输出流, 可以往服务器端写数据.
//        3. 通过转换流 和 字符高效流, 将上一步获取的字节输出流封装成: 字符高效输出流.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        4. 创建字符高效输入流, 关联: 数据源文件(具体要上传的文件)
        BufferedReader br = new BufferedReader(new FileReader("D:test/name.txt"));
//        5. 具体的上传文件的动作(其实就是IO流的读写代码).
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();//换行
            bw.flush();//释放缓存区资源
        }
        // 6. 核心步骤: 给服务器端一个结束标记, 意思是: 我上传完毕了, 你该干嘛干嘛.
        socket.shutdownOutput();
//        7. 通过Socket#getInputStream(), 可以读取服务器端写过来的回执信息.
//        8. 将上一步获取到的流对象, 封装成: 字符高效输入流.
        BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        9. 具体的读取服务器端写过来的回执信息的动作, 并打印.
        String result = br2.readLine();
        System.out.println("客户端收到: " + result);
//        10. 释放资源.
        br.close();
        socket.close();


    }
}
