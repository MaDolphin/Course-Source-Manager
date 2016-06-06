package com.JavaEE.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String userImage;
    private Integer userStatus;
    private Timestamp createTime;
    private Collection<CourseInfo> courseInfosByUserId;
    private Collection<Message> messagesByUserId;
    private Collection<Message> messagesByUserId_0;
    private Collection<WorkInfo> workInfosByUserId;

    @Id
    @Column(name = "userId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName", nullable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "userPwd", nullable = true, length = 50)
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "userEmail", nullable = true, length = 50)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "userImage", nullable = true, length = 255)
    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Basic
    @Column(name = "userStatus", nullable = true)
    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
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

        User user = (User) o;

        if (userId != user.userId) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userPwd != null ? !userPwd.equals(user.userPwd) : user.userPwd != null) return false;
        if (userEmail != null ? !userEmail.equals(user.userEmail) : user.userEmail != null) return false;
        if (userImage != null ? !userImage.equals(user.userImage) : user.userImage != null) return false;
        if (userStatus != null ? !userStatus.equals(user.userStatus) : user.userStatus != null) return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPwd != null ? userPwd.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userImage != null ? userImage.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<CourseInfo> getCourseInfosByUserId() {
        return courseInfosByUserId;
    }

    public void setCourseInfosByUserId(Collection<CourseInfo> courseInfosByUserId) {
        this.courseInfosByUserId = courseInfosByUserId;
    }

    @OneToMany(mappedBy = "userByFromer")
    public Collection<Message> getMessagesByUserId() {
        return messagesByUserId;
    }

    public void setMessagesByUserId(Collection<Message> messagesByUserId) {
        this.messagesByUserId = messagesByUserId;
    }

    @OneToMany(mappedBy = "userByToer")
    public Collection<Message> getMessagesByUserId_0() {
        return messagesByUserId_0;
    }

    public void setMessagesByUserId_0(Collection<Message> messagesByUserId_0) {
        this.messagesByUserId_0 = messagesByUserId_0;
    }

    @OneToMany(mappedBy = "userByUsrId")
    public Collection<WorkInfo> getWorkInfosByUserId() {
        return workInfosByUserId;
    }

    public void setWorkInfosByUserId(Collection<WorkInfo> workInfosByUserId) {
        this.workInfosByUserId = workInfosByUserId;
    }
}
