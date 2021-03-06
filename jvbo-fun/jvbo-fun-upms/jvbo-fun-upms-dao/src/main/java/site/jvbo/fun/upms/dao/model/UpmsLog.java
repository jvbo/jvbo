package site.jvbo.fun.upms.dao.model;

import java.io.Serializable;

public class UpmsLog implements Serializable {
    private Long logId;

    private Integer logType;

    private String appName;

    private String methodName;

    private String methodDesc;

    private Long spendTimeMs;

    private String requestIp;

    private String requestType;

    private Long requestUser;

    private String requestUserAgent;

    private String requestBasePath;

    private String requestUri;

    private String requestUrl;

    private String requestParams;

    private String permissions;

    private Integer responseStatusCode;

    private String responseResult;

    private String exceptionMsg;

    private String exceptionDesc;

    private Long gmtCreate;

    private Long createBy;

    private Long gmtModified;

    private Long modifiedBy;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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

    public Long getSpendTimeMs() {
        return spendTimeMs;
    }

    public void setSpendTimeMs(Long spendTimeMs) {
        this.spendTimeMs = spendTimeMs;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Long getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(Long requestUser) {
        this.requestUser = requestUser;
    }

    public String getRequestUserAgent() {
        return requestUserAgent;
    }

    public void setRequestUserAgent(String requestUserAgent) {
        this.requestUserAgent = requestUserAgent;
    }

    public String getRequestBasePath() {
        return requestBasePath;
    }

    public void setRequestBasePath(String requestBasePath) {
        this.requestBasePath = requestBasePath;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(String requestParams) {
        this.requestParams = requestParams;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Integer getResponseStatusCode() {
        return responseStatusCode;
    }

    public void setResponseStatusCode(Integer responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionDesc() {
        return exceptionDesc;
    }

    public void setExceptionDesc(String exceptionDesc) {
        this.exceptionDesc = exceptionDesc;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
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
        sb.append(", logType=").append(logType);
        sb.append(", appName=").append(appName);
        sb.append(", methodName=").append(methodName);
        sb.append(", methodDesc=").append(methodDesc);
        sb.append(", spendTimeMs=").append(spendTimeMs);
        sb.append(", requestIp=").append(requestIp);
        sb.append(", requestType=").append(requestType);
        sb.append(", requestUser=").append(requestUser);
        sb.append(", requestUserAgent=").append(requestUserAgent);
        sb.append(", requestBasePath=").append(requestBasePath);
        sb.append(", requestUri=").append(requestUri);
        sb.append(", requestUrl=").append(requestUrl);
        sb.append(", requestParams=").append(requestParams);
        sb.append(", permissions=").append(permissions);
        sb.append(", responseStatusCode=").append(responseStatusCode);
        sb.append(", responseResult=").append(responseResult);
        sb.append(", exceptionMsg=").append(exceptionMsg);
        sb.append(", exceptionDesc=").append(exceptionDesc);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", createBy=").append(createBy);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifiedBy=").append(modifiedBy);
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
        UpmsLog other = (UpmsLog) that;
        return (this.getLogId() == null ? other.getLogId() == null : this.getLogId().equals(other.getLogId()))
            && (this.getLogType() == null ? other.getLogType() == null : this.getLogType().equals(other.getLogType()))
            && (this.getAppName() == null ? other.getAppName() == null : this.getAppName().equals(other.getAppName()))
            && (this.getMethodName() == null ? other.getMethodName() == null : this.getMethodName().equals(other.getMethodName()))
            && (this.getMethodDesc() == null ? other.getMethodDesc() == null : this.getMethodDesc().equals(other.getMethodDesc()))
            && (this.getSpendTimeMs() == null ? other.getSpendTimeMs() == null : this.getSpendTimeMs().equals(other.getSpendTimeMs()))
            && (this.getRequestIp() == null ? other.getRequestIp() == null : this.getRequestIp().equals(other.getRequestIp()))
            && (this.getRequestType() == null ? other.getRequestType() == null : this.getRequestType().equals(other.getRequestType()))
            && (this.getRequestUser() == null ? other.getRequestUser() == null : this.getRequestUser().equals(other.getRequestUser()))
            && (this.getRequestUserAgent() == null ? other.getRequestUserAgent() == null : this.getRequestUserAgent().equals(other.getRequestUserAgent()))
            && (this.getRequestBasePath() == null ? other.getRequestBasePath() == null : this.getRequestBasePath().equals(other.getRequestBasePath()))
            && (this.getRequestUri() == null ? other.getRequestUri() == null : this.getRequestUri().equals(other.getRequestUri()))
            && (this.getRequestUrl() == null ? other.getRequestUrl() == null : this.getRequestUrl().equals(other.getRequestUrl()))
            && (this.getRequestParams() == null ? other.getRequestParams() == null : this.getRequestParams().equals(other.getRequestParams()))
            && (this.getPermissions() == null ? other.getPermissions() == null : this.getPermissions().equals(other.getPermissions()))
            && (this.getResponseStatusCode() == null ? other.getResponseStatusCode() == null : this.getResponseStatusCode().equals(other.getResponseStatusCode()))
            && (this.getResponseResult() == null ? other.getResponseResult() == null : this.getResponseResult().equals(other.getResponseResult()))
            && (this.getExceptionMsg() == null ? other.getExceptionMsg() == null : this.getExceptionMsg().equals(other.getExceptionMsg()))
            && (this.getExceptionDesc() == null ? other.getExceptionDesc() == null : this.getExceptionDesc().equals(other.getExceptionDesc()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getModifiedBy() == null ? other.getModifiedBy() == null : this.getModifiedBy().equals(other.getModifiedBy()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogId() == null) ? 0 : getLogId().hashCode());
        result = prime * result + ((getLogType() == null) ? 0 : getLogType().hashCode());
        result = prime * result + ((getAppName() == null) ? 0 : getAppName().hashCode());
        result = prime * result + ((getMethodName() == null) ? 0 : getMethodName().hashCode());
        result = prime * result + ((getMethodDesc() == null) ? 0 : getMethodDesc().hashCode());
        result = prime * result + ((getSpendTimeMs() == null) ? 0 : getSpendTimeMs().hashCode());
        result = prime * result + ((getRequestIp() == null) ? 0 : getRequestIp().hashCode());
        result = prime * result + ((getRequestType() == null) ? 0 : getRequestType().hashCode());
        result = prime * result + ((getRequestUser() == null) ? 0 : getRequestUser().hashCode());
        result = prime * result + ((getRequestUserAgent() == null) ? 0 : getRequestUserAgent().hashCode());
        result = prime * result + ((getRequestBasePath() == null) ? 0 : getRequestBasePath().hashCode());
        result = prime * result + ((getRequestUri() == null) ? 0 : getRequestUri().hashCode());
        result = prime * result + ((getRequestUrl() == null) ? 0 : getRequestUrl().hashCode());
        result = prime * result + ((getRequestParams() == null) ? 0 : getRequestParams().hashCode());
        result = prime * result + ((getPermissions() == null) ? 0 : getPermissions().hashCode());
        result = prime * result + ((getResponseStatusCode() == null) ? 0 : getResponseStatusCode().hashCode());
        result = prime * result + ((getResponseResult() == null) ? 0 : getResponseResult().hashCode());
        result = prime * result + ((getExceptionMsg() == null) ? 0 : getExceptionMsg().hashCode());
        result = prime * result + ((getExceptionDesc() == null) ? 0 : getExceptionDesc().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifiedBy() == null) ? 0 : getModifiedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}