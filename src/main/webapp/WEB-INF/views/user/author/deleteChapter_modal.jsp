<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/19
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="deleteChapterModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body" style="text-align: center">
                <h2><strong>提示</strong></h2>
                <p>您是否要删除这一章？</p>
            </div>
            <div class="modal-footer" style="text-align: center;">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger" onclick="deleteChapterByChapterId()">确定</button>
            </div>
        </div>
    </div>
</div>
