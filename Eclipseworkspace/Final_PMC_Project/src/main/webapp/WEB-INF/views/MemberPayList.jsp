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
        button{ border: 1px solid; background: #1b5ac2; outline: none; float: right; color: #ffffff}
                
    </style>



<body>

	<header>
		<div>
			<img src="./resources/img/dd.png" width="200" height="140">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="./Main">좌석</a></li>
			<li class="mainmenu"><a href="./Product">상품</a></li>
			<li class="mainmenu"><a href="MemberList">회원</a></li>
			<li class="mainmenu"><a href="./MemberPayList">매출</a></li>
			<li class="mainmenu"><a href="./MasterNotice">기타</a></li>
		</ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="./MemberPayList">월별 매출</a></li>
			<li class="SubMenu"><a href="./CatePayList">카테고리별 매출</a></li>
		
		</ul>
	</aside>
	<section>

<form method="post" action="./MemberPayList.jsp"></form>
	<table id="aa">
		<tr>
			<td><select id="selectyear">
			
					<option value="19">2019</option>
					<option value="18">2018</option>
			</select></td>
			<td>
				년
			</td>
			
		<td><select id = "selectmonth">		
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
			

			</select></td>
			<td>
				월
			</td>
		

		
				<td><button type="button" onclick="search()" id="search" >선택</button></td>
			
		</tr>
	</table>
	<table id="bb" border="1">
		<tr>
			<td class="Paymenu">2일</td>
			<td class="Paymenu">시간</td>
			<td class="Paymenu">카테고리</td>
			<td class="Paymenu">ID</td>
			<td class="Paymenu">상품명</td>
			<td class="Paymenu">수량</td>
			<td class="Paymenu">가격</td>
			
		</tr>
		<tbody id="prlist">	
		<c:forEach var="paymentdetail" items="${pList}">
		<c:set var="Date" value="${paymentdetail.u_start}"/>
    
    	</c:forEach>
		</tbody>
	</table>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>


</body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

function search(){
	var selyear = $("#selectyear option:selected").val();
	var selmonth = $("#selectmonth option:selected").val();
	var plus = selyear +"/"+ selmonth + "%";
	
	console.log(plus);
	
	$.ajax({
		type : 'post',
		url : 'datesearch',
		data : plus,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		success : function(data){
			console.log(data)
			var tbl = document.getElementById('prlist');
			var result = "";
			for(var i=0; i<data.length; i++){
                result += '<td>'+data[i].u_start.substring(8,10)+'</td>'
                result += '<td>'+data[i].u_start.substring(11,19)+'</td>'
	            result += '<td>'+data[i].pc_name+'</td>'
	            result += '<td>'+data[i].m_id+'</td>'
	            result += '<td>'+data[i].pr_name+'</td>'
	            result += '<td>'+data[i].pl_qty+'</td>'
	            result += '<td>'+data[i].pl_price+'</td>'
		}
			tbl.innerHTML = result;
              
		}
	})
}



	

		


</script>
</html>