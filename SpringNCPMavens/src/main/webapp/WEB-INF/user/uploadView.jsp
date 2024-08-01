<%--
  Created by IntelliJ IDEA.
  User: bitcamp
  Date: 2024-03-27
  Time: 오전 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="seq" value="${seq}"/>
<table border="1" frame="hsides" rules="rows">
    <tr>
        <td rowspan="3" width="300" height="200"><span id="imageSpan"></span></td>
        <td>번호 : ${seq}</td>
    </tr>
    <tr>
        <td width="200">상품명 : <span id="imageNameSpan"></span></td>
    </tr>
    <tr>
        <td>파일명 : <span id="imageOriginalNameSpan"></span></td>
    </tr>

    <tr>
        <td colspan="2" height="200"><span id="imageContentSpan"></span></td>
    </tr>
</table>
<div style="margin-top: 5px">
    <input type="button" value="목록" onclick="location.href='/user/uploadList'"/>
    <input type="button" value="수정" onclick="location.href='/user/uploadUpdateForm?seq=${seq}'"/>
</div>
<script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script src="/js/uploadView.js"></script>
</body>
</html>
