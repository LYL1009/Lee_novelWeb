<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/7
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb", request.getContextPath());
    %>
    <%@ include file="include/include-head.jsp"%>

</head>
<body>
<%@ include file="include/include-nav.jsp"%>

<!--导航栏2-->
<div class="nav2">
    <div class="nav3">
        <ul>
            <li class="nav4 ${addClass.get("complete")}"><a href="${lee_novelWeb}/category?type=complete">全本小说</a></li>
            <li class="nav4 ${addClass.get("玄幻")}"><a href="${lee_novelWeb}/category?type=fantasy">玄幻小说</a></li>
            <li class="nav4 ${addClass.get("仙侠")}"><a href="${lee_novelWeb}/category?type=xianxia">仙侠小说</a></li>
            <li class="nav4 ${addClass.get("都市")}"><a href="${lee_novelWeb}/category?type=city">都市小说</a></li>
            <li class="nav4 ${addClass.get("历史")}"><a href="${lee_novelWeb}/category?type=history">历史小说</a></li>
            <li class="nav4 ${addClass.get("网游")}"><a href="${lee_novelWeb}/category?type=onlinegame">网游小说</a></li>
            <li class="nav4 ${addClass.get("科幻")}"><a href="${lee_novelWeb}/category?type=sciencefiction">科幻小说</a></li>
            <li class="nav4 ${addClass.get("恐怖")}"><a href="${lee_novelWeb}/category?type=terrorist">灵异小说</a></li>
            <li class="nav4 ${addClass.get("言情")}"><a href="${lee_novelWeb}/category?type=romance">言情小说</a></li>
            <li class="nav4 ${addClass.get("其他")}"><a href="${lee_novelWeb}/category?type=other">其他小说</a></li>
        </ul>
    </div>
    <div class="allbook">
        <div class="box" style="width: 770px;height: 205px;">
            <p class="titles">
                <b>全本小说网共有小说17931本，汇聚最优秀的海量小说，无限精彩任您挑选。</b>
                <span class="resetcondition">
                     <a href="${lee_novelWeb}/category?type=${type}">清除条件</a>
                 </span>
            </p>
            <div class="filter">
                <ul>
                    <li>
                        <span>排序：</span>
                        <a ${tag_id eq 0 or tag_id eq null ? "class='curr'" : ""}
                                href="${lee_novelWeb}/category?tag_id=0&type=${type}&words=${words}&is_complete=${is_complete}&is_reverse=${is_reverse}">默认</a>
                        <c:forEach items="${tags}" var="tag">
                            <a ${tag_id eq tag.tagId ? "class='curr'":""}
                                    href="${lee_novelWeb}/category?tag_id=${tag.tagId}&type=${type}&words=${words}&is_complete=${is_complete}&is_reverse=${is_reverse}">
                                    ${tag.tagName}
                            </a>
                        </c:forEach>
                    </li>
                    <li>
                        <span>字数：</span>
                        <a ${words eq 0 or words eq null ? "class='curr'":""}
                                href="${lee_novelWeb}/category?words=0&type=${type}&tag_id=${tag_id}&is_complete=${is_complete}&is_reverse=${is_reverse}">全部</a>
                        <a ${words eq 1 ? "class='curr'":""}
                                href="${lee_novelWeb}/category?words=1&type=${type}&tag_id=${tag_id}&is_complete=${is_complete}&is_reverse=${is_reverse}">30万以下</a>
                        <a ${words eq 2 ? "class='curr'":""}
                                href="${lee_novelWeb}/category?words=2&type=${type}&tag_id=${tag_id}&is_complete=${is_complete}&is_reverse=${is_reverse}">30万-50万</a>
                        <a ${words eq 3 ? "class='curr'":""}
                                href="${lee_novelWeb}/category?words=3&type=${type}&tag_id=${tag_id}&is_complete=${is_complete}&is_reverse=${is_reverse}">50万-100万</a>
                        <a ${words eq 4 ? "class='curr'":""}
                                href="${lee_novelWeb}/category?words=4&type=${type}&tag_id=${tag_id}&is_complete=${is_complete}&is_reverse=${is_reverse}">100万-200万</a>
                        <a ${words eq 5 ? "class='curr'":""}
                                href="${lee_novelWeb}/category?words=5&type=${type}&tag_id=${tag_id}&is_complete=${is_complete}&is_reverse=${is_reverse}">200万以上</a>
                    </li>
                    <li>
                        <span>状态：</span>
                        <c:if test="${addClass.get('complete') != null}">
                            <a href="#" class="curr">已完本</a>
                        </c:if>
                        <c:if test="${addClass.get('complete') == null}">
                            <a ${is_complete eq 0 or is_complete eq null ? "class='curr'":""}
                                    href="${lee_novelWeb}/category?is_complete=0&type=${type}&tag_id=${tag_id}&words=${words}&is_reverse=${is_reverse}">不限</a>
                            <a ${is_complete eq 1 ? "class='curr'":""}
                                    href="${lee_novelWeb}/category?is_complete=1&type=${type}&tag_id=${tag_id}&words=${words}&is_reverse=${is_reverse}">连载中</a>
                            <a ${is_complete eq 2 ? "class='curr'":""}
                                    href="${lee_novelWeb}/category?is_complete=2&type=${type}&tag_id=${tag_id}&words=${words}&is_reverse=${is_reverse}">已完本</a>
                        </c:if>
                    </li>
                    <li>
                        <span>顺序：</span>
                        <a ${is_reverse eq 0 or is_reverse eq null ? "class='curr'":""}
                                href="${lee_novelWeb}/category?is_reverse=0&type=${type}&tag_id=${tag_id}&words=${words}&is_complete=${is_complete}">正序</a>
                        <a ${is_reverse eq 1 ? "class='curr'":""}
                                href="${lee_novelWeb}/category?is_reverse=1&type=${type}&tag_id=${tag_id}&words=${words}&is_complete=${is_complete}">倒序</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="booklist">
            <p class="shownumber">当前每页显示16部小说</p>
            <div class="sitebox" id="frameContent">
                <ul class="rdc">
                    <c:forEach items="${categoryNovels}" var="categoryNovel">
                        <li class="exhibition">
                            <div class="listimage">
                                <a href="${lee_novelWeb}/chapter?novelId=${categoryNovel.novelId}" target="_blank">
                                    <img src="${categoryNovel.novelImage}" class="fantasyimg firstimg">
                                </a>
                            </div>
                            <div class="listimages">
                                <dl>
                                    <dt>
                                    <span class="titlename f4"><a class="colores" href="${lee_novelWeb}/chapter?novelId=${categoryNovel.novelId}"
                                                                  target="_blank">${categoryNovel.novelName}</a></span>
                                        <span class="uploadingtime">${UpdateTimes.get(categoryNovel.novelId)}</span>
                                    </dt>
                                    <dd class="authorname">作者：${categoryNovel.authorName}</dd>
                                    <dd class="synopsis">
                                            ${categoryNovel.introduction}
                                    </dd>
                                    <dd class="thelatestchapter">最新章节：<a class="colores hrefstyles"
                                           href="${lee_novelWeb}/detail?chapterId=${allNovelsNewUpdateChapterId.get(categoryNovel.novelId)}"
                                           target="_blank">${categoryNovel.newChapter}</a>
                                    </dd>
                                </dl>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="paging" id="pages"></div>
        </div>
    </div>
</div>

<!--d底部-->
<%@ include file="include/include-footer.jsp"%>

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
