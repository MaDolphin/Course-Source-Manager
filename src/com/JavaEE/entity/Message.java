package com.JavaEE.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
public class Message {
    private int mesId;
    private Integer couId;
    private Date startTime;
    private Integer fromer;
    private Integer toer;
    private String mesInfo;
    private Integer smesIf;
    private Integer mesType;
    private Integer mesStatus;
    private Timestamp createTime;
    private User userByFromer;
    private Course course;
    private User userByToer;

    @Id
    @Column(name = "mesId", nullable = false)
    public int getMesId() {
        return mesId;
    }

    public void setMesId(int mesId) {
        this.mesId = mesId;
    }

    @Basic
    @Column(name = "couId", nullable = true)
    public Integer getCouId() {
        return couId;
    }

    public void setCouId(Integer couId) {
        this.couId = couId;
    }

    @Basic
    @Column(name = "startTime", nullable = true)
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "fromer", nullable = true)
    public Integer getFromer() {
        return fromer;
    }

    public void setFromer(Integer fromer) {
        this.fromer = fromer;
    }

    @Basic
    @Column(name = "toer", nullable = true)
    public Integer getToer() {
        return toer;
    }

    public void setToer(Integer toer) {
        this.toer = toer;
    }

    @Basic
    @Column(name = "mesInfo", nullable = true, length = -1)
    public String getMesInfo() {
        return mesInfo;
    }

    public void setMesInfo(String mesInfo) {
        this.mesInfo = mesInfo;
    }

    @Basic
    @Column(name = "smesIf", nullable = true)
    public Integer getSmesIf() {
        return smesIf;
    }

    public void setSmesIf(Integer smesIf) {
        this.smesIf = smesIf;
    }

    @Basic
    @Column(name = "mesType", nullable = true)
    public Integer getMesType() {
        return mesType;
    }

    public void setMesType(Integer mesType) {
        this.mesType = mesType;
    }

    @Basic
    @Column(name = "mesStatus", nullable = true)
    public Integer getMesStatus() {
        return mesStatus;
    }

    public void setMesStatus(Integer mesStatus) {
        this.mesStatus = mesStatus;
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

        Message message = (Message) o;

        if (mesId != message.mesId) return false;
        if (couId != null ? !couId.equals(message.couId) : message.couId != null) return false;
        if (startTime != null ? !startTime.equals(message.startTime) : message.startTime != null) return false;
        if (fromer != null ? !fromer.equals(message.fromer) : message.fromer != null) return false;
        if (toer != null ? !toer.equals(message.toer) : message.toer != null) return false;
        if (mesInfo != null ? !mesInfo.equals(message.mesInfo) : message.mesInfo != null) return false;
        if (smesIf != null ? !smesIf.equals(message.smesIf) : message.smesIf != null) return false;
        if (mesType != null ? !mesType.equals(message.mesType) : message.mesType != null) return false;
        if (mesStatus != null ? !mesStatus.equals(message.mesStatus) : message.mesStatus != null) return false;
        if (createTime != null ? !createTime.equals(message.createTime) : message.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mesId;
        result = 31 * result + (couId != null ? couId.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (fromer != null ? fromer.hashCode() : 0);
        result = 31 * result + (toer != null ? toer.hashCode() : 0);
        result = 31 * result + (mesInfo != null ? mesInfo.hashCode() : 0);
        result = 31 * result + (smesIf != null ? smesIf.hashCode() : 0);
        result = 31 * result + (mesType != null ? mesType.hashCode() : 0);
        result = 31 * result + (mesStatus != null ? mesStatus.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fromer", referencedColumnName = "userId", insertable=false, updatable=false)
    public User getUserByFromer() {
        return userByFromer;
    }

    public void setUserByFromer(User userByFromer) {
        this.userByFromer = userByFromer;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "couId", referencedColumnName = "couId", insertable=false, updatable=false), @JoinColumn(name = "startTime", referencedColumnName = "startTime", insertable=false, updatable=false)})
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "toer", referencedColumnName = "userId", insertable=false, updatable=false)
    public User getUserByToer() {
        return userByToer;
    }

    public void setUserByToer(User userByToer) {
        this.userByToer = userByToer;
    }
}
