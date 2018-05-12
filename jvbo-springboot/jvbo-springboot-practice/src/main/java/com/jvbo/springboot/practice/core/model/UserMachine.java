package com.jvbo.springboot.practice.core.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserMachine implements Serializable {
    private Long user_machine_id;

    private Long user_id;

    private Long machine_id;

    private String machine_from;

    private String state;

    private Long expire_time;

    private String machine_name;

    private String machine_type;

    private BigDecimal unit_price;

    private BigDecimal per_amount;

    private BigDecimal total_amount;

    private Integer cycle_of_operation;

    private Integer generate_of_time;

    private BigDecimal generate_of_amount;

    private Integer limit_count;

    private Integer sort;

    private String created_by;

    private Long gmt_created;

    private String modified_by;

    private Long gmt_modified;

    private Integer is_deleted;

    private static final long serialVersionUID = 1L;

    public Long getUser_machine_id() {
        return user_machine_id;
    }

    public void setUser_machine_id(Long user_machine_id) {
        this.user_machine_id = user_machine_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(Long machine_id) {
        this.machine_id = machine_id;
    }

    public String getMachine_from() {
        return machine_from;
    }

    public void setMachine_from(String machine_from) {
        this.machine_from = machine_from;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(Long expire_time) {
        this.expire_time = expire_time;
    }

    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
    }

    public String getMachine_type() {
        return machine_type;
    }

    public void setMachine_type(String machine_type) {
        this.machine_type = machine_type;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public BigDecimal getPer_amount() {
        return per_amount;
    }

    public void setPer_amount(BigDecimal per_amount) {
        this.per_amount = per_amount;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public Integer getCycle_of_operation() {
        return cycle_of_operation;
    }

    public void setCycle_of_operation(Integer cycle_of_operation) {
        this.cycle_of_operation = cycle_of_operation;
    }

    public Integer getGenerate_of_time() {
        return generate_of_time;
    }

    public void setGenerate_of_time(Integer generate_of_time) {
        this.generate_of_time = generate_of_time;
    }

    public BigDecimal getGenerate_of_amount() {
        return generate_of_amount;
    }

    public void setGenerate_of_amount(BigDecimal generate_of_amount) {
        this.generate_of_amount = generate_of_amount;
    }

    public Integer getLimit_count() {
        return limit_count;
    }

    public void setLimit_count(Integer limit_count) {
        this.limit_count = limit_count;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Long getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Long gmt_created) {
        this.gmt_created = gmt_created;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public Long getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public Integer getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Integer is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", user_machine_id=").append(user_machine_id);
        sb.append(", user_id=").append(user_id);
        sb.append(", machine_id=").append(machine_id);
        sb.append(", machine_from=").append(machine_from);
        sb.append(", state=").append(state);
        sb.append(", expire_time=").append(expire_time);
        sb.append(", machine_name=").append(machine_name);
        sb.append(", machine_type=").append(machine_type);
        sb.append(", unit_price=").append(unit_price);
        sb.append(", per_amount=").append(per_amount);
        sb.append(", total_amount=").append(total_amount);
        sb.append(", cycle_of_operation=").append(cycle_of_operation);
        sb.append(", generate_of_time=").append(generate_of_time);
        sb.append(", generate_of_amount=").append(generate_of_amount);
        sb.append(", limit_count=").append(limit_count);
        sb.append(", sort=").append(sort);
        sb.append(", created_by=").append(created_by);
        sb.append(", gmt_created=").append(gmt_created);
        sb.append(", modified_by=").append(modified_by);
        sb.append(", gmt_modified=").append(gmt_modified);
        sb.append(", is_deleted=").append(is_deleted);
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
        UserMachine other = (UserMachine) that;
        return (this.getUser_machine_id() == null ? other.getUser_machine_id() == null : this.getUser_machine_id().equals(other.getUser_machine_id()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getMachine_id() == null ? other.getMachine_id() == null : this.getMachine_id().equals(other.getMachine_id()))
            && (this.getMachine_from() == null ? other.getMachine_from() == null : this.getMachine_from().equals(other.getMachine_from()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getExpire_time() == null ? other.getExpire_time() == null : this.getExpire_time().equals(other.getExpire_time()))
            && (this.getMachine_name() == null ? other.getMachine_name() == null : this.getMachine_name().equals(other.getMachine_name()))
            && (this.getMachine_type() == null ? other.getMachine_type() == null : this.getMachine_type().equals(other.getMachine_type()))
            && (this.getUnit_price() == null ? other.getUnit_price() == null : this.getUnit_price().equals(other.getUnit_price()))
            && (this.getPer_amount() == null ? other.getPer_amount() == null : this.getPer_amount().equals(other.getPer_amount()))
            && (this.getTotal_amount() == null ? other.getTotal_amount() == null : this.getTotal_amount().equals(other.getTotal_amount()))
            && (this.getCycle_of_operation() == null ? other.getCycle_of_operation() == null : this.getCycle_of_operation().equals(other.getCycle_of_operation()))
            && (this.getGenerate_of_time() == null ? other.getGenerate_of_time() == null : this.getGenerate_of_time().equals(other.getGenerate_of_time()))
            && (this.getGenerate_of_amount() == null ? other.getGenerate_of_amount() == null : this.getGenerate_of_amount().equals(other.getGenerate_of_amount()))
            && (this.getLimit_count() == null ? other.getLimit_count() == null : this.getLimit_count().equals(other.getLimit_count()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getCreated_by() == null ? other.getCreated_by() == null : this.getCreated_by().equals(other.getCreated_by()))
            && (this.getGmt_created() == null ? other.getGmt_created() == null : this.getGmt_created().equals(other.getGmt_created()))
            && (this.getModified_by() == null ? other.getModified_by() == null : this.getModified_by().equals(other.getModified_by()))
            && (this.getGmt_modified() == null ? other.getGmt_modified() == null : this.getGmt_modified().equals(other.getGmt_modified()))
            && (this.getIs_deleted() == null ? other.getIs_deleted() == null : this.getIs_deleted().equals(other.getIs_deleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUser_machine_id() == null) ? 0 : getUser_machine_id().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getMachine_id() == null) ? 0 : getMachine_id().hashCode());
        result = prime * result + ((getMachine_from() == null) ? 0 : getMachine_from().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getExpire_time() == null) ? 0 : getExpire_time().hashCode());
        result = prime * result + ((getMachine_name() == null) ? 0 : getMachine_name().hashCode());
        result = prime * result + ((getMachine_type() == null) ? 0 : getMachine_type().hashCode());
        result = prime * result + ((getUnit_price() == null) ? 0 : getUnit_price().hashCode());
        result = prime * result + ((getPer_amount() == null) ? 0 : getPer_amount().hashCode());
        result = prime * result + ((getTotal_amount() == null) ? 0 : getTotal_amount().hashCode());
        result = prime * result + ((getCycle_of_operation() == null) ? 0 : getCycle_of_operation().hashCode());
        result = prime * result + ((getGenerate_of_time() == null) ? 0 : getGenerate_of_time().hashCode());
        result = prime * result + ((getGenerate_of_amount() == null) ? 0 : getGenerate_of_amount().hashCode());
        result = prime * result + ((getLimit_count() == null) ? 0 : getLimit_count().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCreated_by() == null) ? 0 : getCreated_by().hashCode());
        result = prime * result + ((getGmt_created() == null) ? 0 : getGmt_created().hashCode());
        result = prime * result + ((getModified_by() == null) ? 0 : getModified_by().hashCode());
        result = prime * result + ((getGmt_modified() == null) ? 0 : getGmt_modified().hashCode());
        result = prime * result + ((getIs_deleted() == null) ? 0 : getIs_deleted().hashCode());
        return result;
    }
}