package com.JavaEE.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
public class Teacher {
    private int teaId;
    private String teaName;
    private String teaPwd;
    private String teaEmail;
    private Integer teaStatus;
    private Collection<Course> coursesByTeaId;
    private Collection<Source> sourcesByTeaId;

    @Id
    @Column(name = "teaId", nullable = false)
    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    @Basic
    @Column(name = "teaName", nullable = true, length = 50)
    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    @Basic
    @Column(name = "teaPwd", nullable = true, length = 50)
    public String getTeaPwd() {
        return teaPwd;
    }

    public void setTeaPwd(String teaPwd) {
        this.teaPwd = teaPwd;
    }

    @Basic
    @Column(name = "teaEmail", nullable = true, length = 50)
    public String getTeaEmail() {
        return teaEmail;
    }

    public void setTeaEmail(String teaEmail) {
        this.teaEmail = teaEmail;
    }

    @Basic
    @Column(name = "teaStatus", nullable = true)
    public Integer getTeaStatus() {
        return teaStatus;
    }

    public void setTeaStatus(Integer teaStatus) {
        this.teaStatus = teaStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (teaId != teacher.teaId) return false;
        if (teaName != null ? !teaName.equals(teacher.teaName) : teacher.teaName != null) return false;
        if (teaPwd != null ? !teaPwd.equals(teacher.teaPwd) : teacher.teaPwd != null) return false;
        if (teaEmail != null ? !teaEmail.equals(teacher.teaEmail) : teacher.teaEmail != null) return false;
        if (teaStatus != null ? !teaStatus.equals(teacher.teaStatus) : teacher.teaStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teaId;
        result = 31 * result + (teaName != null ? teaName.hashCode() : 0);
        result = 31 * result + (teaPwd != null ? teaPwd.hashCode() : 0);
        result = 31 * result + (teaEmail != null ? teaEmail.hashCode() : 0);
        result = 31 * result + (teaStatus != null ? teaStatus.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "teacherByCouTea")
    public Collection<Course> getCoursesByTeaId() {
        return coursesByTeaId;
    }

    public void setCoursesByTeaId(Collection<Course> coursesByTeaId) {
        this.coursesByTeaId = coursesByTeaId;
    }

    @OneToMany(mappedBy = "teacherByUploader")
    public Collection<Source> getSourcesByTeaId() {
        return sourcesByTeaId;
    }

    public void setSourcesByTeaId(Collection<Source> sourcesByTeaId) {
        this.sourcesByTeaId = sourcesByTeaId;
    }
}
