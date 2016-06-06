package com.JavaEE.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
public class Admin {
    private int adminId;
    private String adminName;
    private String adminPwd;

    @Id
    @Column(name = "adminId", nullable = false)
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "adminName", nullable = true, length = 50)
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "adminPwd", nullable = true, length = 50)
    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (adminId != admin.adminId) return false;
        if (adminName != null ? !adminName.equals(admin.adminName) : admin.adminName != null) return false;
        if (adminPwd != null ? !adminPwd.equals(admin.adminPwd) : admin.adminPwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId;
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        result = 31 * result + (adminPwd != null ? adminPwd.hashCode() : 0);
        return result;
    }
}
