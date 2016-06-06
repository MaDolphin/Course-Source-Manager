package com.JavaEE.dao;

import com.JavaEE.entity.Source;

import java.sql.Date;
import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public interface SourceDao {
    public boolean addSource(Source source);
    public boolean deleteSource(Source source);
    public boolean updateSource(Source source);
    public Source querySourceByID(String srcid);
    public List<Source> allSourcesByCourse(String couid, Date startTime);
    public List<Source> allSourcesByCourseNew(String couid);
}
