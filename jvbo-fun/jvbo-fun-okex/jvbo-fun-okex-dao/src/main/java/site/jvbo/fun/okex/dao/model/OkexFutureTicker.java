package site.jvbo.fun.okex.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OkexFutureTicker implements Serializable {
    private Long futureTickerId;

    private Long channelId;

    private BigDecimal high;

    private BigDecimal limitLow;

    private BigDecimal vol;

    private BigDecimal last;

    private BigDecimal low;

    private BigDecimal buy;

    private BigDecimal holdAmount;

    private BigDecimal sell;

    private Long contractId;

    private BigDecimal unitAmount;

    private BigDecimal limitHigh;

    private Long gmtCreate;

    private Long timestamp;

    private Long createBy;

    private Long gmtModified;

    private Long modifiedBy;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getFutureTickerId() {
        return futureTickerId;
    }

    public void setFutureTickerId(Long futureTickerId) {
        this.futureTickerId = futureTickerId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLimitLow() {
        return limitLow;
    }

    public void setLimitLow(BigDecimal limitLow) {
        this.limitLow = limitLow;
    }

    public BigDecimal getVol() {
        return vol;
    }

    public void setVol(BigDecimal vol) {
        this.vol = vol;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getHoldAmount() {
        return holdAmount;
    }

    public void setHoldAmount(BigDecimal holdAmount) {
        this.holdAmount = holdAmount;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(BigDecimal unitAmount) {
        this.unitAmount = unitAmount;
    }

    public BigDecimal getLimitHigh() {
        return limitHigh;
    }

    public void setLimitHigh(BigDecimal limitHigh) {
        this.limitHigh = limitHigh;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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
        sb.append(", futureTickerId=").append(futureTickerId);
        sb.append(", channelId=").append(channelId);
        sb.append(", high=").append(high);
        sb.append(", limitLow=").append(limitLow);
        sb.append(", vol=").append(vol);
        sb.append(", last=").append(last);
        sb.append(", low=").append(low);
        sb.append(", buy=").append(buy);
        sb.append(", holdAmount=").append(holdAmount);
        sb.append(", sell=").append(sell);
        sb.append(", contractId=").append(contractId);
        sb.append(", unitAmount=").append(unitAmount);
        sb.append(", limitHigh=").append(limitHigh);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", timestamp=").append(timestamp);
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
        OkexFutureTicker other = (OkexFutureTicker) that;
        return (this.getFutureTickerId() == null ? other.getFutureTickerId() == null : this.getFutureTickerId().equals(other.getFutureTickerId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getHigh() == null ? other.getHigh() == null : this.getHigh().equals(other.getHigh()))
            && (this.getLimitLow() == null ? other.getLimitLow() == null : this.getLimitLow().equals(other.getLimitLow()))
            && (this.getVol() == null ? other.getVol() == null : this.getVol().equals(other.getVol()))
            && (this.getLast() == null ? other.getLast() == null : this.getLast().equals(other.getLast()))
            && (this.getLow() == null ? other.getLow() == null : this.getLow().equals(other.getLow()))
            && (this.getBuy() == null ? other.getBuy() == null : this.getBuy().equals(other.getBuy()))
            && (this.getHoldAmount() == null ? other.getHoldAmount() == null : this.getHoldAmount().equals(other.getHoldAmount()))
            && (this.getSell() == null ? other.getSell() == null : this.getSell().equals(other.getSell()))
            && (this.getContractId() == null ? other.getContractId() == null : this.getContractId().equals(other.getContractId()))
            && (this.getUnitAmount() == null ? other.getUnitAmount() == null : this.getUnitAmount().equals(other.getUnitAmount()))
            && (this.getLimitHigh() == null ? other.getLimitHigh() == null : this.getLimitHigh().equals(other.getLimitHigh()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getModifiedBy() == null ? other.getModifiedBy() == null : this.getModifiedBy().equals(other.getModifiedBy()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFutureTickerId() == null) ? 0 : getFutureTickerId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getHigh() == null) ? 0 : getHigh().hashCode());
        result = prime * result + ((getLimitLow() == null) ? 0 : getLimitLow().hashCode());
        result = prime * result + ((getVol() == null) ? 0 : getVol().hashCode());
        result = prime * result + ((getLast() == null) ? 0 : getLast().hashCode());
        result = prime * result + ((getLow() == null) ? 0 : getLow().hashCode());
        result = prime * result + ((getBuy() == null) ? 0 : getBuy().hashCode());
        result = prime * result + ((getHoldAmount() == null) ? 0 : getHoldAmount().hashCode());
        result = prime * result + ((getSell() == null) ? 0 : getSell().hashCode());
        result = prime * result + ((getContractId() == null) ? 0 : getContractId().hashCode());
        result = prime * result + ((getUnitAmount() == null) ? 0 : getUnitAmount().hashCode());
        result = prime * result + ((getLimitHigh() == null) ? 0 : getLimitHigh().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifiedBy() == null) ? 0 : getModifiedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}