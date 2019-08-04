<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>피모씨 관리자</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
</head>
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
        .SubMenu:first-child{margin-top: 200px;text-decoration: underline}
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
        button{width: 100px; height: 30px; border: 1px solid; background: #1b5ac2; outline: none; float: right; color: #ffffff}
                
    </style>



<body>

	<header>
		<div>
			<img src="./resources/img/dd.png" width="200" height="140">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="./">좌석</a></li>
			<li class="mainmenu"><a href="#">상품</a></li>
			<li class="mainmenu"><a href="#">회원</a></li>
			<li class="mainmenu"><a href="./MemberPayList">매출</a></li>
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

<form method="post" action="./MemberPayList.jsp"></form>
	<table id="aa">
		<tr>
			<td><select id="selectyear">
			<c:forEach var="paymentdetail" items="${pList}">
			<c:set var="Year" value="${paymentdetail.u_start}"/>
					<option>${fn:substring(Year,0,4)}</option>
			</c:forEach>		
			</select></td>
			
				<td><select id="selectmonth">
					<c:forEach var="paymentdetail" items="${pList}">
			<c:set var="Month" value="${paymentdetail.u_start}"/>
					<option>${fn:substring(Month,5,7)}</option>
			</c:forEach>	


			</select></td>
		

		
				<td><input type="button" onclick="search(${selectyear}, ${selectmonth});return false;" id="search" value="선택"></input></td>
			
		</tr>
	</table>
	<table id="bb" border="1">
		<tr>
			<td class="Paymenu">일</td>
			<td class="Paymenu">시간</td>
			<td class="Paymenu">카테고리</td>
			<td class="Paymenu">ID</td>
			<td class="Paymenu">상품명</td>
			<td class="Paymenu">수량</td>
			<td class="Paymenu">가격</td>
			
		</tr>	
		<c:forEach var="paymentdetail" items="${pList}">
		<c:set var="Date" value="${paymentdetail.u_start}"/>
    	<tr>
    		<td>${fn:substring(Date,8,10)}</td>
            <td>${fn:substring(Date,11,19)}</td>
    		<td>${paymentdetail.pc_name}</td>
    		<td>${paymentdetail.m_id}</td>
    		<td>${paymentdetail.pr_name}</td>
    		<td>${paymentdetail.pl_qty}</td>
    		<td>${paymentdetail.pl_price}</td>
    		
    	</tr>
    	</c:forEach>
	</table>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>


</body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$("#search").click(function(){
	var c = $("#selectyear option:selected").val();
	var d = $("#selectmonth option:selected").val();

	
			console.log(c);
			console.log(d);
	
});

</script>
</html>