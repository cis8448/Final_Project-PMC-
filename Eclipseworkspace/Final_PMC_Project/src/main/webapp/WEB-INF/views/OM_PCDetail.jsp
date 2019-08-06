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
					<h6>PMC PCInfoDetail</h6>
				</div>
				<div class="login-form">
					<div class="control-group">
						<input type="text" name="p_id" class="login-field"
							value="${pcr.p_id}" readonly="readonly">
					</div>
					<div class="control-group">
						<input type="text" class="login-field" value="${pcr.p_name }"
							readonly="readonly">
					</div>
					<div class="control-group">
						<input type="text" value="${pcr.p_sido }" readonly="readonly">
						<input type="text" value="${pcr.p_gugun }" readonly="readonly">
						<input type="text" value="${pcr.p_dong }" readonly="readonly">
						<input type="text" value="${pcr.p_addr }" readonly="readonly">
					</div>
					<div class="control-group">
						<input type="text" class="login-field" value="${pcr.p_phone }"
							readonly="readonly">
					</div>
					<div class="control-group">
						<input type="text" class="login-field" value="${pcr.p_email }">
					</div>
					<div class="control-group">
						첨부파일
						<div class="control-group">
							<c:set var="file" value="${bfList }" />
							<c:if test="${empty file }">
						첨부파일없음.
						<%
								session.setAttribute("fileChk", 1);
							%>

							</c:if>
							<c:if test="${!empty file }">
								<c:forEach var="bf" items="${bfList }">
									<a href="./download?sysFileName=${bf.bf_sysName}">${bf.bf_sysName }</a>
								</c:forEach>
							</c:if>
						</div>
					</div>
					<a class="login-link" href="#" onclick="cancel()"> 돌아가기 </a>
				</div>
			</div>
		</div>

	</center>

</body>
<script>
	function cancel() {
		self.close();
	}
</script>
</html>