package com.jvbo.blog.model;

import java.util.Date;

public class DataDic {
    private String id;

    private String dicType;

    private String dicKey;

    private String dicVal;

    private Integer sort;

    private Date addTime;

    private String addUserId;

    private Date updTime;

    private String updUserId;

    private String delFlag;

    private String dicDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getDicKey() {
        return dicKey;
    }

    public void setDicKey(String dicKey) {
        this.dicKey = dicKey;
    }

    public String getDicVal() {
        return dicVal;
    }

    public void setDicVal(String dicVal) {
        this.dicVal = dicVal;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public String getUpdUserId() {
        return updUserId;
    }

    public void setUpdUserId(String updUserId) {
        this.updUserId = updUserId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDicDesc() {
        return dicDesc;
    }

    public void setDicDesc(String dicDesc) {
        this.dicDesc = dicDesc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dicType=").append(dicType);
        sb.append(", dicKey=").append(dicKey);
        sb.append(", dicVal=").append(dicVal);
        sb.append(", sort=").append(sort);
        sb.append(", addTime=").append(addTime);
        sb.append(", addUserId=").append(addUserId);
        sb.append(", updTime=").append(updTime);
        sb.append(", updUserId=").append(updUserId);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", dicDesc=").append(dicDesc);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DataDic other = (DataDic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDicType() == null ? other.getDicType() == null : this.getDicType().equals(other.getDicType()))
            && (this.getDicKey() == null ? other.getDicKey() == null : this.getDicKey().equals(other.getDicKey()))
            && (this.getDicVal() == null ? other.getDicVal() == null : this.getDicVal().equals(other.getDicVal()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getAddUserId() == null ? other.getAddUserId() == null : this.getAddUserId().equals(other.getAddUserId()))
            && (this.getUpdTime() == null ? other.getUpdTime() == null : this.getUpdTime().equals(other.getUpdTime()))
            && (this.getUpdUserId() == null ? other.getUpdUserId() == null : this.getUpdUserId().equals(other.getUpdUserId()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getDicDesc() == null ? other.getDicDesc() == null : this.getDicDesc().equals(other.getDicDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDicType() == null) ? 0 : getDicType().hashCode());
        result = prime * result + ((getDicKey() == null) ? 0 : getDicKey().hashCode());
        result = prime * result + ((getDicVal() == null) ? 0 : getDicVal().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getAddUserId() == null) ? 0 : getAddUserId().hashCode());
        result = prime * result + ((getUpdTime() == null) ? 0 : getUpdTime().hashCode());
        result = prime * result + ((getUpdUserId() == null) ? 0 : getUpdUserId().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getDicDesc() == null) ? 0 : getDicDesc().hashCode());
        return result;
    }
}