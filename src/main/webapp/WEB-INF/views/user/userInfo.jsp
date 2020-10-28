<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/15
  Time: 10:36
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
        function saveUserInfo() {
            var gender = $("#gender").val();
            var email = $("#email").val();
            var qq = $("#QQ").val();
            var phone = $("#phone").val();
            var userInfo = $("#userInfo").val();
            $.ajax({
                url:"${lee_novelWeb}/user/saveUserInfo",
                type:"GET",
                data:{
                    "id":${sessionScope.user.userId},
                    "gender":gender,
                    "email":email,
                    "qq":qq,
                    "phone":phone,
                    "userInfo":userInfo
                },
                dataType:"text",
                success:function (data) {
                    if (data == 'success') {
                        alert("保存成功");
                        window.location.href="${lee_novelWeb}/user/updateUser";
                    }
                }
            });
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
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 个人信息</h3>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <form id="setBasicForm" novalidate="novalidate" style="display: inline-block">
                            <dl>
                                <dt>昵称</dt>
                                <dd>${sessionScope.user.username}</dd>
                            </dl>
                            <dl>
                                <dt>ID</dt>
                                <dd>${sessionScope.user.userId}</dd>
                            </dl>
                            <c:if test="${sessionScope.author.userId == sessionScope.user.userId}">
                                <dl>
                                    <dt>笔名</dt>
                                    <dd>${sessionScope.author.authorName}</dd>
                                </dl>
                            </c:if>
                            <dl>
                                <dt>邮箱</dt>
                                <dd>
                                    <input id="email" type="text" value="${sessionScope.user.email}"
                                           style="border: 1px solid #e0deda;height: 28px;width: 200px;">
                                </dd>
                            </dl>
                            <dl>
                                <dt>性别</dt>
                                <dd>
                                    <input id="gender" type="text" value="${sessionScope.user.gender == 0?"女":"男"}"
                                           style="border: 1px solid #e0deda;height: 28px;width: 200px;"/>
                                </dd>
                            </dl>
                            <dl class="qdp-form-higher">
                                <dt>QQ</dt>
                                <dd>
                                    <input id="QQ" type="text" value="${sessionScope.user.qq}"
                                           style="border: 1px solid #e0deda;height: 28px;">
                                </dd>
                            </dl>
                            <dl class="qdp-form-higher">
                                <dt>电话</dt>
                                <dd id="selAddressX" style="visibility: visible;">
                                    <input id="phone" type="text" value="${sessionScope.user.phone}"
                                           style="border: 1px solid #e0deda;height: 28px;">
                                </dd>
                            </dl>
                            <dl class="qdp-form-higher">
                                <dt>简介</dt>
                                <dd>
                                    <div class="ui-textarea-x" style="width:324px;">
                                        <textarea id="userInfo" name="introduction" maxlength="_100_" rows="2"
                                                  placeholder="可以简单的描述自己" data-eid="qd_M140">${sessionScope.user.info}</textarea>
                                        <div class="ui-textarea"></div>
                                        <label for="userInfo" class="ui-textarea-count">
                                            <span>0</span>/<span>100</span> </label></div>
                                </dd>
                            </dl>
                            <dl class="qdp-form-higher">
                                <dt></dt>
                                <dd>
                                    <div class="">
                                        <input type="button" onclick="saveUserInfo()" id="dialogMsgSubmit" class="clip">
                                        <label class="ui-button" for="dialogMsgSubmit">保存</label>
                                    </div>
                                </dd>
                            </dl>
                        </form>
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
