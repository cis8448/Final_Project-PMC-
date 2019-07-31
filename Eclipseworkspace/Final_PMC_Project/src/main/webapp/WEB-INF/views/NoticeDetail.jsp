<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" 
	href="resources/css/Style_login.css" 
	type="text/css">
<link rel="stylesheet" 
	href="resources/css/Style.css" 
	type="text/css">
</head>
<body>
	<div class="helloId">
		<h1 id="title">PJI's Board</h1>
	</div>
	<br>
	<a href="./MasterNotice" style="float:right">돌아가기</a>
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>상세보기</h6>
				</div>
				<div class="login-form">
					글 번호
					<div class="control-group">
						<input type="text" class="login-field" 
							value="${pcroomnotice.no_num}" readonly="readonly">
					</div>
					글 제목
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomnotice.no_title}" readonly="readonly">
					</div>
					작성시간
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomnotice.no_date}" readonly="readonly">
					</div>
					글 내용
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomnotice.no_content}" readonly="readonly">
					</div>
				</div>
			</div>
		</div>
		</div>
	</center>
</body>

</html>






