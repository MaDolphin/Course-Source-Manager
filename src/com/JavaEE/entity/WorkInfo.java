package com.JavaEE.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
@IdClass(WorkInfoPK.class)
public class WorkInfo {
    private int workId;
    private int couId;
    private Date startTime;
    private int usrId;
    private String workName;
    private String workUrl;
    private Integer workStatus;
    private Timestamp createTime;
    private Course course;
    private User userByUsrId;

    @Id
    @Column(name = "workId", nullable = false)
    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    @Id
    @Column(name = "couId", nullable = false)
    public int getCouId() {
        return couId;
    }

    public void setCouId(int couId) {
        this.couId = couId;
    }

    @Id
    @Column(name = "startTime", nullable = false)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Id
    @Column(name = "usrId", nullable = false)
    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Basic
    @Column(name = "workName", nullable = true, length = 50)
    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    @Basic
    @Column(name = "workUrl", nullable = true, length = 255)
    public String getWorkUrl() {
        return workUrl;
    }

    public void setWorkUrl(String workUrl) {
        this.workUrl = workUrl;
    }

    @Basic
    @Column(name = "workStatus", nullable = true)
    public Integer getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Integer workStatus) {
        this.workStatus = workStatus;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkInfo workInfo = (WorkInfo) o;

        if (workId != workInfo.workId) return false;
        if (couId != workInfo.couId) return false;
        if (usrId != workInfo.usrId) return false;
        if (startTime != null ? !startTime.equals(workInfo.startTime) : workInfo.startTime != null) return false;
        if (workName != null ? !workName.equals(workInfo.workName) : workInfo.workName != null) return false;
        if (workUrl != null ? !workUrl.equals(workInfo.workUrl) : workInfo.workUrl != null) return false;
        if (workStatus != null ? !workStatus.equals(workInfo.workStatus) : workInfo.workStatus != null) return false;
        if (createTime != null ? !createTime.equals(workInfo.createTime) : workInfo.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workId;
        result = 31 * result + couId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + usrId;
        result = 31 * result + (workName != null ? workName.hashCode() : 0);
        result = 31 * result + (workUrl != null ? workUrl.hashCode() : 0);
        result = 31 * result + (workStatus != null ? workStatus.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "couId", referencedColumnName = "couId", nullable = false, insertable=false, updatable=false), @JoinColumn(name = "startTime", referencedColumnName = "startTime", nullable = false, insertable=false, updatable=false)})
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "usrId", referencedColumnName = "userId", nullable = false, insertable=false, updatable=false)
    public User getUserByUsrId() {
        return userByUsrId;
    }

    public void setUserByUsrId(User userByUsrId) {
        this.userByUsrId = userByUsrId;
    }
}
