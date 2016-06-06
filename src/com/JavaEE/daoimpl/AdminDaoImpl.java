package com.JavaEE.daoimpl;

import com.JavaEE.dao.AdminDao;
import com.JavaEE.entity.Admin;
import org.hibernate.*;
import java.util.*;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by xfcq on 2016/4/26.
 */
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
    @Override
    public void addAdmin(Admin admin) {
        try{
            this.getHibernateTemplate().save(admin);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Admin queryAdminByID(String aid) {
        Admin admin = (Admin) (getHibernateTemplate().get(Admin.class,Integer.valueOf(aid)));
        return admin;
    }

    @Override
    public List<Admin> allAdmins() {
        List a=(List<Admin>)this.getHibernateTemplate().find("from Admin");
        return a;
    }

    @Override
    public boolean existAdmin(String id,String password) {
        List list = (List<Admin>) this.getHibernateTemplate().find("from Admin a where a.adminId=? and a.adminPwd=?",new Object[]{Integer.valueOf(id),password});
        if(list.size() == 0)
            return false;
        else return true;
    }
}
