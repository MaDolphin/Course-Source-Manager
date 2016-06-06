package com.JavaEE.dao;

import com.JavaEE.entity.Course;

import java.sql.Date;
import java.util.List;

/**
 * Created by xfcq on 2016/5/9.
 */
public interface CourseDao {
    public boolean addCourse(Course course);
    public boolean deleteCourse(Course course);
    public boolean updateCourse(Course course);
    public Course queryCourseByID(String couid, Date startTime);
    public List<Course> allCourses();
    public List<Course> allCoursesBySelect();
    public List<Course> allCoursesByNew12();
    public List<Course> allCoursesByLikeName(String couname);
    public List<Course> allCoursesByName(String couname);
    public List<Course> allCoursesByTeacher(String teaid);
    public List<Course> allCourseByUser(String userid);
}
