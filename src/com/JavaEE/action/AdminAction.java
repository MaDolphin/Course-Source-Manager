package com.JavaEE.action;

import com.JavaEE.entity.Admin;
import com.JavaEE.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by xfcq on 2016/6/7.
 */
public class AdminAction extends ActionSupport implements SessionAware {
    private AdminService adminService;
    private int adminId;
    private String adminName;
    private String adminPwd;
    private Map session;

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public String executeAdminEditInfo(){
        Admin admin = adminService.queryAdminById(String.valueOf(adminId));
        admin.setAdminPwd(adminPwd);
        admin.setAdminName(adminName);
        adminService.editAdmin(admin);
        Admin r = adminService.queryAdminById(String.valueOf(adminId));
        session.put("admin",r);
        return SUCCESS;
    }
}
