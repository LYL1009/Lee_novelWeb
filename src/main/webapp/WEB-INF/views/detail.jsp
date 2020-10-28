<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/13
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta http-equiv="Cache-Control" content="no-transform"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb", request.getContextPath());
    %>
    <!--引入facicon.ico网页图标-->
    <link rel="shortcut icon" href="${lee_novelWeb}/static/img/favicon.ico" type="image/x-icon">
    <!--引入初始化css文件-->
    <link rel="stylesheet" type="text/css" href="${lee_novelWeb}/static/css/base.css">
    <link rel="stylesheet" type="text/css" href="${lee_novelWeb}/static/css/biquge.css"/>
    <script type="text/javascript" src="${lee_novelWeb}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${lee_novelWeb}/static/js/bqg.js"></script>
    <script type="text/javascript">
        var preview_page = "6568492.html";
        var next_page = "index.html";
        var index_page = "index.html";
        var article_id = "745";
        var chapter_id = "7078525";

        function jumpPage() {
            var event = document.all ? window.event : arguments[0];
            if (event.keyCode == 37) document.location = preview_page;
            if (event.keyCode == 39) document.location = next_page;
            if (event.keyCode == 13) document.location = index_page;
        }

        function addBookcase_detail() {
            if (${detail != null}) {
                $.ajax({
                    url: "${lee_novelWeb}/addBookcase",
                    type: "GET",
                    data: {
                        novelId:${detail.novelId},
                        chapterId:${detail.chapterId}
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
        }

        function vote_detail() {
            alert("投票成功");
        }
    </script>
</head>
<body>
<%@include file="include/include-nav.jsp" %>

<div class="content_read">
    <c:if test="${detail == null}">
        <div class="box_con" style="text-align: center">
            <h1>网站未获取到该章资源，请敬请谅解</h1>
        </div>
    </c:if>
    <c:if test="${detail != null}">
        <div class="box_con">
            <div class="con_top">
                <script type="text/javascript">textselect();</script>
                <a href="${lee_novelWeb}/list">齐书网</a> &gt;
                <a href="${lee_novelWeb}/category?type=${type}">${novel.type}小说</a> &gt;
                <a href="${lee_novelWeb}/chapter?novelId=${novel.novelId}">${novel.novelName}</a>
                &gt; ${detail.chapterName}
            </div>
            <div class="bookname">
                <h1>${detail.chapterName}</h1>
                <div class="bottem1">
                    <a href="#" onclick="vote_detail()">投推荐票</a>
                    <a href="${lee_novelWeb}/turnPage?chapterId=${detail.chapterId}&novelId=${detail.novelId}&turn=${0}">上一章</a>
                    &larr; <a href="${lee_novelWeb}/chapter?novelId=${detail.novelId}">章节目录</a> &rarr;
                    <a href="${lee_novelWeb}/turnPage?chapterId=${detail.chapterId}&novelId=${detail.novelId}&turn=${1}">下一章</a>
                    <a href="#" onclick="addBookcase_detail()">加入书架</a>
                </div>
                <div id="listtj" style="border-bottom: 1px dashed #88C6E5;text-align: center;">&nbsp;推荐阅读：
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
            <table style="width:100%; text-align:center;">
                <tr>
                    <td>
                        <script>read_1_1();</script>
                    </td>
                    <td>
                        <script>read_1_2();</script>
                    </td>
                    <td>
                        <script>read_1_3();</script>
                    </td>
                </tr>
            </table>
            <div id="content" style="font-size: 16px;">
                    ${detail.content}
            </div>
            <!--<script>read3();</script>
            <script>bdshare();</script>-->
            <div class="bottem2">
                <a href="#" onclick="vote_detail()">投推荐票</a>
                <a href="${lee_novelWeb}/turnPage?chapterId=${detail.chapterId}&novelId=${detail.novelId}&turn=${0}">上一章</a>
                &larr; <a href="${lee_novelWeb}/chapter?novelId=${detail.novelId}">章节目录</a> &rarr;
                <a href="${lee_novelWeb}/turnPage?chapterId=${detail.chapterId}&novelId=${detail.novelId}&turn=${1}">下一章</a>
                <a href="#" onclick="addBookcase_detail()">加入书架</a>
            </div>
            <script>read4();</script>
            <div id="hm_t_54219"></div>
        </div>
    </c:if>
</div>

<%@include file="include/include-footer.jsp" %>

<script charset="utf-8" src="http://www.baidu.com/js/opensug.js"></script>
<script>
    (function () {
        var bp = document.createElement('script');
        bp.src = '//push.zhanzhang.baidu.com/push.js';
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(bp, s);
    })();
</script>
</body>
</html>
