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
        .mainmenu:first-child{background-color: azure}
        .SubMenu{margin-bottom: 50px; margin-left: 20px}
        .SubMenu:first-child{margin-top: 200px;text-decoration: underline}
        header{position: fixed; z-index: 999;background-color: white;width: 100%}
        aside{position:  relative; top: 180px;float: left;width: 10%; left: 70px}
        section{background-color: white;position: relative; top: 250px;float: right;width: 80%}
        footer{background-color: antiquewhite;display: block;content: '';clear: both;text-align: center;position: fixed;bottom: 0px;width: 100%}
        .SubMenu:hover{text-decoration: underline}
        .mainmenu:hover{background-color: azure}

        img{width:300px;height:200px; padding:10px;}


        
        
      
        
    </style>
<body>

        <div>
        <img src="./resources/img/dd.png">
        </div> 
        
        <ul id="Menu">
            <li class="mainmenu"><a href="./">좌석</a></li>
            <li class="mainmenu"><a href="./Product">상품</a></li>
            <li class="mainmenu"><a href="./MemberList">회원</a></li>
            <li class="mainmenu"><a href="./MemberPayList">매출</a></li>
            

        </ul>    
   
  <aside>
	  
    <ul id="SubMenu">
    	<li class="Submenu"><a href="./MasterNotice">운영관리자용 공지사항</a></li>
    </ul>
    <ul id="SubMenu">
    	<li class="Submenu"><a href="./PcmasterNotice">PC방관리자용 공지사항</a></li>
    </ul>
    <ul id="SubMenu">
    	<li class="Submenu"><a href="./CustomerSc">고객용 고객센터</a></li>
    </ul>
    <ul id="SubMenu">
    	<li class="Submenu"><a href="./PcmasterSc">PC방관리자용 고객센터</a></li>
    </ul>
	</aside>
    
    <section>
        <a href="./MasterNotice" style="float:right">돌아가기</a>
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>상세보기</h6>
				</div>
				<div class="login-form">
					글 번호
					<div class="control-group">
						<input type="text" class="login-field" 
							value="${pcroomnoticebean.no_num}" readonly="readonly">
					</div>
					글 제목
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomnoticebean.no_title}" readonly="readonly">
					</div>
					글 내용
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomnoticebean.no_content}" readonly="readonly">
					</div>
					작성 날짜
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomnoticebean.no_date}" readonly="readonly">
					</div>
					글 내용
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomnoticebean.no_cate}" readonly="readonly">
					</div>
					</div>
					</div>
					</div>
					</center>
					
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
</html>