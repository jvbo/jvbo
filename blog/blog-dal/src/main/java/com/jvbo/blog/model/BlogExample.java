package com.jvbo.blog.model;

import com.jvbo.framework.mybatis.pageplugin.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public BlogExample() {
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

        public Criteria andTypeIdIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("typeId =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("typeId <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("typeId >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("typeId >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("typeId <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("typeId <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("typeId like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("typeId not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("typeId in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("typeId not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("typeId between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("typeId not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNull() {
            addCriterion("keyWord is null");
            return (Criteria) this;
        }

        public Criteria andKeyWordIsNotNull() {
            addCriterion("keyWord is not null");
            return (Criteria) this;
        }

        public Criteria andKeyWordEqualTo(String value) {
            addCriterion("keyWord =", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotEqualTo(String value) {
            addCriterion("keyWord <>", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThan(String value) {
            addCriterion("keyWord >", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordGreaterThanOrEqualTo(String value) {
            addCriterion("keyWord >=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThan(String value) {
            addCriterion("keyWord <", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLessThanOrEqualTo(String value) {
            addCriterion("keyWord <=", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordLike(String value) {
            addCriterion("keyWord like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotLike(String value) {
            addCriterion("keyWord not like", value, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordIn(List<String> values) {
            addCriterion("keyWord in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotIn(List<String> values) {
            addCriterion("keyWord not in", values, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordBetween(String value1, String value2) {
            addCriterion("keyWord between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andKeyWordNotBetween(String value1, String value2) {
            addCriterion("keyWord not between", value1, value2, "keyWord");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNull() {
            addCriterion("releaseDate is null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIsNotNull() {
            addCriterion("releaseDate is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateEqualTo(Date value) {
            addCriterion("releaseDate =", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotEqualTo(Date value) {
            addCriterion("releaseDate <>", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThan(Date value) {
            addCriterion("releaseDate >", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("releaseDate >=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThan(Date value) {
            addCriterion("releaseDate <", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateLessThanOrEqualTo(Date value) {
            addCriterion("releaseDate <=", value, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateIn(List<Date> values) {
            addCriterion("releaseDate in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotIn(List<Date> values) {
            addCriterion("releaseDate not in", values, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateBetween(Date value1, Date value2) {
            addCriterion("releaseDate between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateNotBetween(Date value1, Date value2) {
            addCriterion("releaseDate not between", value1, value2, "releaseDate");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrIsNull() {
            addCriterion("releaseDateStr is null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrIsNotNull() {
            addCriterion("releaseDateStr is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrEqualTo(String value) {
            addCriterion("releaseDateStr =", value, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrNotEqualTo(String value) {
            addCriterion("releaseDateStr <>", value, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrGreaterThan(String value) {
            addCriterion("releaseDateStr >", value, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrGreaterThanOrEqualTo(String value) {
            addCriterion("releaseDateStr >=", value, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrLessThan(String value) {
            addCriterion("releaseDateStr <", value, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrLessThanOrEqualTo(String value) {
            addCriterion("releaseDateStr <=", value, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrLike(String value) {
            addCriterion("releaseDateStr like", value, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrNotLike(String value) {
            addCriterion("releaseDateStr not like", value, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrIn(List<String> values) {
            addCriterion("releaseDateStr in", values, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrNotIn(List<String> values) {
            addCriterion("releaseDateStr not in", values, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrBetween(String value1, String value2) {
            addCriterion("releaseDateStr between", value1, value2, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andReleaseDateStrNotBetween(String value1, String value2) {
            addCriterion("releaseDateStr not between", value1, value2, "releaseDateStr");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNull() {
            addCriterion("clickNum is null");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNotNull() {
            addCriterion("clickNum is not null");
            return (Criteria) this;
        }

        public Criteria andClickNumEqualTo(Integer value) {
            addCriterion("clickNum =", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotEqualTo(Integer value) {
            addCriterion("clickNum <>", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThan(Integer value) {
            addCriterion("clickNum >", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("clickNum >=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThan(Integer value) {
            addCriterion("clickNum <", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThanOrEqualTo(Integer value) {
            addCriterion("clickNum <=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIn(List<Integer> values) {
            addCriterion("clickNum in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotIn(List<Integer> values) {
            addCriterion("clickNum not in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumBetween(Integer value1, Integer value2) {
            addCriterion("clickNum between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("clickNum not between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumIsNull() {
            addCriterion("replyNum is null");
            return (Criteria) this;
        }

        public Criteria andReplyNumIsNotNull() {
            addCriterion("replyNum is not null");
            return (Criteria) this;
        }

        public Criteria andReplyNumEqualTo(Integer value) {
            addCriterion("replyNum =", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumNotEqualTo(Integer value) {
            addCriterion("replyNum <>", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumGreaterThan(Integer value) {
            addCriterion("replyNum >", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("replyNum >=", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumLessThan(Integer value) {
            addCriterion("replyNum <", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumLessThanOrEqualTo(Integer value) {
            addCriterion("replyNum <=", value, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumIn(List<Integer> values) {
            addCriterion("replyNum in", values, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumNotIn(List<Integer> values) {
            addCriterion("replyNum not in", values, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumBetween(Integer value1, Integer value2) {
            addCriterion("replyNum between", value1, value2, "replyNum");
            return (Criteria) this;
        }

        public Criteria andReplyNumNotBetween(Integer value1, Integer value2) {
            addCriterion("replyNum not between", value1, value2, "replyNum");
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