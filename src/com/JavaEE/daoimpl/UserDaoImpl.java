package com.JavaEE.daoimpl;

import com.JavaEE.dao.UserDao;
import com.JavaEE.entity.User;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.*;
import java.util.*;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


/**
 * Created by xfcq on 2016/4/26.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    @Override
    public void addUser(User user) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        user.setCreateTime(date);
        user.setUserStatus(0);
        try{
            this.getHibernateTemplate().save(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public User queryUserByID(String uid) {
        User user = (User) (getHibernateTemplate().get(User.class,Integer.valueOf(uid)));
        return user;
    }

    @Override
    public List<User> allUsers() {
        List a=(List<User>)this.getHibernateTemplate().find("from User");
        return a;
    }

    @Override
    public boolean existUser(String email, String password) {
        List list = (List<User>) this.getHibernateTemplate().find("from User a where a.userEmail=? and a.userPwd=? and a.userStatus=1",new String[]{email,password});
        if(list.size() == 0)
            return false;
        else return true;
    }

    @Override
    public boolean existUserInverify(String email, String password) {
        List list = (List<User>) this.getHibernateTemplate().find("from User a where a.userEmail=? and a.userPwd=? and a.userStatus=0",new String[]{email,password});
        if(list.size() == 0)
            return false;
        else return true;
    }

    @Override
    public boolean existUserByName(String name) {
        List list = (List<User>) this.getHibernateTemplate().find("from User a where a.userName=?",name);
        if(list.size() == 0)
            return false;
        else return true;
    }
    @Override
    public boolean existUserByEmail(String email) {
        List list = (List<User>) this.getHibernateTemplate().find("from User a where a.userEmail=?",email);
        if(list.size() == 0)
            return false;
        else return true;
    }

    @Override
    public User queryUserByEmail(String email) {
        List list = (List<User>) this.getHibernateTemplate().find("from User a where a.userEmail=?",email);
        User user = (User)list.get(0);
        return user;
    }

    @Override
    public List<User> allUsersByAuthority() {
        List a=(List<User>)this.getHibernateTemplate().find("from User a where a.userStatus=0");
        return a;
    }

    @Override
    public boolean updateUser(User user) {
        try{
            this.getHibernateTemplate().saveOrUpdate(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
