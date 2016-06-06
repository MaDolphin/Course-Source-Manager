package com.JavaEE.daoimpl;

import com.JavaEE.dao.WorkInfoDao;
import com.JavaEE.entity.WorkInfo;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.sql.Date;
import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public class WorkInfoDaoImpl extends HibernateDaoSupport implements WorkInfoDao {
    @Override
    public boolean addWorkInfo(WorkInfo workInfo) {
        try{
            this.getHibernateTemplate().save(workInfo);
            this.getHibernateTemplate().flush();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteWorkInfo(WorkInfo workInfo) {
        try{
            this.getHibernateTemplate().delete(workInfo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateWorkInfo(WorkInfo workInfo) {
        try{
            this.getHibernateTemplate().saveOrUpdate(workInfo);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<WorkInfo> queryWorkInfoByUser(String couid,Date startTime,String userid) {
        List list = (List<WorkInfo>) this.getHibernateTemplate().find("from WorkInfo a where a.couId=? and a.startTime=? and a.usrId=?",new Object[]{Integer.valueOf(couid),startTime,Integer.valueOf(userid)});
        return list;
    }

    @Override
    public List<WorkInfo> allWorkInfosByCourse(String couid, Date startTime) {
        List list = (List<WorkInfo>) this.getHibernateTemplate().find("from WorkInfo a where a.couId=? and a.startTime=? group by a.workId",new Object[]{Integer.valueOf(couid),startTime});
        return list;
    }

    @Override
    public List<WorkInfo> allWorkInfosById(String workid) {
        List list = (List<WorkInfo>) this.getHibernateTemplate().find("from WorkInfo a where a.workId=?",new Object[]{Integer.valueOf(workid)});
        return list;
    }

    @Override
    public WorkInfo queryUserHomeworkByUserCourseHomework(String workid, String userid) {
        List list = (List<WorkInfo>) this.getHibernateTemplate().find("from WorkInfo a where a.workId=? and a.usrId=?",new Object[]{Integer.valueOf(workid),Integer.valueOf(userid)});
        WorkInfo workInfo = (WorkInfo) list.get(0);
        return workInfo;
    }

    @Override
    public List allWorkInfoListByUser(String userid) {
        List list = (List<WorkInfo>) this.getHibernateTemplate().find("select a.workId,a.couId,a.startTime,a.workName,a.workUrl,a.workStatus,c.couName from WorkInfo a left join a.course c where a.usrId=? order by a.workStatus",new Object[]{Integer.valueOf(userid)});
        return list;
    }
}
