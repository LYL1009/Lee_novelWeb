<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/15
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    pageContext.setAttribute("lee_novelWeb",request.getContextPath());
%>
<div class="col-sm-3 col-md-2 sidebar">
    <div class="tree">
        <ul style="padding-left:0px;" class="list-group">
            <li class="list-group-item tree-closed">
                <a href="${lee_novelWeb}/user/homepage"><i class="glyphicon glyphicon-dashboard"></i> 首页</a>
            </li>
            <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 个人中心 <span class="badge"
                                                                                             style="float:right">3</span></span>
                <ul style="margin-top:10px;display:none;">
                    <li style="height:30px;">
                        <a href="${lee_novelWeb}/user/recentlyRead">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-book-half" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M8.5 2.687v9.746c.935-.53 2.12-.603 3.213-.493 1.18.12 2.37.461 3.287.811V2.828c-.885-.37-2.154-.769-3.388-.893-1.33-.134-2.458.063-3.112.752zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
                            </svg> 最近阅读</a>
                    </li>
                    <li style="height:30px;">
                        <a href="${lee_novelWeb}/user/myBookcase">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-layout-text-sidebar-reverse" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M2 1h12a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zm12-1a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12z"/>
                                <path fill-rule="evenodd" d="M5 15V1H4v14h1zm8-11.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm0 3a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm0 3a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm0 3a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5z"/>
                            </svg> 我的书架</a>
                    </li>
                    <li style="height:30px;">
                        <a href="${lee_novelWeb}/user/info">
                            <svg width="1em" height="1em" viewBox="0 0 14 14" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                <path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                            </svg> 个人信息</a>
                    </li>
                </ul>
            </li>

            <c:if test="${sessionScope.author == null}">
                <li class="list-group-item tree-closed">
                    <a href="${lee_novelWeb}/user/toBecomeAuthorPage"><i class="glyphicon glyphicon-list-alt"></i>
                        成为作家</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.author.userId == sessionScope.user.userId}">
                <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-ok"></i> 作家专区 <span class="badge"
                                                                                style="float:right">4</span></span>
                    <ul style="margin-top:10px;display:none;">
                        <li style="height:30px;">
                            <a href="${lee_novelWeb}/author/toMyOwnNovelPage"><i class="glyphicon glyphicon-check"></i> 我的作品</a>
                        </li>
                        <li style="height:30px;">
                            <a href="${lee_novelWeb}/author/toPublishNovelPage"><i class="glyphicon glyphicon-check"></i> 发布小说</a>
                        </li>
                        <li style="height:30px;">
                            <a href="${lee_novelWeb}/author/toUpdateNovelPage"><i class="glyphicon glyphicon-check"></i> 更新小说</a>
                        </li>
                        <li style="height:30px;">
                            <a href="${lee_novelWeb}/author/toNovelChapterPage"><i class="glyphicon glyphicon-check"></i> 小说章节</a>
                        </li>
                    </ul>
                </li>
            </c:if>
        </ul>
    </div>
</div>
