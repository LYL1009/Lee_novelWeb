<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2020/10/14
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("lee_novelWeb",request.getContextPath());
%>
<!--d底部-->
<div class="footer">
    <div class="said">
        <p>本站所有小说由网友上传，如有侵犯版权，请来站内短信告知，本站立即予以处理。拒绝任何色情小说，一经发现，立即删除。</p>
        <p>Copyright © 2020 <a href="${lee_novelWeb}/list" target="_blank">齐书网</a> All Rights Reserved.</p>
        <p>川ICP备1900032号-1</p>
    </div>
</div>
