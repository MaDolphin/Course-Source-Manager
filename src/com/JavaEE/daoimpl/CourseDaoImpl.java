package com.JavaEE.daoimpl;

import com.JavaEE.dao.CourseDao;
import com.JavaEE.entity.Course;
import com.JavaEE.entity.CoursePK;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xfcq on 2016/5/9.
 */
public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {
    @Override
    public boolean addCourse(Course course) {
        try{
            this.getHibernateTemplate().clear();
            this.getHibernateTemplate().save(course);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Course queryCourseByID(String couid, Date startTime) {
        CoursePK cou = new CoursePK();
        cou.setCouId(Integer.valueOf(couid));
        cou.setStartTime(startTime);
//        Course course = (Course) (getHibernateTemplate().get(Course.class,cou));
        List list = (List<Course>) this.getHibernateTemplate().find("from Course a where a.couId=? and a.startTime=?",new Object[]{Integer.valueOf(couid),startTime});
        Course course = (Course) list.get(0);
        return course;
    }

    @Override
    public List<Course> allCourses() {
        List a=(List<Course>)this.getHibernateTemplate().find("from Course");
        return a;
    }

    @Override
    public List<Course> allCoursesBySelect() {
        List a=(List<Course>)this.getHibernateTemplate().find("from Course c where c.couStatus=1");
        return a;
    }

    @Override
    public boolean deleteCourse(Course course) {
        try{
            this.getHibernateTemplate().delete(course);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCourse(Course course) {
        try{
            this.getHibernateTemplate().clear();
            this.getHibernateTemplate().saveOrUpdate(course);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Course> allCoursesByTeacher(String teaid) {
        List list = (List<Course>) this.getHibernateTemplate().find("from Course a where a.couTea=?",new Object[]{Integer.valueOf(teaid)});
        return list;
    }

    @Override
    public List<Course> allCourseByUser(final String userid) {
        List<Course> list = (List<Course>) this.getHibernateTemplate().find("select a.couId,a.startTime,a.couName,a.couInfo,a.couTea,a.couType,a.couImage,a.couStatus from CourseInfo b left join b.course a where b.userId=?",new Object[]{Integer.valueOf(userid)});
        return list;
    }

    @Override
    public List<Course> allCoursesByNew12() {
        List a=(List<Course>)this.getHibernateTemplate().find("from Course c where c.couStatus=1 order by startTime desc");
        int num = a.size();
        if(num>=12)
            num=12;
        a = a.subList(0,num);
        return a;
    }

    @Override
    public List<Course> allCoursesByLikeName(String couname) {
        List a=(List<Course>)this.getHibernateTemplate().find("from Course c where c.couStatus=1 and c.couName like '%"+couname+"%' group by c.couName");
        return a;
    }

    @Override
    public List<Course> allCoursesByName(String couname) {
        List a=(List<Course>)this.getHibernateTemplate().find("from Course c where c.couStatus=1 and c.couName = '"+couname+"' ");
        return a;
    }
}
