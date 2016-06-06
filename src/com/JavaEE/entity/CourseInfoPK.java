package com.JavaEE.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by xfcq on 2016/5/26.
 */
public class CourseInfoPK implements Serializable {
    private int couId;
    private Date startTime;
    private int userId;

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

    @Column(name = "userId", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInfoPK that = (CourseInfoPK) o;

        if (couId != that.couId) return false;
        if (userId != that.userId) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
