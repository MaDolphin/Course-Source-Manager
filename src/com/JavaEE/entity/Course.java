package com.JavaEE.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
@IdClass(CoursePK.class)
public class Course {
    private int couId;
    private Date startTime;
    private String couName;
    private String couInfo;
    private Integer couTea;
    private String couType;
    private String couImage;
    private Integer couStatus;
    private Teacher teacherByCouTea;
    private Collection<CourseInfo> courseInfos;
    private Collection<Message> messages;
    private Collection<Source> sources;
    private Collection<WorkInfo> workInfos;

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

    @Basic
    @Column(name = "couName", nullable = true, length = 50)
    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    @Basic
    @Column(name = "couInfo", nullable = true, length = -1)
    public String getCouInfo() {
        return couInfo;
    }

    public void setCouInfo(String couInfo) {
        this.couInfo = couInfo;
    }

    @Basic
    @Column(name = "couTea", nullable = true)
    public Integer getCouTea() {
        return couTea;
    }

    public void setCouTea(Integer couTea) {
        this.couTea = couTea;
    }

    @Basic
    @Column(name = "couType", nullable = true, length = 20)
    public String getCouType() {
        return couType;
    }

    public void setCouType(String couType) {
        this.couType = couType;
    }

    @Basic
    @Column(name = "couImage", nullable = true, length = 255)
    public String getCouImage() {
        return couImage;
    }

    public void setCouImage(String couImage) {
        this.couImage = couImage;
    }

    @Basic
    @Column(name = "couStatus", nullable = true)
    public Integer getCouStatus() {
        return couStatus;
    }

    public void setCouStatus(Integer couStatus) {
        this.couStatus = couStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (couId != course.couId) return false;
        if (startTime != null ? !startTime.equals(course.startTime) : course.startTime != null) return false;
        if (couName != null ? !couName.equals(course.couName) : course.couName != null) return false;
        if (couInfo != null ? !couInfo.equals(course.couInfo) : course.couInfo != null) return false;
        if (couTea != null ? !couTea.equals(course.couTea) : course.couTea != null) return false;
        if (couType != null ? !couType.equals(course.couType) : course.couType != null) return false;
        if (couImage != null ? !couImage.equals(course.couImage) : course.couImage != null) return false;
        if (couStatus != null ? !couStatus.equals(course.couStatus) : course.couStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = couId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (couName != null ? couName.hashCode() : 0);
        result = 31 * result + (couInfo != null ? couInfo.hashCode() : 0);
        result = 31 * result + (couTea != null ? couTea.hashCode() : 0);
        result = 31 * result + (couType != null ? couType.hashCode() : 0);
        result = 31 * result + (couImage != null ? couImage.hashCode() : 0);
        result = 31 * result + (couStatus != null ? couStatus.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "couTea", referencedColumnName = "teaId", insertable=false, updatable=false)
    public Teacher getTeacherByCouTea() {
        return teacherByCouTea;
    }

    public void setTeacherByCouTea(Teacher teacherByCouTea) {
        this.teacherByCouTea = teacherByCouTea;
    }

    @OneToMany(mappedBy = "course")
    public Collection<CourseInfo> getCourseInfos() {
        return courseInfos;
    }

    public void setCourseInfos(Collection<CourseInfo> courseInfos) {
        this.courseInfos = courseInfos;
    }

    @OneToMany(mappedBy = "course")
    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
    }

    @OneToMany(mappedBy = "course")
    public Collection<Source> getSources() {
        return sources;
    }

    public void setSources(Collection<Source> sources) {
        this.sources = sources;
    }

    @OneToMany(mappedBy = "course")
    public Collection<WorkInfo> getWorkInfos() {
        return workInfos;
    }

    public void setWorkInfos(Collection<WorkInfo> workInfos) {
        this.workInfos = workInfos;
    }
}
