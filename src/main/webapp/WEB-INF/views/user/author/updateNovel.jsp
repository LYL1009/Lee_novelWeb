<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/16
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb", request.getContextPath());
    %>
    <%@ include file="../../include/include_userHead.jsp" %>
    <style>
        .tree li {
            list-style-type: none;
            cursor: pointer;
        }

        table tbody tr:nth-child(odd) {
            background: #F4F4F4;
        }

        table tbody td:nth-child(even) {
            color: #C00;
        }
    </style>
</head>
<body>
<%-- 个人中心导航栏 --%>
<%@ include file="../../include/include_userNav.jsp" %>

<div class="container-fluid">
    <div class="row">
        <%--    个人中心侧边栏    --%>
        <%@ include file="../../include/include_userSidebar.jsp" %>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 更新小说</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${novels.size() == 0}">
                        <div class="table-responsive" style="height: 100px;text-align: center">
                            <h2>目前并未发布小说</h2>
                        </div>
                    </c:if>
                    <c:if test="${novels.size() > 0}">
                        <form class="form-inline" role="form" style="float:left;">
                            <div class="form-group has-feedback">
                                <div class="input-group">
                                    <div style="font-size: 16px;"><strong>请选择小说</strong></div>
                                </div>
                            </div>
                        </form>
                        <br>
                        <hr style="clear:both;">
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                <c:forEach items="${novels}" var="novel">
                                    <tr>
                                        <td class="col-md-8">
                                            <div class="media" style="margin:10px 0;">
                                                <div class="media-left">
                                                    <a href="#">
                                                        <img style="width:100px;" class="media-object"
                                                             src="${novel.novelImage}"
                                                             alt="...">
                                                    </a>
                                                </div>
                                                <div class="media-body">
                                                    <h3 class="media-heading">
                                                        <div class="clearfix">
                                                            <span class="pull-left">${novel.novelName}</span>
                                                            <a href="${lee_novelWeb}/author/updateNovelChapter?novelId=${novel.novelId}"
                                                               class="btn btn-warning btn-md pull-right">更新小说</a>
                                                        </div>
                                                    </h3>
                                                    <div class="row">
                                                        <h5 class="col-md-2">
                                                            <svg width="1em" height="1em" viewBox="0 0 16 16"
                                                                 class="bi bi-bar-chart-steps" fill="currentColor"
                                                                 xmlns="http://www.w3.org/2000/svg">
                                                                <path fill-rule="evenodd"
                                                                      d="M.5 0a.5.5 0 0 1 .5.5v15a.5.5 0 0 1-1 0V.5A.5.5 0 0 1 .5 0z"/>
                                                                <rect width="5" height="2" x="2" y="1" rx=".5"/>
                                                                <rect width="8" height="2" x="4" y="5" rx=".5"/>
                                                                <path d="M6 9.5a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-6a.5.5 0 0 1-.5-.5v-1zm2 4a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-7a.5.5 0 0 1-.5-.5v-1z"/>
                                                            </svg>
                                                                ${novel.type}</h5>
                                                        <h5 class="col-md-3">
                                                            <svg width="1em" height="1em" viewBox="0 0 16 16"
                                                                 class="bi bi-layout-text-sidebar-reverse"
                                                                 fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                                <path fill-rule="evenodd"
                                                                      d="M2 1h12a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1zm12-1a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12z"/>
                                                                <path fill-rule="evenodd"
                                                                      d="M5 15V1H4v14h1zm8-11.5a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm0 3a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm0 3a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5zm0 3a.5.5 0 0 0-.5-.5h-5a.5.5 0 0 0 0 1h5a.5.5 0 0 0 .5-.5z"/>
                                                            </svg>
                                                            当前共${map.get(novel.novelId)}章
                                                        </h5>
                                                        <h5 class="col-md-3">
                                                            <svg width="1em" height="1em" viewBox="0 0 16 16"
                                                                 class="bi bi-badge-tm" fill="currentColor"
                                                                 xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M5.295 11V5.995H7V5H2.403v.994h1.701V11h1.19zm3.397 0V7.01h.058l1.428 3.239h.773l1.42-3.24h.057V11H13.5V5.001h-1.2l-1.71 3.894h-.039l-1.71-3.894H7.634V11h1.06z"/>
                                                                <path fill-rule="evenodd"
                                                                      d="M14 3H2a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1zM2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2z"/>
                                                            </svg>
                                                            当前共
                                                            <c:if test="${novel.totalWords >= 10000}">
                                                                ${novel.totalWords / 10000}万
                                                            </c:if>
                                                            <c:if test="${novel.totalWords < 10000}">
                                                                ${novel.totalWords}
                                                            </c:if>
                                                            字
                                                        </h5>
                                                    </div>
                                                    <span><p>${novel.introduction}</p></span>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="col-md-4"></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${lee_novelWeb}/static/js/jquery-3.3.1.js" type="text/javascript"></script>
<script src="${lee_novelWeb}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${lee_novelWeb}/static/js/docs.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function () {
            if ($(this).find("ul")) {
                $(this).toggleClass("tree-closed");
                if ($(this).hasClass("tree-closed")) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
    });
</script>
</body>
</html>
