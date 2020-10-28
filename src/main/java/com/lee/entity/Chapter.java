package com.lee.entity;

import java.util.Date;

public class Chapter {
    private Integer chapterId;

    private Integer novelId;

    private String chapterName;

    private String path;

    private Integer words;

    private Date updateTime;

    private Integer sequenceId;

    public Chapter(Integer chapterId, Integer novelId, String chapterName, String path, Integer words, Date updateTime, Integer sequenceId) {
        this.chapterId = chapterId;
        this.novelId = novelId;
        this.chapterName = chapterName;
        this.path = path;
        this.words = words;
        this.updateTime = updateTime;
        this.sequenceId = sequenceId;
    }

    public Chapter() {
        super();
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
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

    public Integer getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Integer sequenceId) {
        this.sequenceId = sequenceId;
    }
}