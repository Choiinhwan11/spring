<%--
  Created by IntelliJ IDEA.
  User: bitcamp
  Date: 2024-03-25
  Time: 오전 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
        }
        th,td {
            padding: 5px;
            width: 200px;
        }
    </style>
</head>
<body>
<form id="uploadListForm">
    <table id="uploadListTable" border="1" frame="hsides" rules="rows">
        <tr>
            <th width="100"><input type="checkbox" id="all"/>번호</th>
            <th width="200">이미지</th>
            <th width="200">이미지 이름</th>
        </tr>

        <%-- 동적 처리 --%>
    </table>
    <input type="button" id="uploadDeleteBtn" value="선택삭제" style="margin-top: 5px">
</form>
    <script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
    <script src="../js/uploadList.js"></script>
    <script src="../js/uploadDelete.js"></script>
</body>
</html>
