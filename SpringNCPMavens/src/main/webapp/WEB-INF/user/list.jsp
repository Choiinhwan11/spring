<%--
  Created by IntelliJ IDEA.
  User: bitcamp
  Date: 2024-03-21
  Time: 오후 4:28
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
            width: 200px;
        }
        #currentPaging{
            color :red;
            border: 1px solid #ccc;
        }
        #userPagingDiv{
            max-width: 650px;
            margin-top: 10px;
            text-align: center;
        }
        #userPagingDiv span{
            padding: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <input type="hidden" id="pg" value="${pg}"><br><br>

    <a href="/"><img src="../image/딸기탕후루.jpg" width="100"></a>
    <table border="1" frame="hsides" role="rows" id="userListTable">
        <tr>
            <th>이름</th>
            <th>아이디</th>
            <th>비밀번호</th>
        </tr>
        <%-- 동적처리 --%>
    </table>

    <%-- 페이징 처리 --%>
    <div id="userPagingDiv"></div>
    <script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
    <script src="/js/list.js"></script>
    <script>
        function userPaging(pg){
            location.href = "/user/list?pg=" + pg;
        }
    </script>
</body>
</html>
