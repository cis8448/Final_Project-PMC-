<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        .mainmenu:nth-child(3){background-color: azure}
        .SubMenu{margin-bottom: 50px; margin-left: 20px}
        .SubMenu:first-child{margin-top: 200px;text-decoration: underline}
        header{position: fixed; z-index: 999;background-color: white;width: 100%}
        aside{position:  relative; top: 180px;float: left;width: 10%; left: 70px}
        section{position: relative; top: 10px;float: left;width: 80%; margin-left: 250px;}
        footer{background-color: antiquewhite;display: block;content: '';clear: both;text-align: center;position: fixed;bottom: 0px;width: 100%}
        .SubMenu:hover{text-decoration: underline}
        .mainmenu:hover{background-color: azure}
        img{width:300px;height:200px; padding:10px;}
        button{width: 50px; height: 100%; border: 0px; background: #1b5ac2; outline: none; float: right; color: #ffffff}
        .MemberInfo{width: 100px; height: 100%; background: #1b5ac2; color: #ffffff}
        .button2{border: 1px solid skyblue; background-color:dodgerblue; color: white; padding: 5px; margin-left: 30px;}
        .LastButton{margin-left: 77%; margin-top: 10px;}
        .right{width: 30%; float: right; box-sizing: border-box; margin-right: 510px; border: 2px solid black;}
        .left{width: 100px; float: left; box-sizing: border-box; background-color: cadetblue; margin-left: 450px;  border: 2px solid black; }
        .right2{float: right; margin-right: 510px; margin-top: 10px; margin-bottom: 10px;}
        .content{border-bottom: 2px solid black;}
        h2{margin-left: 700px;}
    </style>

<body>
    <header>
        <div>
        <img src="./resources/img/pmc1.jpg">
        </div> 
        <ul id="Menu">
            <li class="mainmenu"><a href="./Main">좌석</a></li>
            <li class="mainmenu"><a href="./Product">상품</a></li>
            <li class="mainmenu"><a href="./MemberList">회원</a></li>
            <li class="mainmenu"><a href="./MemberPayList">매출</a></li>
            <li class="mainmenu"><a href="#">기타</a></li>
        </ul>    
    </header>
    <aside>
    <ul id="SubMenu">
        <li class="SubMenu"><a href="./MemberList">전체회원</a></li>
    </ul>
    </aside>
    <section>
      <br>
   <table border="1" bordercolor="#3D3D3D" width ="1200" height="100" align = "center" >
   			<tr bgcolor="blue" align ="center">
				<p><td colspan = "5" span style="color:white">회원 매출확인</td></p>
    		</tr>
    	<tr align="center" bgcolor="skybule">
    		<td>날짜</td>
    		<td>회원아이디</td>
    		<td>상품이름</td>
    		<td>갯수</td>
            <td>가격</td>
    	</tr> 
    	<c:forEach var="memberpay" items="${mpList}">
    	<tr align="center">
    		<td>${memberpay.u_start}</td>
    		<td>${memberpay.u_m_id}</td>
    		<td>${memberpay.pr_name}</td>
    		<td>${memberpay.pl_qty}</td>
            <td>${memberpay.pl_price}</td>
    	</tr>
    	</c:forEach>
    	
    </table>

    <div align="center">${paging}</div>
                       <div class="LastButton">
                <a href="./MemberList" class="button2">회원목록보기</a>
        </div>
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>

</html>