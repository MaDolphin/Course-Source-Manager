package com.JavaEE.dao;

import com.JavaEE.entity.Message;

import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public interface MessageDao {
    public boolean addMessage(Message message);
    public boolean deleteMessage(Message message);
    public boolean updateMessage(Message message);
    public Message queryMessageByID(String mesid);
    public List<Message> allMessages();
}
