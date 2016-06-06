package com.JavaEE.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
@IdClass(CourseInfoPK.class)
public class CourseInfo {
    private int couId;
    private Date startTime;
    private int userId;
    private Timestamp joinTime;
    private Course course;
    private User userByUserId;

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
    @Column(name = "userId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "joinTime", nullable = false)
    public Timestamp getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInfo that = (CourseInfo) o;

        if (couId != that.couId) return false;
        if (userId != that.userId) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (joinTime != null ? !joinTime.equals(that.joinTime) : that.joinTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (joinTime != null ? joinTime.hashCode() : 0);
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
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false, insertable=false, updatable=false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
