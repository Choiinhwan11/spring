<%--
  Created by IntelliJ IDEA.
  User: bitcamp
  Date: 2024-03-21
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

    </style>


</head>
<body>
  <form id="writeForm">
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
                  <input type="text" name="id" id="id"/>
                  <div id="idDiv"></div>
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
                  <input type="button" value="입력" id="writeBtn"/>
                  <input type="reset" value="취소"/>
              </td>
          </tr>
      </table>
  </form>
  <script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
  <script src="/js/write.js"></script>
</body>
</html>
