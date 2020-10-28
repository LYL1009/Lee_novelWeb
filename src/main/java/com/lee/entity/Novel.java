package com.lee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lee.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Novel {
    private Integer novelId;

    private String novelName;

    private String authorName;

    private Integer authorId;

    private Integer status;

    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private String newChapter;

    private String introduction;

    private Integer novelViews;

    private Integer recommendVotes;

    private Integer collection;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date releaseTime;

    private Integer totalWords;

    private String novelImage;

    public Novel(Integer novelId, String novelName, String authorName, Integer authorId, Integer status, String type, Date updateTime, String newChapter, String introduction, Integer novelViews, Integer recommendVotes, Integer collection, Date releaseTime, Integer totalWords, String novelImage) {
        this.novelId = novelId;
        this.novelName = novelName;
        this.authorName = authorName;
        this.authorId = authorId;
        this.status = status;
        this.type = type;
        this.updateTime = updateTime;
        this.newChapter = newChapter;
        this.introduction = introduction;
        this.novelViews = novelViews;
        this.recommendVotes = recommendVotes;
        this.collection = collection;
        this.releaseTime = releaseTime;
        this.totalWords = totalWords;
        this.novelImage = novelImage;
    }

    public Novel() {
        super();
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName == null ? null : novelName.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getNewChapter() {
        return newChapter;
    }

    public void setNewChapter(String newChapter) {
        this.newChapter = newChapter == null ? null : newChapter.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getNovelViews() {
        return novelViews;
    }

    public void setNovelViews(Integer novelViews) {
        this.novelViews = novelViews;
    }

    public Integer getRecommendVotes() {
        return recommendVotes;
    }

    public void setRecommendVotes(Integer recommendVotes) {
        this.recommendVotes = recommendVotes;
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public java.util.Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(java.util.Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(Integer totalWords) {
        this.totalWords = totalWords;
    }

    public String getNovelImage() {
        return novelImage;
    }

    public void setNovelImage(String novelImage) {
        this.novelImage = novelImage == null ? null : novelImage.trim();
    }

    @Override
    public String toString() {
        return "Novel{" +
                "novelId=" + novelId +
                ", novelName='" + novelName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorId=" + authorId +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", updateTime=" + updateTime +
                ", newChapter='" + newChapter + '\'' +
                ", introduction='" + introduction + '\'' +
                ", novelViews=" + novelViews +
                ", recommendVotes=" + recommendVotes +
                ", collection=" + collection +
                ", releaseTime=" + releaseTime +
                ", totalWords=" + totalWords +
                ", novelImage='" + novelImage + '\'' +
                '}';
    }
}