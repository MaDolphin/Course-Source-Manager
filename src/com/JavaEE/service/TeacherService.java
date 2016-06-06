package com.JavaEE.service;

import com.JavaEE.entity.*;

import java.io.File;
import java.sql.Date;
import java.util.List;

/**
 * Created by xfcq on 2016/5/12.
 */
public interface TeacherService {
    public boolean existTeacher(String id,String password);
    public Teacher queryTeacherById(String teaid);
    public List<Course> queryAllCourseByTeacher(String teaid);
    public List<Source> queryAllSourceByCourse(String couid, Date startTime);
    public List queryAllCourseInfoByCourse(String couid, Date startTime);
    public List<WorkInfo> queryAllWorkInfoByCourse(String couid, Date startTime);
    public List<Product> queryAllProductByCourse(String couid);
    public Course queryCourseById(String couid, Date startTime);
    public boolean addSource(Source source, String savePath, File uploadFile);
    public boolean delSource(String srcid);
    public boolean openCourse(String couid, Date startTime);
    public boolean endCourse(String couid, Date startTime);
    public boolean addHomework(WorkInfo workInfo,String workText,String savePath) throws Exception;
    public boolean delHomework(String workId);
    public boolean addProduct(Product product, String savePath, File uploadFile);
    public boolean delProduct(String proId);
}
