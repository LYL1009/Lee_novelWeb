package com.lee.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NovelExample() {
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

        public Criteria andNovelNameIsNull() {
            addCriterion("novel_name is null");
            return (Criteria) this;
        }

        public Criteria andNovelNameIsNotNull() {
            addCriterion("novel_name is not null");
            return (Criteria) this;
        }

        public Criteria andNovelNameEqualTo(String value) {
            addCriterion("novel_name =", value, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameNotEqualTo(String value) {
            addCriterion("novel_name <>", value, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameGreaterThan(String value) {
            addCriterion("novel_name >", value, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameGreaterThanOrEqualTo(String value) {
            addCriterion("novel_name >=", value, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameLessThan(String value) {
            addCriterion("novel_name <", value, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameLessThanOrEqualTo(String value) {
            addCriterion("novel_name <=", value, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameLike(String value) {
            addCriterion("novel_name like", value, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameNotLike(String value) {
            addCriterion("novel_name not like", value, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameIn(List<String> values) {
            addCriterion("novel_name in", values, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameNotIn(List<String> values) {
            addCriterion("novel_name not in", values, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameBetween(String value1, String value2) {
            addCriterion("novel_name between", value1, value2, "novelName");
            return (Criteria) this;
        }

        public Criteria andNovelNameNotBetween(String value1, String value2) {
            addCriterion("novel_name not between", value1, value2, "novelName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNull() {
            addCriterion("author_name is null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIsNotNull() {
            addCriterion("author_name is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorNameEqualTo(String value) {
            addCriterion("author_name =", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotEqualTo(String value) {
            addCriterion("author_name <>", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThan(String value) {
            addCriterion("author_name >", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameGreaterThanOrEqualTo(String value) {
            addCriterion("author_name >=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThan(String value) {
            addCriterion("author_name <", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLessThanOrEqualTo(String value) {
            addCriterion("author_name <=", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameLike(String value) {
            addCriterion("author_name like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotLike(String value) {
            addCriterion("author_name not like", value, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameIn(List<String> values) {
            addCriterion("author_name in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotIn(List<String> values) {
            addCriterion("author_name not in", values, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameBetween(String value1, String value2) {
            addCriterion("author_name between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorNameNotBetween(String value1, String value2) {
            addCriterion("author_name not between", value1, value2, "authorName");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("author_id is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("author_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("author_id =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("author_id <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("author_id >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("author_id >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("author_id <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("author_id <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("author_id in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("author_id not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("author_id between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("author_id not between", value1, value2, "authorId");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andNewChapterIsNull() {
            addCriterion("new_chapter is null");
            return (Criteria) this;
        }

        public Criteria andNewChapterIsNotNull() {
            addCriterion("new_chapter is not null");
            return (Criteria) this;
        }

        public Criteria andNewChapterEqualTo(String value) {
            addCriterion("new_chapter =", value, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterNotEqualTo(String value) {
            addCriterion("new_chapter <>", value, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterGreaterThan(String value) {
            addCriterion("new_chapter >", value, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterGreaterThanOrEqualTo(String value) {
            addCriterion("new_chapter >=", value, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterLessThan(String value) {
            addCriterion("new_chapter <", value, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterLessThanOrEqualTo(String value) {
            addCriterion("new_chapter <=", value, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterLike(String value) {
            addCriterion("new_chapter like", value, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterNotLike(String value) {
            addCriterion("new_chapter not like", value, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterIn(List<String> values) {
            addCriterion("new_chapter in", values, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterNotIn(List<String> values) {
            addCriterion("new_chapter not in", values, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterBetween(String value1, String value2) {
            addCriterion("new_chapter between", value1, value2, "newChapter");
            return (Criteria) this;
        }

        public Criteria andNewChapterNotBetween(String value1, String value2) {
            addCriterion("new_chapter not between", value1, value2, "newChapter");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andNovelViewsIsNull() {
            addCriterion("novel_views is null");
            return (Criteria) this;
        }

        public Criteria andNovelViewsIsNotNull() {
            addCriterion("novel_views is not null");
            return (Criteria) this;
        }

        public Criteria andNovelViewsEqualTo(Integer value) {
            addCriterion("novel_views =", value, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsNotEqualTo(Integer value) {
            addCriterion("novel_views <>", value, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsGreaterThan(Integer value) {
            addCriterion("novel_views >", value, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsGreaterThanOrEqualTo(Integer value) {
            addCriterion("novel_views >=", value, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsLessThan(Integer value) {
            addCriterion("novel_views <", value, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsLessThanOrEqualTo(Integer value) {
            addCriterion("novel_views <=", value, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsIn(List<Integer> values) {
            addCriterion("novel_views in", values, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsNotIn(List<Integer> values) {
            addCriterion("novel_views not in", values, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsBetween(Integer value1, Integer value2) {
            addCriterion("novel_views between", value1, value2, "novelViews");
            return (Criteria) this;
        }

        public Criteria andNovelViewsNotBetween(Integer value1, Integer value2) {
            addCriterion("novel_views not between", value1, value2, "novelViews");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesIsNull() {
            addCriterion("recommend_votes is null");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesIsNotNull() {
            addCriterion("recommend_votes is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesEqualTo(Integer value) {
            addCriterion("recommend_votes =", value, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesNotEqualTo(Integer value) {
            addCriterion("recommend_votes <>", value, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesGreaterThan(Integer value) {
            addCriterion("recommend_votes >", value, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_votes >=", value, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesLessThan(Integer value) {
            addCriterion("recommend_votes <", value, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_votes <=", value, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesIn(List<Integer> values) {
            addCriterion("recommend_votes in", values, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesNotIn(List<Integer> values) {
            addCriterion("recommend_votes not in", values, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesBetween(Integer value1, Integer value2) {
            addCriterion("recommend_votes between", value1, value2, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andRecommendVotesNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_votes not between", value1, value2, "recommendVotes");
            return (Criteria) this;
        }

        public Criteria andCollectionIsNull() {
            addCriterion("collection is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIsNotNull() {
            addCriterion("collection is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionEqualTo(Integer value) {
            addCriterion("collection =", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotEqualTo(Integer value) {
            addCriterion("collection <>", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionGreaterThan(Integer value) {
            addCriterion("collection >", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("collection >=", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionLessThan(Integer value) {
            addCriterion("collection <", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionLessThanOrEqualTo(Integer value) {
            addCriterion("collection <=", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionIn(List<Integer> values) {
            addCriterion("collection in", values, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotIn(List<Integer> values) {
            addCriterion("collection not in", values, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionBetween(Integer value1, Integer value2) {
            addCriterion("collection between", value1, value2, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotBetween(Integer value1, Integer value2) {
            addCriterion("collection not between", value1, value2, "collection");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andTotalWordsIsNull() {
            addCriterion("total_words is null");
            return (Criteria) this;
        }

        public Criteria andTotalWordsIsNotNull() {
            addCriterion("total_words is not null");
            return (Criteria) this;
        }

        public Criteria andTotalWordsEqualTo(Integer value) {
            addCriterion("total_words =", value, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsNotEqualTo(Integer value) {
            addCriterion("total_words <>", value, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsGreaterThan(Integer value) {
            addCriterion("total_words >", value, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_words >=", value, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsLessThan(Integer value) {
            addCriterion("total_words <", value, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsLessThanOrEqualTo(Integer value) {
            addCriterion("total_words <=", value, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsIn(List<Integer> values) {
            addCriterion("total_words in", values, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsNotIn(List<Integer> values) {
            addCriterion("total_words not in", values, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsBetween(Integer value1, Integer value2) {
            addCriterion("total_words between", value1, value2, "totalWords");
            return (Criteria) this;
        }

        public Criteria andTotalWordsNotBetween(Integer value1, Integer value2) {
            addCriterion("total_words not between", value1, value2, "totalWords");
            return (Criteria) this;
        }

        public Criteria andNovelImageIsNull() {
            addCriterion("novel_image is null");
            return (Criteria) this;
        }

        public Criteria andNovelImageIsNotNull() {
            addCriterion("novel_image is not null");
            return (Criteria) this;
        }

        public Criteria andNovelImageEqualTo(String value) {
            addCriterion("novel_image =", value, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageNotEqualTo(String value) {
            addCriterion("novel_image <>", value, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageGreaterThan(String value) {
            addCriterion("novel_image >", value, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageGreaterThanOrEqualTo(String value) {
            addCriterion("novel_image >=", value, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageLessThan(String value) {
            addCriterion("novel_image <", value, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageLessThanOrEqualTo(String value) {
            addCriterion("novel_image <=", value, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageLike(String value) {
            addCriterion("novel_image like", value, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageNotLike(String value) {
            addCriterion("novel_image not like", value, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageIn(List<String> values) {
            addCriterion("novel_image in", values, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageNotIn(List<String> values) {
            addCriterion("novel_image not in", values, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageBetween(String value1, String value2) {
            addCriterion("novel_image between", value1, value2, "novelImage");
            return (Criteria) this;
        }

        public Criteria andNovelImageNotBetween(String value1, String value2) {
            addCriterion("novel_image not between", value1, value2, "novelImage");
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