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
<title>피모씨 관리자</title>
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

.mainmenu:first-child {
	background-color: azure
}

.SubMenu {
	margin-bottom: 50px;
	margin-left: 20px
}

.SubMenu:first-child {
	margin-top: 200px;
}

.SubMenu:last_child {
	text-decoration: underline
}

header {
	position: fixed;
	z-index: 999;
	background-color: white;
	width: 100%
}

aside {
	position: fixed;
	top: 180px;
	float: left;
	width: 10%;
	left: 70px
}

section {
	position: relative;
	top: 180px;
	float: right;
	width: 80%;
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

.Pc_roomImg {
	text-align: center;
}

.Img {
	display: block;
	margin: auto;
	width: 30%;
	height: 200px
}

table {
	width: 81%;
	margin-top: 30px;
	text-align: center
}

.AddMenu {
	display: inline-block;
	width: 1200px
}

.AddMenu>li {
	float: left;
	margin-left: 90%
}

.AddMenu>li:last-child {
	margin: 0
}

li:after {
	display: block;
	content: '';
	clear: both;
}

.addbtn {
	font-size: 30px;
	width: 100%
}

#imgbix {
	width: 81%;
}

input {
	display: block;
	magin: auto;
}

#enbtn {
	margin-left: 75%;
}
</style>


<body>
	<header>
		<div>
			<img src="./resources/img/dd.png" id="pcimg">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="#">좌석</a></li>
			<li class="mainmenu"><a href="./MemberList">회원</a></li>
			<li class="mainmenu"><a href="./product">상품</a></li>
			<li class="mainmenu"><a href="./MemberPayList">매출</a></li>
			<li class="mainmenu"><a href="./pcmasternotice">기타</a></li>
		</ul>
	</header>
	<aside>

		<div>
			<a href=#>'${id}'님 안녕하세요</a>
			<p />
			<button onclick="btn2()">정보 수정</button>
			<button onclick="btn3()">PC방 사진등록</button>
			<form action="#">
				<input type="button" onclick="btn1()" id="button1" value=""
					style="width: 70px; height: 30px;">
			</form>
		</div>

		<ul id="SubMenu">
			<li class="SubMenu"><a href="#">좌석정보</a></li>
			<li class="SubMenu"><a href="./SeatDetail">좌석 상세보기 / 수정</a></li>
			<li class="SubMenu"><a href="./SeatUpdate">좌석 배치 변경</a></li>
		</ul>
	</aside>
	<section>
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
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	var param = '${sessionScope.id}'
	var result = "";
	setTimeout(
			function() {
				$
						.ajax({
							type : 'post',
							url : 'SeatChecker',
							data : param,
							contentType : "application/json; charset=UTF-8",
							dataType : "json",
							success : function(data) {
								var tbl = document.getElementById('tb1');

								console.log(data);
								result += '<tr><td>pc번호</td><td>사용상태</td><td>사용자아아디</td><td>남은 시간</td>'
								for (var i = 0; i < data.length; i++) {
									result += '<tr>';
									result += '<td>' + data[i].s_id + '</td>';
									result += '<td>' + data[i].s_state
											+ '</td>';
									result += '<td>' + data[i].m_id + '</td>';
									result += '<td>' + data[i].m_time + '</td>';
									result += '</tr>'
								}
								console.log(result);
								tbl.innerHTML = result;
							},
							error : function(error) {
								alert("실패");
							}

						})

			}, 10000)
</script>
<script type="text/javascript">
	function btn2() {
		var url = "PCInfoUpdate";
		var name = "popup2222";
		var option = "width=700 , height=600";
		window.open(url, name, option);
	}
</script>
<script type="text/javascript">
	function btn3() {
		var url = "PC";
		var name = "popup2222";
		var option = "width=700 , height=600";
		window.open(url, name, option);
	}
</script>
</html>
