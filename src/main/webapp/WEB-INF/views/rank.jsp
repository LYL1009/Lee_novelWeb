<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/11
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb", request.getContextPath());
    %>
    <%@include file="include/include-head.jsp"%>
</head>
<body>
<%@include file="include/include-nav.jsp"%>

<!--排行栏-->
<div class="topbar">
    <p class="userlogin"><b>热门排行榜：</b></p>
    <div class="topborder">
        <ul class="topimglist">
            <c:forEach items="${novelsByViewsTop}" var="novel">
                <li class="toplist">
                    <div class="topimg">
                        <a href="${lee_novelWeb}/chapter?novelId=${novel.novelId}" target="_blank">
                            <img src="${novel.novelImage}" class="topimges img-topimgesfirst">
                        </a>
                    </div>
                    <div class="topcontent">
                        <h3>
                            <a class="fictionname" href="${lee_novelWeb}/chapter?novelId=${novel.novelId}" target="_blank">${novel.novelName}</a>
                        </h3>
                        <p>
                            <span>作者：${novel.authorName}</span><br/>
                            <span class="newest f5">最新：
                                <a class="fictionname"
                                   href="${lee_novelWeb}/detail?chapterId=${allNovelsNewUpdateChapterId.get(novel.novelId)}"
                                   target="_blank">${novel.newChapter}</a>
                            </span>
                        </p>
                        <p class="topbookcontent f5">
                            ${novel.introduction}
                        </p>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="otherlists">
        <ul class="toptitle">
            <li class="titlecontent">
                <span class="pubs styleone">文章名称</span>
                <span class="pubs styleone">最新章节</span>
                <span class="pubs stylethour">作者</span>
                <span class="pubs styletwo">更新时间</span>
                <span class="pubs styletwo">浏览量</span>
                <span class="pubs styletwo">写作状态</span>
            </li>
        </ul>
    </div>
    <div class="otherlistes" id="frameContent">
        <ul class="toptitles">
            <c:forEach items="${novelList}" var="novel">
                <li class="titlecontents">
                    <span class="pubes f4 styleone stylefour"><a href="${lee_novelWeb}/chapter?novelId=${novel.novelId}">${novel.novelName}</a></span>
                    <span class="pubes f4 styleone stylefour">
                        <a href="${lee_novelWeb}/detail?chapterId=${allNovelsNewUpdateChapterId.get(novel.novelId)}">
                                ${novel.newChapter}</a>
                    </span>
                    <span class="pubes f4 stylethour stylefour">${novel.authorName}</span>
                    <span class="pubes styletwo">${UpdateTimes.get(novel.novelId)}</span>
                    <span class="pubes styletwo">${novel.novelViews}</span>
                    <span class="pubes styletwo">
                        <c:if test="${novel.status==0}">
                            连载中
                        </c:if>
                        <c:if test="${novel.status==1}">
                            完结
                        </c:if>
                    </span>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="pageing" id="pages"></div>
</div>

<%@include file="include/include-footer.jsp"%>

<!--引入js文件-->
<script charset="UTF-8" type="text/javascript">
    var obj = document.getElementById("frameContent");  //获取内容层
    var pages = document.getElementById("pages");         //获取翻页层
    var pgindex = 1;                                      //当前页
    window.onload = function ()                             //重写窗体加载的事件
    {
        var allpages = Math.ceil(parseInt(obj.scrollHeight) / parseInt(obj.offsetHeight));//获取页面数量
        pages.innerHTML = "<b>共" + allpages + "页</b> ";     //输出页面数量
        pages.innerHTML += "<a href=\"javascript:gotopage('-1');\">上一页&nbsp</a>";
        for (var i = 1; i <= allpages; i++) {
            pages.innerHTML += "<a href=\"javascript:showPage('" + i + "');\">第" + i + "页</a> ";
//循环输出第几页
        }
        pages.innerHTML += "<a href=\"javascript:gotopage('1');\">下一页</a>";
    };

    function gotopage(value) {
        try {
            value == "-1" ? showPage(pgindex - 1) : showPage(pgindex + 1);
        } catch (e) {

        }
    }

    function showPage(pageINdex) {
        obj.scrollTop = (pageINdex - 1) * parseInt(obj.offsetHeight);                                                                  //根据高度，输出指定的页
        pgindex = pageINdex;
    }

</script>
</body>
</html>
