package com.lee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andHistoryIdIsNull() {
            addCriterion("history_id is null");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIsNotNull() {
            addCriterion("history_id is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryIdEqualTo(Integer value) {
            addCriterion("history_id =", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotEqualTo(Integer value) {
            addCriterion("history_id <>", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdGreaterThan(Integer value) {
            addCriterion("history_id >", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("history_id >=", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLessThan(Integer value) {
            addCriterion("history_id <", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("history_id <=", value, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdIn(List<Integer> values) {
            addCriterion("history_id in", values, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotIn(List<Integer> values) {
            addCriterion("history_id not in", values, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdBetween(Integer value1, Integer value2) {
            addCriterion("history_id between", value1, value2, "historyId");
            return (Criteria) this;
        }

        public Criteria andHistoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("history_id not between", value1, value2, "historyId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andNovelIdIsNull() {
            addCriterion("novel_id is null");
            return (Criteria) this;
        }

        public Criteria andNovelIdIsNotNull() {
            addCriterion("novel_id is not null");
            return (Criteria) this;
        }

        public Criteria andNovelIdEqualTo(Integer value) {
            addCriterion("novel_id =", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdNotEqualTo(Integer value) {
            addCriterion("novel_id <>", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdGreaterThan(Integer value) {
            addCriterion("novel_id >", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("novel_id >=", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdLessThan(Integer value) {
            addCriterion("novel_id <", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdLessThanOrEqualTo(Integer value) {
            addCriterion("novel_id <=", value, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdIn(List<Integer> values) {
            addCriterion("novel_id in", values, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdNotIn(List<Integer> values) {
            addCriterion("novel_id not in", values, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdBetween(Integer value1, Integer value2) {
            addCriterion("novel_id between", value1, value2, "novelId");
            return (Criteria) this;
        }

        public Criteria andNovelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("novel_id not between", value1, value2, "novelId");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNull() {
            addCriterion("chapter_id is null");
            return (Criteria) this;
        }

        public Criteria andChapterIdIsNotNull() {
            addCriterion("chapter_id is not null");
            return (Criteria) this;
        }

        public Criteria andChapterIdEqualTo(Integer value) {
            addCriterion("chapter_id =", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotEqualTo(Integer value) {
            addCriterion("chapter_id <>", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThan(Integer value) {
            addCriterion("chapter_id >", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapter_id >=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThan(Integer value) {
            addCriterion("chapter_id <", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdLessThanOrEqualTo(Integer value) {
            addCriterion("chapter_id <=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdIn(List<Integer> values) {
            addCriterion("chapter_id in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotIn(List<Integer> values) {
            addCriterion("chapter_id not in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdBetween(Integer value1, Integer value2) {
            addCriterion("chapter_id between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chapter_id not between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeIsNull() {
            addCriterion("last_read_time is null");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeIsNotNull() {
            addCriterion("last_read_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeEqualTo(Date value) {
            addCriterion("last_read_time =", value, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeNotEqualTo(Date value) {
            addCriterion("last_read_time <>", value, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeGreaterThan(Date value) {
            addCriterion("last_read_time >", value, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_read_time >=", value, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeLessThan(Date value) {
            addCriterion("last_read_time <", value, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_read_time <=", value, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeIn(List<Date> values) {
            addCriterion("last_read_time in", values, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeNotIn(List<Date> values) {
            addCriterion("last_read_time not in", values, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeBetween(Date value1, Date value2) {
            addCriterion("last_read_time between", value1, value2, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andLastReadTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_read_time not between", value1, value2, "lastReadTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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