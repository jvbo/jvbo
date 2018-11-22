package site.jvbo.fun.okex.dao.model;

import java.io.Serializable;

public class OkexChannel implements Serializable {
    private Long channelId;

    private Integer channelType;

    private String channel;

    private Integer isOnlined;

    private Long gmtCreate;

    private Long createBy;

    private Long gmtModified;

    private Long modifiedBy;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Integer getIsOnlined() {
        return isOnlined;
    }

    public void setIsOnlined(Integer isOnlined) {
        this.isOnlined = isOnlined;
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
        sb.append(", channelId=").append(channelId);
        sb.append(", channelType=").append(channelType);
        sb.append(", channel=").append(channel);
        sb.append(", isOnlined=").append(isOnlined);
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
        OkexChannel other = (OkexChannel) that;
        return (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getChannelType() == null ? other.getChannelType() == null : this.getChannelType().equals(other.getChannelType()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getIsOnlined() == null ? other.getIsOnlined() == null : this.getIsOnlined().equals(other.getIsOnlined()))
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
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getChannelType() == null) ? 0 : getChannelType().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getIsOnlined() == null) ? 0 : getIsOnlined().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifiedBy() == null) ? 0 : getModifiedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}