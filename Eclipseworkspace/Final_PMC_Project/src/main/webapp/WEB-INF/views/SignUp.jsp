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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<body>
	<div class="helloId">
		<h1 id="title"></h1>
	</div>
	<br />
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>PMC SignUp</h6>
				</div>
				<div class="login-form">
					<form action="JSPSignUp" method="post" name="frm" id="frm"
						onsubmit="return check()">
						<div class="control-group">
							<table>
								<tr>
									<th><input type="text" name="p_id" class="login-field"
										value="" placeholder="아이디" id="userid" required="required"></th>
									<td><button type="button" value="중복확인" onclick="btn1()" /></td>
								</tr>
							</table>
						</div>
						<div class="control-group">
							<input type="password" name="p_pass" class="login-field" value=""
								placeholder="비밀번호" required="required">
						</div>
						<div class="control-group">
							<input type="password" name="p_pass2" class="login-field"
								value="" placeholder="비밀번호 확인" required="required">
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

						<input type="submit" value="Sign Up!" onclick="sign_check()"
							class="btn btn-primary btn-large btn-block"> <a
							class="login-link" href="./"> 돌아가기 </a>
					</form>
				</div>
			</div>
		</div>

	</center>
</body>
<script>
	function check() {
		var frm = document.SignUp;
		var length = frm.length - 1;
		for (var i = 0; i < length; i++) {
			if (frm[i].value == "" || frm[i].value == null) {
				alert(frm[i].name + "을 입력하세요!!");
				frm[i].focus();
				return false;
			}
		}

		return true;
	}
</script>
<script>
	var idck = 0;

	function btn1() {
		//userid 를 param.
		var userid = $("#userid").val();
		console.log(userid)
		$.ajax({
			type : 'POST',
			data : userid,
			url : "PCIdCheck",
			dataType : 'json',
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				console.log(data)
				if (data.cnt > 0) {
					alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
					idck = 0;
				} else {
					alert("사용가능한 아이디입니다.");
					//아이디가 중복하지 않으면  idck = 1 
					idck = 1;
				}

			},
			error : function(error) {
				alert("error : " + error);
			}

		});
	};

	
</script>
</html>







