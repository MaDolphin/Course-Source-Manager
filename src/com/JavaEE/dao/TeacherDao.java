package com.JavaEE.dao;

import com.JavaEE.entity.Teacher;

import java.util.List;

/**
 * Created by xfcq on 2016/4/26.
 */
public interface TeacherDao {
    public boolean addTeacher(Teacher tea);
    public Teacher queryTeacherByID(String teaid);
    public List<Teacher> allTeachers();
    public boolean existTeacher(String id,String password);
    public boolean existTeacherInverify(String id,String password);
    public boolean existTeacherByName(String name);
    public boolean existTeacherByEmail(String email);
    public Teacher queryTeacherByEmail(String email);
    public boolean updateTeacher(Teacher teacher);
}
