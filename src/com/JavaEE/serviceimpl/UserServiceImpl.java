package com.JavaEE.serviceimpl;

import com.JavaEE.dao.*;
import com.JavaEE.entity.*;
import com.JavaEE.service.UserService;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xfcq on 2016/5/12.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private CourseDao courseDao;
    private CourseInfoDao courseInfoDao;
    private SourceDao sourceDao;
    private WorkInfoDao workInfoDao;
    private ProductDao productDao;
    private TeacherDao teacherDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setCourseInfoDao(CourseInfoDao courseInfoDao) {
        this.courseInfoDao = courseInfoDao;
    }

    public void setSourceDao(SourceDao sourceDao) {
        this.sourceDao = sourceDao;
    }

    public void setWorkInfoDao(WorkInfoDao workInfoDao) {
        this.workInfoDao = workInfoDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public boolean existUser(String userEmail,String password){
        if(userDao.existUser(userEmail,password)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean existUserInverify(String userEmail,String password){
        if(userDao.existUserInverify(userEmail,password)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean emailAvailable(String userEmail){
        if(userDao.existUserByEmail(userEmail)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean nameAvailable(String userName){
        if(userDao.existUserByName(userName)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean registerUser(User user) {
        if(userDao.existUserByEmail(user.getUserEmail())==false && userDao.existUserByName(user.getUserName())==false){
            userDao.addUser(user);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User queryUserByEmail(String userEmail) {
        return userDao.queryUserByEmail(userEmail);
    }

    @Override
    public List<Course> queryallCoursesByNew12() {
        return courseDao.allCoursesByNew12();
    }

    @Override
    public List<Course> queryallCoursesByLikeName(String couname) {
        return courseDao.allCoursesByLikeName(couname);
    }

    public List<Course> queryallCourseBySelect(){
        return courseDao.allCoursesBySelect();
    }

    @Override
    public List<Course> queryallCourseByName(String couname) {
        return courseDao.allCoursesByName(couname);
    }

    @Override
    public Course queryCourseById(String couid, Date startTime) {
        return courseDao.queryCourseByID(couid,startTime);
    }

    @Override
    public Teacher queryTeacherById(String teaid) {
        return teacherDao.queryTeacherByID(teaid);
    }

    @Override
    public List<Source> querySourceByCourse(String couid, Date startTime) {
        return sourceDao.allSourcesByCourse(couid,startTime);
    }

    @Override
    public List<Product> queryProductByCourse(String couid) {
        return productDao.allProductsByCourse(couid);
    }

    @Override
    public List<Product> queryProductByItem(String couid) {
        return productDao.allProductByItem(couid);
    }

    @Override
    public List<WorkInfo> queryHomeworkByCourse(String couid, Date startTime) {
        return workInfoDao.allWorkInfosByCourse(couid,startTime);
    }

    @Override
    public boolean joinInCourse(CourseInfo courseInfo) {
        return courseInfoDao.addCourseInfo(courseInfo);
    }

    @Override
    public boolean joinOutCourse(CourseInfo courseInfo) {
        try{
            List<WorkInfo> homeworkList = workInfoDao.queryWorkInfoByUser(String.valueOf(courseInfo.getCouId()),courseInfo.getStartTime(),String.valueOf(courseInfo.getUserId()));
            for(int i=0;i<homeworkList.size();i++){
                workInfoDao.deleteWorkInfo(homeworkList.get(i));
            }
            CourseInfo temp = courseInfoDao.queryCourseInfoByCourseUser(String.valueOf(courseInfo.getCouId()),courseInfo.getStartTime(),String.valueOf(courseInfo.getUserId()));
            courseInfoDao.deleteCourseInfo(temp);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean queryUserExistCourseInfo(String couid,Date startTime,String userid) {
        CourseInfo temp = courseInfoDao.queryCourseInfoByCourseUser(String.valueOf(couid),startTime,String.valueOf(userid));
        if(temp == null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public List queryUserCourse(String userid) {
        return courseInfoDao.CourseInfosByUser(userid);
    }

    @Override
    public List queryUserHomework(String userid) {
        return workInfoDao.allWorkInfoListByUser(userid);
    }

    @Override
    public User queryUserInfo(String userid) {
        return userDao.queryUserByID(userid);
    }

    @Override
    public boolean editUserInfo(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean editUserHomework(WorkInfo workInfo) {
        return workInfoDao.updateWorkInfo(workInfo);
    }

    @Override
    public WorkInfo queryUserHomeworkByUserCourseHomework(String workid,String userid) {
        return workInfoDao.queryUserHomeworkByUserCourseHomework(workid,userid);
    }
}
