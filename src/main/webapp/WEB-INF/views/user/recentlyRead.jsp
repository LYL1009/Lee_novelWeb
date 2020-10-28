<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/15
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb", request.getContextPath());
    %>
    <%@ include file="../include/include_userHead.jsp" %>
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
<%@ include file="../include/include_userNav.jsp" %>

<div class="container-fluid">
    <div class="row">
        <%--    个人中心侧边栏    --%>
        <%@ include file="../include/include_userSidebar.jsp" %>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 最近阅读</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${novelHistories.size() == 0}">
                        <div class="table-responsive" style="height: 100px;text-align: center">
                            <h2>目前并未浏览任何小说</h2>
                        </div>
                    </c:if>
                    <c:if test="${novelHistories.size() > 0}">
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
                        <div class="table-responsive">
                            <table class="table  table-bordered" style="text-align: center;">
                                <thead>
                                <tr>
                                    <th style="width: auto;text-align: center;">类型</th>
                                    <th style="text-align: center;">书名</th>
                                    <th style="text-align: center;">作者</th>
                                    <th style="text-align: center;">最新章节</th>
                                    <th style="text-align: center;">上次阅读时间</th>
                                    <th style="width: auto;text-align: center;">阅读进度</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${novelHistories}" var="history">
                                    <tr>
                                        <td style="vertical-align: middle;">${map.get(history.historyId).type}</td>
                                        <td style="vertical-align: middle;"><a
                                                href="${lee_novelWeb}/chapter?novelId=${history.novelId}">${map.get(history.historyId).novelName}</a>
                                        </td>
                                        <td style="vertical-align: middle;">${map.get(history.historyId).authorName}</td>
                                        <td style="vertical-align: middle;"><a
                                                href="${lee_novelWeb}/detail?chapterId=${allNovelsNewUpdateChapterId.get(history.novelId)}">${map.get(history.historyId).newChapter}</a>
                                        </td>
                                        <td style="vertical-align: middle;">${lastReadTimes.get(history.historyId)}</td>
                                        <td>
                                            <a href="${lee_novelWeb}/detail?chapterId=${history.chapterId}">${readSchedule.get(history.historyId)}</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>

                    <%--<tfoot>
                    <tr>
                        <td colspan="6" align="center">
                            <ul class="pagination">
                                <li class="disabled"><a href="#">上一页</a></li>
                                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">下一页</a></li>
                            </ul>
                        </td>
                    </tr>

                    </tfoot>--%>

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
    $("tbody .btn-success").click(function () {
        window.location.href = "assignRole.html";
    });
    $("tbody .btn-primary").click(function () {
        window.location.href = "edit.html";
    });
</script>
</body>
</html>
