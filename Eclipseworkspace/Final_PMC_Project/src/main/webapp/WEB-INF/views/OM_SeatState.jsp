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
<title>Insert title here</title>
</head>
<body>
	<center>
		<div id="imgbix">
			<img
				src="./resources/${(not empty Sfile) ?    Sfile.c_content: 'img/No_image.png'}"
				class="Pc_roomImg Img" alt="pc방 배치도" id="img">
		</div>
		<table border="1px solid black" id="tb1">
			<tr>
				<td>Pc번호</td>
				<td>사용 상태</td>
				<td>사용자 아이디</td>
				<td>남은시간</td>
			</tr>
			<c:forEach var="SeatBean" items="${Slist}">
				<tr>
					<td>${SeatBean.s_id}</td>
					<td>${SeatBean.s_state}</td>
					<td>${SeatBean.m_id}</td>
					<td>${SeatBean.m_time}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>