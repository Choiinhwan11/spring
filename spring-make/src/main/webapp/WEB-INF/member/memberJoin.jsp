        <%--
  Created by IntelliJ IDEA.
  User: choiinhwan
  Date: 2024/03/19
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/memberJoin.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div id="regist_wrap" class="wrap">
    <div>
        <h1>회원가입</h1>
        <form action="/member/memberJoin" method="post" name="regiform" id="regist_form" class="form" onsubmit="return sendit()">
            <p><input type="text" name="username" id="username" placeholder="이름 입력"></p>
            <p><input type="text" name="userid" id="userid" placeholder="아이디 입력"></p>
            <p><input type="password" name="userpw" id="userpw" placeholder="비밀번호"></p>
            <p><input type="password" name="userpw_ch" id="userpw_ch" placeholder="비밀번호 확인 "></p>
            <p><input type="text" name="userphone" id="userphone" placeholder="전화번호 입력해주세요"></p>
            <p><input type="text" name="useremail" id="useremail" placeholder="E-mail"></p>
            <p class="usergender">
                <label for="male">male <input type="radio" name="usergender[]" id="male" value="male"></label>
                <label for="female">female <input type="radio" name="usergender[]" id="female" value="female"></label>

            </p>
            <p><input type="submit" value="회원가입" class="signup_btn"></p>
            <p class="pre_btn"><a href="login.jsp">Login.</a></p>


        </form>
    </div>
</div>
<script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/bagicmemberJoin.js"></script>
<script type="text/javascript" src="../js/idCheck.js"></script>
<script type="text/javascript" src="../js/memberJoin.js"></script>

</body>
</html>