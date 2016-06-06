package com.JavaEE.daoimpl;

import com.JavaEE.dao.CourseInfoDao;
import com.JavaEE.entity.CourseInfo;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public class CourseInfoDaoImpl extends HibernateDaoSupport implements CourseInfoDao {
    @Override
    public boolean addCourseInfo(CourseInfo courseInfo) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        courseInfo.setJoinTime(date);
        try{
            this.getHibernateTemplate().save(courseInfo);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCourseInfo(CourseInfo courseInfo) {
        try{
            this.getHibernateTemplate().delete(courseInfo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCourseInfo(CourseInfo courseInfo) {
        try{
            this.getHibernateTemplate().saveOrUpdate(courseInfo);
            this.getHibernateTemplate().flush();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CourseInfo queryCourseInfoByID(String couid) {
        CourseInfo courseInfo = (CourseInfo) (getHibernateTemplate().get(CourseInfo.class,couid));
        return courseInfo;
    }

    @Override
    public List allCourseInfosByCourse(String couid, Date startTime) {
        List a=(List)this.getHibernateTemplate().find("select u.userId,u.userName,u.userEmail,a.joinTime from CourseInfo a left join a.userByUserId u where a.couId=? and a.startTime=?",new Object[]{Integer.valueOf(couid),startTime});
        return a;
    }

    @Override
    public List<CourseInfo> allCourseInfosByCourseForDel(String couid, Date startTime) {
        List<CourseInfo> a=(List<CourseInfo>)this.getHibernateTemplate().find("from CourseInfo a where a.couId=? and a.startTime=?",new Object[]{Integer.valueOf(couid),startTime});
        return a;
    }

    @Override
    public List CourseInfosByUser(String userid) {
        List a=(List)this.getHibernateTemplate().find("select a.couId,c.couName,a.startTime from CourseInfo a left join a.course c where a.userId=?",new Object[]{Integer.valueOf(userid)});
        return a;
    }

    @Override
    public CourseInfo queryCourseInfoByCourseUser(String couid, Date startTime, String userid) {
        List a=(List<CourseInfo>)this.getHibernateTemplate().find("from CourseInfo a where a.userId=? and a.couId=? and a.startTime=?",new Object[]{Integer.valueOf(userid),Integer.valueOf(couid),startTime});
        if(a.size() == 0){
            return null;
        }else{
            CourseInfo courseInfo = (CourseInfo) a.get(0);
            return courseInfo;
        }
    }
}
