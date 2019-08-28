<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피모씨 운영관리자</title>
<style>
input {
	width: 150px;
	height: 100px;
}

table {
	width: 60%;
	height: 100%;
	margin: auto;
	text-align: center;
	margin-top:
}
</style>
</head>
<body>
	<br>
	<br>
	<center>
		<h1>운영관리자</h1>
		<hr style="border: solid; 1 px; width: 70%; margin-bottom: 200px;">
	</center>
	<table>
		<tr>
			<th><input type="button" value="미승인 피시방 관리" style=""
				onclick="btn1(1)"></th>
			<th><input type="button" value="승인  피시방관리" style=""
				onclick="btn1(2)"></th>
			<th><input type="button" value="고객센터 관리" style=""
				onclick="btn1(4)"></th>
			
		</tr>
	</table>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function btn1(a) {
		if (a == 1) {
			location.href = "OM_Approval";
		} else if (a == 2) {
			location.href = "OM_Approvalx";
		} else if (a == 4) {
			location.href = "OM_MemberList";
		}  else if (a == 6) {

		}

	}
</script>
</html>