package com.jvbo.blog.model;

import com.jvbo.framework.mybatis.pageplugin.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LinkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public LinkExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNull() {
            addCriterion("linkName is null");
            return (Criteria) this;
        }

        public Criteria andLinkNameIsNotNull() {
            addCriterion("linkName is not null");
            return (Criteria) this;
        }

        public Criteria andLinkNameEqualTo(String value) {
            addCriterion("linkName =", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotEqualTo(String value) {
            addCriterion("linkName <>", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThan(String value) {
            addCriterion("linkName >", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameGreaterThanOrEqualTo(String value) {
            addCriterion("linkName >=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThan(String value) {
            addCriterion("linkName <", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLessThanOrEqualTo(String value) {
            addCriterion("linkName <=", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameLike(String value) {
            addCriterion("linkName like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotLike(String value) {
            addCriterion("linkName not like", value, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameIn(List<String> values) {
            addCriterion("linkName in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotIn(List<String> values) {
            addCriterion("linkName not in", values, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameBetween(String value1, String value2) {
            addCriterion("linkName between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkNameNotBetween(String value1, String value2) {
            addCriterion("linkName not between", value1, value2, "linkName");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNull() {
            addCriterion("linkUrl is null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIsNotNull() {
            addCriterion("linkUrl is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUrlEqualTo(String value) {
            addCriterion("linkUrl =", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotEqualTo(String value) {
            addCriterion("linkUrl <>", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThan(String value) {
            addCriterion("linkUrl >", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("linkUrl >=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThan(String value) {
            addCriterion("linkUrl <", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("linkUrl <=", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlLike(String value) {
            addCriterion("linkUrl like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotLike(String value) {
            addCriterion("linkUrl not like", value, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlIn(List<String> values) {
            addCriterion("linkUrl in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotIn(List<String> values) {
            addCriterion("linkUrl not in", values, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlBetween(String value1, String value2) {
            addCriterion("linkUrl between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andLinkUrlNotBetween(String value1, String value2) {
            addCriterion("linkUrl not between", value1, value2, "linkUrl");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("orderNo is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("orderNo is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(Integer value) {
            addCriterion("orderNo =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(Integer value) {
            addCriterion("orderNo <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(Integer value) {
            addCriterion("orderNo >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderNo >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(Integer value) {
            addCriterion("orderNo <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(Integer value) {
            addCriterion("orderNo <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<Integer> values) {
            addCriterion("orderNo in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<Integer> values) {
            addCriterion("orderNo not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(Integer value1, Integer value2) {
            addCriterion("orderNo between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(Integer value1, Integer value2) {
            addCriterion("orderNo not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andAddUserIdIsNull() {
            addCriterion("addUserId is null");
            return (Criteria) this;
        }

        public Criteria andAddUserIdIsNotNull() {
            addCriterion("addUserId is not null");
            return (Criteria) this;
        }

        public Criteria andAddUserIdEqualTo(String value) {
            addCriterion("addUserId =", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdNotEqualTo(String value) {
            addCriterion("addUserId <>", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdGreaterThan(String value) {
            addCriterion("addUserId >", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("addUserId >=", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdLessThan(String value) {
            addCriterion("addUserId <", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdLessThanOrEqualTo(String value) {
            addCriterion("addUserId <=", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdLike(String value) {
            addCriterion("addUserId like", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdNotLike(String value) {
            addCriterion("addUserId not like", value, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdIn(List<String> values) {
            addCriterion("addUserId in", values, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdNotIn(List<String> values) {
            addCriterion("addUserId not in", values, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdBetween(String value1, String value2) {
            addCriterion("addUserId between", value1, value2, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddUserIdNotBetween(String value1, String value2) {
            addCriterion("addUserId not between", value1, value2, "addUserId");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("addTime <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("updTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("updTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("updTime =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("updTime <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("updTime >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updTime >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("updTime <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("updTime <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("updTime in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("updTime not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("updTime between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("updTime not between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNull() {
            addCriterion("updUserId is null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIsNotNull() {
            addCriterion("updUserId is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdEqualTo(String value) {
            addCriterion("updUserId =", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotEqualTo(String value) {
            addCriterion("updUserId <>", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThan(String value) {
            addCriterion("updUserId >", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("updUserId >=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThan(String value) {
            addCriterion("updUserId <", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLessThanOrEqualTo(String value) {
            addCriterion("updUserId <=", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdLike(String value) {
            addCriterion("updUserId like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotLike(String value) {
            addCriterion("updUserId not like", value, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdIn(List<String> values) {
            addCriterion("updUserId in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotIn(List<String> values) {
            addCriterion("updUserId not in", values, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdBetween(String value1, String value2) {
            addCriterion("updUserId between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andUpdUserIdNotBetween(String value1, String value2) {
            addCriterion("updUserId not between", value1, value2, "updUserId");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("delFlag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("delFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("delFlag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("delFlag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("delFlag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delFlag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("delFlag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("delFlag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("delFlag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("delFlag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("delFlag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("delFlag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("delFlag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("delFlag not between", value1, value2, "delFlag");
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