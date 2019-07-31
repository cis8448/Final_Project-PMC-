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
        .mainmenu:nth-child(2){background-color: azure}
        .SubMenu{margin-bottom: 50px; margin-left: 20px}
        .SubMenu:first-child{margin-top: 200px;text-decoration: underline}
        header{position: fixed; z-index: 999;background-color: white;width: 100%}
        aside{position:  relative; top: 180px;float: left;width: 10%; left: 70px}
        section{background-color: white; position: relative; top: 250px;float: right;width: 80%}
        footer{background-color: antiquewhite;display: block;content: '';clear: both;text-align: center;position: fixed;bottom: 0px;width: 100%}
        .SubMenu:hover{text-decoration: underline}
        .mainmenu:hover{background-color: azure}
        img{width:300px;height:200px; padding:10px;}
        input:-ms-input-placeholder {color:#a8a8a8;}
        input::-webkit-input-placeholer {color:a8a8a8;}
        input::-moz-placeholder {color:a8a8a8;}
        .Search{height: 40px; width: 400px; border: 1px solid #1b5ac2; background: #ffffff; margin-left: 830px;}
        input{font-size: 16px; width: 325px; padding: 10px; border: 0px; outline: none; float: left; }
        button{width: 50px; height: 100%; border: 1px solid; background: #1b5ac2; outline: none; float: right; color: #ffffff}
        .my-box {margin-top:20px; border:1px solid; width : 1200px; height: 500px; padding:10px; }
   		.margin{margin-left: 1020px;}
   		.btnfont{font-size: 18px; width: 100px; height: 50px;}
   		
        
    </style>
<body>
    <header>
        <div>
        <img src="./resources/img/dd.png">
        </div> 
        <ul id="Menu">
            <li class="mainmenu"><a href="./">좌석</a></li>
            <li class="mainmenu"><a href="./Product">상품</a></li>
            <li class="mainmenu"><a href="#">회원</a></li>
            <li class="mainmenu"><a href="#">매출</a></li>
            <li class="mainmenu"><a href="#">기타</a></li>
        </ul>    
    </header>
    <aside>
    <ul id="SubMenu">
        <li class="SubMenu"><a href="#">전체</a></li>
        <li class="SubMenu"><a href="#">라면</a></li>
        <li class="SubMenu"><a href="#">식사</a></li>
        <li class="SubMenu"><a href="#">음료</a></li>
        <li class="SubMenu"><a href="#">커피</a></li>
        <li class="SubMenu"><a href="#">토핑추가</a></li>
        <li class="SubMenu"><a href="#">카테고리 추가</a></li>
    </ul>
    </aside>
    <section>
        <div class="Search">
       <input type="text" placeholder="검색">
       <button>검색</button>
    </div><br>
	<div class="my-box">
	<table border="1" bordercolor="#3D3D3D" width ="1200" height="100" align = "center" >
       <tr align="center" bgcolor="skybule">
            <td>카테고리</td>
            <td>이름</td>
            <td>수량</td>
            <td>가격</td>
            <td>비고</td>
       </tr> 
       <c:forEach var="product" items="${prList}">
       <tr align="center">
          <td>${product.pc_id}</td>
          <td>${product.pr_name}</td>
          <td>${product.pr_qty}</td>
          <td>${product.pr_price}</td>
          <td align="center"><a href="./ProductDetail">상세보기</a></td>
       </tr>
       </c:forEach>
    </table>
	</div><br>
	<div class="margin">
	<button class="btnfont">삭제</button>
	<button class="btnfont"><a href="./ProductAdd">상품 추가</a></button>
	</div>
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
</html>