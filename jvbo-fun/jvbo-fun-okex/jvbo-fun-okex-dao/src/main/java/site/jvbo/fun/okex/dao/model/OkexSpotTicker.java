package site.jvbo.fun.okex.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class OkexSpotTicker implements Serializable {
    private Long spotTickerId;

    private Long channelId;

    private BigDecimal high;

    private BigDecimal vol;

    private BigDecimal last;

    private BigDecimal low;

    private BigDecimal buy;

    private BigDecimal change;

    private BigDecimal sell;

    private BigDecimal dayLow;

    private BigDecimal close;

    private BigDecimal dayHigh;

    private BigDecimal open;

    private Long timestamp;

    private Long gmtCreate;

    private Long createBy;

    private Long gmtModified;

    private Long modifiedBy;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getSpotTickerId() {
        return spotTickerId;
    }

    public void setSpotTickerId(Long spotTickerId) {
        this.spotTickerId = spotTickerId;
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

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public BigDecimal getDayLow() {
        return dayLow;
    }

    public void setDayLow(BigDecimal dayLow) {
        this.dayLow = dayLow;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(BigDecimal dayHigh) {
        this.dayHigh = dayHigh;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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
        sb.append(", spotTickerId=").append(spotTickerId);
        sb.append(", channelId=").append(channelId);
        sb.append(", high=").append(high);
        sb.append(", vol=").append(vol);
        sb.append(", last=").append(last);
        sb.append(", low=").append(low);
        sb.append(", buy=").append(buy);
        sb.append(", change=").append(change);
        sb.append(", sell=").append(sell);
        sb.append(", dayLow=").append(dayLow);
        sb.append(", close=").append(close);
        sb.append(", dayHigh=").append(dayHigh);
        sb.append(", open=").append(open);
        sb.append(", timestamp=").append(timestamp);
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
        OkexSpotTicker other = (OkexSpotTicker) that;
        return (this.getSpotTickerId() == null ? other.getSpotTickerId() == null : this.getSpotTickerId().equals(other.getSpotTickerId()))
            && (this.getChannelId() == null ? other.getChannelId() == null : this.getChannelId().equals(other.getChannelId()))
            && (this.getHigh() == null ? other.getHigh() == null : this.getHigh().equals(other.getHigh()))
            && (this.getVol() == null ? other.getVol() == null : this.getVol().equals(other.getVol()))
            && (this.getLast() == null ? other.getLast() == null : this.getLast().equals(other.getLast()))
            && (this.getLow() == null ? other.getLow() == null : this.getLow().equals(other.getLow()))
            && (this.getBuy() == null ? other.getBuy() == null : this.getBuy().equals(other.getBuy()))
            && (this.getChange() == null ? other.getChange() == null : this.getChange().equals(other.getChange()))
            && (this.getSell() == null ? other.getSell() == null : this.getSell().equals(other.getSell()))
            && (this.getDayLow() == null ? other.getDayLow() == null : this.getDayLow().equals(other.getDayLow()))
            && (this.getClose() == null ? other.getClose() == null : this.getClose().equals(other.getClose()))
            && (this.getDayHigh() == null ? other.getDayHigh() == null : this.getDayHigh().equals(other.getDayHigh()))
            && (this.getOpen() == null ? other.getOpen() == null : this.getOpen().equals(other.getOpen()))
            && (this.getTimestamp() == null ? other.getTimestamp() == null : this.getTimestamp().equals(other.getTimestamp()))
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
        result = prime * result + ((getSpotTickerId() == null) ? 0 : getSpotTickerId().hashCode());
        result = prime * result + ((getChannelId() == null) ? 0 : getChannelId().hashCode());
        result = prime * result + ((getHigh() == null) ? 0 : getHigh().hashCode());
        result = prime * result + ((getVol() == null) ? 0 : getVol().hashCode());
        result = prime * result + ((getLast() == null) ? 0 : getLast().hashCode());
        result = prime * result + ((getLow() == null) ? 0 : getLow().hashCode());
        result = prime * result + ((getBuy() == null) ? 0 : getBuy().hashCode());
        result = prime * result + ((getChange() == null) ? 0 : getChange().hashCode());
        result = prime * result + ((getSell() == null) ? 0 : getSell().hashCode());
        result = prime * result + ((getDayLow() == null) ? 0 : getDayLow().hashCode());
        result = prime * result + ((getClose() == null) ? 0 : getClose().hashCode());
        result = prime * result + ((getDayHigh() == null) ? 0 : getDayHigh().hashCode());
        result = prime * result + ((getOpen() == null) ? 0 : getOpen().hashCode());
        result = prime * result + ((getTimestamp() == null) ? 0 : getTimestamp().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifiedBy() == null) ? 0 : getModifiedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}