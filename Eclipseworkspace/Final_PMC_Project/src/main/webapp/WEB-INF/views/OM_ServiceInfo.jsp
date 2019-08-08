<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운영관리자 상세회원정보</title>
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

.mainmenu:nth-child(4) {
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

.right {
	width: 30%;
	float: right;
	box-sizing: border-box;
	margin-right: 510px;
	border: 2px solid black;
}

.left {
	width: 110px;
	float: left;
	box-sizing: border-box;
	background-color: cadetblue;
	margin-left: 435px;
	border: 2px solid black;
}

.content {
	border-bottom: 2px solid black;
}

h2 {
	margin-left: 700px;
}

.LastButton {
	margin-left: 59.6%;
	margin-top: 10px;
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
			<li class="mainmenu"><a href="./OM_Service?cate=0">PC방 고객센터</a></li>
		</ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="./OM_ServiceInfo?cate=0">PC방 고객센터</a></li>
			<li class="SubMenu"><a href="./OM_ServiceInfo?cate=1">앱 고객센터</a></li>
		</ul>
	</aside>
	<section>
		<h2>공지사항 상세보기</h2>
		<br>
		<div class=left>
			<p class="content">from :</p>
			<p class="content">to :</p>
			<p class="content">글제목 :</p>			
			<p>글내용 :</p>

		</div>

		<div class=right>
			<p class="content" id="no_p_id">${OMservice.no_m_id}</p>
			<p class="content" id="no_p_id">${OMservice.no_p_id}</p>
			<p class="content">${OMservice.no_title}</p>
			<p>${OMservice.no_content}</p>

		</div>

		<br>
		<div class="LastButton">
			<a href="./OM_Service?cate=0" class="button2">뒤로가기</a>
		</div>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>

</html>