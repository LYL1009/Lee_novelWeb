<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/7
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb", request.getContextPath());
    %>
    <%@include file="include/include-head.jsp"%>
</head>
<body>
<%@ include file="include/include-nav.jsp"%>

<!--排行及推荐-->
<div class="music_top">
    <div class="ranking">
        <p class="rankintitle">全本小说排行榜</p>
        <ul class="rankcontent">
            <c:forEach items="${novels}" var="novel">
                <li>
                    <span class="bookname">
                        <a href="${lee_novelWeb}/chapter?novelId=${novel.novelId}"
                           target="_blank">${novel.novelName}</a>
                    </span>
                    <span class="author">${novel.authorName}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="recommend">
        <p class="rankintitles">经典完本小说推荐</p>
        <p class="website">
            本站永久域名：<a href="${lee_novelWeb}/list">www.qishuwang.com</a>
        </p>
        <ul class="rdc">
            <c:forEach items="${novelsByTopSix}" var="novelByTopSix">
                <li class="bookcontent">
                    <div class="brief">
                        <div class="briefbook">
                            <a href="${lee_novelWeb}/chapter?novelId=${novelByTopSix.novelId}" target="_blank">
                                <img src="${novelByTopSix.novelImage}" class="briefbookimg img-fristimg">
                            </a>
                        </div>
                        <div class="contentbrief">
                            <h3>
                                <a class="fictionname" href="${lee_novelWeb}/chapter?novelId=${novelByTopSix.novelId}"
                                   target="_blank">${novelByTopSix.novelName}</a>
                            </h3>
                            <p>
                                <span>作者：${novelByTopSix.authorName}</span><br/>
                                <span class="newest f5">
                                    最新：<a class="fictionname"
                                          href="${lee_novelWeb}/detail?chapterId=${allNovelsNewUpdateChapterId.get(novelByTopSix.novelId)}"
                                          target="_blank">${novelByTopSix.newChapter}</a>
                                </span>
                            </p>
                            <p class="fictioncontent f5">
                                    ${novelByTopSix.introduction}
                            </p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<!--其他分类-->
<div class="novelslist">
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">玄幻奇幻</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-thefirstone" href="${lee_novelWeb}/chapter?novelId=${fantasy.novelId}">
                    <img src="${fantasy.novelImage}" class="img-mergedimages img-thefirstone">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${fantasy.novelId}">${fantasy.novelName}</a></dt>
                    <p class="fictioncontent f5">${fantasy.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${fantasyByTwoToThirteen}" var="fantasyNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${fantasyNovel.novelId}"
                           target="_blank">${fantasyNovel.novelName}</a>&nbsp/&nbsp${fantasyNovel.authorName}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">仙侠修真</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-thesecond" href="${lee_novelWeb}/chapter?novelId=${xianxia.novelId}"
                   target="_blank">
                    <img src="${xianxia.novelImage}" class="img-mergedimages img-thesecond">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${xianxia.novelId}"
                           target="_blank">${xianxia.novelName}</a></dt>
                    <p class="fictioncontent f5">${xianxia.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${xianxiaByTwoToThirteen}" var="xianxiaNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${xianxiaNovel.novelId}"
                           target="_blank">${xianxiaNovel.novelName}</a>&nbsp/&nbsp${xianxiaNovel.authorName}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">都市重生</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-thethird" href="${lee_novelWeb}/chapter?novelId=${city.novelId}"
                   target="_blank">
                    <img src="${city.novelImage}" class="img-mergedimages img-thesecond">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${city.novelId}" target="_blank">${city.novelName}</a>
                    </dt>
                    <p class="fictioncontent f5">${city.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${cityByTwoToThirteen}" var="cityNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${cityNovel.novelId}"
                           target="_blank">${cityNovel.novelName}</a>&nbsp/&nbsp${cityNovel.authorName}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="novelslist">
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">历史军事</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-thefourth" href="${lee_novelWeb}/chapter?novelId=${history.novelId}"
                   target="_blank">
                    <img src="${history.novelImage}" class="img-mergedimages img-thefourth">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${history.novelId}"
                           target="_blank">${history.novelName}</a></dt>
                    <p class="fictioncontent f5">${history.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${historyByTwoToThirteen}" var="historyNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${historyNovel.novelId}"
                           target="_blank">${historyNovel.novelName}</a>&nbsp/&nbsp${historyNovel.authorName}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">网游竞技</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-thefifth" href="${lee_novelWeb}/chapter?novelId=${onlinegame.novelId}"
                   target="_blank">
                    <img src="${onlinegame.novelImage}" class="img-mergedimages img-thefifth">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${onlinegame.novelId}">${onlinegame.novelName}</a></dt>
                    <p class="fictioncontent f5">${onlinegame.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${onlinegameByTwoToThirteen}" var="onlinegameNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${onlinegameNovel.novelId}"
                           target="_blank">${onlinegameNovel.novelName}</a>&nbsp/&nbsp${onlinegameNovel.authorName}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">科幻次元</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-thesixed"
                   href="${lee_novelWeb}/chapter?novelId=${sciencefiction.novelId}" target="_blank">
                    <img src="${sciencefiction.novelImage}" class="img-mergedimages img-thesixed">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${sciencefiction.novelId}"
                           target="_blank">${sciencefiction.novelName}</a></dt>
                    <p class="fictioncontent f5">${sciencefiction.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${sciencefictionByTwoToThirteen}" var="sciencefictionNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${sciencefictionNovel.novelId}"
                           target="_blank">${sciencefictionNovel.novelName}</a>&nbsp/&nbsp${sciencefictionNovel.authorName}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="novelslist">
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">灵异恐怖</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-thesevened" href="${lee_novelWeb}/chapter?novelId=${terrorist.novelId}"
                   target="_blank">
                    <img src="${terrorist.novelImage}" class="img-mergedimages img-thesevened">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${terrorist.novelId}"
                           target="_blank">${terrorist.novelName}</a></dt>
                    <p class="fictioncontent f5">${terrorist.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${terroristByTwoToThirteen}" var="terroristNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${terroristNovel.novelId}"
                           target="_blank">${terroristNovel.novelName}</a>&nbsp/&nbsp${terroristNovel.authorName}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">女生言情</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-theeighth" href="${lee_novelWeb}/chapter?novelId=${romance.novelId}"
                   target="_blank">
                    <img src="${romance.novelImage}" class="img-mergedimages img-theeighth">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${romance.novelId}"
                           target="_blank">${romance.novelName}</a></dt>
                    <p class="fictioncontent f5">${romance.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${romanceByTwoToThirteen}" var="romanceNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${romanceNovel.novelId}"
                           target="_blank">${romanceNovel.novelName}</a>&nbsp/&nbsp${romanceNovel.authorName}
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="listcontent">
        <div class="titletype">
            <span class="iconfont">&#xe638;</span>
            <p class="typetitle">其他小说</p>
        </div>
        <div class="othertype">
            <div class=othertypesimg>
                <a class="img-mergedimages img-thenighth" href="${lee_novelWeb}/chapter?novelId=${other.novelId}"
                   target="_blank">
                    <img src="${other.novelImage}" class="img-mergedimages img-thenighth">
                </a>
            </div>
            <div class="otherprofile">
                <dl>
                    <dt><a href="${lee_novelWeb}/chapter?novelId=${other.novelId}"
                           target="_blank">${other.novelName}</a></dt>
                    <p class="fictioncontent f5">${other.introduction}</p>
                </dl>
            </div>
        </div>
        <div class="otherlist">
            <ul>
                <c:forEach items="${otherByTwoToThirteen}" var="otherNovel">
                    <li><a href="${lee_novelWeb}/chapter?novelId=${otherNovel.novelId}"
                           target="_blank">${otherNovel.novelName}</a>&nbsp/&nbsp${otherNovel.authorName}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<!--新书上架-->
<div class="newbooklist">
    <div class="ranking">
        <p class="rankintitle">最新小说</p>
        <ul class="newbook">
            <c:forEach items="${novelsByNew}" var="newNovel">
                <li>
                    <span><a href="${lee_novelWeb}/chapter?novelId=${newNovel.novelId}"
                             target="_blank">${newNovel.novelName}</a> / ${newNovel.authorName}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="recommends">
        <p class="newstitles">最新更新小说</p>
        <ul class="updatethenovel">
            <c:forEach items="${novelsByNewUpdate}" var="newUpdateNovel">
                <li class="sort">
                    <span class="pub s1">${newUpdateNovel.type}</span>
                    <span class="pub s2 f4">
                        <a href="${lee_novelWeb}/chapter?novelId=${newUpdateNovel.novelId}" target="_blank">
                                ${newUpdateNovel.novelName}</a>
                    </span>
                    <span class="pub s3 f4">
                        <a href="${lee_novelWeb}/detail?chapterId=${allNovelsNewUpdateChapterId.get(newUpdateNovel.novelId)}"
                           target="_blank">${newUpdateNovel.newChapter}</a>
                    </span>
                    <span class="pub s4 f4">${newUpdateNovel.authorName}</span>
                    <span class="pub s5">${map.get(newUpdateNovel.novelId)}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<!--友情连接-->
<div class="blogroll">
    <div class="blogrolles">
        <span class="iconfont">&#xe638;</span>
        <p class="typetitle">友情链接</p>
    </div>
    <div class="blogrollname">
        <ul>
            <li><a href="http://www.baidu.com" target="_blank">百度</a></li>
            <li><a href="https://www.88quanben.com/" target="_blank">免费全本小说</a></li>
            <li><a href="http://www.ybdu.co/" target="_blank">全本小说</a></li>
            <li><a href="http://www.adingdian.com/" target="_blank">顶点小说</a></li>
            <li><a href="https://www.635book.com/" target="_blank">小说免费阅读</a></li>
            <li><a href="http://www.chongshengxiaoshuo.com/" target="_blank">重生小说</a></li>
            <li><a href="http://www.sulage.com/" target="_blank">书拉阁</a></li>
            <li><a href="http://www.kcxsw.com/" target="_blank">快穿小说</a></li>
            <li><a href="https://www.gexingshuo.com/" target="_blank">说说大全</a></li>
            <li><a href="https://www.suanming.com.cn/" target="_blank">免费算命</a></li>
            <li><a href="http://www.biquge.se/" target="_blank">笔趣阁</a></li>
            <li><a href="https://www.whhost.net/" target="_blank">366亿图网</a></li>
            <li><a href="http://www.pv61.com/" target="_blank">4小说网</a></li>
            <li><a href="http://www.ting89.com/" target="_blank">有声小说</a></li>
            <li><a href="http://www.haoshiwen.org/" target="_blank">古诗网</a></li>
            <li><a href="https://www.ertongtuku.com/" target="_blank">二筒阅读网</a></li>
            <li><a href="http://www.jstxdm.com/" target="_blank">剑圣文学网</a></li>
            <li><a href="https://www.17qq.com/" target="_blank">个性签名</a></li>
            <li><a href="http://www.xiaoshuoqi.com/" target="_blank">小说旗</a></li>
            <li><a href="http://www.dushu7.com/" target="_blank">读书趣</a></li>
            <li><a href="https://xs.sogou.com/" target="_blank">多多看书</a></li>
            <li><a href="https://www.17k.com/" target="_blank">17k小说网</a></li>
            <li><a href="http://www.shuhai.com/" target="_blank">书海小说网</a></li>
            <li><a href="http://www.58xs.com/" target="_blank">58小说网</a></li>
            <li><a href="http://www.i7wu.cn/" target="_blank">爱奇文学</a></li>
            <li><a href="https://www.qidian.com/" target="_blank">起点</a></li>
            <li><a href="http://www.fbook.net/" target="_blank">天下书盟</a></li>
            <li><a href="http://www.kuaikanxs.com/" target="_blank">快看小说</a></li>
            <li><a href="http://www.kanshu.com/" target="_blank">看书网</a></li>
            <li><a href="http://www.jjwxc.net/" target="_blank">晋江原创网</a></li>
        </ul>
    </div>
</div>

<%@ include file="include/include-footer.jsp"%>
</body>
</html>
