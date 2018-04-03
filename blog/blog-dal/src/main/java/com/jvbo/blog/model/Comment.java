package com.jvbo.blog.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {
    private String id;

    private String userIp;

    private String blogId;

    private String content;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date commentDate;

    private Integer state;

    private String addUserId;

    private Date addTime;

    private Date updTime;

    private String updUserId;

    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userIp=").append(userIp);
        sb.append(", blogId=").append(blogId);
        sb.append(", content=").append(content);
        sb.append(", commentDate=").append(commentDate);
        sb.append(", state=").append(state);
        sb.append(", addUserId=").append(addUserId);
        sb.append(", addTime=").append(addTime);
        sb.append(", updTime=").append(updTime);
        sb.append(", updUserId=").append(updUserId);
        sb.append(", delFlag=").append(delFlag);
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
        Comment other = (Comment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserIp() == null ? other.getUserIp() == null : this.getUserIp().equals(other.getUserIp()))
            && (this.getBlogId() == null ? other.getBlogId() == null : this.getBlogId().equals(other.getBlogId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCommentDate() == null ? other.getCommentDate() == null : this.getCommentDate().equals(other.getCommentDate()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getAddUserId() == null ? other.getAddUserId() == null : this.getAddUserId().equals(other.getAddUserId()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdTime() == null ? other.getUpdTime() == null : this.getUpdTime().equals(other.getUpdTime()))
            && (this.getUpdUserId() == null ? other.getUpdUserId() == null : this.getUpdUserId().equals(other.getUpdUserId()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserIp() == null) ? 0 : getUserIp().hashCode());
        result = prime * result + ((getBlogId() == null) ? 0 : getBlogId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCommentDate() == null) ? 0 : getCommentDate().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getAddUserId() == null) ? 0 : getAddUserId().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdTime() == null) ? 0 : getUpdTime().hashCode());
        result = prime * result + ((getUpdUserId() == null) ? 0 : getUpdUserId().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }
}