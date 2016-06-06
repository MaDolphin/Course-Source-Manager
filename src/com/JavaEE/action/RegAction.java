package com.JavaEE.action;

import com.JavaEE.dao.UserDao;
import com.JavaEE.entity.User;
import com.JavaEE.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xfcq on 2016/4/26.
 */
public class RegAction extends ActionSupport implements SessionAware {
    private UserService userService;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String result;
    private Map session;

    public void setSession(Map session) {
        this.session = session;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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

    public String executeRegister(){
        User user = new User();
        user.setUserName(this.getUserName());
        user.setUserPwd(this.getUserPwd());
        user.setUserEmail(this.getUserEmail());
        if(userService.registerUser(user)){
            result = "true";
        }else {
            result = "false";
        }
        session.put("result_user_register",result);
        return SUCCESS;
    }

    public String executeEmailAvailable(){
        if(userService.emailAvailable(userEmail)){
            result = "true";
        }else {
            result = "false";
        }
        return SUCCESS;
    }

    public String executeNameAvailable(){
        if(userService.nameAvailable(userName)){
            result = "true";
        }else {
            result = "false";
        }
        return SUCCESS;
    }


}
