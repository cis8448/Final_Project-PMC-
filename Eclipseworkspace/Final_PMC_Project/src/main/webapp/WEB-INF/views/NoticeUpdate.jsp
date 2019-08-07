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
textarea {
	resize: none;
	width: 100%;
	height: 400px;
}

input {
	width: 100%
}

from {
	margin: 0;
	padding: 0
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
				<li class="Submenu"><a href="./NoticeList?cate=0">일반공지사항</a></li>
				<li class="Submenu"><a href="./NoticeList?cate=1">PC방공지사항</a></li>
				<li class="Submenu"><a href="./ServiceList?cate=0">일반고객센터</a></li>
				<li class="Submenu"><a href="./ServiceList?cate=1">PC방고객센터</a></li>
			</ul>
		</aside>
	</table>

	<section>
		<form action="./NoticeUpdate?no_num=${pcroomnoticebean.no_num}" method="post">
			<a href="./NoticeList" style="float: right">돌아가기</a>
				<table border="1px solid black">
				
				<tr>
					<td colspan="2">공지사항 작성</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="no_title" value="${pcroomnoticebean.no_title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="no_content">${pcroomnoticebean.no_content}</textarea></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정완료"></td>
				</tr>
			</table>
		</form>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
	<br>
	<br>
	<div align="center">${paging}</div>

</body>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<script>
function write() {
	location.href = "WriteFrm?cate=0";
}

function replyInsert(se_num){
	//form의 데이터를 javascript 객체화.
	// == json 객체
	var obj=$("#rFrm").serializeObject();
	obj.r_se_num=se_num;
	console.log(obj);
	
	$.ajax({
		type: 'post',
		url: 'replyInsert',
		data: obj,
		dataType: 'json',
		success: function(data, status, xhr){
			console.log(status);
			console.log(xhr);
			//XMLHttpRequest(객체의 폼형식 관련 API)
			console.log(data);
			
			var rlist='';
			for(var i = 0; i < data.rList.length; i++){
				rlist += '<tr height="25" align="center">'
					+'<td width="100">'+data.rList[i].r_id+'</td>'
					+'<td width="200">'+data.rList[i].r_contents+'</td>'
					+'<td width="200">'+data.rList[i].r_date +'</td></tr>';
			}
			$('#rTable').html(rlist);
		},
		error: function(xhr, status){
			alert("댓글 저장 실패");
			console.log(xhr);
			console.log(status);
		}
	});
}
</script>
</html>