<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/Style_login.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/Style.css" type="text/css">
</head>
<body>

	<div class="helloId">
		<h1 id="title"></h1>
	</div>
	<br />
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>PMC PwChange</h6>
				</div>
				<div class="login-form">
					<form action="changepw2" method="post">
				<div class="control-group">
					<input type="password" name="p_pass" class="login-field" value=""
						placeholder="비밀번호" required="required" maxlength="20" size="20"
						id="_pass">
				</div>
				<div class="control-group">
					<input type="password" name="p_pass2" class="login-field" value=""
						placeholder="비밀번호 확인" required="required" maxlength="20" size="20"
						id="_pass2">				
				</div>
				<table>
						<tr>
						<th>
						<input type="submit" value="변경" 
						class="btn btn-primary btn-large btn-block" style="width:100px;height: 50px;margin-left: 80px;">
						</th><td>
						<input type="button" value="취소" onclick="close2()" style="width:100px;height: 50px;">
						</td>
						</tr>
						</table>
			</div>
		</div>
	</center>
</body>
<script>
window.onload = function() {
	var chk = '${param.cpw}';
	
	if (chk == 1) {
		alert("변경완료!");
		self.close();
		opener.parent.location.reload();
	}else if(chk ==2){
		alert("다시 시도해 주세요");
	}

}
</script>
<script>
	function close2() {
		self.close();
	}
</script>
</html>