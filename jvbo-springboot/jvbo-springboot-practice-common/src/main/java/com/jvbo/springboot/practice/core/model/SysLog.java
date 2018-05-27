package com.jvbo.springboot.practice.core.model;

import java.io.Serializable;

public class SysLog implements Serializable {
    private String logId;

    private String appName;

    private Integer logType;

    private String methodName;

    private String methodDesc;

    private String requestUser;

    private String requestIp;

    private String requestUri;

    private String requestPath;

    private String requestParams;

    private String exceptionCode;

    private String exceptionDesc;

    private String responseStatus;

    private String responseCode;

    private String responseMsg;

    private String responseData;

    private String createdBy;

    private Long gmtCreated;

    private String modifiedBy;

    private Long gmtModified;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }

    public String getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(String requestUser) {
        this.requestUser = requestUser;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDesc() {
        return exceptionDesc;
    }

    public void setExceptionDesc(String exceptionDesc) {
        this.exceptionDesc = exceptionDesc;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Long gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logId=").append(logId);
        sb.append(", appName=").append(appName);
        sb.append(", logType=").append(logType);
        sb.append(", methodName=").append(methodName);
        sb.append(", methodDesc=").append(methodDesc);
        sb.append(", requestUser=").append(requestUser);
        sb.append(", requestIp=").append(requestIp);
        sb.append(", requestUri=").append(requestUri);
        sb.append(", requestPath=").append(requestPath);
        sb.append(", requestParams=").append(requestParams);
        sb.append(", exceptionCode=").append(exceptionCode);
        sb.append(", exceptionDesc=").append(exceptionDesc);
        sb.append(", responseStatus=").append(responseStatus);
        sb.append(", responseCode=").append(responseCode);
        sb.append(", responseMsg=").append(responseMsg);
        sb.append(", responseData=").append(responseData);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", modifiedBy=").append(modifiedBy);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", isDeleted=").append(isDeleted);
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
        SysLog other = (SysLog) that;
        return (this.getLogId() == null ? other.getLogId() == null : this.getLogId().equals(other.getLogId()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getLogType() == null ? other.getLogType() == null : this.getLogType().equals(other.getLogType()))
            && (this.getMethodName() == null ? other.getMethodName() == null : this.getMethodName().equals(other.getMethodName()))
            && (this.getMethodDesc() == null ? other.getMethodDesc() == null : this.getMethodDesc().equals(other.getMethodDesc()))
            && (this.getRequestUser() == null ? other.getRequestUser() == null : this.getRequestUser().equals(other.getRequestUser()))
            && (this.getRequestIp() == null ? other.getRequestIp() == null : this.getRequestIp().equals(other.getRequestIp()))
            && (this.getRequestUri() == null ? other.getRequestUri() == null : this.getRequestUri().equals(other.getRequestUri()))
            && (this.getRequestPath() == null ? other.getRequestPath() == null : this.getRequestPath().equals(other.getRequestPath()))
            && (this.getRequestParams() == null ? other.getRequestParams() == null : this.getRequestParams().equals(other.getRequestParams()))
            && (this.getExceptionCode() == null ? other.getExceptionCode() == null : this.getExceptionCode().equals(other.getExceptionCode()))
            && (this.getExceptionDesc() == null ? other.getExceptionDesc() == null : this.getExceptionDesc().equals(other.getExceptionDesc()))
            && (this.getResponseStatus() == null ? other.getResponseStatus() == null : this.getResponseStatus().equals(other.getResponseStatus()))
            && (this.getResponseCode() == null ? other.getResponseCode() == null : this.getResponseCode().equals(other.getResponseCode()))
            && (this.getResponseMsg() == null ? other.getResponseMsg() == null : this.getResponseMsg().equals(other.getResponseMsg()))
            && (this.getResponseData() == null ? other.getResponseData() == null : this.getResponseData().equals(other.getResponseData()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getModifiedBy() == null ? other.getModifiedBy() == null : this.getModifiedBy().equals(other.getModifiedBy()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogId() == null) ? 0 : getLogId().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getLogType() == null) ? 0 : getLogType().hashCode());
        result = prime * result + ((getMethodName() == null) ? 0 : getMethodName().hashCode());
        result = prime * result + ((getMethodDesc() == null) ? 0 : getMethodDesc().hashCode());
        result = prime * result + ((getRequestUser() == null) ? 0 : getRequestUser().hashCode());
        result = prime * result + ((getRequestIp() == null) ? 0 : getRequestIp().hashCode());
        result = prime * result + ((getRequestUri() == null) ? 0 : getRequestUri().hashCode());
        result = prime * result + ((getRequestPath() == null) ? 0 : getRequestPath().hashCode());
        result = prime * result + ((getRequestParams() == null) ? 0 : getRequestParams().hashCode());
        result = prime * result + ((getExceptionCode() == null) ? 0 : getExceptionCode().hashCode());
        result = prime * result + ((getExceptionDesc() == null) ? 0 : getExceptionDesc().hashCode());
        result = prime * result + ((getResponseStatus() == null) ? 0 : getResponseStatus().hashCode());
        result = prime * result + ((getResponseCode() == null) ? 0 : getResponseCode().hashCode());
        result = prime * result + ((getResponseMsg() == null) ? 0 : getResponseMsg().hashCode());
        result = prime * result + ((getResponseData() == null) ? 0 : getResponseData().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getModifiedBy() == null) ? 0 : getModifiedBy().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}