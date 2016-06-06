package com.JavaEE.dao;
import com.JavaEE.entity.Admin;

import java.util.*;
/**
 * Created by xfcq on 2016/4/26.
 */
public interface AdminDao {
    public void addAdmin(Admin admin);
    public Admin queryAdminByID(String aid);
    public List<Admin> allAdmins();
    public boolean existAdmin(String id,String password);
}
