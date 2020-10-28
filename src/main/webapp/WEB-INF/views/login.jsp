<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/7
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>齐书网</title>
    <%
        pageContext.setAttribute("lee_novelWeb",request.getContextPath());
    %>
    <%@ include file="include/include-head.jsp"%>
    <script type="text/javascript">
        function userLogin() {
            var username = $("#username").val();
            var password = $("#password").val();
            $.ajax({
                url:"${lee_novelWeb}/login",
                type:"POST",
                data:{
                    "username":username,
                    "password":password
                },
                dataType:"text",
                success:function (response) {
                    if (response == 'success') {
                        window.location.href='${lee_novelWeb}/list';
                    } else if (response == 'error') {
                        alert("账号或者密码错误！");
                    }
                }
            });
        }

        function userRegister() {
            var username = $("#register-username").val();
            var email = $("#register-email").val();
            var password = $("#register-password").val();
            var confirmPassword = $("#register-confirmPassword").val();
            var phone = $("#register-phone").val();
            if (password == confirmPassword && phone.length == 11) {
                $.ajax({
                    url: "${lee_novelWeb}/register",
                    type: "POST",
                    data: {
                        "username":username,
                        "email":email,
                        "password":password,
                        "phone":phone
                    },
                    dataType: "text",
                    success: function (data) {
                        if (data == 'success') {
                            alert("注册成功");
                            window.location.href="${lee_novelWeb}/toLogin";
                        } else if (data == 'username') {
                            alert("用户名已被注册，请更换");
                        } else if (data == 'email') {
                            alert("该邮箱已被使用");
                        } else if (data == 'phone') {
                            alert("该手机号已被使用");
                        } else {
                            alert("操作失败，请重新尝试！");
                        }
                    }
                });
            } else {
                alert("请再次确认密码或手机号！");
            }
        }
    </script>
</head>
<body>
<%@ include file="include/include-nav.jsp"%>

<!--登录界面-->
<div class="misc f4" >
    <div class="logininterface" id="enter">
        <p class="userlogin"><b>用户登录：</b></p>
        <div class="loginform">
            <span class="loginimg">
                <i class="iconfont">&#xe67c;</i>
            </span>
            <form id="userlogin" method="post" style="padding-top: 70px;">
                <p class="userstyle">
                    <span class="iconfont userandlock">&#xe607;</span>:
                    <input type="text" id="username" name="username" placeholder="请输入用户名">
                </p>
                <p class="userstyle">
                    <span class="iconfont">&#xe608;</span>:
                    <input type="password" id="password" name="password" placeholder="请输入密码">
                </p>
                <p class="userstyles distance">
                    <input type="button" onclick="userLogin()" value="立即登录">
                </p>
            </form>
            <p class="forgetposs">
                <a href="#" target="_blank">忘记密码？</a>/<a href="#register">立即注册</a>
            </p>
        </div>
    </div>
    <div class="logininterface" id="register">
        <p class="userlogin"><b>用户注册：</b></p>
        <div class="loginform">
            <p class="back"><a href="#enter" >返回上一级</a></p>
            <span class="loginimg">
                    <i class="iconfont">&#xe696;</i>
                </span>
            <div class="ration" style="padding-top: 70px;">
                <p class="rationstyle">
                    <label class="f6" for="register-username">用户名：</label>
                    <input type="text" id="register-username" name="register-username" placeholder="请输入用户名">
                </p>
                <p class="rationstyle">
                    <label class="f6" for="register-email">邮箱：</label>
                    <input type="email" id="register-email" name="register-email" placeholder="请输入密码">
                </p>
                <p class="rationstyle">
                    <label class="f6" for="register-password">密码：</label>
                    <input type="password" id="register-password" name="register-password" placeholder="请输入密码">
                </p>
                <p class="rationstyle">
                    <label class="f6" for="register-confirmPassword">确认密码：</label>
                    <input type="password" id="register-confirmPassword" name="register-confirmPassword" placeholder="请再次输入密码">
                </p>
                <p class="rationstyle">
                    <label class="f6" for="register-phone">手机号：</label>
                    <input type="text" id="register-phone" name="register-phone" placeholder="请输入手机号">
                </p>
                <%--<p class="rationstyle">
                    <label class="f6" for="register-validateCode">验证码：</label>
                    <input type="text" id="register-validateCode" name="register-validateCode" placeholder="请输入验证码">
                </p>--%>
                <p class="userstyles distances">
                    <input type="button" onclick="userRegister()" value="提交"/>
                </p>
            </div>
        </div>
    </div>
</div>

<%@ include file="include/include-footer.jsp"%>
</body>
</html>
