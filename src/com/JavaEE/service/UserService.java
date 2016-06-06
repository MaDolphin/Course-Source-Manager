package com.JavaEE.service;

import com.JavaEE.entity.*;

import java.sql.Date;
import java.util.List;

/**
 * Created by xfcq on 2016/5/12.
 */
public interface UserService {
    public boolean existUser(String userEmail,String password);
    public boolean existUserInverify(String userEmail,String password);
    public boolean emailAvailable(String userEmail);
    public boolean nameAvailable(String userName);
    public boolean registerUser(User user);
    public User queryUserByEmail(String userEmail);
    public List<Course> queryallCoursesByNew12();
    public List<Course> queryallCoursesByLikeName(String couname);
    public List<Course> queryallCourseBySelect();
    public List<Course> queryallCourseByName(String couname);
    public Course queryCourseById(String couid, Date startTime);
    public Teacher queryTeacherById(String teaid);
    public List<Source> querySourceByCourse(String couid, Date startTime);
    public List<Product> queryProductByCourse(String couid);
    public List<Product> queryProductByItem(String couid);
    public List<WorkInfo> queryHomeworkByCourse(String couid,Date startTime);
    public boolean joinInCourse(CourseInfo courseInfo);
    public boolean joinOutCourse(CourseInfo courseInfo);
    public boolean queryUserExistCourseInfo(String couid,Date startTime,String userid);
    public List queryUserCourse(String userid);
    public List queryUserHomework(String userid);
    public User queryUserInfo(String userid);
    public boolean editUserInfo(User user);
    public boolean editUserHomework(WorkInfo workInfo);
    public WorkInfo queryUserHomeworkByUserCourseHomework(String workid,String userid);
}
