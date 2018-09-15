package site.jvbo.fun.upms.dao.model;

import java.util.ArrayList;
import java.util.List;

public class UpmsLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UpmsLogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(Integer value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(Integer value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(Integer value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(Integer value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(Integer value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<Integer> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<Integer> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(Integer value1, Integer value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNull() {
            addCriterion("method_name is null");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNotNull() {
            addCriterion("method_name is not null");
            return (Criteria) this;
        }

        public Criteria andMethodNameEqualTo(String value) {
            addCriterion("method_name =", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotEqualTo(String value) {
            addCriterion("method_name <>", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThan(String value) {
            addCriterion("method_name >", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("method_name >=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThan(String value) {
            addCriterion("method_name <", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThanOrEqualTo(String value) {
            addCriterion("method_name <=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLike(String value) {
            addCriterion("method_name like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotLike(String value) {
            addCriterion("method_name not like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameIn(List<String> values) {
            addCriterion("method_name in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotIn(List<String> values) {
            addCriterion("method_name not in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameBetween(String value1, String value2) {
            addCriterion("method_name between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotBetween(String value1, String value2) {
            addCriterion("method_name not between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodDescIsNull() {
            addCriterion("method_desc is null");
            return (Criteria) this;
        }

        public Criteria andMethodDescIsNotNull() {
            addCriterion("method_desc is not null");
            return (Criteria) this;
        }

        public Criteria andMethodDescEqualTo(String value) {
            addCriterion("method_desc =", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescNotEqualTo(String value) {
            addCriterion("method_desc <>", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescGreaterThan(String value) {
            addCriterion("method_desc >", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescGreaterThanOrEqualTo(String value) {
            addCriterion("method_desc >=", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescLessThan(String value) {
            addCriterion("method_desc <", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescLessThanOrEqualTo(String value) {
            addCriterion("method_desc <=", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescLike(String value) {
            addCriterion("method_desc like", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescNotLike(String value) {
            addCriterion("method_desc not like", value, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescIn(List<String> values) {
            addCriterion("method_desc in", values, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescNotIn(List<String> values) {
            addCriterion("method_desc not in", values, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescBetween(String value1, String value2) {
            addCriterion("method_desc between", value1, value2, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andMethodDescNotBetween(String value1, String value2) {
            addCriterion("method_desc not between", value1, value2, "methodDesc");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsIsNull() {
            addCriterion("spend_time_ms is null");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsIsNotNull() {
            addCriterion("spend_time_ms is not null");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsEqualTo(Integer value) {
            addCriterion("spend_time_ms =", value, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsNotEqualTo(Integer value) {
            addCriterion("spend_time_ms <>", value, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsGreaterThan(Integer value) {
            addCriterion("spend_time_ms >", value, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsGreaterThanOrEqualTo(Integer value) {
            addCriterion("spend_time_ms >=", value, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsLessThan(Integer value) {
            addCriterion("spend_time_ms <", value, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsLessThanOrEqualTo(Integer value) {
            addCriterion("spend_time_ms <=", value, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsIn(List<Integer> values) {
            addCriterion("spend_time_ms in", values, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsNotIn(List<Integer> values) {
            addCriterion("spend_time_ms not in", values, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsBetween(Integer value1, Integer value2) {
            addCriterion("spend_time_ms between", value1, value2, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andSpendTimeMsNotBetween(Integer value1, Integer value2) {
            addCriterion("spend_time_ms not between", value1, value2, "spendTimeMs");
            return (Criteria) this;
        }

        public Criteria andRequestIpIsNull() {
            addCriterion("request_ip is null");
            return (Criteria) this;
        }

        public Criteria andRequestIpIsNotNull() {
            addCriterion("request_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIpEqualTo(String value) {
            addCriterion("request_ip =", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpNotEqualTo(String value) {
            addCriterion("request_ip <>", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpGreaterThan(String value) {
            addCriterion("request_ip >", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpGreaterThanOrEqualTo(String value) {
            addCriterion("request_ip >=", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpLessThan(String value) {
            addCriterion("request_ip <", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpLessThanOrEqualTo(String value) {
            addCriterion("request_ip <=", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpLike(String value) {
            addCriterion("request_ip like", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpNotLike(String value) {
            addCriterion("request_ip not like", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpIn(List<String> values) {
            addCriterion("request_ip in", values, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpNotIn(List<String> values) {
            addCriterion("request_ip not in", values, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpBetween(String value1, String value2) {
            addCriterion("request_ip between", value1, value2, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpNotBetween(String value1, String value2) {
            addCriterion("request_ip not between", value1, value2, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNull() {
            addCriterion("request_type is null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNotNull() {
            addCriterion("request_type is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeEqualTo(String value) {
            addCriterion("request_type =", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotEqualTo(String value) {
            addCriterion("request_type <>", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThan(String value) {
            addCriterion("request_type >", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("request_type >=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThan(String value) {
            addCriterion("request_type <", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThanOrEqualTo(String value) {
            addCriterion("request_type <=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLike(String value) {
            addCriterion("request_type like", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotLike(String value) {
            addCriterion("request_type not like", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIn(List<String> values) {
            addCriterion("request_type in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotIn(List<String> values) {
            addCriterion("request_type not in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeBetween(String value1, String value2) {
            addCriterion("request_type between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotBetween(String value1, String value2) {
            addCriterion("request_type not between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentIsNull() {
            addCriterion("request_user_agent is null");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentIsNotNull() {
            addCriterion("request_user_agent is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentEqualTo(String value) {
            addCriterion("request_user_agent =", value, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentNotEqualTo(String value) {
            addCriterion("request_user_agent <>", value, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentGreaterThan(String value) {
            addCriterion("request_user_agent >", value, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentGreaterThanOrEqualTo(String value) {
            addCriterion("request_user_agent >=", value, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentLessThan(String value) {
            addCriterion("request_user_agent <", value, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentLessThanOrEqualTo(String value) {
            addCriterion("request_user_agent <=", value, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentLike(String value) {
            addCriterion("request_user_agent like", value, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentNotLike(String value) {
            addCriterion("request_user_agent not like", value, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentIn(List<String> values) {
            addCriterion("request_user_agent in", values, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentNotIn(List<String> values) {
            addCriterion("request_user_agent not in", values, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentBetween(String value1, String value2) {
            addCriterion("request_user_agent between", value1, value2, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestUserAgentNotBetween(String value1, String value2) {
            addCriterion("request_user_agent not between", value1, value2, "requestUserAgent");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathIsNull() {
            addCriterion("request_base_path is null");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathIsNotNull() {
            addCriterion("request_base_path is not null");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathEqualTo(String value) {
            addCriterion("request_base_path =", value, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathNotEqualTo(String value) {
            addCriterion("request_base_path <>", value, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathGreaterThan(String value) {
            addCriterion("request_base_path >", value, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathGreaterThanOrEqualTo(String value) {
            addCriterion("request_base_path >=", value, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathLessThan(String value) {
            addCriterion("request_base_path <", value, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathLessThanOrEqualTo(String value) {
            addCriterion("request_base_path <=", value, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathLike(String value) {
            addCriterion("request_base_path like", value, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathNotLike(String value) {
            addCriterion("request_base_path not like", value, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathIn(List<String> values) {
            addCriterion("request_base_path in", values, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathNotIn(List<String> values) {
            addCriterion("request_base_path not in", values, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathBetween(String value1, String value2) {
            addCriterion("request_base_path between", value1, value2, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestBasePathNotBetween(String value1, String value2) {
            addCriterion("request_base_path not between", value1, value2, "requestBasePath");
            return (Criteria) this;
        }

        public Criteria andRequestUriIsNull() {
            addCriterion("request_uri is null");
            return (Criteria) this;
        }

        public Criteria andRequestUriIsNotNull() {
            addCriterion("request_uri is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUriEqualTo(String value) {
            addCriterion("request_uri =", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriNotEqualTo(String value) {
            addCriterion("request_uri <>", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriGreaterThan(String value) {
            addCriterion("request_uri >", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriGreaterThanOrEqualTo(String value) {
            addCriterion("request_uri >=", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriLessThan(String value) {
            addCriterion("request_uri <", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriLessThanOrEqualTo(String value) {
            addCriterion("request_uri <=", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriLike(String value) {
            addCriterion("request_uri like", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriNotLike(String value) {
            addCriterion("request_uri not like", value, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriIn(List<String> values) {
            addCriterion("request_uri in", values, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriNotIn(List<String> values) {
            addCriterion("request_uri not in", values, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriBetween(String value1, String value2) {
            addCriterion("request_uri between", value1, value2, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUriNotBetween(String value1, String value2) {
            addCriterion("request_uri not between", value1, value2, "requestUri");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIsNull() {
            addCriterion("request_url is null");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIsNotNull() {
            addCriterion("request_url is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUrlEqualTo(String value) {
            addCriterion("request_url =", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotEqualTo(String value) {
            addCriterion("request_url <>", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlGreaterThan(String value) {
            addCriterion("request_url >", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("request_url >=", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLessThan(String value) {
            addCriterion("request_url <", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLessThanOrEqualTo(String value) {
            addCriterion("request_url <=", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLike(String value) {
            addCriterion("request_url like", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotLike(String value) {
            addCriterion("request_url not like", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIn(List<String> values) {
            addCriterion("request_url in", values, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotIn(List<String> values) {
            addCriterion("request_url not in", values, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlBetween(String value1, String value2) {
            addCriterion("request_url between", value1, value2, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotBetween(String value1, String value2) {
            addCriterion("request_url not between", value1, value2, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestParamsIsNull() {
            addCriterion("request_params is null");
            return (Criteria) this;
        }

        public Criteria andRequestParamsIsNotNull() {
            addCriterion("request_params is not null");
            return (Criteria) this;
        }

        public Criteria andRequestParamsEqualTo(String value) {
            addCriterion("request_params =", value, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsNotEqualTo(String value) {
            addCriterion("request_params <>", value, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsGreaterThan(String value) {
            addCriterion("request_params >", value, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsGreaterThanOrEqualTo(String value) {
            addCriterion("request_params >=", value, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsLessThan(String value) {
            addCriterion("request_params <", value, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsLessThanOrEqualTo(String value) {
            addCriterion("request_params <=", value, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsLike(String value) {
            addCriterion("request_params like", value, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsNotLike(String value) {
            addCriterion("request_params not like", value, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsIn(List<String> values) {
            addCriterion("request_params in", values, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsNotIn(List<String> values) {
            addCriterion("request_params not in", values, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsBetween(String value1, String value2) {
            addCriterion("request_params between", value1, value2, "requestParams");
            return (Criteria) this;
        }

        public Criteria andRequestParamsNotBetween(String value1, String value2) {
            addCriterion("request_params not between", value1, value2, "requestParams");
            return (Criteria) this;
        }

        public Criteria andPermissionsIsNull() {
            addCriterion("permissions is null");
            return (Criteria) this;
        }

        public Criteria andPermissionsIsNotNull() {
            addCriterion("permissions is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionsEqualTo(String value) {
            addCriterion("permissions =", value, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsNotEqualTo(String value) {
            addCriterion("permissions <>", value, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsGreaterThan(String value) {
            addCriterion("permissions >", value, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsGreaterThanOrEqualTo(String value) {
            addCriterion("permissions >=", value, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsLessThan(String value) {
            addCriterion("permissions <", value, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsLessThanOrEqualTo(String value) {
            addCriterion("permissions <=", value, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsLike(String value) {
            addCriterion("permissions like", value, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsNotLike(String value) {
            addCriterion("permissions not like", value, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsIn(List<String> values) {
            addCriterion("permissions in", values, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsNotIn(List<String> values) {
            addCriterion("permissions not in", values, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsBetween(String value1, String value2) {
            addCriterion("permissions between", value1, value2, "permissions");
            return (Criteria) this;
        }

        public Criteria andPermissionsNotBetween(String value1, String value2) {
            addCriterion("permissions not between", value1, value2, "permissions");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIsNull() {
            addCriterion("response_code is null");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIsNotNull() {
            addCriterion("response_code is not null");
            return (Criteria) this;
        }

        public Criteria andResponseCodeEqualTo(String value) {
            addCriterion("response_code =", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotEqualTo(String value) {
            addCriterion("response_code <>", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeGreaterThan(String value) {
            addCriterion("response_code >", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("response_code >=", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLessThan(String value) {
            addCriterion("response_code <", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLessThanOrEqualTo(String value) {
            addCriterion("response_code <=", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLike(String value) {
            addCriterion("response_code like", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotLike(String value) {
            addCriterion("response_code not like", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIn(List<String> values) {
            addCriterion("response_code in", values, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotIn(List<String> values) {
            addCriterion("response_code not in", values, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeBetween(String value1, String value2) {
            addCriterion("response_code between", value1, value2, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotBetween(String value1, String value2) {
            addCriterion("response_code not between", value1, value2, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIsNull() {
            addCriterion("response_status is null");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIsNotNull() {
            addCriterion("response_status is not null");
            return (Criteria) this;
        }

        public Criteria andResponseStatusEqualTo(String value) {
            addCriterion("response_status =", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotEqualTo(String value) {
            addCriterion("response_status <>", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusGreaterThan(String value) {
            addCriterion("response_status >", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("response_status >=", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLessThan(String value) {
            addCriterion("response_status <", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLessThanOrEqualTo(String value) {
            addCriterion("response_status <=", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLike(String value) {
            addCriterion("response_status like", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotLike(String value) {
            addCriterion("response_status not like", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIn(List<String> values) {
            addCriterion("response_status in", values, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotIn(List<String> values) {
            addCriterion("response_status not in", values, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusBetween(String value1, String value2) {
            addCriterion("response_status between", value1, value2, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotBetween(String value1, String value2) {
            addCriterion("response_status not between", value1, value2, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIsNull() {
            addCriterion("response_msg is null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIsNotNull() {
            addCriterion("response_msg is not null");
            return (Criteria) this;
        }

        public Criteria andResponseMsgEqualTo(String value) {
            addCriterion("response_msg =", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotEqualTo(String value) {
            addCriterion("response_msg <>", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgGreaterThan(String value) {
            addCriterion("response_msg >", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgGreaterThanOrEqualTo(String value) {
            addCriterion("response_msg >=", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLessThan(String value) {
            addCriterion("response_msg <", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLessThanOrEqualTo(String value) {
            addCriterion("response_msg <=", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgLike(String value) {
            addCriterion("response_msg like", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotLike(String value) {
            addCriterion("response_msg not like", value, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgIn(List<String> values) {
            addCriterion("response_msg in", values, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotIn(List<String> values) {
            addCriterion("response_msg not in", values, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgBetween(String value1, String value2) {
            addCriterion("response_msg between", value1, value2, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseMsgNotBetween(String value1, String value2) {
            addCriterion("response_msg not between", value1, value2, "responseMsg");
            return (Criteria) this;
        }

        public Criteria andResponseDataIsNull() {
            addCriterion("response_data is null");
            return (Criteria) this;
        }

        public Criteria andResponseDataIsNotNull() {
            addCriterion("response_data is not null");
            return (Criteria) this;
        }

        public Criteria andResponseDataEqualTo(String value) {
            addCriterion("response_data =", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotEqualTo(String value) {
            addCriterion("response_data <>", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataGreaterThan(String value) {
            addCriterion("response_data >", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataGreaterThanOrEqualTo(String value) {
            addCriterion("response_data >=", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLessThan(String value) {
            addCriterion("response_data <", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLessThanOrEqualTo(String value) {
            addCriterion("response_data <=", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLike(String value) {
            addCriterion("response_data like", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotLike(String value) {
            addCriterion("response_data not like", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataIn(List<String> values) {
            addCriterion("response_data in", values, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotIn(List<String> values) {
            addCriterion("response_data not in", values, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataBetween(String value1, String value2) {
            addCriterion("response_data between", value1, value2, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotBetween(String value1, String value2) {
            addCriterion("response_data not between", value1, value2, "responseData");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgIsNull() {
            addCriterion("exception_msg is null");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgIsNotNull() {
            addCriterion("exception_msg is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgEqualTo(String value) {
            addCriterion("exception_msg =", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgNotEqualTo(String value) {
            addCriterion("exception_msg <>", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgGreaterThan(String value) {
            addCriterion("exception_msg >", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgGreaterThanOrEqualTo(String value) {
            addCriterion("exception_msg >=", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgLessThan(String value) {
            addCriterion("exception_msg <", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgLessThanOrEqualTo(String value) {
            addCriterion("exception_msg <=", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgLike(String value) {
            addCriterion("exception_msg like", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgNotLike(String value) {
            addCriterion("exception_msg not like", value, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgIn(List<String> values) {
            addCriterion("exception_msg in", values, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgNotIn(List<String> values) {
            addCriterion("exception_msg not in", values, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgBetween(String value1, String value2) {
            addCriterion("exception_msg between", value1, value2, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionMsgNotBetween(String value1, String value2) {
            addCriterion("exception_msg not between", value1, value2, "exceptionMsg");
            return (Criteria) this;
        }

        public Criteria andExceptionDescIsNull() {
            addCriterion("exception_desc is null");
            return (Criteria) this;
        }

        public Criteria andExceptionDescIsNotNull() {
            addCriterion("exception_desc is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionDescEqualTo(String value) {
            addCriterion("exception_desc =", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescNotEqualTo(String value) {
            addCriterion("exception_desc <>", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescGreaterThan(String value) {
            addCriterion("exception_desc >", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescGreaterThanOrEqualTo(String value) {
            addCriterion("exception_desc >=", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescLessThan(String value) {
            addCriterion("exception_desc <", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescLessThanOrEqualTo(String value) {
            addCriterion("exception_desc <=", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescLike(String value) {
            addCriterion("exception_desc like", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescNotLike(String value) {
            addCriterion("exception_desc not like", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescIn(List<String> values) {
            addCriterion("exception_desc in", values, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescNotIn(List<String> values) {
            addCriterion("exception_desc not in", values, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescBetween(String value1, String value2) {
            addCriterion("exception_desc between", value1, value2, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescNotBetween(String value1, String value2) {
            addCriterion("exception_desc not between", value1, value2, "exceptionDesc");
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