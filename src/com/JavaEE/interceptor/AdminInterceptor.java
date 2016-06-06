package com.JavaEE.interceptor;

import java.util.Map;

import com.JavaEE.entity.Admin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AdminInterceptor implements Interceptor{

    private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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
        if(session.get("admin")!=null){
            return invocation.invoke();
        }else{
            return "login_admin";
        }
    }
}
