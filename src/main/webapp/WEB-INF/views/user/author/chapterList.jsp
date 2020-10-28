<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/18
  Time: 16:55
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
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 小说章节</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div style="font-size: 16px;"><strong>${novel.novelName} 所有章节</strong></div>
                            </div>
                        </div>
                    </form>
                    <div class="form-group pull-right" style="margin-bottom: 5px;">
                        <a href="${lee_novelWeb}/author/updateNovelChapter?novelId=${novel.novelId}"
                           class="btn btn-info">
                            添加章节</a>
                    </div>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table table-bordered" style="text-align: center;">
                            <thead>
                            <tr>
                                <th style="width: auto;text-align: center;">章节</th>
                                <th style="text-align: center;">标题</th>
                                <th style="text-align: center;">发布时间</th>
                                <th style="text-align: center;">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${chapters != null}">
                                <c:forEach items="${chapters}" var="chapter">
                                    <tr>
                                        <td style="vertical-align: middle;">第${chapter.sequenceId}章</td>
                                        <td style="vertical-align: middle;">${chapter.chapterName}</td>
                                        <td style="vertical-align: middle;">${updateTimes.get(chapter.chapterId)}</td>
                                        <td style="vertical-align: middle;">
                                            <a href="${lee_novelWeb}/author/toModifyChapterPage?novelId=${novel.novelId}&chapterId=${chapter.chapterId}"
                                               class="btn btn-warning btn-xs">编辑</a>
                                            <button class="btn btn-danger btn-xs delete-btn" onclick="toDeleteChapterModal()"
                                                    data-chapter-id="SgvzIc-WtFO9ipcavAQ2d4">删除
                                            </button>
                                            <input type="hidden" id="chapterId" name="chapterId" value="${chapter.chapterId}">
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${chapters == null}">
                                <tr>
                                    <td colspan="4" style="vertical-align: middle;"><h3>目前无任何章节信息</h3></td>
                                </tr>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="deleteChapter_modal.jsp"%>
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

    function toDeleteChapterModal() {
        $("#deleteChapterModal").modal('show');
    }

    function deleteChapterByChapterId() {
        var chapterId = $("#chapterId").val();
        if (chapterId > 0) {
            $("#deleteChapterModal").modal('hide');
            $.ajax({
                url:"${lee_novelWeb}/author/deleteChapter",
                type:"POST",
                data:{
                    "chapterId":chapterId,
                    "novelId":${novel.novelId}
                },
                dataType:"text",
                success:function (data) {
                    if (data == 'success') {
                        alert("删除成功");
                        window.location.href="${lee_novelWeb}/author/chapter_list?novelId=${novel.novelId}";
                    } else {
                        alert("操作失败，请重新尝试！");
                    }
                }
            });
        }
    }
</script>
</body>
</html>

