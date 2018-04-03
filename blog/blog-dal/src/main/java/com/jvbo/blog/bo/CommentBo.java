/*
 * CommentBo.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: CommentBo.java
 * @Package com.jvbo.blog.bo
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.bo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**  
 * @ClassName: CommentBo 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
public class CommentBo {
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
    
    private BlogBo blogBo; // 被评论的博客
    
    /**
	 * @return the blogBo
	 */
	public BlogBo getBlogBo() {
		return blogBo;
	}

	/**
	 * @param blogBo the blogBo to set
	 */
	public void setBlogBo(BlogBo blogBo) {
		this.blogBo = blogBo;
	}

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
}
