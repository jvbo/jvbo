package site.jvbo.fun.okex.dao.model;

import java.io.Serializable;

public class OkexSymbolPair implements Serializable {
    private Long symbolPairId;

    private String base;

    private String quote;

    private Integer isOnlined;

    private Integer isMonitored;

    private Long sort;

    private Long gmtCreate;

    private Long createBy;

    private Long gmtModified;

    private Long modifiedBy;

    private Integer isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getSymbolPairId() {
        return symbolPairId;
    }

    public void setSymbolPairId(Long symbolPairId) {
        this.symbolPairId = symbolPairId;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Integer getIsOnlined() {
        return isOnlined;
    }

    public void setIsOnlined(Integer isOnlined) {
        this.isOnlined = isOnlined;
    }

    public Integer getIsMonitored() {
        return isMonitored;
    }

    public void setIsMonitored(Integer isMonitored) {
        this.isMonitored = isMonitored;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
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
        sb.append(", symbolPairId=").append(symbolPairId);
        sb.append(", base=").append(base);
        sb.append(", quote=").append(quote);
        sb.append(", isOnlined=").append(isOnlined);
        sb.append(", isMonitored=").append(isMonitored);
        sb.append(", sort=").append(sort);
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
        OkexSymbolPair other = (OkexSymbolPair) that;
        return (this.getSymbolPairId() == null ? other.getSymbolPairId() == null : this.getSymbolPairId().equals(other.getSymbolPairId()))
            && (this.getBase() == null ? other.getBase() == null : this.getBase().equals(other.getBase()))
            && (this.getQuote() == null ? other.getQuote() == null : this.getQuote().equals(other.getQuote()))
            && (this.getIsOnlined() == null ? other.getIsOnlined() == null : this.getIsOnlined().equals(other.getIsOnlined()))
            && (this.getIsMonitored() == null ? other.getIsMonitored() == null : this.getIsMonitored().equals(other.getIsMonitored()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
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
        result = prime * result + ((getSymbolPairId() == null) ? 0 : getSymbolPairId().hashCode());
        result = prime * result + ((getBase() == null) ? 0 : getBase().hashCode());
        result = prime * result + ((getQuote() == null) ? 0 : getQuote().hashCode());
        result = prime * result + ((getIsOnlined() == null) ? 0 : getIsOnlined().hashCode());
        result = prime * result + ((getIsMonitored() == null) ? 0 : getIsMonitored().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifiedBy() == null) ? 0 : getModifiedBy().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }
}