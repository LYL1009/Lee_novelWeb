<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/19
  Time: 11:23
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
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 章节修改</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div style="font-size: 16px;"><strong>${novel.novelName} 第${chapter.sequenceId}章</strong>
                                </div>
                            </div>
                        </div>
                    </form>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <div class="box-body" style="">

                            <div class="form-group">
                                <label for="chapterName">标题</label>
                                <input type="text" class="form-control" id="chapterName" name="chapterName"
                                       value="${chapter.chapterName}">
                            </div>

                            <div class="form-group">
                                <label for="chapterContent">内容</label>
                                <div>
                                        <textarea id="chapterContent" name="chapterContent" class="form-control"
                                                  rows="20">${detail.content}</textarea>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <button type="button" onclick="modifyChapter()" id="submit-btn"
                                    class="btn btn-primary fa-pull-right" data-novel-id="">修改
                            </button>
                        </div>
                    </div>
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

    function modifyChapter() {
        var novelId = ${novel.novelId};
        var chapterName = $("#chapterName").val();
        var chapterContent = $("#chapterContent").val();
        $.ajax({
            url: "${lee_novelWeb}/author/updateChapter",
            type: "POST",
            data: {
                "novelId": novelId,
                "chapterName": chapterName,
                "chapterContent": chapterContent
            },
            dataType: "text",
            success: function (data) {
                if (data == 'success') {
                    alert("发布成功");
                    window.location.href = "${lee_novelWeb}/author/toMyOwnNovelPage";
                } else {
                    alert("操作失败，请重新尝试！");
                }
            }
        });
    }
</script>
</body>
</html>


