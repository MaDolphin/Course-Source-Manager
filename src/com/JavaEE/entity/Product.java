package com.JavaEE.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by xfcq on 2016/5/26.
 */
@Entity
public class Product {
    private int proId;
    private Integer couId;
    private String proName;
    private String proType;
    private String proFormat;
    private Integer proNo;
    private String proUrl;
    private Timestamp createTime;

    @Id
    @Column(name = "proId", nullable = false)
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
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
    @Column(name = "proName", nullable = true, length = 50)
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Basic
    @Column(name = "proType", nullable = true, length = 50)
    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    @Basic
    @Column(name = "proFormat", nullable = true, length = 10)
    public String getProFormat() {
        return proFormat;
    }

    public void setProFormat(String proFormat) {
        this.proFormat = proFormat;
    }

    @Basic
    @Column(name = "proNo", nullable = true)
    public Integer getProNo() {
        return proNo;
    }

    public void setProNo(Integer proNo) {
        this.proNo = proNo;
    }

    @Basic
    @Column(name = "proUrl", nullable = true, length = 255)
    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
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

        Product product = (Product) o;

        if (proId != product.proId) return false;
        if (couId != null ? !couId.equals(product.couId) : product.couId != null) return false;
        if (proName != null ? !proName.equals(product.proName) : product.proName != null) return false;
        if (proType != null ? !proType.equals(product.proType) : product.proType != null) return false;
        if (proFormat != null ? !proFormat.equals(product.proFormat) : product.proFormat != null) return false;
        if (proNo != null ? !proNo.equals(product.proNo) : product.proNo != null) return false;
        if (proUrl != null ? !proUrl.equals(product.proUrl) : product.proUrl != null) return false;
        if (createTime != null ? !createTime.equals(product.createTime) : product.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proId;
        result = 31 * result + (couId != null ? couId.hashCode() : 0);
        result = 31 * result + (proName != null ? proName.hashCode() : 0);
        result = 31 * result + (proType != null ? proType.hashCode() : 0);
        result = 31 * result + (proFormat != null ? proFormat.hashCode() : 0);
        result = 31 * result + (proNo != null ? proNo.hashCode() : 0);
        result = 31 * result + (proUrl != null ? proUrl.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
