package com.JavaEE.action;

import com.JavaEE.entity.Admin;
import com.JavaEE.entity.Teacher;
import com.JavaEE.service.AdminService;
import com.JavaEE.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


/**
 * Created by xfcq on 2016/5/17.
 */
public class AdminTeacherLoginAction extends ActionSupport implements SessionAware {
    private TeacherService teacherService;
    private AdminService adminService;
    private String id;
    private String password;
    private String result;
    private Map session;

    public void setSession(Map session) {
        this.session = session;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String executeLogin(){
        if(String.valueOf(id).subSequence(0, 1).equals("2")){
            if(teacherService.existTeacher(id,password)){
                result = "true";
                Teacher teacher = teacherService.queryTeacherById(id);
                session.put("teacher",teacher);
                return "success_teacher";
            }else{
                result = "false";
                return INPUT;
            }
        }
        if(String.valueOf(id).subSequence(0, 1).equals("3")){
            if(adminService.existAdmin(id,password)){
                result = "true";
                Admin admin = adminService.queryAdminById(id);
                session.put("admin",admin);
                return "success_admin";
            }else{
                result = "false";
                return INPUT;
            }
        }else{
            return INPUT;
        }
    }

    public String executeLogout(){
        this.session.remove("admin");
        this.session.remove("teacher");
        return SUCCESS;
    }

}
