<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Login.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>	
	<center>
	<p id="mungu"></p>
	</center>
</body>
<script>
window.onload = function() {
	var chk = '${param.check}';
	
	if (chk == 1) {
		document.getElementById("mungu").innerHTML="블락된 계정입니다!";
	}if(chk == 2){
		document.getElementById("mungu").innerHTML="아이디 or 비밀번호가 틀립니다!";
	}

}
</script>
</html>