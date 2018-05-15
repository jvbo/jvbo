package com.jvbo.springcloud.eureka.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(columnDefinition="order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    
    private Integer version;
    
    @Column(columnDefinition="order_no")
    private String orderNo;
    
    @Column(columnDefinition="order_subject")
    private String orderSubject;
    
    @Column(columnDefinition="user_id")
    private Long userId;
    
    @Column(columnDefinition="order_time")
    private Long orderTime;
    
    @Column(columnDefinition="expire_time")
    private Long expireTime;
    
    @Column(columnDefinition="total_amount")
    private BigDecimal totalAmount;
    
    @Column(columnDefinition="total_strategy")
    private BigDecimal totalStrategy;
    
    @Column(columnDefinition="order_type")
    private Integer orderType;
    
    @Column(columnDefinition="pay_type")
    private Integer payType;
    
    private Integer state;
    
    private String remark;
    
    @Column(columnDefinition="gmt_created")
    private Long gmtCreated;
    
    @Column(columnDefinition="created_by")
    private String createdBy;
    
    @Column(columnDefinition="gmt_modified")
    private Long gmtModified;
    
    @Column(columnDefinition="modified_by")
    private String modifiedBy;
    
    @Column(columnDefinition="is_deleted")
    private Integer isDeleted;

    /**
     * @return the orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return the orderNo
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return the orderSubject
     */
    public String getOrderSubject() {
        return orderSubject;
    }

    /**
     * @param orderSubject the orderSubject to set
     */
    public void setOrderSubject(String orderSubject) {
        this.orderSubject = orderSubject;
    }

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
     * @return the orderTime
     */
    public Long getOrderTime() {
        return orderTime;
    }

    /**
     * @param orderTime the orderTime to set
     */
    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * @return the expireTime
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime the expireTime to set
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * @return the totalAmount
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the totalStrategy
     */
    public BigDecimal getTotalStrategy() {
        return totalStrategy;
    }

    /**
     * @param totalStrategy the totalStrategy to set
     */
    public void setTotalStrategy(BigDecimal totalStrategy) {
        this.totalStrategy = totalStrategy;
    }

    /**
     * @return the orderType
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * @param orderType the orderType to set
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the payType
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * @param payType the payType to set
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * @return the state
     */
    public Integer getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
