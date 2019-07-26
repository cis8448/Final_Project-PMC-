<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="resources/css/Style_login.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/Style.css" type="text/css">
</head>
<body>
<body>
<div class="helloId">
<h1 id="title"> jsj's Board </h1>
</div><br/>
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>회원 가입</h6>
				</div>
				<div class="login-form">

					<form action="memberInsert" method="post" name="joinFrm"
						onsubmit="return check()">
						<div class="control-group">
							<input type="text" name="m_id" 
								class="login-field" value=""
								placeholder="아이디">
						</div>
						<div class="control-group">
							<input type="password" name="m_pwd" 
								class="login-field" value=""
								placeholder="비밀번호">
						</div>
						<div class="control-group">
							<input type="text" name="m_name" 
								class="login-field" value=""
								placeholder="이름">
						</div>
						<div class="control-group">
							<input type="text" name="m_birth" 
								class="login-field" value=""
								placeholder="생년월일(20190101)">
						</div>
						
						<div class="control-group">
							<input type="text" name="m_addr" 
								class="login-field" value=""
								placeholder="주소">
						</div>
						<div class="control-group">
							<input type="text" name="m_phone" 
							class="login-field" value=""
								placeholder="전화번호(숫자만입력하세요!)">
						</div>
						
						<input type="submit" value="Join!"
							class="btn btn-primary btn-large btn-block"> <a
							class="login-link" href="./"> 돌아가기 </a>

					</form>
				</div>
			</div>
		</div>

	</center>
</body>
<script>
function check(){
	var frm = document.joinFrm;
	var length = frm.length - 1;//submit 제외
	for(var i = 0; i < length; i++){
		if(frm[i].value == "" || frm[i].value == null){
			alert(frm[i].name + "을 입력하세요!!");
			frm[i].focus();
			return false;//입력 안했을 경우
		}
	}
	return true;//입력이 다 처리 됐으면.
}
</script>
</html>







