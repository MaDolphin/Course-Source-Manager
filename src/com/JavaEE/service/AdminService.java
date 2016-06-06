package com.JavaEE.service;

import com.JavaEE.entity.Admin;
import com.JavaEE.entity.Course;
import com.JavaEE.entity.Teacher;
import com.JavaEE.entity.User;

import java.io.File;
import java.sql.Date;
import java.util.List;

/**
 * Created by xfcq on 2016/5/12.
 */
public interface AdminService {
    public boolean addCourse(Course course, String savePath,File uploadFile);
    public boolean deleteCourse(String couid,Date startTime);
    public boolean loadCourseInfo(String uploadFileFileName);
    public void courseIntoDB(List<Course> courseList);
    public boolean batchImportCourse(String uploadFileFileName,String savePath,File uploadFile);
    public boolean addTeacher(Teacher teacher);
    public boolean batchImportTeacher(String uploadFileFileName,String savePath,File uploadFile);
    public boolean loadTeacherInfo(String uploadFileFileName);
    public void teacherIntoDB(List<Teacher> teacherList);
    public boolean editCourse(Course course, String savePath,File uploadFile);
    public boolean editCourse(Course course);
    public Course queryCourseByID(String couid, Date startTime);
    public List<User> queryAllUser();
    public List<Course> queryAllCourse();
    public List<Teacher> queryAllTeacher();
    public List<User> queryAllUserByAuthority();
    public boolean existAdmin(String id,String password);
    public Admin queryAdminById(String aid);
    public boolean passUser(String userid);
    public boolean cancelUser(String userid);
    public boolean passTeacher(String teaid);
    public boolean cancelTeacher(String teaid);
    public boolean resetPasswordUser(String userid);
    public boolean resetPasswordTeacher(String teaid);
    public List<Course> queryAllCourseByTeacher(String teaid);
    public Teacher queryTeacherById(String teaid);
    public boolean editTeacher(Teacher teacher);
    public User queryUserById(String userid);
    public List<Course> queryAllCourseByUser(String userid);
}
