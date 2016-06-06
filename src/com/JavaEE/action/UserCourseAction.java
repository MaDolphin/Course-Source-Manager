package com.JavaEE.action;

import com.JavaEE.entity.*;
import com.JavaEE.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.JSONObject;
import net.sf.json.util.CycleDetectionStrategy;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static com.opensymphony.xwork2.Action.*;

/**
 * Created by xfcq on 2016/5/30.
 */
public class UserCourseAction implements SessionAware {
    private UserService userService;
    private String searchInfo;
    private JSON indexSearchJSON;
    private Map session;
    private int couId;
    private Date startTime;
    private String couName;
    private String couInfo;
    private Integer couTea;
    private String couType;
    private String couImage;
    private Integer couStatus;
    private int userId;
    private String result_joinInCourse;
    private String result_joinOutCourse;
    private String fileUrl;
    private int workId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String userImage;
    private Integer userStatus;
    private Timestamp createTime;
    private String result_edit_user;

    public void setSession(Map session) {
        this.session = session;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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

    public Integer getCouTea() {
        return couTea;
    }

    public void setCouTea(Integer couTea) {
        this.couTea = couTea;
    }

    public String getCouType() {
        return couType;
    }

    public void setCouType(String couType) {
        this.couType = couType;
    }

    public String getCouImage() {
        return couImage;
    }

    public void setCouImage(String couImage) {
        this.couImage = couImage;
    }

    public Integer getCouStatus() {
        return couStatus;
    }

    public void setCouStatus(Integer couStatus) {
        this.couStatus = couStatus;
    }

    public JSON getIndexSearchJSON() {
        return indexSearchJSON;
    }

    public void setIndexSearchJSON(JSON indexSearchJSON) {
        this.indexSearchJSON = indexSearchJSON;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(String searchInfo) {
        this.searchInfo = searchInfo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getResult_joinInCourse() {
        return result_joinInCourse;
    }

    public void setResult_joinInCourse(String result_joinCourse) {
        this.result_joinInCourse = result_joinCourse;
    }

    public String getResult_joinOutCourse() {
        return result_joinOutCourse;
    }

    public void setResult_joinOutCourse(String result_joinOutCourse) {
        this.result_joinOutCourse = result_joinOutCourse;
    }

    public String getResult_edit_user() {
        return result_edit_user;
    }

    public void setResult_edit_user(String result_edit_user) {
        this.result_edit_user = result_edit_user;
    }

    public String executeIndexSearch(){
        List<Course> list = userService.queryallCoursesByLikeName(searchInfo);
        JsonConfig jsonConfig = new JsonConfig();  //建立配置文件
        jsonConfig.setIgnoreDefaultExcludes(false);  //设置默认忽略
        jsonConfig.setExcludes(new String[]{"couTea","startTime","couId","couInfo","couType","couStatus","couImage","teacherByCouTea","courseInfos","messages","sources","workInfos"});
        indexSearchJSON = JSONArray.fromObject(list,jsonConfig);
        return SUCCESS;
    }

    public String initShowCourse(){
        List<Course> list = userService.queryallCourseBySelect();
        session.put("user_coulistAll",list);
        return SUCCESS;
    }

    public String initDetailCourse(){
        if(session.get("user") != null){
            Course course = userService.queryCourseById(String.valueOf(couId),startTime);
            List<Product> productList = userService.queryProductByCourse(String.valueOf(course.getCouId()));
            List<Product> productListItem = userService.queryProductByItem(String.valueOf(course.getCouId()));
            List<Source> sourceList = userService.querySourceByCourse(String.valueOf(course.getCouId()),course.getStartTime());
            Teacher teacher = userService.queryTeacherById(String.valueOf(course.getCouTea()));
            User user = (User) session.get("user");
            boolean flag = userService.queryUserExistCourseInfo(String.valueOf(couId),startTime,String.valueOf(user.getUserId()));
            session.put("userExistCourse",flag);
            session.put("detail_course_course",course);
            session.put("detail_course_productList",productList);
            session.put("detail_course_productListItem",productListItem);
            session.put("detail_course_sourceList",sourceList);
            session.put("detail_course_teacher",teacher);
            return SUCCESS;
        }else {
            return INPUT;
        }
    }

    public String initSearchCourse(){
        List<Course> lista = userService.queryallCourseBySelect();
        session.put("user_coulistAll",lista);
        List<Course> listb = userService.queryallCourseByName(couName);
        session.put("user_search_coulist",listb);
        return SUCCESS;
    }

    public String executeUserJoinInCourse(){
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setCouId(couId);
        courseInfo.setStartTime(startTime);
        courseInfo.setUserId(userId);
        if(userService.joinInCourse(courseInfo)){
            result_joinInCourse = "true";
        }else {
            result_joinInCourse = "false";
        }
        session.put("result_joinInCourse",result_joinInCourse);
        return SUCCESS;
    }

    public String executeUserJoinOutCourse(){
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setCouId(couId);
        courseInfo.setStartTime(startTime);
        courseInfo.setUserId(userId);
        if(userService.joinOutCourse(courseInfo)){
            result_joinOutCourse = "true";
        }else {
            result_joinOutCourse = "false";
        }
        session.put("result_joinOutCourse",result_joinOutCourse);
        return SUCCESS;
    }

    public String initUserIndex(){
        User user = (User) session.get("user");
        List homeworkList = userService.queryUserHomework(String.valueOf(user.getUserId()));
        List courseInfoList = userService.queryUserCourse(String.valueOf(user.getUserId()));
        session.put("user_index_homeworkList",homeworkList);
        session.put("user_index_courseList",courseInfoList);
        return SUCCESS;
    }

    public String initEditUserInfo(){
        return SUCCESS;
    }

    public String executeEditUser(){
        User user = userService.queryUserInfo(String.valueOf(userId));
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        user.setUserEmail(userEmail);
        if(userService.editUserInfo(user)){
            result_edit_user = "true";
        }else {
            result_edit_user = "false";
        }
        session.put("result_edit_user",result_edit_user);
        return SUCCESS;
    }

    public String initShowHomework(){
        WorkInfo workInfo = userService.queryUserHomeworkByUserCourseHomework(String.valueOf(workId),String.valueOf(userId));
        workInfo.setWorkStatus(1);
        userService.editUserHomework(workInfo);
        return SUCCESS;
    }
}
