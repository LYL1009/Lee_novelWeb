package com.lee.entity;

import java.util.Date;

public class History {
    private Integer historyId;

    private Integer userId;

    private Integer novelId;

    private Integer chapterId;

    private Date lastReadTime;

    private Integer status;

    public History(Integer historyId, Integer userId, Integer novelId, Integer chapterId, Date lastReadTime, Integer status) {
        this.historyId = historyId;
        this.userId = userId;
        this.novelId = novelId;
        this.chapterId = chapterId;
        this.lastReadTime = lastReadTime;
        this.status = status;
    }

    public History() {
        super();
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Date getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(Date lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}