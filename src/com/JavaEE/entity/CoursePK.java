package com.JavaEE.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by xfcq on 2016/5/26.
 */
public class CoursePK implements Serializable {
    private int couId;
    private Date startTime;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursePK coursePK = (CoursePK) o;

        if (couId != coursePK.couId) return false;
        if (startTime != null ? !startTime.equals(coursePK.startTime) : coursePK.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }
}
