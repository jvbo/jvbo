package site.jvbo.fun.okex.dao.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OkexFutureTickerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OkexFutureTickerExample() {
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

        public Criteria andFutureTickerIdIsNull() {
            addCriterion("future_ticker_id is null");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdIsNotNull() {
            addCriterion("future_ticker_id is not null");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdEqualTo(Long value) {
            addCriterion("future_ticker_id =", value, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdNotEqualTo(Long value) {
            addCriterion("future_ticker_id <>", value, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdGreaterThan(Long value) {
            addCriterion("future_ticker_id >", value, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("future_ticker_id >=", value, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdLessThan(Long value) {
            addCriterion("future_ticker_id <", value, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdLessThanOrEqualTo(Long value) {
            addCriterion("future_ticker_id <=", value, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdIn(List<Long> values) {
            addCriterion("future_ticker_id in", values, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdNotIn(List<Long> values) {
            addCriterion("future_ticker_id not in", values, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdBetween(Long value1, Long value2) {
            addCriterion("future_ticker_id between", value1, value2, "futureTickerId");
            return (Criteria) this;
        }

        public Criteria andFutureTickerIdNotBetween(Long value1, Long value2) {
            addCriterion("future_ticker_id not between", value1, value2, "futureTickerId");
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

        public Criteria andLimitLowIsNull() {
            addCriterion("limit_low is null");
            return (Criteria) this;
        }

        public Criteria andLimitLowIsNotNull() {
            addCriterion("limit_low is not null");
            return (Criteria) this;
        }

        public Criteria andLimitLowEqualTo(BigDecimal value) {
            addCriterion("limit_low =", value, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowNotEqualTo(BigDecimal value) {
            addCriterion("limit_low <>", value, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowGreaterThan(BigDecimal value) {
            addCriterion("limit_low >", value, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_low >=", value, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowLessThan(BigDecimal value) {
            addCriterion("limit_low <", value, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_low <=", value, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowIn(List<BigDecimal> values) {
            addCriterion("limit_low in", values, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowNotIn(List<BigDecimal> values) {
            addCriterion("limit_low not in", values, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_low between", value1, value2, "limitLow");
            return (Criteria) this;
        }

        public Criteria andLimitLowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_low not between", value1, value2, "limitLow");
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

        public Criteria andHoldAmountIsNull() {
            addCriterion("hold_amount is null");
            return (Criteria) this;
        }

        public Criteria andHoldAmountIsNotNull() {
            addCriterion("hold_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHoldAmountEqualTo(BigDecimal value) {
            addCriterion("hold_amount =", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountNotEqualTo(BigDecimal value) {
            addCriterion("hold_amount <>", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountGreaterThan(BigDecimal value) {
            addCriterion("hold_amount >", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hold_amount >=", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountLessThan(BigDecimal value) {
            addCriterion("hold_amount <", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hold_amount <=", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountIn(List<BigDecimal> values) {
            addCriterion("hold_amount in", values, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountNotIn(List<BigDecimal> values) {
            addCriterion("hold_amount not in", values, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hold_amount between", value1, value2, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hold_amount not between", value1, value2, "holdAmount");
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

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(Long value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(Long value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(Long value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(Long value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Long value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<Long> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<Long> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(Long value1, Long value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(Long value1, Long value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andUnitAmountIsNull() {
            addCriterion("unit_amount is null");
            return (Criteria) this;
        }

        public Criteria andUnitAmountIsNotNull() {
            addCriterion("unit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAmountEqualTo(BigDecimal value) {
            addCriterion("unit_amount =", value, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountNotEqualTo(BigDecimal value) {
            addCriterion("unit_amount <>", value, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountGreaterThan(BigDecimal value) {
            addCriterion("unit_amount >", value, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_amount >=", value, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountLessThan(BigDecimal value) {
            addCriterion("unit_amount <", value, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_amount <=", value, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountIn(List<BigDecimal> values) {
            addCriterion("unit_amount in", values, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountNotIn(List<BigDecimal> values) {
            addCriterion("unit_amount not in", values, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_amount between", value1, value2, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andUnitAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_amount not between", value1, value2, "unitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitHighIsNull() {
            addCriterion("limit_high is null");
            return (Criteria) this;
        }

        public Criteria andLimitHighIsNotNull() {
            addCriterion("limit_high is not null");
            return (Criteria) this;
        }

        public Criteria andLimitHighEqualTo(BigDecimal value) {
            addCriterion("limit_high =", value, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighNotEqualTo(BigDecimal value) {
            addCriterion("limit_high <>", value, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighGreaterThan(BigDecimal value) {
            addCriterion("limit_high >", value, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_high >=", value, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighLessThan(BigDecimal value) {
            addCriterion("limit_high <", value, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighLessThanOrEqualTo(BigDecimal value) {
            addCriterion("limit_high <=", value, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighIn(List<BigDecimal> values) {
            addCriterion("limit_high in", values, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighNotIn(List<BigDecimal> values) {
            addCriterion("limit_high not in", values, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_high between", value1, value2, "limitHigh");
            return (Criteria) this;
        }

        public Criteria andLimitHighNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("limit_high not between", value1, value2, "limitHigh");
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