<%--
  Created by IntelliJ IDEA.
  User: jungyeon
  Date: 2024-03-21
  Time: 오전 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        th, td{
            padding: 5px;
        }
        div{
            color: red;
            font-size: small;
        }
    </style>
</head>
<body>
<form id="writeForm">
    <a href="/Chapter06_Web/"><img src="../image/Logo.png" width="30%"/></a>
    <table border="1">
        <tr>
            <th>이름</th>
            <td>
                <input type="text" name="name" id="name">
                <div id="nameDiv"></div>
            </td>
        </tr>
        <tr>
            <th>아이디</th>
            <td>
                <input type="text" name="id" id="id">
                <div id="idDiv"></div>
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>
                <input type="text" name="pwd" id="pwd">
                <div id="pwdDiv"></div>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="button" id="writeBtn" value="입력하기">
            </td>
        </tr>
    </table>
</form>
<script src="https://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script src="../js/write.js"></script>

</body>
</html>
