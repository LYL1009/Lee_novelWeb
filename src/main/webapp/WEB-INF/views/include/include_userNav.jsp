<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/15
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("lee_novelWeb",request.getContextPath());
%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div>
                <a class="navbar-brand" style="font-size:32px;" href="${lee_novelWeb}/list">齐书网</a>
                <span class="navbar-brand" style="font-size:32px;">- 个人中心</span>
            </div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;padding-right: 30px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle"
                                data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i> ${sessionScope.user.username} <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="${lee_novelWeb}/user/info"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="${lee_novelWeb}/user/homepage"><i class="glyphicon glyphicon-comment"></i> 首页</a></li>
                            <li class="divider"></li>
                            <li><a href="${lee_novelWeb}/list"><i class="glyphicon glyphicon-circle-arrow-left"></i> 返回齐书网</a></li>
                            <li><a href="${lee_novelWeb}/logout"><i class="glyphicon glyphicon-off"></i> 退出登录</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
