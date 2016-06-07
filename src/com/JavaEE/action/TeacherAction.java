package com.JavaEE.action;

import com.JavaEE.dao.TeacherDao;
import com.JavaEE.entity.Admin;
import com.JavaEE.entity.Course;
import com.JavaEE.entity.Teacher;
import com.JavaEE.service.AdminService;
import com.JavaEE.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by xfcq on 2016/5/11.
 */
public class TeacherAction extends ActionSupport implements SessionAware {
    private AdminService adminService;
    private TeacherService teacherService;
    private int teaId;
    private String teaName;
    private String teaPwd;
    private String teaEmail;
    private int teaStatus;
    private String result;
    private Map session;

    public void setSession(Map session) {
        this.session = session;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTeaStatus() {
        return teaStatus;
    }

    public void setTeaStatus(int teaStatus) {
        this.teaStatus = teaStatus;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaPwd() {
        return teaPwd;
    }

    public void setTeaPwd(String teaPwd) {
        this.teaPwd = teaPwd;
    }

    public String getTeaEmail() {
        return teaEmail;
    }

    public void setTeaEmail(String teaEmail) {
        this.teaEmail = teaEmail;
    }

    public String executeAddTeacher(){
        Teacher tea = new Teacher();
        tea.setTeaName(this.teaName);
        tea.setTeaPwd(this.teaPwd);
        tea.setTeaEmail(this.teaEmail);
        tea.setTeaStatus(1);
        if(adminService.addTeacher(tea)){
            result = "true";
        }else {
            result = "false";
        }
        session.put("result_teacher_add",result);
        return SUCCESS;
    }

    public String executeAllTeacher(){
        List<Teacher> teacherList = adminService.queryAllTeacher();
        this.session.put("teacherList",teacherList);
        return SUCCESS;
    }

    public String executeResetPasswordTeacher(){
        adminService.resetPasswordTeacher(String.valueOf(teaId));
        return SUCCESS;
    }

    public String executePassTeacher(){
        adminService.passTeacher(String.valueOf(teaId));
        return SUCCESS;
    }

    public String executeCancelTeacher(){
        adminService.cancelTeacher(String.valueOf(teaId));
        return SUCCESS;
    }

    public String initShowTeacher(){
        Teacher teacher=adminService.queryTeacherById(String.valueOf(teaId));
        List<Course> list = adminService.queryAllCourseByTeacher(String.valueOf(teaId));
        session.put("show_teacher",teacher);
        session.put("show_teacher_list",list);
        return SUCCESS;
    }

    public String initEditTeacher(){
        Teacher teacher=adminService.queryTeacherById(String.valueOf(teaId));
        session.put("edit_teacher",teacher);
        return SUCCESS;
    }

    public String executeEditTeacher(){
        Teacher teacher=adminService.queryTeacherById(String.valueOf(teaId));
        teacher.setTeaName(teaName);
        teacher.setTeaEmail(teaEmail);
        teacher.setTeaPwd(teaPwd);
        if(adminService.editTeacher(teacher)){
            result = "true";
        }else{
            result = "false";
        }
        session.put("result_teacher_edit",result);
        return SUCCESS;
    }

    public String executeTeacherEditInfo(){
        Teacher teacher = teacherService.queryTeacherById(String.valueOf(teaId));
        teacher.setTeaPwd(teaPwd);
        teacher.setTeaName(teaName);
        teacher.setTeaEmail(teaEmail);
        teacherService.editTeacher(teacher);
        Teacher r = teacherService.queryTeacherById(String.valueOf(teaId));
        session.put("teacher",r);
        return SUCCESS;
    }

}
