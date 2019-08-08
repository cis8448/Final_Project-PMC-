<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
    	button{ border: 1px solid; background: #1b5ac2; outline: none; float: right; color: #ffffff}
        #cate{width: 100px; height: 40px;}        
    </style>



<body>

	<header>
		<div>
        <img src="./resources/img/dd.png">
        </div> 
        <ul id="Menu">
            <li class="mainmenu"><a href="./SeatState">좌석</a></li>
            <li class="mainmenu"><a href="./Product">상품</a></li>
            <li class="mainmenu"><a href="./MemberList">회원</a></li>
            <li class="mainmenu"><a href="./MemberPayList">매출</a></li>
            <li class="mainmenu"><a href="./NoticeList?cate=0">기타</a></li>
        </ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="./MemberPayList">월별 매출</a></li>
			<li class="SubMenu"><a href="./CatePayList">카테고리별 매출</a></li>
			
		</ul>
	</aside>
	
	
	<section>
	<form method="post" action="./CatePayList.jsp"></form>
	<table>
		<tr>
			<td><select id="selectCate">
			<c:forEach var="pay" items="${cateList}">
			<c:set var="Cate" value="${pay.pc_name}"/>
					<option id="pc_name">${pay.pc_name}</option>
				
			</c:forEach>
					
			</select></td>
			
			<td><button type="button" onclick="cateSearch()" id="catesearch" >선택</button></td>
		</tr>
	</table>		
    	<table id="bb" border="1">
		<tr>
			<td class="Paymenu">날짜</td>
			<td class="Paymenu">ID</td>
			<td class="Paymenu">상품명</td>
			<td class="Paymenu">수량</td>
			<td class="Paymenu">가격</td>	
		</tr>
		
		<tbody id="cateResult" align="center">
		<c:forEach var="cate" items="${cateList}">
			
				${cateResult.u_start}
				${cateResult.m_id}
				${cateResult.p_name}
				${cateResult.pl_qty}
				${cateResult.pl_price}
			
		</c:forEach>
		</tbody>
	</table>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>


</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
function cateSearch(){
	var selcate = $("#selectCate option:selected").val();
	var pc_name = document.getElementById("pc_name").innerHTML;
	
	console.log(selcate);
	console.log(pc_name);
	$.ajax({
        type : 'post',
        url : 'casearch',
		data : pc_name,
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		success : function(data){
            var tbl = document.getElementById('cateResult');
	         var result = "";
	         for(var i=0;i<data.length;i++){
	        	 result += '<tr align="center">'
                result += '<td>'+data[i].u_start+'</td>'
	            result += '<td>'+data[i].u_m_id+'</td>'
	            result += '<td>'+data[i].pr_name+'</td>'
	            result += '<td>'+data[i].pl_qty+'</td>'
	            result += '<td>'+data[i].pl_price+'</td>'
	            result += '</tr">'
	            
		}
                 
             
        tbl.innerHTML = result;
        }
    })
    }
		      
		    
	
</script>

</html>