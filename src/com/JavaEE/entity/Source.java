package com.JavaEE.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
public class Source {
    private int srcId;
    private Integer couId;
    private Date startTime;
    private String srcName;
    private String srcType;
    private String srcInfo;
    private String srcFormat;
    private Integer srcNo;
    private String srcUrl;
    private Integer uploader;
    private Timestamp uploadTime;
    private Course course;
    private Teacher teacherByUploader;

    @Id
    @Column(name = "srcId", nullable = false)
    public int getSrcId() {
        return srcId;
    }

    public void setSrcId(int srcId) {
        this.srcId = srcId;
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
    @Column(name = "srcName", nullable = true, length = 50)
    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    @Basic
    @Column(name = "srcType", nullable = true, length = 50)
    public String getSrcType() {
        return srcType;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    @Basic
    @Column(name = "srcInfo", nullable = true, length = -1)
    public String getSrcInfo() {
        return srcInfo;
    }

    public void setSrcInfo(String srcInfo) {
        this.srcInfo = srcInfo;
    }

    @Basic
    @Column(name = "srcFormat", nullable = true, length = 10)
    public String getSrcFormat() {
        return srcFormat;
    }

    public void setSrcFormat(String srcFormat) {
        this.srcFormat = srcFormat;
    }

    @Basic
    @Column(name = "srcNo", nullable = true)
    public Integer getSrcNo() {
        return srcNo;
    }

    public void setSrcNo(Integer srcNo) {
        this.srcNo = srcNo;
    }

    @Basic
    @Column(name = "srcUrl", nullable = true, length = 255)
    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    @Basic
    @Column(name = "uploader", nullable = true)
    public Integer getUploader() {
        return uploader;
    }

    public void setUploader(Integer uploader) {
        this.uploader = uploader;
    }

    @Basic
    @Column(name = "uploadTime", nullable = false)
    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Source source = (Source) o;

        if (srcId != source.srcId) return false;
        if (couId != null ? !couId.equals(source.couId) : source.couId != null) return false;
        if (startTime != null ? !startTime.equals(source.startTime) : source.startTime != null) return false;
        if (srcName != null ? !srcName.equals(source.srcName) : source.srcName != null) return false;
        if (srcType != null ? !srcType.equals(source.srcType) : source.srcType != null) return false;
        if (srcInfo != null ? !srcInfo.equals(source.srcInfo) : source.srcInfo != null) return false;
        if (srcFormat != null ? !srcFormat.equals(source.srcFormat) : source.srcFormat != null) return false;
        if (srcNo != null ? !srcNo.equals(source.srcNo) : source.srcNo != null) return false;
        if (srcUrl != null ? !srcUrl.equals(source.srcUrl) : source.srcUrl != null) return false;
        if (uploader != null ? !uploader.equals(source.uploader) : source.uploader != null) return false;
        if (uploadTime != null ? !uploadTime.equals(source.uploadTime) : source.uploadTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = srcId;
        result = 31 * result + (couId != null ? couId.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (srcName != null ? srcName.hashCode() : 0);
        result = 31 * result + (srcType != null ? srcType.hashCode() : 0);
        result = 31 * result + (srcInfo != null ? srcInfo.hashCode() : 0);
        result = 31 * result + (srcFormat != null ? srcFormat.hashCode() : 0);
        result = 31 * result + (srcNo != null ? srcNo.hashCode() : 0);
        result = 31 * result + (srcUrl != null ? srcUrl.hashCode() : 0);
        result = 31 * result + (uploader != null ? uploader.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "uploader", referencedColumnName = "teaId", insertable=false, updatable=false)
    public Teacher getTeacherByUploader() {
        return teacherByUploader;
    }

    public void setTeacherByUploader(Teacher teacherByUploader) {
        this.teacherByUploader = teacherByUploader;
    }
}
