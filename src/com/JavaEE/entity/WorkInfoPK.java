package com.JavaEE.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by xfcq on 2016/5/26.
 */
public class WorkInfoPK implements Serializable {
    private int workId;
    private int couId;
    private Date startTime;
    private int usrId;

    @Column(name = "workId", nullable = false)
    @Id
    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    @Column(name = "couId", nullable = false)
    @Id
    public int getCouId() {
        return couId;
    }

    public void setCouId(int couId) {
        this.couId = couId;
    }

    @Column(name = "startTime", nullable = false)
    @Id
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Column(name = "usrId", nullable = false)
    @Id
    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkInfoPK that = (WorkInfoPK) o;

        if (workId != that.workId) return false;
        if (couId != that.couId) return false;
        if (usrId != that.usrId) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workId;
        result = 31 * result + couId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + usrId;
        return result;
    }
}
