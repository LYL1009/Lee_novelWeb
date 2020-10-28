<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/15
  Time: 20:48
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
    <link rel="stylesheet" href="${lee_novelWeb}/static/css/userInfo.css" type="text/css">
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
    <script type="text/javascript">
        function becomeAuthor() {
            var authorName = $("#authorName").val();
            if (authorName != null && authorName != "") {
                $.ajax({
                    url:"${lee_novelWeb}/user/becomeAuthor",
                    type:"POST",
                    data:{
                        "authorName":authorName
                    },
                    dataType:"text",
                    success:function (data) {
                        if (data == 'success') {
                            window.location.href="${lee_novelWeb}/user/homepage";
                        } else if (data == 'repeat') {
                            alert("您输入的笔名已被使用，请您更换");
                        } else {
                            alert("开通失败");
                        }
                    }
                });
            } else {
                alert("请输入您的笔名！");
            }
        }
    </script>
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
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 成为作者</h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <h1>请输入笔名</h1>
                        <input type="text" id="authorName" style="border: 1px solid #a6a6a6;width: 500px;margin-top: 14px;font-size: 16px;font-family: sans-serif;"><br>
                        <br>
                        <button class="btn btn-success btn-sm" onclick="becomeAuthor()" style="font-size: 16px;">开通</button>
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
</script>
</body>
</html>
