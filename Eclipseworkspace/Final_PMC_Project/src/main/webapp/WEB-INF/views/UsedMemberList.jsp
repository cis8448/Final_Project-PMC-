<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        .SubMenu:first-child{margin-top: 200px;}
        .SubMenu:nth-child(2){text-decoration: underline}
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
        .btnDetail{width: 100%; height: 100%;}
    </style>
<body>
    <header>
        <div>
        <img src="./resources/img/pmc1.jpg">
        </div> 
        <ul id="Menu">
            <li class="mainmenu"><a href="./Main">좌석</a></li>
            <li class="mainmenu"><a href="#">상품</a></li>
            <li class="mainmenu"><a href="./MemberList">회원</a></li>
            <li class="mainmenu"><a href="#">매출</a></li>
            <li class="mainmenu"><a href="#">기타</a></li>
        </ul>    
    </header>
    <aside>
    <ul id="SubMenu">
        <li class="SubMenu"><a href="./MemberList">전체회원</a></li>
        <li class="SubMenu"><a href="./UsedMemberList">사용중인회원</a></li>
        <li class="SubMenu"><a href="./ReseveMemberList">예약대기중인회원</a></li>
    </ul>
    </aside>
    <section>
    <div class="Search">
    	<input type="text" placeholder="회원 검색">
    	<button>검색</button>
    </div><br>
   <table border="1" bordercolor="#3D3D3D" width ="1200" height="100" align = "center" >
   			<tr bgcolor="blue" align ="center">
				<p><td colspan = "5" span style="color:white">사용중인 회원</td></p>
    		</tr>
    	<tr align="center" bgcolor="skybule">
    		<td>회원아이디</td>
    		<td>회원이름</td>
    		<td>생년월일</td>
    		<td>보유시간</td>
    		<td>비고</td>
    	</tr>
    	<c:forEach var="member" items="${mList}">
    	<tr>
    		<td>${member.m_id}</td>
    		<td>${member.m_name}</td>
    		<td>${member.m_birthday}</td>
    		<td>${member.m_retime}</td>
    		<td><form action="./"><button class="btnDetail">상세보기</button></form></td>
    	</tr>
    	</c:forEach>
    </table>
    <div align="center">${paging}</div>
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
</html>