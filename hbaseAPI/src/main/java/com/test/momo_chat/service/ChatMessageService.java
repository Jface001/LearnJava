package com.test.momo_chat.service;



import com.test.momo_chat.entity.Msg;

import java.util.List;

/**
 * @ClassName ChatMessageService
 * @Description TODO 用于实现查询数据的接口
 * @Create By     Frank
 */
public interface ChatMessageService {
    //根据条件进行查询方法：日期、发送人id、接受人id
    List<Msg> getMessage(String date, String sender, String receiver) throws Exception;
    //关闭资源方法
    void close();
}
