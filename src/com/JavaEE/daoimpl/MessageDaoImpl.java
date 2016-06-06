package com.JavaEE.daoimpl;

import com.JavaEE.dao.MessageDao;
import com.JavaEE.entity.Message;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {
    @Override
    public boolean addMessage(Message message) {
        try{
            this.getHibernateTemplate().save(message);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMessage(Message message) {
        try{
            this.getHibernateTemplate().delete(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateMessage(Message message) {
        try{
            this.getHibernateTemplate().saveOrUpdate(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Message queryMessageByID(String mesid) {
        Message message = (Message) (getHibernateTemplate().get(Message.class,mesid));
        return message;
    }

    @Override
    public List<Message> allMessages() {
        List a=(List<Message>)this.getHibernateTemplate().find("from Message");
        return a;
    }
}
