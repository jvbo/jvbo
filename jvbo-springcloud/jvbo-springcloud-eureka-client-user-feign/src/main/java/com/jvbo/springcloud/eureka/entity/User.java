/*
 * User.java 2017年6月3日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: User.java
 * @Package com.jvbo.cloud.entity
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月3日
 */
package com.jvbo.springcloud.eureka.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
 * @ClassName: User 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月3日
 */
@Entity
@Table(name="t_user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6503330234998618470L;

	@Id
    @Column(columnDefinition="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
	
	private String phone;
    
    private String salt;
    
    private String password;
	
    @Column(columnDefinition="login_name")
	private String loginName;
	
    @Column(columnDefinition="nick_name")
	private String nickName;
	
    @Column(columnDefinition="created_by")
	private String createdBy;
    
    @Column(columnDefinition="gmt_created")
    private Long gmtCreated;
    
    @Column(columnDefinition="modified_by")
    private String modifiedBy;
    
    @Column(columnDefinition="gmt_modified")
    private Long gmtModified;
    
    @Column(columnDefinition="is_deleted")
    private Integer isDeleted;
    
    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the gmtCreated
     */
    public Long getGmtCreated() {
        return gmtCreated;
    }

    /**
     * @param gmtCreated the gmtCreated to set
     */
    public void setGmtCreated(Long gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the gmtModified
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified the gmtModified to set
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return the isDeleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
