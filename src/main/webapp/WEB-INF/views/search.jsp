<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/13
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb", request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${lee_novelWeb}/static/css/biquge.css"/>
    <%@include file="include/include-head.jsp"%>
    <script type="text/javascript" src="${lee_novelWeb}/static/js/bqg.js"></script>
    <script language="javascript" type="text/javascript">
        var bookid = "745";
        var booktitle = "雪中悍刀行";
    </script>
</head>
<body>
<%@ include file="include/include-nav.jsp"%>

<%-- 搜索框 --%>
<div class="box_con">
    <c:if test="${searchNovels.size() < maxSize and searchNovels.size() > 0}">
        <div class="con_top">
            <div id="bdshare" class="bdshare_b" style="line-height: 12px;"><a class="shareCount"></a></div>
            <h2>搜索“${condition}”的结果</h2>
        </div>

        <c:forEach items="${searchNovels}" var="searchNovel" varStatus="status">
            <div class="bookbox">
                <div class="p10"><span class="num">${status.index+1}</span>
                    <div class="bookinfo"><h4 class="bookname"
                                              style="zoom: 1;margin: 0;padding: 0;font-size: 16px;text-indent: 0;line-height: 28px;">
                        <a href="${lee_novelWeb}/chapter?novelId=${searchNovel.novelId}">${searchNovel.novelName}</a></h4>
                        <div class="cat" style="font-size: 14px;">分类：${searchNovel.type}</div>
                        <div class="author">作者：${searchNovel.authorName}</div>
                        <div class="update" style="font-size: 14px;color: #888;"><span>最新：</span>
                            <a href="${lee_novelWeb}/detail?chapterId=${allNovelsNewUpdateChapterId.get(searchNovel.novelId)}">
                                    ${searchNovel.newChapter}</a></div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>

    <c:if test="${searchNovels.size() >= maxSize or searchNovels.size() <= 0}">
        <div class="no-result-wrap" data-l1="3" style="margin-bottom: 30px;padding-bottom: 30px;text-align: center;">
            <div class="no-result-img" style="padding: 47px 0 13px;">
                <span class="no-data-img"
                      style="display: block;width: 142px;height: 100px;margin: 0 auto;background: url(https://qidian.gtimg.com/qd/images/common/big_wu.ba1a4.png) no-repeat;"></span>
            </div>
            <h3 style="font: 16px/24px PingFangSC-Regular,HelveticaNeue-Light,'Helvetica Neue Light','Microsoft YaHei',sans-serif;">
                没有输入有效关键词</h3>
            <p style="font: 14px/24px PingFangSC-Regular,'-apple-system',Simsun;color: #a6a6a6;">
                你也可以去<a class="blue" style="margin: 0 5px;color: #3f5a93;" href="${lee_novelWeb}/list" data-eid="qd_S14">首页</a>找书
            </p>
        </div>
    </c:if>
</div>

<%@ include file="include/include-footer.jsp"%>
</body>
</html>
