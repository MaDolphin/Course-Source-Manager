package com.JavaEE.dao;

import com.JavaEE.entity.WorkInfo;

import java.sql.Date;
import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public interface WorkInfoDao {
    public boolean addWorkInfo(WorkInfo workInfo);
    public boolean deleteWorkInfo(WorkInfo workInfo);
    public boolean updateWorkInfo(WorkInfo workInfo);
    public List<WorkInfo> queryWorkInfoByUser(String couid,Date startTime,String userid);
    public List<WorkInfo> allWorkInfosByCourse(String couid, Date startTime);
    public List<WorkInfo> allWorkInfosById(String workid);
    public WorkInfo queryUserHomeworkByUserCourseHomework(String workid,String userid);
    public List allWorkInfoListByUser(String userid);
}
