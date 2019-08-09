<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운영관리자 전체회원</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
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
	width: 1100px;
	margin-left: 150px
}

#SubMenu {
	height: 100px
}

a {
	text-decoration: none;
	color: inherit;
}

.mainmenu {
	float: left;;
	line-height: 100px;
	width: 24.8%;
	text-align: center;
	border: 1px solid black;
	font-size: 30px
}

.mainmenu:nth-child(3) {
	background-color: azure
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
	position: relative;
	top: 10px;
	float: left;
	width: 80%;
	margin-left: 250px;
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
	width: 300px;
	height: 200px;
	padding: 10px;
}

input:-ms-input-placeholder {
	color: #a8a8a8;
}

input::-webkit-input-placeholer {
	color: a8a8a8;
}

input::-moz-placeholder {
	color: a8a8a8;
}

.Search {
	height: 40px;
	width: 400px;
	border: 1px solid #1b5ac2;
	background: #ffffff;
	margin-left: 60%;
}

input {
	font-size: 16px;
	width: 325px;
	padding: 10px;
	border: 0px;
	outline: none;
	float: left;
}

button {
	width: 50px;
	height: 100%;
	border: 0px;
	background: #1b5ac2;
	outline: none;
	float: right;
	color: #ffffff
}

.MemberInfo {
	width: 100px;
	height: 100%;
	background: #1b5ac2;
	color: #ffffff
}
</style>

<body>
	<header>
		<div>
			<img src="./resources/img/pmc1.jpg">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="./OM_Approval">PC방업주관리</a></li>
			<li class="mainmenu"><a href="./OM_MemberList">PC방전체회원</a></li>
			<li class="mainmenu"><a href="./OM_Notice?cate=0">PC방 공지사항</a></li>
			<li class="mainmenu"><a href="./OM_Service?cate=1">PC방 고객센터</a></li>
		</ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="./OM_Notice?cate=0">PC방 공지</a></li>
			<li class="SubMenu"><a href="./OM_Notice?cate=2">앱 공지</a></li>
		</ul>
	</aside>
	<section>
		<div class="Search">
			<input type="text" placeholder="작성자 아이디 OR 글 제목" id="SearchArea"
				value="">
			<button type="button" onclick="OMMemberSearch()">검색</button>
		</div>
		<br>
		<table border="1" bordercolor="#3D3D3D" width="1200" height="100"
			align="center">
			<tr bgcolor="blue" align="center">
				<p>
				<td colspan="6" span style="color: white">공지사항 목록</td>
				</p>
			</tr>
			<tr align="center" bgcolor="skybule">
				<td>점주 아이디</td>
				<td style="width: 30%;">공지사항 제목</td>
				<td>작성시간</td>
				<td>비고</td>
			</tr>
			<tbody id="resultSearch" align="center">
				<c:forEach var="no" items="${nList}">
					<tr align="center">
						<td id="Search">${no.no_p_id}</td>
						<td>${no.no_title}</td>
						<td>${no.no_date}</td>
						<td><a href="./OM_NoticeInfo?no_num=${no.no_num}"
							class="MemberInfo">상세보기</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="OM_Nwrite">작성</a>
		<div align="center">${paging}</div>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
	function OMMemberSearch() {

		var res = $('#SearchArea').val();//입력한 값 받아오기

		console.log(res);

		$.ajax({
			type : 'post',
			url : 'OMNoticeSearch',
			data : res,
			dataType : 'json',
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				console.log(data)
				var tbl = document.getElementById('resultSearch');
				var result = "";
				for (var i = 0; i < data.length; i++) {
					result += '<tr align="center">'
					result += '<td id="Search">' + data[i].no_p_id + '</td>'
					result += '<td>' + data[i].no_title + '</td>'
					result += '<td>' + data[i].no_date + '</td>'
					result += '<td><a href="./OM_NoticeInfo?no_num='
							+ data[i].no_num
							+ '" class="MemberInfo">상세보기</a></td>'
					result += '</tr>'
				}

				tbl.innerHTML = result;

			}
		})

	};
</script>
<script type="text/javascript">
	function write() {
		location.href = "OM_Nwrite";
	}
</script>
</html>