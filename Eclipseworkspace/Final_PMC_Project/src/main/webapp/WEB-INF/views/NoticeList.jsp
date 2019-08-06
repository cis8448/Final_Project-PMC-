<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
html, body, ul {
	margin: 0;
	padding: 0;
}

div {
	display: inline-block;
}

ul {
	list-style: none
}

#Menu {
	list-style: none;
	display: inline-block;
	background-color: gainsboro;
	margin-bottom: 30px;
	width: 1200px;
	margin-left: 130px
}

#SubMenu {
	margin-top:250px;
	height: 100px;
}

a {
	text-decoration: none;
	color: inherit;
}

.mainmenu {
	float: left;;
	line-height: 100px;
	width: 19.8%;
	text-align: center;
	border: 1px solid black;
	font-size: 50px
}

.mainmenu:last-child {
	background-color: azure;
}

.SubMenu {
	margin-bottom: 50px;
	margin-left: 20px
}

.SubMenu:first-child {
	margin-top: 200px;
	text-decoration: underline
}

header {
	position: fixed;
	z-index: 999;
	background-color: white;
	width: 100%
}

aside {
	position: relative;
	top: 180px;
	float: left;
	width: 10%;
	left: 70px
}

section {
	background-color:;
	position: relative;
	top: 250px;
	float: right;
	width: 80%
}

footer {
	background-color: antiquewhite;
	display: block;
	content: '';
	clear: both;
	text-align: center;
	position: fixed;
	bottom: 0px;
	width: 100%
}

.SubMenu:hover {
	text-decoration: underline
}

.mainmenu:hover {
	background-color: azure
}

img {
	width: 150px;
	height: 200px;
	padding: 10px;
}

table {
	width: 80%;
	text-align: center
}

.button {
	border: 1px solid skyblue;
	background-color: dodgerblue;
	color: white;
	padding: 5px;
	margin-left: 30px;
	
}

</style>
<body>
	
		<div>
			<img src="./resources/image/dd.png">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="./Main">좌석</a></li>
			<li class="mainmenu"><a href="./Product">상품</a></li>
			<li class="mainmenu"><a href="./MemberList">회원</a></li>
			<li class="mainmenu"><a href="./MemberPayList">매출</a></li>
			<li class="mainmenu"><a href="./NoticeList">기타</a></li>
		</ul>
	

	
	
	<table>
	<aside>
    <ul id="SubMenu">
    	<li class="Submenu"><a href="./NoticeList">전체 공지사항</a></li>
    </ul>
	</aside>
</table>

	<section>
		<table border="1px solid black">
			<tr class="Notice">
				<td colspan="5">공지사항</td>
				<br>
			</tr>

			<tr class="NoticeNum">
				<td>No</td>
				<td>제목</td>
				<td>작성날짜</td>
				<td>글내용</td>
				<td>카테고리</td>
			</tr>
			

			<c:forEach var="pcroomnoticebean" items="${nList}">
				<tr>
					<td align="center">${pcroomnoticebean.no_p_id}</td>
					<td align="center">${pcroomnoticebean.no_num}</td>
					<td align="center">${pcroomnoticebean.no_title}</td>
					<td align="center">${pcroomnoticebean.no_content}</td>
					<td align="center">${pcroomnoticebean.no_date}</td>
					<td align="center">${pcroomnoticebean.no_cate}</td>
					
				</tr>
			</c:forEach>
		</table>
		
	</section>
			
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>

	<br>
	<br>
	
	<div align="center">${paging}</div>
</body>

</html>