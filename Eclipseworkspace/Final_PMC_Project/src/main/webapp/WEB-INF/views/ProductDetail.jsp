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
   		.margin{margin-left: 900px;}
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

    <section>
	<div class="my-box">
	<table  border="1" bordercolor="#3D3D3D" width ="1200" height="100" align = "center"  class="center">
	<tr>
	</tr>
			<tr>
				<td class="a1">카테고리</td>
				<td>${ProductBean.pc_name}</td>
			</tr>
			<tr>
				<td class="a1" >제품명</td>
				<td>${ProductBean.pr_name}</td>
			</tr>
			<tr>
				<td class="a1">수량</td>
				<td>${ProductBean.pr_qty}</td>
			</tr>
			<tr>
				<td class="a1">가격</td>
				<td>${ProductBean.pr_price}</td>
			</tr>
		</table>
	</div><br>
	<div class="margin">
	<button class="btnfont"><a href="./Product">뒤로가기</a></button>
	<button class="btnfont">삭제</button>
	<button class="btnfont">수정</button>
	</div>
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
</html>