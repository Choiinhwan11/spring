
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<link rel="stylesheet" href="../css/findId.css">
	<link rel="stylesheet" href="../css/memberJoin.css">
</head>
<body>
<section class="login-form">
	<h1> 팀명 </h1>
	<form action="login">
		<div class="int-area">
			<input type="text" name="userid" id="userid" autocomplete="off" required>
			<label for="userid">id</label>
		</div>
		<div class="int-area">
			<input type="password" name="userpw" id="userpw" autocomplete="off" required>
			<label for="userpw">password </label>
		</div>

		<div class="btn-area">
			<button type="submit" id="btn">login</button>
		</div>
	</form>
	<div class="caption">
		<a href="findId.jsp">아이디 찾기</a>/
		<a href="findPassword.jsp">비밀번호 찾기</a>/
		<a href="memberJoin.jsp">회원가입</a>
	</div>
</section>
<script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
</body>
</html>