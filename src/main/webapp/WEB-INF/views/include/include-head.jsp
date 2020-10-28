<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/14
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("lee_novelWeb",request.getContextPath());
%>
<!--引入facicon.ico网页图标-->
<link rel="shortcut icon" href="${lee_novelWeb}/static/img/favicon.ico" type="image/x-icon">
<!--引入初始化css文件-->
<link rel="stylesheet" type="text/css" href="${lee_novelWeb}/static/css/base.css">
<!--引入公共样式css文件-->
<link rel="stylesheet" type="text/css" href="${lee_novelWeb}/static/css/common.css">
<!--引入矢量图-->
<link rel="stylesheet" type="text/css" href="${lee_novelWeb}/static/css/iconfont/iconfont.css">
<!--引入媒体查询css文件-->
<link rel="stylesheet" type="text/css" href="${lee_novelWeb}/static/css/Media_queries.css">
<script src="${lee_novelWeb}/static/js/jquery-3.3.1.js" type="text/javascript"></script>
