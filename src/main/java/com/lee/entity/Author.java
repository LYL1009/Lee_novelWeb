package com.lee.entity;

public class Author {
    private Integer authorId;

    private String authorName;

    private Integer userId;

    public Author(Integer authorId, String authorName, Integer userId) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.userId = userId;
    }

    public Author() {
        super();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}