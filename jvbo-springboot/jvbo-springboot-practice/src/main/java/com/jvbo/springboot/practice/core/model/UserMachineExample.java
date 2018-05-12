package com.jvbo.springboot.practice.core.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserMachineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserMachineExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUser_machine_idIsNull() {
            addCriterion("user_machine_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idIsNotNull() {
            addCriterion("user_machine_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idEqualTo(Long value) {
            addCriterion("user_machine_id =", value, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idNotEqualTo(Long value) {
            addCriterion("user_machine_id <>", value, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idGreaterThan(Long value) {
            addCriterion("user_machine_id >", value, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idGreaterThanOrEqualTo(Long value) {
            addCriterion("user_machine_id >=", value, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idLessThan(Long value) {
            addCriterion("user_machine_id <", value, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idLessThanOrEqualTo(Long value) {
            addCriterion("user_machine_id <=", value, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idIn(List<Long> values) {
            addCriterion("user_machine_id in", values, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idNotIn(List<Long> values) {
            addCriterion("user_machine_id not in", values, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idBetween(Long value1, Long value2) {
            addCriterion("user_machine_id between", value1, value2, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_machine_idNotBetween(Long value1, Long value2) {
            addCriterion("user_machine_id not between", value1, value2, "user_machine_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(Long value) {
            addCriterion("user_id =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(Long value) {
            addCriterion("user_id >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(Long value) {
            addCriterion("user_id <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<Long> values) {
            addCriterion("user_id in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idIsNull() {
            addCriterion("machine_id is null");
            return (Criteria) this;
        }

        public Criteria andMachine_idIsNotNull() {
            addCriterion("machine_id is not null");
            return (Criteria) this;
        }

        public Criteria andMachine_idEqualTo(Long value) {
            addCriterion("machine_id =", value, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idNotEqualTo(Long value) {
            addCriterion("machine_id <>", value, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idGreaterThan(Long value) {
            addCriterion("machine_id >", value, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idGreaterThanOrEqualTo(Long value) {
            addCriterion("machine_id >=", value, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idLessThan(Long value) {
            addCriterion("machine_id <", value, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idLessThanOrEqualTo(Long value) {
            addCriterion("machine_id <=", value, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idIn(List<Long> values) {
            addCriterion("machine_id in", values, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idNotIn(List<Long> values) {
            addCriterion("machine_id not in", values, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idBetween(Long value1, Long value2) {
            addCriterion("machine_id between", value1, value2, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_idNotBetween(Long value1, Long value2) {
            addCriterion("machine_id not between", value1, value2, "machine_id");
            return (Criteria) this;
        }

        public Criteria andMachine_fromIsNull() {
            addCriterion("machine_from is null");
            return (Criteria) this;
        }

        public Criteria andMachine_fromIsNotNull() {
            addCriterion("machine_from is not null");
            return (Criteria) this;
        }

        public Criteria andMachine_fromEqualTo(String value) {
            addCriterion("machine_from =", value, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromNotEqualTo(String value) {
            addCriterion("machine_from <>", value, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromGreaterThan(String value) {
            addCriterion("machine_from >", value, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromGreaterThanOrEqualTo(String value) {
            addCriterion("machine_from >=", value, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromLessThan(String value) {
            addCriterion("machine_from <", value, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromLessThanOrEqualTo(String value) {
            addCriterion("machine_from <=", value, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromLike(String value) {
            addCriterion("machine_from like", value, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromNotLike(String value) {
            addCriterion("machine_from not like", value, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromIn(List<String> values) {
            addCriterion("machine_from in", values, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromNotIn(List<String> values) {
            addCriterion("machine_from not in", values, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromBetween(String value1, String value2) {
            addCriterion("machine_from between", value1, value2, "machine_from");
            return (Criteria) this;
        }

        public Criteria andMachine_fromNotBetween(String value1, String value2) {
            addCriterion("machine_from not between", value1, value2, "machine_from");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andExpire_timeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpire_timeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpire_timeEqualTo(Long value) {
            addCriterion("expire_time =", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeNotEqualTo(Long value) {
            addCriterion("expire_time <>", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeGreaterThan(Long value) {
            addCriterion("expire_time >", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeGreaterThanOrEqualTo(Long value) {
            addCriterion("expire_time >=", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeLessThan(Long value) {
            addCriterion("expire_time <", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeLessThanOrEqualTo(Long value) {
            addCriterion("expire_time <=", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeIn(List<Long> values) {
            addCriterion("expire_time in", values, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeNotIn(List<Long> values) {
            addCriterion("expire_time not in", values, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeBetween(Long value1, Long value2) {
            addCriterion("expire_time between", value1, value2, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeNotBetween(Long value1, Long value2) {
            addCriterion("expire_time not between", value1, value2, "expire_time");
            return (Criteria) this;
        }

        public Criteria andMachine_nameIsNull() {
            addCriterion("machine_name is null");
            return (Criteria) this;
        }

        public Criteria andMachine_nameIsNotNull() {
            addCriterion("machine_name is not null");
            return (Criteria) this;
        }

        public Criteria andMachine_nameEqualTo(String value) {
            addCriterion("machine_name =", value, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameNotEqualTo(String value) {
            addCriterion("machine_name <>", value, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameGreaterThan(String value) {
            addCriterion("machine_name >", value, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameGreaterThanOrEqualTo(String value) {
            addCriterion("machine_name >=", value, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameLessThan(String value) {
            addCriterion("machine_name <", value, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameLessThanOrEqualTo(String value) {
            addCriterion("machine_name <=", value, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameLike(String value) {
            addCriterion("machine_name like", value, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameNotLike(String value) {
            addCriterion("machine_name not like", value, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameIn(List<String> values) {
            addCriterion("machine_name in", values, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameNotIn(List<String> values) {
            addCriterion("machine_name not in", values, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameBetween(String value1, String value2) {
            addCriterion("machine_name between", value1, value2, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_nameNotBetween(String value1, String value2) {
            addCriterion("machine_name not between", value1, value2, "machine_name");
            return (Criteria) this;
        }

        public Criteria andMachine_typeIsNull() {
            addCriterion("machine_type is null");
            return (Criteria) this;
        }

        public Criteria andMachine_typeIsNotNull() {
            addCriterion("machine_type is not null");
            return (Criteria) this;
        }

        public Criteria andMachine_typeEqualTo(String value) {
            addCriterion("machine_type =", value, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeNotEqualTo(String value) {
            addCriterion("machine_type <>", value, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeGreaterThan(String value) {
            addCriterion("machine_type >", value, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeGreaterThanOrEqualTo(String value) {
            addCriterion("machine_type >=", value, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeLessThan(String value) {
            addCriterion("machine_type <", value, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeLessThanOrEqualTo(String value) {
            addCriterion("machine_type <=", value, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeLike(String value) {
            addCriterion("machine_type like", value, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeNotLike(String value) {
            addCriterion("machine_type not like", value, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeIn(List<String> values) {
            addCriterion("machine_type in", values, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeNotIn(List<String> values) {
            addCriterion("machine_type not in", values, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeBetween(String value1, String value2) {
            addCriterion("machine_type between", value1, value2, "machine_type");
            return (Criteria) this;
        }

        public Criteria andMachine_typeNotBetween(String value1, String value2) {
            addCriterion("machine_type not between", value1, value2, "machine_type");
            return (Criteria) this;
        }

        public Criteria andUnit_priceIsNull() {
            addCriterion("unit_price is null");
            return (Criteria) this;
        }

        public Criteria andUnit_priceIsNotNull() {
            addCriterion("unit_price is not null");
            return (Criteria) this;
        }

        public Criteria andUnit_priceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unit_price");
            return (Criteria) this;
        }

        public Criteria andUnit_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unit_price");
            return (Criteria) this;
        }

        public Criteria andPer_amountIsNull() {
            addCriterion("per_amount is null");
            return (Criteria) this;
        }

        public Criteria andPer_amountIsNotNull() {
            addCriterion("per_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPer_amountEqualTo(BigDecimal value) {
            addCriterion("per_amount =", value, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountNotEqualTo(BigDecimal value) {
            addCriterion("per_amount <>", value, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountGreaterThan(BigDecimal value) {
            addCriterion("per_amount >", value, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("per_amount >=", value, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountLessThan(BigDecimal value) {
            addCriterion("per_amount <", value, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("per_amount <=", value, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountIn(List<BigDecimal> values) {
            addCriterion("per_amount in", values, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountNotIn(List<BigDecimal> values) {
            addCriterion("per_amount not in", values, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_amount between", value1, value2, "per_amount");
            return (Criteria) this;
        }

        public Criteria andPer_amountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_amount not between", value1, value2, "per_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationIsNull() {
            addCriterion("cycle_of_operation is null");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationIsNotNull() {
            addCriterion("cycle_of_operation is not null");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationEqualTo(Integer value) {
            addCriterion("cycle_of_operation =", value, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationNotEqualTo(Integer value) {
            addCriterion("cycle_of_operation <>", value, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationGreaterThan(Integer value) {
            addCriterion("cycle_of_operation >", value, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycle_of_operation >=", value, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationLessThan(Integer value) {
            addCriterion("cycle_of_operation <", value, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationLessThanOrEqualTo(Integer value) {
            addCriterion("cycle_of_operation <=", value, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationIn(List<Integer> values) {
            addCriterion("cycle_of_operation in", values, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationNotIn(List<Integer> values) {
            addCriterion("cycle_of_operation not in", values, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationBetween(Integer value1, Integer value2) {
            addCriterion("cycle_of_operation between", value1, value2, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andCycle_of_operationNotBetween(Integer value1, Integer value2) {
            addCriterion("cycle_of_operation not between", value1, value2, "cycle_of_operation");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeIsNull() {
            addCriterion("generate_of_time is null");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeIsNotNull() {
            addCriterion("generate_of_time is not null");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeEqualTo(Integer value) {
            addCriterion("generate_of_time =", value, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeNotEqualTo(Integer value) {
            addCriterion("generate_of_time <>", value, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeGreaterThan(Integer value) {
            addCriterion("generate_of_time >", value, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeGreaterThanOrEqualTo(Integer value) {
            addCriterion("generate_of_time >=", value, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeLessThan(Integer value) {
            addCriterion("generate_of_time <", value, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeLessThanOrEqualTo(Integer value) {
            addCriterion("generate_of_time <=", value, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeIn(List<Integer> values) {
            addCriterion("generate_of_time in", values, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeNotIn(List<Integer> values) {
            addCriterion("generate_of_time not in", values, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeBetween(Integer value1, Integer value2) {
            addCriterion("generate_of_time between", value1, value2, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_timeNotBetween(Integer value1, Integer value2) {
            addCriterion("generate_of_time not between", value1, value2, "generate_of_time");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountIsNull() {
            addCriterion("generate_of_amount is null");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountIsNotNull() {
            addCriterion("generate_of_amount is not null");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountEqualTo(BigDecimal value) {
            addCriterion("generate_of_amount =", value, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountNotEqualTo(BigDecimal value) {
            addCriterion("generate_of_amount <>", value, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountGreaterThan(BigDecimal value) {
            addCriterion("generate_of_amount >", value, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("generate_of_amount >=", value, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountLessThan(BigDecimal value) {
            addCriterion("generate_of_amount <", value, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("generate_of_amount <=", value, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountIn(List<BigDecimal> values) {
            addCriterion("generate_of_amount in", values, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountNotIn(List<BigDecimal> values) {
            addCriterion("generate_of_amount not in", values, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("generate_of_amount between", value1, value2, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andGenerate_of_amountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("generate_of_amount not between", value1, value2, "generate_of_amount");
            return (Criteria) this;
        }

        public Criteria andLimit_countIsNull() {
            addCriterion("limit_count is null");
            return (Criteria) this;
        }

        public Criteria andLimit_countIsNotNull() {
            addCriterion("limit_count is not null");
            return (Criteria) this;
        }

        public Criteria andLimit_countEqualTo(Integer value) {
            addCriterion("limit_count =", value, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countNotEqualTo(Integer value) {
            addCriterion("limit_count <>", value, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countGreaterThan(Integer value) {
            addCriterion("limit_count >", value, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_count >=", value, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countLessThan(Integer value) {
            addCriterion("limit_count <", value, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countLessThanOrEqualTo(Integer value) {
            addCriterion("limit_count <=", value, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countIn(List<Integer> values) {
            addCriterion("limit_count in", values, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countNotIn(List<Integer> values) {
            addCriterion("limit_count not in", values, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countBetween(Integer value1, Integer value2) {
            addCriterion("limit_count between", value1, value2, "limit_count");
            return (Criteria) this;
        }

        public Criteria andLimit_countNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_count not between", value1, value2, "limit_count");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andCreated_byIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreated_byIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_byEqualTo(String value) {
            addCriterion("created_by =", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotEqualTo(String value) {
            addCriterion("created_by <>", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byGreaterThan(String value) {
            addCriterion("created_by >", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLessThan(String value) {
            addCriterion("created_by <", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byLike(String value) {
            addCriterion("created_by like", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotLike(String value) {
            addCriterion("created_by not like", value, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byIn(List<String> values) {
            addCriterion("created_by in", values, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotIn(List<String> values) {
            addCriterion("created_by not in", values, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "created_by");
            return (Criteria) this;
        }

        public Criteria andCreated_byNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "created_by");
            return (Criteria) this;
        }

        public Criteria andGmt_createdIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmt_createdIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_createdEqualTo(Long value) {
            addCriterion("gmt_created =", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdNotEqualTo(Long value) {
            addCriterion("gmt_created <>", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdGreaterThan(Long value) {
            addCriterion("gmt_created >", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_created >=", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdLessThan(Long value) {
            addCriterion("gmt_created <", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdLessThanOrEqualTo(Long value) {
            addCriterion("gmt_created <=", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdIn(List<Long> values) {
            addCriterion("gmt_created in", values, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdNotIn(List<Long> values) {
            addCriterion("gmt_created not in", values, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdBetween(Long value1, Long value2) {
            addCriterion("gmt_created between", value1, value2, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdNotBetween(Long value1, Long value2) {
            addCriterion("gmt_created not between", value1, value2, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andModified_byIsNull() {
            addCriterion("modified_by is null");
            return (Criteria) this;
        }

        public Criteria andModified_byIsNotNull() {
            addCriterion("modified_by is not null");
            return (Criteria) this;
        }

        public Criteria andModified_byEqualTo(String value) {
            addCriterion("modified_by =", value, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byNotEqualTo(String value) {
            addCriterion("modified_by <>", value, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byGreaterThan(String value) {
            addCriterion("modified_by >", value, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byGreaterThanOrEqualTo(String value) {
            addCriterion("modified_by >=", value, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byLessThan(String value) {
            addCriterion("modified_by <", value, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byLessThanOrEqualTo(String value) {
            addCriterion("modified_by <=", value, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byLike(String value) {
            addCriterion("modified_by like", value, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byNotLike(String value) {
            addCriterion("modified_by not like", value, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byIn(List<String> values) {
            addCriterion("modified_by in", values, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byNotIn(List<String> values) {
            addCriterion("modified_by not in", values, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byBetween(String value1, String value2) {
            addCriterion("modified_by between", value1, value2, "modified_by");
            return (Criteria) this;
        }

        public Criteria andModified_byNotBetween(String value1, String value2) {
            addCriterion("modified_by not between", value1, value2, "modified_by");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedEqualTo(Long value) {
            addCriterion("gmt_modified =", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedNotEqualTo(Long value) {
            addCriterion("gmt_modified <>", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedGreaterThan(Long value) {
            addCriterion("gmt_modified >", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_modified >=", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedLessThan(Long value) {
            addCriterion("gmt_modified <", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedLessThanOrEqualTo(Long value) {
            addCriterion("gmt_modified <=", value, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedIn(List<Long> values) {
            addCriterion("gmt_modified in", values, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedNotIn(List<Long> values) {
            addCriterion("gmt_modified not in", values, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedBetween(Long value1, Long value2) {
            addCriterion("gmt_modified between", value1, value2, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andGmt_modifiedNotBetween(Long value1, Long value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmt_modified");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "is_deleted");
            return (Criteria) this;
        }

        public Criteria andIs_deletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "is_deleted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}