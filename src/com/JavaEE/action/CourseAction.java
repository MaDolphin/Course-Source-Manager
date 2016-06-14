package com.JavaEE.action;
import com.JavaEE.dao.CourseDao;
import com.JavaEE.entity.Course;
import com.JavaEE.entity.Teacher;
import com.JavaEE.entity.User;
import com.JavaEE.service.AdminService;
import com.JavaEE.service.TeacherService;
import com.JavaEE.util.FileOperate;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import java.io.*;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class CourseAction extends ActionSupport implements SessionAware {
    private AdminService adminService;
    private int couId;
    private Date startTime;
    private String couName;
    private String couInfo;
    private String couTea;
    private String couType;

    private File upload;
//    private String uploadFileName;
//    private String uploadContextType;
    private String savePath;
    private String result;
    private Map session;

    public void setSession(Map session) {
        this.session = session;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public String getCouType() {
        return couType;
    }

    public void setCouType(String couType) {
        this.couType = couType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCouId() {
        return couId;
    }

    public void setCouId(int couId) {
        this.couId = couId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getCouInfo() {
        return couInfo;
    }

    public void setCouInfo(String couInfo) {
        this.couInfo = couInfo;
    }

    public String getCouTea() {
        return couTea;
    }

    public void setCouTea(String couTea) {
        this.couTea = couTea;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

//    public String getUploadFileName() {
//        return uploadFileName;
//    }
//
//    public void setUploadFileName(String uploadFileName) {
//        this.uploadFileName = uploadFileName;
//    }
//
//    public String getUploadContextType() {
//        return uploadContextType;
//    }
//
//    public void setUploadContextType(String uploadContextType) {
//        this.uploadContextType = uploadContextType;
//    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }


    public String executeAddCourse(){
        Course cou = new Course();
        cou.setCouId(couId);
        cou.setCouName(couName);
        cou.setCouTea(Integer.valueOf(couTea));
        cou.setStartTime(startTime);
        cou.setCouInfo(couInfo);
        cou.setCouType(couType);
        cou.setCouStatus(0);
        if(adminService.addCourse(cou,this.getSavePath(),this.upload)){
            result = "true";
        }else {
            result = "false";
        }
        session.put("result_course_add",result);
        return SUCCESS;
    }

    public String executeDeleteCourse(){
        if(adminService.deleteCourse(String.valueOf(this.couId),this.startTime)){
            result = "true";
        }else{
            result = "false";
        }
        session.put("result_course_del",result);
        return SUCCESS;
    }

    public String executeEditCourse(){
        Course cou = adminService.queryCourseByID(String.valueOf(couId),startTime);
        cou.setCouId(couId);
        cou.setCouName(couName);
        cou.setCouTea(Integer.valueOf(couTea));
        cou.setStartTime(startTime);
        cou.setCouInfo(couInfo);
        cou.setCouType(couType);
        cou.setCouStatus(0);
        if(upload != null){
            if(adminService.editCourse(cou,this.getSavePath(),this.upload)){
                result = "true";
            }else {
                result = "false";
            }
        }else{
            if(adminService.editCourse(cou)){
                result = "true";
            }else {
                result = "false";
            }
        }
        session.put("result_course_edit",result);
        return SUCCESS;
    }

    public String initAddCourse(){
        List<Teacher> list = adminService.queryAllTeacher();
        this.session.put("addCourse_teacherList",list);
        return SUCCESS;
    }

    public String initEditCourse(){
        Course course=adminService.queryCourseByID(String.valueOf(this.couId),this.startTime);
        this.session.put("courseById",course);
        return SUCCESS;
    }

    public String initShowCourse(){
        Course course=adminService.queryCourseByID(String.valueOf(this.couId),this.startTime);
        this.session.put("courseById",course);
        return SUCCESS;
    }

    public String executeAllCourse(){
        List<Course> courseList = adminService.queryAllCourse();
        this.session.put("courseList",courseList);
        return SUCCESS;
    }

    public String initIndex(){
        return SUCCESS;
    }

}
