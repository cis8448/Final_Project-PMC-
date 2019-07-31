<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>
<div class="helloId">
<h1 id="title">PMC LogIn</h1>
</div><br/>
<center>
	<div class="login" style="width: 1000px;">
		<div class="login-screen" style="width: 1000px;">
			<div class="app-title">
				<img src="./resources/img/dd.png" width="200" height="140">
			</div>
			<div class="login-form">
				<form action="JSPLoginCall" method="post">
				<div class="control-group">
				<input type="text" class="login-field" value="" placeholder="아이디 입력" name="p_id">
				</div>
				<div class="control-group">
				<input type="password" class="login-field" value="" placeholder="비밀번호 입력" name="p_pass">
				</div>
				<button class="btn">로그인</button>
				<a class="login-link" href="./SignUp"> 회원가입 </a><a class="login-link" href="./id"> 아이디/비밀번호찾기 </a>
				</form>	
			</div>
		</div>
	</div>
</center>
</body>
<script>
window.onload=function(){
	var chk= ${param.check};
	
	if(chk==1){
		alert("회원가입 성공");
	}
	if(chk==2){
		alert("아이디 or 비밀번호가 틀립니다!");
	}
}
</script>
</html>