<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>로그인 페이지</title>
<link rel="stylesheet" 
	href="resources/css/Style_login.css" 
	type="text/css">
<link rel="stylesheet" 
	href="resources/css/Style.css" 
	type="text/css">
<script>
window.onload=function(){
	var chk=${check};
	
	if(chk==1){
		alert("회원가입 성공");
	}
	if(chk==2){
		alert("로그인 실패");
	}
}
</script>
</head>
<body>
<div class="helloId">
<h1 id="title">한조 PC방 관리자용</h1>
</div><br/>
<center>
	<div class="login">
		<div class="login-screen">
			<div class="app-title">
				<img src="./resources/image/dd.png" width="200" height="140">
			</div>
			<div class="login-form">
				<form action="access" method="post">
				<div class="control-group">
				<input type="text" class="login-field" value="" placeholder="아이디 입력" name="m_id">
				</div>
				<div class="control-group">
				<input type="password" class="login-field" value="" placeholder="비밀번호 입력" name="m_pwd">
				</div>

				<button class="btn">로그인</button>
				<a class="login-link" href="./joinFrm"> 회원가입 </a>
				</form>	
			</div>
		</div>
	</div>
</center>

<<<<<<< HEAD
=======
kdydkddkdkdy
>>>>>>> 8aee5e3cc6b0457bcd35c393bf15d79fee5aa237
</body>
</html>