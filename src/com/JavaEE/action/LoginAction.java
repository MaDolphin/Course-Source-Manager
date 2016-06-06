package com.JavaEE.action;

import com.JavaEE.dao.UserDao;
import com.JavaEE.entity.User;
import com.JavaEE.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by xfcq on 2016/4/26.
 */
public class LoginAction extends ActionSupport implements SessionAware{
    private UserService userService;
    private String userEmail;
    private String password;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String executeLogin(){
        if(userService.existUser(userEmail,password)){
            User user = userService.queryUserByEmail(userEmail);
            this.session.put("user",user);
            result = "true";
        } else{
            if(userService.existUserInverify(userEmail,password)){
                result = "inverify";
            }else {
                result = "false";
            }

        }
        return SUCCESS;
    }

    public String executeLogout(){
        this.session.remove("user");
        return SUCCESS;
    }

}
