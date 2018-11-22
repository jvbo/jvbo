package site.jvbo.fun.okex.dao.model;

import java.util.ArrayList;
import java.util.List;

public class OkexSymbolPairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OkexSymbolPairExample() {
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

        public Criteria andSymbolPairIdIsNull() {
            addCriterion("symbol_pair_id is null");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdIsNotNull() {
            addCriterion("symbol_pair_id is not null");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdEqualTo(Long value) {
            addCriterion("symbol_pair_id =", value, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdNotEqualTo(Long value) {
            addCriterion("symbol_pair_id <>", value, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdGreaterThan(Long value) {
            addCriterion("symbol_pair_id >", value, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdGreaterThanOrEqualTo(Long value) {
            addCriterion("symbol_pair_id >=", value, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdLessThan(Long value) {
            addCriterion("symbol_pair_id <", value, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdLessThanOrEqualTo(Long value) {
            addCriterion("symbol_pair_id <=", value, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdIn(List<Long> values) {
            addCriterion("symbol_pair_id in", values, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdNotIn(List<Long> values) {
            addCriterion("symbol_pair_id not in", values, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdBetween(Long value1, Long value2) {
            addCriterion("symbol_pair_id between", value1, value2, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andSymbolPairIdNotBetween(Long value1, Long value2) {
            addCriterion("symbol_pair_id not between", value1, value2, "symbolPairId");
            return (Criteria) this;
        }

        public Criteria andBaseIsNull() {
            addCriterion("base is null");
            return (Criteria) this;
        }

        public Criteria andBaseIsNotNull() {
            addCriterion("base is not null");
            return (Criteria) this;
        }

        public Criteria andBaseEqualTo(String value) {
            addCriterion("base =", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotEqualTo(String value) {
            addCriterion("base <>", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseGreaterThan(String value) {
            addCriterion("base >", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseGreaterThanOrEqualTo(String value) {
            addCriterion("base >=", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLessThan(String value) {
            addCriterion("base <", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLessThanOrEqualTo(String value) {
            addCriterion("base <=", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseLike(String value) {
            addCriterion("base like", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotLike(String value) {
            addCriterion("base not like", value, "base");
            return (Criteria) this;
        }

        public Criteria andBaseIn(List<String> values) {
            addCriterion("base in", values, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotIn(List<String> values) {
            addCriterion("base not in", values, "base");
            return (Criteria) this;
        }

        public Criteria andBaseBetween(String value1, String value2) {
            addCriterion("base between", value1, value2, "base");
            return (Criteria) this;
        }

        public Criteria andBaseNotBetween(String value1, String value2) {
            addCriterion("base not between", value1, value2, "base");
            return (Criteria) this;
        }

        public Criteria andQuoteIsNull() {
            addCriterion("`quote` is null");
            return (Criteria) this;
        }

        public Criteria andQuoteIsNotNull() {
            addCriterion("`quote` is not null");
            return (Criteria) this;
        }

        public Criteria andQuoteEqualTo(String value) {
            addCriterion("`quote` =", value, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteNotEqualTo(String value) {
            addCriterion("`quote` <>", value, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteGreaterThan(String value) {
            addCriterion("`quote` >", value, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteGreaterThanOrEqualTo(String value) {
            addCriterion("`quote` >=", value, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteLessThan(String value) {
            addCriterion("`quote` <", value, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteLessThanOrEqualTo(String value) {
            addCriterion("`quote` <=", value, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteLike(String value) {
            addCriterion("`quote` like", value, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteNotLike(String value) {
            addCriterion("`quote` not like", value, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteIn(List<String> values) {
            addCriterion("`quote` in", values, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteNotIn(List<String> values) {
            addCriterion("`quote` not in", values, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteBetween(String value1, String value2) {
            addCriterion("`quote` between", value1, value2, "quote");
            return (Criteria) this;
        }

        public Criteria andQuoteNotBetween(String value1, String value2) {
            addCriterion("`quote` not between", value1, value2, "quote");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedIsNull() {
            addCriterion("is_onlined is null");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedIsNotNull() {
            addCriterion("is_onlined is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedEqualTo(Integer value) {
            addCriterion("is_onlined =", value, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedNotEqualTo(Integer value) {
            addCriterion("is_onlined <>", value, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedGreaterThan(Integer value) {
            addCriterion("is_onlined >", value, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_onlined >=", value, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedLessThan(Integer value) {
            addCriterion("is_onlined <", value, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedLessThanOrEqualTo(Integer value) {
            addCriterion("is_onlined <=", value, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedIn(List<Integer> values) {
            addCriterion("is_onlined in", values, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedNotIn(List<Integer> values) {
            addCriterion("is_onlined not in", values, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedBetween(Integer value1, Integer value2) {
            addCriterion("is_onlined between", value1, value2, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsOnlinedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_onlined not between", value1, value2, "isOnlined");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredIsNull() {
            addCriterion("is_monitored is null");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredIsNotNull() {
            addCriterion("is_monitored is not null");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredEqualTo(Integer value) {
            addCriterion("is_monitored =", value, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredNotEqualTo(Integer value) {
            addCriterion("is_monitored <>", value, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredGreaterThan(Integer value) {
            addCriterion("is_monitored >", value, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_monitored >=", value, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredLessThan(Integer value) {
            addCriterion("is_monitored <", value, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredLessThanOrEqualTo(Integer value) {
            addCriterion("is_monitored <=", value, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredIn(List<Integer> values) {
            addCriterion("is_monitored in", values, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredNotIn(List<Integer> values) {
            addCriterion("is_monitored not in", values, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredBetween(Integer value1, Integer value2) {
            addCriterion("is_monitored between", value1, value2, "isMonitored");
            return (Criteria) this;
        }

        public Criteria andIsMonitoredNotBetween(Integer value1, Integer value2) {
            addCriterion("is_monitored not between", value1, value2, "isMonitored");
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

        public Criteria andSortEqualTo(Long value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Long value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Long value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Long value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Long value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Long value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Long> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Long> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Long value1, Long value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Long value1, Long value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Long value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Long value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Long value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Long value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Long value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Long> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Long> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Long value1, Long value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Long value1, Long value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Long value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Long value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Long value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Long value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Long value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Long> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Long> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Long value1, Long value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Long value1, Long value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNull() {
            addCriterion("modified_by is null");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNotNull() {
            addCriterion("modified_by is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedByEqualTo(Long value) {
            addCriterion("modified_by =", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotEqualTo(Long value) {
            addCriterion("modified_by <>", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThan(Long value) {
            addCriterion("modified_by >", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThanOrEqualTo(Long value) {
            addCriterion("modified_by >=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThan(Long value) {
            addCriterion("modified_by <", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThanOrEqualTo(Long value) {
            addCriterion("modified_by <=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByIn(List<Long> values) {
            addCriterion("modified_by in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotIn(List<Long> values) {
            addCriterion("modified_by not in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByBetween(Long value1, Long value2) {
            addCriterion("modified_by between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotBetween(Long value1, Long value2) {
            addCriterion("modified_by not between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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