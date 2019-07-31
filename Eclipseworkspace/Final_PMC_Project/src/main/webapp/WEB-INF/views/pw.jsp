<%@page import="com.pmc.final_project.util.MailUtil"%>
<%@page import="com.pmc.final_project.util.FindUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.buttons {
	color: #fff;
	background: #3232FF;
	font-size: 1.5em;
	padding: 5px 20px;
	border-radius: 0.5em;
	width: 250px;
	height: 90px;
}

input {
	margin-top: 20px;
}
</style>
</head>
<body>

	<header>
		<center>
			<pre>
        <h1 style="color: cornflowerblue; font-size: 40px">관리자
아이디/비밀번호 찾기</h1>
        </pre>
		</center>
	</header>
	<section>
		<center>
			<div>
				<button class="buttons" id="button1" onclick="location.href='./id'"
					style="background: #3232FF">아이디 찾기</button>
				<button class="buttons"
					style="margin-left: 50px; background: #6EE0FF;" id="button2"
					onclick="location.href='./pw'">비밀번호 찾기</button>
			</div>


		</center>
	</section>
	<link rel="stylesheet" href="resources/css/Style_login.css"
		type="text/css">
	<link rel="stylesheet" href="resources/css/Style.css" type="text/css">
	<div class="login" style="width: 550px; height: 400px;">
		<div class="login-screen" style="width: 550px; height: 400px;">
			<div class="login-form">
				<form action="pwsearch" method="post">

					<div class="contror-group">
						<input type="text" name="p_id" placeholder="아이디를 입력해주세요"
							class="login-field" style="margin-top: 80px;">
					</div>
					
					<div class="contror-group">
						<input type="text" name="p_phone" placeholder="전화번호를 입력해주세요"
							class="login-field">
					</div>





					<input type="submit" value="찾기"
						style="background: #3232FF; color: white; margin-top: 150px; width: 100px">
					<input type="button" value="취소"
						style="background: #3232FF; color: white; margin-top: 150px; width: 100px"
						onclick="cancel()">
				</form>

			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	window.onload = function() {
		var chk = '${param.check}';

		if (chk == 1) {
			alert("비밀번호 변경 완료");
		}

	}
</script>
<script>
function cancel() {
	
	location.href="./"
	
}

</script>
</html>