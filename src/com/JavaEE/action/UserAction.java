package com.JavaEE.action;

import com.JavaEE.entity.Course;
import com.JavaEE.entity.User;
import com.JavaEE.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by xfcq on 2016/5/17.
 */
public class UserAction extends ActionSupport implements SessionAware {
    private AdminService adminService;
    private int userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String userImage;
    private Integer userStatus;
    private Timestamp createTime;
    private Map session;

    public void setSession(Map session) {
        this.session = session;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String executeAllUser(){
        List<User> userList = adminService.queryAllUser();
        this.session.put("userList",userList);
        return SUCCESS;
    }

    public String executeAllUserByAuthority(){
        List<User> userList = adminService.queryAllUserByAuthority();
        this.session.put("userListByAuthority",userList);
        return SUCCESS;
    }

    public String executePassUser(){
        adminService.passUser(String.valueOf(userId));
        return SUCCESS;
    }

    public String executeCancelUser(){
        adminService.cancelUser(String.valueOf(userId));
        return SUCCESS;
    }

    public String executeResetPasswordUser(){
        adminService.resetPasswordUser(String.valueOf(userId));
        return SUCCESS;
    }

    public String initShowUser(){
        User user=adminService.queryUserById(String.valueOf(userId));
        List<Course> list = adminService.queryAllCourseByUser(String.valueOf(userId));
        session.put("show_user",user);
        session.put("show_user_list",list);
        return SUCCESS;
    }

}
