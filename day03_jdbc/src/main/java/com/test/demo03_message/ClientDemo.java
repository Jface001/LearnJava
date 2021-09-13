package com.test.demo03_message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Jface
 * @Date: 2021/5/21 10:21
 * @Desc:
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        //1.创建客户端对象,指定服务器IP和端口好.
        Socket socket = new Socket("192.168.16.48", 12306);
        //2.获取输出流
        OutputStream os = socket.getOutputStream();
        //3.具体给服务器端写数据的操作
        os.write("你好呀,我是火星,地雷是否收到??".getBytes());
        //4.获取输入流对象
        InputStream is = socket.getInputStream();
        //5.接收回执并打印
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String s = new String(bys, 0, len);
        System.out.println("客户端收到: " + s);
        //6.释放资源
        socket.close();


    }
}
