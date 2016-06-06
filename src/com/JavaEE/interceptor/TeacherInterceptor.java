package com.JavaEE.interceptor;

import java.util.Map;

import com.JavaEE.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TeacherInterceptor implements Interceptor{

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
        if(session.get("teacher")!=null){
            return invocation.invoke();
        }else{
            return "login_teacher";
        }
    }
}