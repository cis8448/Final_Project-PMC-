<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <style>
        html,body,ul{margin: 0;padding: 0;}
        div{display: inline-block;}
        ul{list-style: none}
        #Menu{list-style: none;display: inline-block;background-color: gainsboro;margin-bottom: 30px; width: 1200px; margin-left: 130px}
        #SubMenu{height: 100px}
        a{text-decoration: none; color: inherit;}
        .mainmenu{float: left;; line-height: 100px; width: 19.8%; text-align: center;border: 1px solid black; font-size: 50px}
        .mainmenu:nth-child(4){background-color: azure}
        .SubMenu{margin-bottom: 50px; margin-left: 20px}
        .SubMenu:first-child{margin-top: 200px;}
        .SubMenu:nth-child(2){text-decoration: underline}
        header{position: fixed; z-index: 999;background-color: white;width: 100%}
        aside{position:  relative; top: 180px;float: left;width: 10%; left: 70px}
        section{position: relative; top: 250px;float: right;width: 80%}
        footer{background-color: antiquewhite;display: block;content: '';clear: both;text-align: center;position: fixed;bottom: 0px;width: 100%}
        .SubMenu:hover{text-decoration: underline}
        .mainmenu:hover{background-color: azure}
        img{width:300px;height:200px; padding:10px;}
        #aa{margin-left: 80%}
        #bb{width: 100%}
        .Paymenu{width: 10%;height:40px; text-align: center;border: 1px solid black; font-size: 12px}
    	button{width: 50px; height: 100%; border: 1px solid; background: #1b5ac2; outline: none; float: right; color: #ffffff}
                
    </style>



<body>

	<header>
		<div>
			<img src="./resources/img/dd.png" width="200" height="140">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="./Main">좌석</a></li>
			<li class="mainmenu"><a href="#">상품</a></li>
			<li class="mainmenu"><a href="#">회원</a></li>
			<li class="mainmenu"><a href="#">매출</a></li>
			<li class="mainmenu"><a href="#">기타</a></li>
		</ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="./MemberPayList">월별 매출</a></li>
			<li class="SubMenu"><a href="./CatePayList">카테고리별 매출</a></li>
			<li class="SubMenu"><a href="./TimePayList">충전시간 매출</a></li>
		</ul>
	</aside>
	<section>
	
	<table id="aa">
		<tr>
			<td><select name="pcselectyear">
					<option value="2018" selected>2018년</option>
					<option value="2019" selected>2019년</option>
			</select></td>

			<td><select name="pcselectmonth">
					<option value="1" selected>1월</option>
					<option value="2" selected>2월</option>
					<option value="3" selected>3월</option>
					<option value="4" selected>4월</option>
					<option value="5" selected>5월</option>
					<option value="6" selected>6월</option>
					<option value="7" selected>7월</option>
					<option value="8" selected>8월</option>
					<option value="9" selected>9월</option>
					<option value="10" selected>10월</option>
					<option value="11" selected>11월</option>
					<option value="12" selected>12월</option>


			</select></td>

				<td><button>검색</button></td>
		</tr>
	</table>
	<table id="bb">
		<tr>
			<td class="Paymenu"><button>카테고리</button></td>
		</tr>
	</table>

	
	<table id="bb">
		<tr>
			<td class="Paymenu">일</td>
			<td class="Paymenu">시간</td>
			<td class="Paymenu">ID</td>
			<td class="Paymenu">상품명</td>
			<td class="Paymenu">수량</td>
			<td class="Paymenu">가격</td>
			
		</tr>
	</table>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>


</body>
</html>