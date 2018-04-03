/*
 * SysBlogBlogType.java 2016年11月10日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: SysBlogBlogType.java
 * @Package com.jvbo.blog.model
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
package com.jvbo.blog.model;

import java.util.Date;

/**  
 * @ClassName: SysBlogBlogType 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月10日
 */
public class SysBlogBlogType {
	
	private String id;
    private String typeId;
    private String title;
    private String summary;
    private String keyWord;
    private String content;
    private Date releaseDate;
    private String releaseDateStr;
    private Integer clickNum;
    private Integer replyNum;
    private String addUserId;
    private Date addTime;
    private Date updTime;
    private String updUserId;
    private String delFlag;
    private BlogType blogType; // 博客类型
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
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

    /**
	 * @return the blogType
	 */
	public BlogType getBlogType() {
		return blogType;
	}

	/**
	 * @param blogType the blogType to set
	 */
	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}
    
}
