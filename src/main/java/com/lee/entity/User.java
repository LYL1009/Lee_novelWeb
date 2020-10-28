package com.lee.entity;

public class User {
    private Integer userId;

    private String username;

    private String password;

    private Integer gender;

    private String email;

    private String qq;

    private String phone;

    private String info;

    private Integer recommend;

    public User(Integer userId, Integer gender, String email, String qq, String phone, String info) {
        this.userId = userId;
        this.gender = gender;
        this.email = email;
        this.qq = qq;
        this.phone = phone;
        this.info = info;
    }

    public User(Integer userId, String username, String password, Integer gender, String email, String qq, String phone, String info, Integer recommend) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.qq = qq;
        this.phone = phone;
        this.info = info;
        this.recommend = recommend;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}