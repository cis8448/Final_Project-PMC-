<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
	height: 100px
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
</style>
<body>
	<header>
		<div>
			<img src="./resources/image/dd.png">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="./Main">�¼�</a></li>
			<li class="mainmenu"><a href="#">��ǰ</a></li>
			<li class="mainmenu"><a href="#">ȸ��</a></li>
			<li class="mainmenu"><a href="#">����</a></li>
			<li class="mainmenu"><a href="./MasterNotice">��Ÿ</a></li>
		</ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="#">��������</a>
				<ul>
				<li class="SubsMenu"><a href="./MasterNotice">� ������ ->
							PC�������</a></li>
					<li class="SubsMenu"><a href="./PcmasterNotice">PC�� ������ ->
							��</a></li>
					
				</ul></li>
			<li class="SubMenu"><a href="#">������</a>
				<ul>
					<li class="SubsMenu"><a href="#">�� -> PC�������</a></li>
					<li class="SubsMenu"><a href="#">PC�� ������ -> �������</a></li>
				</ul></li>
		</ul>
	</aside>

	<section>
		<table border="1px solid black">
			<tr class="Notice">
				<td colspan="3">��������</td>
				<br>

			</tr>

			<tr class="NoticeNum">
				<td>No.</td>
				<td>����</td>
				<td>�ۼ���¥</td>
			</tr>
		</table>

	</section>

		
		<form action="./NoticeWrite">
			<button>�ۼ�</button>
		</form>
		

	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>

</html>