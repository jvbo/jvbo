package site.jvbo.fun.okex.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OkexSpotTickerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OkexSpotTickerExample() {
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

        public Criteria andSpotTickerIdIsNull() {
            addCriterion("spot_ticker_id is null");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdIsNotNull() {
            addCriterion("spot_ticker_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdEqualTo(Long value) {
            addCriterion("spot_ticker_id =", value, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdNotEqualTo(Long value) {
            addCriterion("spot_ticker_id <>", value, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdGreaterThan(Long value) {
            addCriterion("spot_ticker_id >", value, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("spot_ticker_id >=", value, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdLessThan(Long value) {
            addCriterion("spot_ticker_id <", value, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdLessThanOrEqualTo(Long value) {
            addCriterion("spot_ticker_id <=", value, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdIn(List<Long> values) {
            addCriterion("spot_ticker_id in", values, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdNotIn(List<Long> values) {
            addCriterion("spot_ticker_id not in", values, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdBetween(Long value1, Long value2) {
            addCriterion("spot_ticker_id between", value1, value2, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andSpotTickerIdNotBetween(Long value1, Long value2) {
            addCriterion("spot_ticker_id not between", value1, value2, "spotTickerId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Long> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Long> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andHighIsNull() {
            addCriterion("high is null");
            return (Criteria) this;
        }

        public Criteria andHighIsNotNull() {
            addCriterion("high is not null");
            return (Criteria) this;
        }

        public Criteria andHighEqualTo(BigDecimal value) {
            addCriterion("high =", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotEqualTo(BigDecimal value) {
            addCriterion("high <>", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThan(BigDecimal value) {
            addCriterion("high >", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("high >=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThan(BigDecimal value) {
            addCriterion("high <", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThanOrEqualTo(BigDecimal value) {
            addCriterion("high <=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighIn(List<BigDecimal> values) {
            addCriterion("high in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotIn(List<BigDecimal> values) {
            addCriterion("high not in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("high between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("high not between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andVolIsNull() {
            addCriterion("vol is null");
            return (Criteria) this;
        }

        public Criteria andVolIsNotNull() {
            addCriterion("vol is not null");
            return (Criteria) this;
        }

        public Criteria andVolEqualTo(BigDecimal value) {
            addCriterion("vol =", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotEqualTo(BigDecimal value) {
            addCriterion("vol <>", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThan(BigDecimal value) {
            addCriterion("vol >", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vol >=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThan(BigDecimal value) {
            addCriterion("vol <", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vol <=", value, "vol");
            return (Criteria) this;
        }

        public Criteria andVolIn(List<BigDecimal> values) {
            addCriterion("vol in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotIn(List<BigDecimal> values) {
            addCriterion("vol not in", values, "vol");
            return (Criteria) this;
        }

        public Criteria andVolBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vol between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andVolNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vol not between", value1, value2, "vol");
            return (Criteria) this;
        }

        public Criteria andLastIsNull() {
            addCriterion("`last` is null");
            return (Criteria) this;
        }

        public Criteria andLastIsNotNull() {
            addCriterion("`last` is not null");
            return (Criteria) this;
        }

        public Criteria andLastEqualTo(BigDecimal value) {
            addCriterion("`last` =", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotEqualTo(BigDecimal value) {
            addCriterion("`last` <>", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThan(BigDecimal value) {
            addCriterion("`last` >", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`last` >=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThan(BigDecimal value) {
            addCriterion("`last` <", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`last` <=", value, "last");
            return (Criteria) this;
        }

        public Criteria andLastIn(List<BigDecimal> values) {
            addCriterion("`last` in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotIn(List<BigDecimal> values) {
            addCriterion("`last` not in", values, "last");
            return (Criteria) this;
        }

        public Criteria andLastBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`last` between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andLastNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`last` not between", value1, value2, "last");
            return (Criteria) this;
        }

        public Criteria andLowIsNull() {
            addCriterion("low is null");
            return (Criteria) this;
        }

        public Criteria andLowIsNotNull() {
            addCriterion("low is not null");
            return (Criteria) this;
        }

        public Criteria andLowEqualTo(BigDecimal value) {
            addCriterion("low =", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotEqualTo(BigDecimal value) {
            addCriterion("low <>", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThan(BigDecimal value) {
            addCriterion("low >", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("low >=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThan(BigDecimal value) {
            addCriterion("low <", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("low <=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowIn(List<BigDecimal> values) {
            addCriterion("low in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotIn(List<BigDecimal> values) {
            addCriterion("low not in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("low between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("low not between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andBuyIsNull() {
            addCriterion("buy is null");
            return (Criteria) this;
        }

        public Criteria andBuyIsNotNull() {
            addCriterion("buy is not null");
            return (Criteria) this;
        }

        public Criteria andBuyEqualTo(BigDecimal value) {
            addCriterion("buy =", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotEqualTo(BigDecimal value) {
            addCriterion("buy <>", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyGreaterThan(BigDecimal value) {
            addCriterion("buy >", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("buy >=", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyLessThan(BigDecimal value) {
            addCriterion("buy <", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("buy <=", value, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyIn(List<BigDecimal> values) {
            addCriterion("buy in", values, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotIn(List<BigDecimal> values) {
            addCriterion("buy not in", values, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy between", value1, value2, "buy");
            return (Criteria) this;
        }

        public Criteria andBuyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("buy not between", value1, value2, "buy");
            return (Criteria) this;
        }

        public Criteria andChangeIsNull() {
            addCriterion("`change` is null");
            return (Criteria) this;
        }

        public Criteria andChangeIsNotNull() {
            addCriterion("`change` is not null");
            return (Criteria) this;
        }

        public Criteria andChangeEqualTo(BigDecimal value) {
            addCriterion("`change` =", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotEqualTo(BigDecimal value) {
            addCriterion("`change` <>", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeGreaterThan(BigDecimal value) {
            addCriterion("`change` >", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`change` >=", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeLessThan(BigDecimal value) {
            addCriterion("`change` <", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`change` <=", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeIn(List<BigDecimal> values) {
            addCriterion("`change` in", values, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotIn(List<BigDecimal> values) {
            addCriterion("`change` not in", values, "change");
            return (Criteria) this;
        }

        public Criteria andChangeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`change` between", value1, value2, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`change` not between", value1, value2, "change");
            return (Criteria) this;
        }

        public Criteria andSellIsNull() {
            addCriterion("sell is null");
            return (Criteria) this;
        }

        public Criteria andSellIsNotNull() {
            addCriterion("sell is not null");
            return (Criteria) this;
        }

        public Criteria andSellEqualTo(BigDecimal value) {
            addCriterion("sell =", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotEqualTo(BigDecimal value) {
            addCriterion("sell <>", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellGreaterThan(BigDecimal value) {
            addCriterion("sell >", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sell >=", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellLessThan(BigDecimal value) {
            addCriterion("sell <", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sell <=", value, "sell");
            return (Criteria) this;
        }

        public Criteria andSellIn(List<BigDecimal> values) {
            addCriterion("sell in", values, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotIn(List<BigDecimal> values) {
            addCriterion("sell not in", values, "sell");
            return (Criteria) this;
        }

        public Criteria andSellBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell between", value1, value2, "sell");
            return (Criteria) this;
        }

        public Criteria andSellNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sell not between", value1, value2, "sell");
            return (Criteria) this;
        }

        public Criteria andDayLowIsNull() {
            addCriterion("day_low is null");
            return (Criteria) this;
        }

        public Criteria andDayLowIsNotNull() {
            addCriterion("day_low is not null");
            return (Criteria) this;
        }

        public Criteria andDayLowEqualTo(BigDecimal value) {
            addCriterion("day_low =", value, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowNotEqualTo(BigDecimal value) {
            addCriterion("day_low <>", value, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowGreaterThan(BigDecimal value) {
            addCriterion("day_low >", value, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("day_low >=", value, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowLessThan(BigDecimal value) {
            addCriterion("day_low <", value, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("day_low <=", value, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowIn(List<BigDecimal> values) {
            addCriterion("day_low in", values, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowNotIn(List<BigDecimal> values) {
            addCriterion("day_low not in", values, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_low between", value1, value2, "dayLow");
            return (Criteria) this;
        }

        public Criteria andDayLowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_low not between", value1, value2, "dayLow");
            return (Criteria) this;
        }

        public Criteria andCloseIsNull() {
            addCriterion("`close` is null");
            return (Criteria) this;
        }

        public Criteria andCloseIsNotNull() {
            addCriterion("`close` is not null");
            return (Criteria) this;
        }

        public Criteria andCloseEqualTo(BigDecimal value) {
            addCriterion("`close` =", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotEqualTo(BigDecimal value) {
            addCriterion("`close` <>", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThan(BigDecimal value) {
            addCriterion("`close` >", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`close` >=", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThan(BigDecimal value) {
            addCriterion("`close` <", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`close` <=", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseIn(List<BigDecimal> values) {
            addCriterion("`close` in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotIn(List<BigDecimal> values) {
            addCriterion("`close` not in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`close` between", value1, value2, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`close` not between", value1, value2, "close");
            return (Criteria) this;
        }

        public Criteria andDayHighIsNull() {
            addCriterion("day_high is null");
            return (Criteria) this;
        }

        public Criteria andDayHighIsNotNull() {
            addCriterion("day_high is not null");
            return (Criteria) this;
        }

        public Criteria andDayHighEqualTo(BigDecimal value) {
            addCriterion("day_high =", value, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighNotEqualTo(BigDecimal value) {
            addCriterion("day_high <>", value, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighGreaterThan(BigDecimal value) {
            addCriterion("day_high >", value, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("day_high >=", value, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighLessThan(BigDecimal value) {
            addCriterion("day_high <", value, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighLessThanOrEqualTo(BigDecimal value) {
            addCriterion("day_high <=", value, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighIn(List<BigDecimal> values) {
            addCriterion("day_high in", values, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighNotIn(List<BigDecimal> values) {
            addCriterion("day_high not in", values, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_high between", value1, value2, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andDayHighNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_high not between", value1, value2, "dayHigh");
            return (Criteria) this;
        }

        public Criteria andOpenIsNull() {
            addCriterion("`open` is null");
            return (Criteria) this;
        }

        public Criteria andOpenIsNotNull() {
            addCriterion("`open` is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEqualTo(BigDecimal value) {
            addCriterion("`open` =", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotEqualTo(BigDecimal value) {
            addCriterion("`open` <>", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThan(BigDecimal value) {
            addCriterion("`open` >", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`open` >=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThan(BigDecimal value) {
            addCriterion("`open` <", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`open` <=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenIn(List<BigDecimal> values) {
            addCriterion("`open` in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotIn(List<BigDecimal> values) {
            addCriterion("`open` not in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`open` between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`open` not between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("`timestamp` is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("`timestamp` is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Long value) {
            addCriterion("`timestamp` =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Long value) {
            addCriterion("`timestamp` <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Long value) {
            addCriterion("`timestamp` >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Long value) {
            addCriterion("`timestamp` >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Long value) {
            addCriterion("`timestamp` <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Long value) {
            addCriterion("`timestamp` <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Long> values) {
            addCriterion("`timestamp` in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Long> values) {
            addCriterion("`timestamp` not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Long value1, Long value2) {
            addCriterion("`timestamp` between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Long value1, Long value2) {
            addCriterion("`timestamp` not between", value1, value2, "timestamp");
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