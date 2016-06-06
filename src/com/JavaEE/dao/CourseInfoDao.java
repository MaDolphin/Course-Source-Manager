package com.JavaEE.dao;

import com.JavaEE.entity.CourseInfo;

import java.sql.Date;
import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public interface CourseInfoDao {
    public boolean addCourseInfo(CourseInfo courseInfo);
    public boolean deleteCourseInfo(CourseInfo courseInfo);
    public boolean updateCourseInfo(CourseInfo courseInfo);
    public CourseInfo queryCourseInfoByID(String couid);
    public List allCourseInfosByCourse(String couid, Date startTime);
    public List<CourseInfo> allCourseInfosByCourseForDel(String couid, Date startTime);
    public List CourseInfosByUser(String userid);
    public CourseInfo queryCourseInfoByCourseUser(String couid,Date startTime,String userid);
}
