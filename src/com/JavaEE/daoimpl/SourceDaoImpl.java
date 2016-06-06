package com.JavaEE.daoimpl;

import com.JavaEE.dao.SourceDao;
import com.JavaEE.entity.Source;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public class SourceDaoImpl extends HibernateDaoSupport implements SourceDao {
    @Override
    public boolean addSource(Source source) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        source.setUploadTime(date);
        try{
            this.getHibernateTemplate().save(source);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteSource(Source source) {
        try{
            this.getHibernateTemplate().delete(source);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSource(Source source) {
        try{
            this.getHibernateTemplate().saveOrUpdate(source);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Source querySourceByID(String srcid) {
        Source source = (Source) (getHibernateTemplate().get(Source.class,Integer.valueOf(srcid)));
        return source;
    }

    @Override
    public List<Source> allSourcesByCourse(String couid, Date startTime) {
        List list = (List<Source>) this.getHibernateTemplate().find("from Source a where a.couId=? and a.startTime=? order by a.srcType,a.srcNo asc ",new Object[]{Integer.valueOf(couid),startTime});
        return list;
    }

    @Override
    public List<Source> allSourcesByCourseNew(String couid) {
        List list = (List<Source>) this.getHibernateTemplate().find("select srcId,couId,MAX (startTime),srcName,srcType,srcInfo,srcFormat,srcNo,srcUrl,uploader,uploadTime from Source a where a.couId=? group by a.startTime",new Object[]{Integer.valueOf(couid)});
        return list;
    }
}
