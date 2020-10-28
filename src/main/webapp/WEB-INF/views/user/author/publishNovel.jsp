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

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: inline-block;
            max-width: 100%;
            margin-bottom: 5px;
            font-weight: 700;
        }

        .input-group {
            position: relative;
            display: table;
            border-collapse: separate;
        }

        .input-group-btn {
            position: relative;
            font-size: 0;
            white-space: nowrap;
        }

        .btn.btn-file > input[type='file'] {
            position: absolute;
            top: 0;
            right: 0;
            min-width: 100%;
            min-height: 100%;
            font-size: 100px;
            text-align: right;
            opacity: 0;
            filter: alpha(opacity=0);
            outline: none;
            background: white;
            cursor: inherit;
            display: block;
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
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 发布小说</h3>
                </div>
                <div class="panel-body">
                    <div class="box-body" style="">
                        <div class="form-group">
                            <label for="novelName">书名</label>
                            <input type="text" class="form-control" id="novelName" name="novelName" value="">
                        </div>

                        <div class="form-group">
                            <label for="category-form">分类</label>
                            <select name="category_id" id="category-form" class="form-control" data-category-id="">
                                <option value="1">玄幻</option>
                                <option value="2">仙侠</option>
                                <option value="3">都市</option>
                                <option value="4">历史</option>
                                <option value="5">网游</option>
                                <option value="6">科幻</option>
                                <option value="7">恐怖</option>
                                <option value="8">言情</option>
                                <option value="9">其他</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="novelImage">缩略图</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="novelImage" name="novelImage"
                                       value="">
                                <span class="input-group-btn">
                                    <label class="btn btn-default btn-file">
                                        上传图片
                                        <%--<input hidden="hidden" type="file" class="btn btn-default" id="thumbnail-btn">--%>
                                    </label>
                                </span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="novelIntroduction">简介</label>
                            <div>
                                    <textarea class="form-control" id="novelIntroduction" name="novelIntroduction"
                                              rows="5"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="box-footer">
                        <button type="button" id="submit-btn" class="btn btn-primary fa-pull-right" data-novel-id=""
                                onclick="publishNovel()">发布小说
                        </button>
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

    function publishNovel() {
        var novelName = $("#novelName").val();
        var novelType = $("#category-form option:selected").text();
        var novelImage = $("#novelImage").val();
        var novelIntroduction = $("#novelIntroduction").val();
        $.ajax({
            url: "${lee_novelWeb}/author/publishNovel",
            type: "POST",
            data: {
                "novelName": novelName,
                "novelType": novelType,
                "novelImage": novelImage,
                "novelIntroduction": novelIntroduction
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
