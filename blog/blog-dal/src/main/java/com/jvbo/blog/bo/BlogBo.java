/*
 * BlogBo.java 2016年11月11日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: BlogBo.java
 * @Package com.jvbo.blog.bo
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
package com.jvbo.blog.bo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.jvbo.blog.model.BlogType;

/**
 * @ClassName: BlogBo 
 * @Description: TODO
 * @author jvbo
 * @date 2016年11月11日
 */
public class BlogBo {
	private String id;

    private String typeId;

    private String title;

    private String summary;

    private String keyWord;

    private String content;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDate;
    
    private String releaseDateStr;

    private Integer clickNum;

    private Integer replyNum;

    private String addUserId;

    private Date addTime;

    private Date updTime;

    private String updUserId;

    private String delFlag;
    
    private String contentNoTag; // 博客内容 无网页标签 Lucene分词用
	private BlogType blogType; // 博客类型
	private Integer blogCount; // 博客数量 非博客实际属性，主要是 根据发布日期归档查询博客数量用
	private List<String> imagesList=new LinkedList<String>(); // 博客里存在的图片 主要用于列表展示显示缩略图

    /**
	 * @return the contentNoTag
	 */
	public String getContentNoTag() {
		return contentNoTag;
	}

	/**
	 * @param contentNoTag the contentNoTag to set
	 */
	public void setContentNoTag(String contentNoTag) {
		this.contentNoTag = contentNoTag;
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

	/**
	 * @return the blogCount
	 */
	public Integer getBlogCount() {
		return blogCount;
	}

	/**
	 * @param blogCount the blogCount to set
	 */
	public void setBlogCount(Integer blogCount) {
		this.blogCount = blogCount;
	}

	/**
	 * @return the imagesList
	 */
	public List<String> getImagesList() {
		return imagesList;
	}

	/**
	 * @param imagesList the imagesList to set
	 */
	public void setImagesList(List<String> imagesList) {
		this.imagesList = imagesList;
	}

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
}
