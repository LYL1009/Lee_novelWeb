<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/14
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("lee_novelWeb",request.getContextPath());
%>
<!--header头部-->
<div class="header">
    <div class="logo f1">
        <a href="${lee_novelWeb}/list" target="_blank">齐书网</a>
    </div>
    <div class="search ">
        <div class="search1 f1">
            <form action="${lee_novelWeb}/search" method="post">
                <input type="text" class="text" id="condition" name="condition" value="${condition}" placeholder="请输入小说名或作者名...">
                <button type="submit" class="btn">搜索</button>
            </form>
        </div>
        <div class="hotwrods f1">
            <a href="${lee_novelWeb}/chapter?novelId=13" target="_blank">一念永恒</a>
            <a href="${lee_novelWeb}/chapter?novelId=2" target="_blank">仙逆</a>
            <a href="${lee_novelWeb}/chapter?novelId=22" target="_blank">沧元图</a>
            <a href="${lee_novelWeb}/chapter?novelId=110" target="_blank">庆余年</a>
            <a href="${lee_novelWeb}/chapter?novelId=123" target="_blank">牧神记</a>
            <a href="${lee_novelWeb}/chapter?novelId=23" target="_blank">圣墟</a>
            <a href="${lee_novelWeb}/chapter?novelId=126" target="_blank">斗罗大陆</a>
        </div>
    </div>
    <c:if test="${sessionScope.user != null}">
        <div class="login f1">
            <div class="s">
                <span>Hi,${sessionScope.user.username}</span> | <a href="${lee_novelWeb}/logout">退出登录</a><br>
                <a href="${lee_novelWeb}/user/homepage">个人中心</a> | <a href="${lee_novelWeb}/user/myBookcase">我的书架</a><br>
            </div>
        </div>
    </c:if>
    <c:if test="${sessionScope.user == null}">
        <div class="login f1">
            <p class="s">
                <a class="loginhref f1 f2 f3" href="${lee_novelWeb}/toLogin">登录</a>
                <a class="register f1 f2 f3" href="${lee_novelWeb}/toLogin#register">注册</a>
            </p>
        </div>
    </c:if>
</div>

<!--nav导航栏-->
<div class="nav">
    <a href="${lee_novelWeb}/list">首页</a>
    <a href="${lee_novelWeb}/category?type=fantasy">玄幻奇幻</a>
    <a href="${lee_novelWeb}/category?type=xianxia">仙侠修真</a>
    <a href="${lee_novelWeb}/category?type=city">都市重生</a>
    <a href="${lee_novelWeb}/category?type=history">历史军事</a>
    <a href="${lee_novelWeb}/category?type=onlinegame">网游竞技</a>
    <a href="${lee_novelWeb}/category?type=sciencefiction">科幻次元</a>
    <a href="${lee_novelWeb}/category?type=terrorist">灵异恐怖</a>
    <a href="${lee_novelWeb}/category?type=romance">女生言情</a>
    <a href="${lee_novelWeb}/category?type=other">其他</a>
    <a href="${lee_novelWeb}/category?type=complete">全本</a>
    <a href="${lee_novelWeb}/category?type=rank">排行</a>
    <a href="${lee_novelWeb}/category?type=library">书库</a>
</div>
