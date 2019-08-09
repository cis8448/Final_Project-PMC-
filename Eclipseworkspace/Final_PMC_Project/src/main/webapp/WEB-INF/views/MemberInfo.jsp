<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피모씨 관리자</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<script>
window.onload = function(){
	var chk = '${param.ct}';
	
	if(chk==1){
		document.getElementById("bl").innerHTML = "블락해제";

	}else{
		document.getElementById("bl").innerHTML = "블락설정";
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

.button2 {
	border: 1px solid skyblue;
	background-color: dodgerblue;
	color: white;
	padding: 5px;
	margin-left: 30px;
}

.LastButton {
	margin-left: 38%;
	margin-top: 10px;
}

.right {
	width: 30%;
	float: right;
	box-sizing: border-box;
	margin-right: 510px;
	border: 2px solid black;
}

.left {
	width: 100px;
	float: left;
	box-sizing: border-box;
	background-color: cadetblue;
	margin-left: 450px;
	border: 2px solid black;
}

.right2 {
	float: right;
	margin-right: 510px;
	margin-top: 10px;
	margin-bottom: 10px;
}

.content {
	border-bottom: 2px solid black;
}

h2 {
	margin-left: 700px;
}
</style>

<body>
	<header>
		<div>
        <img src="./resources/img/dd.png">
        </div> 
        <ul id="Menu">
            <li class="mainmenu"><a href="./SeatState">좌석</a></li>
            <li class="mainmenu"><a href="./Product">상품</a></li>
            <li class="mainmenu"><a href="#">회원</a></li>
            <li class="mainmenu"><a href="./MemberPayList">매출</a></li>
            <li class="mainmenu"><a href="./NoticeList?cate=0">기타</a></li>
        </ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="./MemberList">전체회원</a></li>
		</ul>
	</aside>
	<section>
		<h2>회원 상세보기</h2>
		<br>
		<div class=left>
			<p class="content">회원아이디 :</p>
			<p class="content">회원이름 :</p>
			<p class="content">생년월일 :</p>
			<p class="content">이메일 :</p>
			<p class="content">연락처 :</p>
			<p>보유시간 :</p>
		</div>

		<div class=right>
			<p class="content" id="m_id">${member.m_id}</p>
			<p class="content">${member.m_name}</p>
			<p class="content">${member.m_birthday}</p>
			<p class="content">${member.m_email}</p>
			<p class="content">${member.m_phone}</p>
			<p id="times">${member.m_time}</p>
		</div>

		<div class=right2>
			<select id="sel">
				<option value="1" selected id="hour">1시간</option>
				<option value="2" selected id="hour">2시간</option>
				<option value="3" selected id="hour">3시간</option>
				<option value="5" selected id="hour">5시간</option>
				<option value="10" selected id="hour">10시간</option>
				<option value="12" selected id="hour">12시간</option>
			</select> <input type="button" class="button2" value="시간추가"
				onclick="TimeAdd()" />

		</div>


		<br>
		<div class="LastButton">
		    <a href="#" class="button2" onclick="block(this)" id="bl">
		    ${ 1 eq param.ct ? '블락해제' : '블락설정'}</a>
			<a href="./MemberPayCheck?m_id=${member.m_id}" class="button2">매출확인</a> 
			<a href="./MemberUseLog?m_id=${member.m_id}" class="button2">사용기록</a>
			<a href="./MemberList" class="button2">뒤로가기</a>
		</div>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
	function TimeAdd() {

		var res = $("#sel option:selected").val();
		var m_id = document.getElementById('m_id').innerHTML;
		
		//var t = parseInt($("#t").val());
		var result = 'time='+res+'&m_id='+m_id
		console.log(result);
		$.ajax({
			type : 'post',
			url : 'TimeAdd',
			data : result,
			//contentType : "application/json; charset=UTF-8",
			dataType : 'json',
			success : function(data) {
				var time = document.getElementById('times');
				time.innerHTML = data.cnt;
				
			},
			error : function(data) {
				console.log("ang")
				
			}
		});
	};
	
	function block(obj) {
		var m_id = document.getElementById('m_id').innerHTML;
		
		console.log(m_id);
		
		$.ajax({
			type : 'post',
			url : 'block',
			data : m_id,
			dataType : 'json',
			success : function(data){
				if(data.success){
					
				}else{
					
				}
				location.href ="./MemberInfo?m_id="+m_id
			},
			error : function(error){
				
			}
			
		});
	}
</script>


</html>