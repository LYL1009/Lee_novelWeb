package com.lee.entity;

public class Bookcase {
    private Integer bookcaseId;

    private Integer novelId;

    private Integer userId;

    private Integer status;

    private Integer chapterId;

    public Bookcase(Integer bookcaseId, Integer novelId, Integer userId, Integer status, Integer chapterId) {
        this.bookcaseId = bookcaseId;
        this.novelId = novelId;
        this.userId = userId;
        this.status = status;
        this.chapterId = chapterId;
    }

    public Bookcase() {
        super();
    }

    public Integer getBookcaseId() {
        return bookcaseId;
    }

    public void setBookcaseId(Integer bookcaseId) {
        this.bookcaseId = bookcaseId;
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    @Override
    public String toString() {
        return "Bookcase{" +
                "bookcaseId=" + bookcaseId +
                ", novelId=" + novelId +
                ", userId=" + userId +
                ", status=" + status +
                ", chapterId=" + chapterId +
                '}';
    }
}