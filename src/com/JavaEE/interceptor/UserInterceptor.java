package com.JavaEE.interceptor;

import java.util.Map;

import com.JavaEE.entity.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserInterceptor implements Interceptor{

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
//        System.out.println("----destroy()----");
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
//        System.out.println("-----Init()-------");
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub
//        System.out.println("----intercept()------");
        Map<String, Object> session= invocation.getInvocationContext().getSession();
        if(session.get("user")!=null){
            return invocation.invoke();
        }else{
            return "login_user";
        }
    }
}