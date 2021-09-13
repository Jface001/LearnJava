package com.test.demo03_message;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Jface
 * @Date: 2021/5/21 10:30
 * @Desc: 案例:演示TCP协议之客户端给服务器端发送一句话,服务器端接收到后打印
 */
public class ServerDemo {
    public static void main(String[] args) throws Exception {
        //1.创建服务器端的Socket对象(ServerSocket),指定:端口号
        ServerSocket serverSocket = new ServerSocket(12306);
        //2.监听连接
        Socket accept = serverSocket.accept();
        //3.通过Socket#
        InputStream is = accept.getInputStream();
        //4.将读取到的数据转成字符串,并打印
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        //5.将读取到的数据转换成字符串, 并打印
        String s = new String(bys, 0, len);
        System.out.println("服务端收到:" + s);
        //6.获取输出流,往客户端写数据
        OutputStream os = accept.getOutputStream();
        //7.非客户端写回执信息
        os.write("火星火星,我已收到".getBytes());
        //8.释放资源
        accept.close();
    }
}
