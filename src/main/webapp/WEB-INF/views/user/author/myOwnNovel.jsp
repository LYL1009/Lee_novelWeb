<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/16
  Time: 9:46
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
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 我的作品</h3>
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
                                    <div class="input-group-addon">查询条件</div>
                                    <input class="form-control has-success" type="text" placeholder="请输入查询条件">
                                </div>
                            </div>
                            <button type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询
                            </button>
                        </form>
                        <br>
                        <hr style="clear:both;">
                        <div class="table-responsive" style="height: 600px">
                            <table class="table  table-bordered" style="text-align: center;font-size: 12px;">
                                <thead>
                                <tr>
                                    <th style="width: auto;text-align: center;">书名</th>
                                    <th style="text-align: center;">分类</th>
                                    <th style="text-align: center;">章数</th>
                                    <th style="text-align: center;">字数</th>
                                    <th style="text-align: center;">发布时间</th>
                                    <th style="width: auto;text-align: center;">是否完本</th>
                                    <th style="width: auto;text-align: center;">是否推荐</th>
                                    <th style="width: auto;text-align: center;">作者</th>
                                    <th style="width: auto;text-align: center;">简介</th>
                                    <th style="width: auto;text-align: center;">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${novels}" var="novel">
                                    <tr>
                                        <td style="vertical-align: middle;">${novel.novelName}</td>
                                        <td style="vertical-align: middle;">${novel.type}</td>
                                        <c:if test="${map.get(novel.novelId) == null}">
                                            <td style="vertical-align: middle;">无</td>
                                        </c:if>
                                        <c:if test="${map.get(novel.novelId) != null}">
                                            <td style="vertical-align: middle;">${map.get(novel.novelId)}</td>
                                        </c:if>
                                        <c:if test="${novel.totalWords >= 10000}">
                                            <td style="vertical-align: middle;">${novel.totalWords / 10000}w</td>
                                        </c:if>
                                        <c:if test="${novel.totalWords < 10000}">
                                            <td style="vertical-align: middle;">${novel.totalWords}</td>
                                        </c:if>
                                        <c:if test="${novelReleaseTime.get(novel.novelId) == null}">
                                            <td style="vertical-align: middle;">无</td>
                                        </c:if>
                                        <c:if test="${novelReleaseTime.get(novel.novelId) != null}">
                                            <td style="vertical-align: middle;">${novelReleaseTime.get(novel.novelId)}</td>
                                        </c:if>
                                        <td style="vertical-align: middle;">${novel.status == 0?"连载中":"已完结"}</td>
                                        <td style="vertical-align: middle;">否</td>
                                        <td style="vertical-align: middle;">${sessionScope.author.authorName}</td>
                                        <td style="vertical-align: middle;width: 300px;">${novel.introduction}</td>
                                        <td style="vertical-align: middle;">
                                            <!-- Split button -->
                                            <div class="btn-group">
                                                <button type="button" id="buttonGroup"
                                                        class="btn btn-danger dropdown-toggle" data-toggle="dropdown"
                                                        aria-haspopup="true" aria-expanded="false">
                                                    <span class="caret"></span>
                                                    <span class="sr-only">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu dropdown-menu-right"
                                                    aria-labelledby="buttonGroup" style="min-width: auto;">
                                                    <li>
                                                        <a href="${lee_novelWeb}/author/updateNovelChapter?novelId=${novel.novelId}">更新</a>
                                                    </li>
                                                    <c:if test="${novel.status == 0}">
                                                        <li><a href="#" onclick="toEndNovelModal()">完结</a></li>
                                                    </c:if>
                                                    <li>
                                                        <a href="${lee_novelWeb}/author/toEditNovelPage?novelId=${novel.novelId}">编辑</a>
                                                    </li>
                                                    <li><a href="#" onclick="toDeleteNovelModal()">删除</a></li>
                                                </ul>
                                                <input type="hidden" id="novelId" value="${novel.novelId}">
                                            </div>
                                        </td>
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

<%@ include file="endNovel_modal.jsp" %>
<%@ include file="delete_modal.jsp" %>
</body>
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

    function toEndNovelModal() {
        $("#endNovelModal").modal('show');
    }

    function endNovelByNovelId() {
        var novelId = $("#novelId").val();
        $.ajax({
            url: "${lee_novelWeb}/author/endNovel",
            type: "POST",
            data: {
                "novelId": novelId
            },
            dataType: "text",
            success: function (data) {
                if (data == 'success') {
                    window.location.href = "${lee_novelWeb}/author/toMyOwnNovelPage";
                } else {
                    alert("操作失败，请重新尝试！");
                }
            }
        });
    }

    function toDeleteNovelModal() {
        $("#deleteModal").modal('show');
    }

    function deleteNovelByNovelId() {
        var novelId = $("#novelId").val();
        $.ajax({
            url: "${lee_novelWeb}/author/deleteNovel",
            type: "POST",
            data: {
                "novelId": novelId
            },
            dataType: "text",
            success: function (data) {
                if (data == 'success') {
                    window.location.href = "${lee_novelWeb}/author/toMyOwnNovelPage";
                } else {
                    alert("操作失败，请重新尝试！");
                }
            }
        });
    }
</script>
</html>

