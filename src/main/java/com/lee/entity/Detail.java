package com.lee.entity;

import java.util.Date;

public class Detail {
    private Integer detailId;

    private Integer novelId;

    private String chapterName;

    private Integer chapterId;

    private Integer words;

    private Date updateTime;

    private String content;

    public Detail(Integer detailId, Integer novelId, String chapterName, Integer chapterId, Integer words, Date updateTime) {
        this.detailId = detailId;
        this.novelId = novelId;
        this.chapterName = chapterName;
        this.chapterId = chapterId;
        this.words = words;
        this.updateTime = updateTime;
    }

    public Detail(Integer detailId, Integer novelId, String chapterName, Integer chapterId, Integer words, Date updateTime, String content) {
        this.detailId = detailId;
        this.novelId = novelId;
        this.chapterName = chapterName;
        this.chapterId = chapterId;
        this.words = words;
        this.updateTime = updateTime;
        this.content = content;
    }

    public Detail() {
        super();
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "Detail{" +
                "detailId=" + detailId +
                ", novelId=" + novelId +
                ", chapterName='" + chapterName + '\'' +
                ", chapterId=" + chapterId +
                ", words=" + words +
                ", updateTime=" + updateTime +
                ", content='" + content + '\'' +
                '}';
    }
}