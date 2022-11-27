package com.my.store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BaseEntity implements Serializable {
    private String createdUser;
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;


    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(getCreatedUser(), that.getCreatedUser()) &&
                Objects.equals(getModifiedUser(), that.getModifiedUser()) &&
                Objects.equals(getCreatedTime(), that.getCreatedTime()) &&
                Objects.equals(getModifiedTime(), that.getModifiedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCreatedUser(), getModifiedUser(), getCreatedTime(), getModifiedTime());
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
