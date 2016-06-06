package com.JavaEE.dao;

import com.JavaEE.entity.User;

import java.util.List;

/**
 * Created by xfcq on 2016/4/26.
 */
public interface UserDao {
    public void addUser(User user);
    public User queryUserByID(String uid);
    public List<User> allUsers();
    public List<User> allUsersByAuthority();
    public boolean existUser(String email,String password);
    public boolean existUserInverify(String email, String password);
    public boolean existUserByName(String name);
    public boolean existUserByEmail(String email);
    public User queryUserByEmail(String email);
    public boolean updateUser(User user);
}
