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
        <li class="SubMenu"><a href="#">좌석정보</a></li>
        <li class="SubMenu"><a href="#">좌석 상세보기 / 수정</a></li>
        <li class="SubMenu"><a href="#">좌석 배치 변경</a></li>
    </ul>
    </aside>
    <section>
    	<table border="1px solid black" class="noticewrite">
			<tr >
				<td colspan="3" class="notice">공지사항</td>
				<br>
			</tr>
			<tr class="NoticeNum">
				<td>제목</td>
				<td><textarea type="text" 
                           placeholder="글 제목" name="btitle" maxlength="100"
                           style="width: 600px; height: 20px "  
                           ></textarea></td>
         </tr>
         <tr>                  
                <td>내용</td>
                <td><textarea placeholder="글 내용" name="bcontent" maxlength="1000"
                style="width: 600px; height: 300px"></textarea></td></tr>
 
		</table>
		
		<table class="btn">
		<tr>
			<td><button>작성</button></td>
			<td><form action="./MasterNotice"><button>취소</button></td></form>
		</tr>
		
		
		</table>


    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
</html>