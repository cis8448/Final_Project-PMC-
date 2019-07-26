<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="resources/css/Style_login.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/Style.css" type="text/css">

</head>
<body>
	<div class="helloId">
		<h1 id="title">한조PC방 관리자 회원가입</h1>
	</div>
	<br />
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<img src="./resources/image/dd.png" width="200" height="140">
				</div>
				<div class="login-form">

					<form action="pcroomInsert" method="post">
						<div class="control-group">
							<table>
								<tr>
									<th><input type="text" name="p_id" class="login-field"
										value="" placeholder="아이디" required="required"></th>
									<form action="">
										<td><input type="submit" value="중복확인" id="btn1"></td> 
										<input type="hidden" value="p_id">
								</tr>
							</table>
				</div>
				<div class="control-group">
					<input type="password" name="p_pass" class="login-field" value=""
						placeholder="비밀번호" required="required">
				</div>
				<div class="control-group">
					<input type="password" name="p_pass2" class="login-field" value=""
						placeholder="비밀번호 확인" required="required">
				</div>
				<div class="control-group">
					<input type="text" name="p_name" class="login-field" value=""
						placeholder="업체명" required="required">
				</div>
				<div class="control-group">
					<input type="text" name="p_addr" class="login-field" value=""
						placeholder="주소" required="required">
				</div>
				<div class="control-group">
					<input type="text" name="p_phone" class="login-field" value=""
						placeholder="전화번호(숫자만입력하세요!)" required="required">
				</div>
				<div class="control-group">
					<input type="text" name="p_email" class="login-field" value=""
						placeholder="이메일" required="required">
				</div>

				<input type="submit" value="Join!"      
					class="btn btn-primary btn-large btn-block"> 
					
					<a class="login-link" href="./"> 돌아가기 </a>
				</form>
			</div>
		</div>
		</div>

	</center>


</body>
</html>