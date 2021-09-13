package com.test.demo06_upload_receipt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Jface
 * @Date: 2021/5/21 20:02
 * @Desc: 案例: 演示TCP协议之文件上传案例.
 * <p>
 * TCP协议服务器端代码步骤:
 * 1. 创建服务器端的Socket对象(ServerSocket), 指定: 端口号.
 * 2. 监听连接. 当服务器端监听到有客户端申请建立连接, 并在审核数据成功后, 会创建一个Socket对象, 与该客户端交互.
 * 3. 通过Socket#getInputStream()方法, 获取输入流, 可以读取客户端写过来的数据.
 * 4. 通过转换流和字符高效流将上一步获取的 字节输入流封装成 高效字符输入流.
 * 5. 创建字符高效输出流,关联目的地文件(即: 接收到的数据往哪里写)
 * 6. 具体的IO读写动作, 接收上传的数据.
 * 7. 通过Socket#getOutputStream()获取输出流, 可以给客户端写回执信息.
 * 8. 将上述的流对象封装成 字符高效输出流.
 * 9. 具体给客户端写回执信息的操作.
 * 10. 释放资源.
 * <p>
 * ServerSocket类中的成员方法:
 * public Socket accept();     监听连接.
 * <p>
 * Socket类中的成员方法:
 * public OutputStream getOutputStream();  获取输出流, 可以往服务器端写数据.
 * public InputStream getInputStream();    获取输入流, 可以读取服务器端写过来的数据.
 */
public class ServerDemo {
    public static void main(String[] args) throws Exception {
//        1. 创建服务器端的Socket对象(ServerSocket), 指定: 端口号.
        ServerSocket socket = new ServerSocket(12306);
//        2. 监听连接. 当服务器端监听到有客户端申请建立连接, 并在审核数据成功后, 会创建一个Socket对象, 与该客户端交互.
        Socket accept = socket.accept();
//        3. 通过Socket#getInputStream()方法, 获取输入流, 可以读取客户端写过来的数据.
//        4. 通过转换流和字符高效流将上一步获取的 字节输入流封装成 高效字符输入流.
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
//        5. 创建字符高效输出流,关联目的地文件(即: 接收到的数据往哪里写)
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:test/copy.txt"));
//        6. 具体的IO读写动作, 接收上传的数据.
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();//换行
            bw.flush();
        }//刷新缓存区
//        7. 通过Socket#getOutputStream()获取输出流, 可以给客户端写回执信息.
//        8. 将上述的流对象封装成 字符高效输出流.
        BufferedWriter br2 = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
//        9. 具体给客户端写回执信息的操作
        br2.write("服务器已收到,谢谢你鸭");
        br2.newLine();//换行
        br2.flush();
//        10. 释放资源.
        bw.close();
        accept.close();


    }
}
