package com.jvbo.blog.model;

import com.jvbo.framework.mybatis.pageplugin.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public UserExample() {
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

        public Criteria andLoginNameIsNull() {
            addCriterion("loginName is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("loginName is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("loginName =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("loginName <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("loginName >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("loginName >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("loginName <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("loginName <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("loginName like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("loginName not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("loginName in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("loginName not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("loginName between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("loginName not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNull() {
            addCriterion("passWord is null");
            return (Criteria) this;
        }

        public Criteria andPassWordIsNotNull() {
            addCriterion("passWord is not null");
            return (Criteria) this;
        }

        public Criteria andPassWordEqualTo(String value) {
            addCriterion("passWord =", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotEqualTo(String value) {
            addCriterion("passWord <>", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThan(String value) {
            addCriterion("passWord >", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordGreaterThanOrEqualTo(String value) {
            addCriterion("passWord >=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThan(String value) {
            addCriterion("passWord <", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLessThanOrEqualTo(String value) {
            addCriterion("passWord <=", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordLike(String value) {
            addCriterion("passWord like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotLike(String value) {
            addCriterion("passWord not like", value, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordIn(List<String> values) {
            addCriterion("passWord in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotIn(List<String> values) {
            addCriterion("passWord not in", values, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordBetween(String value1, String value2) {
            addCriterion("passWord between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andPassWordNotBetween(String value1, String value2) {
            addCriterion("passWord not between", value1, value2, "passWord");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("userName =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("userName <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("userName >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("userName <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("userName like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("userName not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("userName in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("userName not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "userName");
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