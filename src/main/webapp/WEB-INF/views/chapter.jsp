<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/13
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb", request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${lee_novelWeb}/static/css/biquge.css"/>
    <%@ include file="include/include-head.jsp" %>
    <script type="text/javascript" src="${lee_novelWeb}/static/js/bqg.js"></script>
    <script type="text/javascript">
        function addBookcase() {
            $.ajax({
                url: "${lee_novelWeb}/addBookcase",
                type: "GET",
                data: {
                    novelId:${novel.novelId},
                    chapterId: ""
                },
                dataType: "text",
                success: function (data) {
                    if (data == 'success') {
                        alert("添加成功");
                    } else if (data == 'error') {
                        alert("该书已被添加");
                    } else if (data == 'false') {
                        alert("添加失败");
                    } else {
                        alert("您无权添加本书，请先登录");
                    }
                }
            });
        }

        function vote() {
            alert("投票成功");
        }
    </script>
</head>
<body>
<%@ include file="include/include-nav.jsp" %>

<div class="box_con">
    <div class="con_top">
        <div id="bdshare" class="bdshare_b" style="line-height: 12px;">
            <img src="http://bdimg.share.baidu.com/static/images/type-button-7.jpg"/><a class="shareCount"></a></div>
        <a href="${lee_novelWeb}/list">齐书网</a> &gt; <a href="${lee_novelWeb}/category?type=${type}">${novel.type}小说</a>
        &gt; ${novel.novelName}最新章节目录
    </div>
    <div id="maininfo">
        <div id="info">
            <h1>${novel.novelName}</h1>
            <p>作&nbsp;&nbsp;&nbsp;&nbsp;者：${novel.authorName}</p>
            <p>动&nbsp;&nbsp;&nbsp;&nbsp;作：<a href="#" onclick="addBookcase()">加入书架</a>,<a href="#" onClick="vote()">投推荐票</a>
            <p>最后更新：${novel_update_time}</p>
            <p>最新章节：<a href="${lee_novelWeb}/detail?chapterId=${newUpdateChapterId}">${novel.newChapter}</a></p>
        </div>
        <div id="intro">
            <p><font style="color:#0066FF"><a href='#' target='_blank'>手机阅读《${novel.novelName}》无弹窗纯文字全文免费阅读</a></font>
            </p>
            <p> ${novel.introduction}</p>
        </div>
    </div>
    <div id="sidebar">
        <div id="fmimg"><img alt="雪中悍刀行" src="${novel.novelImage}" width="120"
                             height="150"/><span class="b"></span></div>
    </div>
    <div id="listtj">&nbsp;推荐阅读：
        <a href="${lee_novelWeb}/chapter?novelId=1">雪中悍刀行</a>、
        <a href="${lee_novelWeb}/chapter?novelId=123">牧神记</a>、
        <a href="${lee_novelWeb}/chapter?novelId=2">仙逆</a>、
        <a href="${lee_novelWeb}/chapter?novelId=3">斗破苍穹</a>、
        <a href="${lee_novelWeb}/chapter?novelId=4">官途</a>、
        <a href="${lee_novelWeb}/chapter?novelId=5">天火大道</a>、
        <a href="${lee_novelWeb}/chapter?novelId=6">三生三世十里桃花</a>、
        <a href="${lee_novelWeb}/chapter?novelId=7">万古仙穹</a>、
        <a href="${lee_novelWeb}/chapter?novelId=9">唐砖</a>、
        <a href="${lee_novelWeb}/chapter?novelId=10">斩龙</a>、
        <a href="${lee_novelWeb}/chapter?novelId=16">逆天邪神</a>、
        <a href="${lee_novelWeb}/chapter?novelId=21">元尊</a>、
        <a href="${lee_novelWeb}/chapter?novelId=24">斗罗大陆Ⅳ终极斗罗</a>、
        <a href="${lee_novelWeb}/chapter?novelId=23">圣墟</a>
    </div>
</div>

<div class="dahengfu">
    <script type="text/javascript">list_mid();</script>
</div>

<div class="box_con">
    <div id="list">
        <dl>
            <c:forEach items="${chapters}" var="chapter">
                <dd><a href='${lee_novelWeb}/detail?chapterId=${chapter.chapterId}'>${chapter.chapterName}</a></dd>
            </c:forEach>
        </dl>
    </div>
</div>

<div class="dahengfu">
    <script type="text/javascript">list_bot();</script>
</div>

<%@ include file="include/include-footer.jsp" %>

<script type="text/javascript">
    (function () {
        var bp = document.createElement('script');
        bp.src = '//push.zhanzhang.baidu.com/push.js';
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(bp, s);
    })();
</script>
</body>
</html>
