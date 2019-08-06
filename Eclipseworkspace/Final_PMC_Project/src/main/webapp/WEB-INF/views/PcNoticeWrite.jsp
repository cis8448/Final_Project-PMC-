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
        section{position: relative; top: 250px;float: right;width: 60% }
        footer{background-color: antiquewhite;display: block;content: '';clear: both;text-align: center;position: fixed;bottom: 0px;width: 100%}
        .SubMenu:hover{text-decoration: underline}
        .mainmenu:hover{background-color: azure}
        img{width:150px;height:200px; padding:10px;}
        .notice{text-align: center;}
        .btn {margin-left: 47%; margin-top: 10px}
        
       
      
    </style>
<body>
    <header>
        <div>
        <img src="./resources/image/dd.png">
        </div> 
        <ul id="Menu">
            <li class="mainmenu"><a href="./Main">좌석</a></li>
            <li class="mainmenu"><a href="#">상품</a></li>
            <li class="mainmenu"><a href="#">회원</a></li>
            <li class="mainmenu"><a href="#">매출</a></li>
            <li class="mainmenu"><a href="./MasterNotice">기타</a></li>
        </ul>    
    </header>
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
    
    <form action="NoticeWrite" method="post">
    <input type="hidden" name="no_p_id" id="no_p_id" value="${id}">
    
    	<table border="1px solid black" class="noticewrite">
			<tr >
				<td colspan="3" class="notice">공지사항</td>
				<br>
			</tr>
			<tr class="NoticeNum">
				<td>제목</td>
				<td><input type="text" 
                           placeholder="글 제목" name="no_title" maxlength="100"
                           style="width: 600px; height: 20px "  ></td>
          </tr>
              <tr>         
                <td>내용</td>
                <td><textarea placeholder="글 내용" name="no_content" maxlength="2048"
                style="width: 600px; height: 300px"></textarea></td>                      
             </tr>
                
              
                
			
		
		</table>
		<input type="submit" class="btn btn-primary pull-right" value="작성하기">	
		<a href="./PcmasterNotice">돌아가기</a>	
		
		</form>


    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
</html>