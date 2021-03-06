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
<script>
window.onload = function(){
	var ck = '${cate}'
	var cc = document.getElementById("btn1")

	
	
	if(ck==	3){
		cc.disabled = true;
	}
	if(ck==	4){
		cc.disabled = false;
	}
	
	
	
}
</script>
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

#Menu{list-style: none;display: inline-block;background-color: white;margin-bottom: 30px; width: 1200px; margin-left: 130px}

#SubMenu {
	margin-top: 250px;
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
		<li class="mainmenu"><a href="./SeatState">좌석</a></li>
		<li class="mainmenu"><a href="./Product">상품</a></li>
		<li class="mainmenu"><a href="./MemberList">회원</a></li>
		<li class="mainmenu"><a href="./MemberPayList">매출</a></li>
		
	</ul>




	<table>
		<aside>
			<ul id="SubMenu">
				<li class="Submenu"><a href="./NoticeList?cate=0">일반공지사항</a></li>
				<li class="Submenu"><a href="./NoticeList?cate=1">PC방공지사항</a></li>
				<li class="Submenu"><a href="./ServiceList?cate=0">일반고객센터</a></li>
				<li class="Submenu"><a href="./ServiceList?cate=1">PC방고객센터</a></li>
			</ul>
		</aside>
	</table>

	<section>
		<table border="1px solid black">
			<tr class="Service">
				<td colspan="5">고객센터</td>
				<br>
			</tr>

			<tr class="ServiceNum">
				<td>작성자ID</td>
				<td style="width: 60%">글제목</td>
				<td>글내용</td>
				

			</tr>

			<form action="WriteFrm?cate=${cate}" method="post">
				<c:forEach var="pcroomnoticebean" items="${nList}">
					<tr>
						<td align="center">${pcroomnoticebean.no_m_id}</td>
						<td align="center"><a href="./NoticeDetail?no_num=${pcroomnoticebean.no_num}&no_cate=${cate}">${pcroomnoticebean.no_title}</td>
						<td align="center">${pcroomnoticebean.no_content}</td>
						

					</tr>
				</c:forEach>
		</table>


		<input type="submit" value="글작성" id="btn1" >
		</form>
	</section>

	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>




	<br>
	<br>

	<div align="center">${paging}</div>
</body>

<script type="text/javascript">
	var num = ${cate}
	var btn =document.getElementById("btn1")
	if(num == 0){
		btn.setAttribute("disabled","true")
	}else{
		btn.removeAttribute("")
	}
	function write(){
		location.href="WriteFrm?cate=";	
	}
	
</script>

</html>