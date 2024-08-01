<%--
  Created by IntelliJ IDEA.
  User: bitcamp
  Date: 2024-03-22
  Time: 오후 12:06
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
        th,td{
            padding: 5px;
        }
        #updateForm div{
            color : red;
            font-size: 8pt;
            font-weight: bold;
        }
    </style>
</head>
<body>
<form id="updateForm">
    <input type="hidden" id="id1" value="${id}" />
    <input type="hidden" id="pg" value="${pg}" />


    <a href="/"><img src="../image/딸기탕후루.jpg" width="50"></a>
    <table border="1">
        <tr>
            <th>이름</th>
            <td>
                <input type="text" name="name" id="name"/>
                <div id="nameDiv"></div>
            </td>
        </tr>
        <tr>
            <th>아이디</th>
            <td>
                <input type="text" name="id" id="id" value="${id}"  readonly/>
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>
                <input type="password" name="pwd" id="pwd"/>
                <div id="pwdDiv"></div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="수정" id="updateBtn"/>
                <input type="button" value="삭제" id="deleteBtn"/>
                <input type="reset" value="취소" id="resetBtn"/>
            </td>
        </tr>
    </table>
</form>
<script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script src="/js/update.js"></script>
<script src="/js/delete.js"></script>
</body>
</html>
