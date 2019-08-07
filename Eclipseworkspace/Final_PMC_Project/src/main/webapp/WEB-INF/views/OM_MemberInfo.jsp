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
    <style>
        html,body,ul{margin: 0;padding: 0;}
        div{display: inline-block;}
        ul{list-style: none}
        #Menu{list-style: none;display: inline-block;background-color: gainsboro;margin-bottom: 30px; width: 1100px; margin-left: 150px}
        #SubMenu{height: 100px}
        a{text-decoration: none; color: inherit;}
        .mainmenu{float: left;; line-height: 100px; width: 33%; text-align: center;border: 1px solid black; font-size: 30px}
        .mainmenu:nth-child(2){background-color: azure}
        .SubMenu{margin-bottom: 50px; margin-left: 20px}
        .SubMenu:first-child{margin-top: 200px;text-decoration: underline}
        header{position: fixed; z-index: 999;background-color: white;width: 100%}
        aside{position:  relative; top: 180px;float: left;width: 10%; left: 70px}
        section{position: relative; top: 10px;float: left;width: 80%; margin-left: 250px;}
        footer{background-color: antiquewhite;display: block;content: '';clear: both;text-align: center;position: fixed;bottom: 0px;width: 100%}
        .SubMenu:hover{text-decoration: underline}
        .mainmenu:hover{background-color: azure}
        img{width:300px;height:200px; padding:10px;}
        input:-ms-input-placeholder {color:#a8a8a8;}
        input::-webkit-input-placeholer {color:a8a8a8;}
        input::-moz-placeholder {color:a8a8a8;}
        .Search{height: 40px; width: 400px; border: 1px solid #1b5ac2; background: #ffffff; margin-left: 60%;}
        input{font-size: 16px; width: 325px; padding: 10px; border: 0px; outline: none; float: left; }
        button{width: 50px; height: 100%; border: 0px; background: #1b5ac2; outline: none; float: right; color: #ffffff}
        .MemberInfo{width: 100px; height: 100%; background: #1b5ac2; color: #ffffff}
		.button2 {border: 1px solid skyblue; background-color: dodgerblue; color: white; padding: 5px; margin-left: 30px;}
		.LastButton {margin-left: 59.6%; margin-top: 10px;}
		.right { width: 30%; float: right; box-sizing: border-box; margin-right: 510px; border: 2px solid black;}
		.left { width: 110px; float: left; box-sizing: border-box; background-color: cadetblue; margin-left: 435px; border: 2px solid black;}
		.content {border-bottom: 2px solid black;}
		h2 {margin-left: 700px;}
    </style>

<body>
	<header>
		<div>
			<img src="./resources/img/pmc1.jpg">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="./OM_Approval">PC방업주관리</a></li>
            <li class="mainmenu"><a href="./OM_MemberList">PC방전체회원</a></li>
            <li class="mainmenu"><a href="./#">PC방공지사항</a></li>
		</ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="./OM_MemberList">전체회원</a></li>
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
			<p class="content" id="m_id">${OMmember.m_id}</p>
			<p class="content">${OMmember.m_name}</p>
			<p class="content">${OMmember.m_birthday}</p>
			<p class="content">${OMmember.m_email}</p>
			<p class="content">${OMmember.m_phone}</p>
			<p id="times">${OMmember.m_time}</p>
		</div>

		<br>
		<div class="LastButton">
			<a href="./OM_MemberList" class="button2">뒤로가기</a>
		</div>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>

</html>