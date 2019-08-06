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
            <li class="mainmenu"><a href="./MasterNotice">기타</a></li>

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
        <a href="./CustomerScDetail" style="float:right">돌아가기</a>
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
							value="${pcroomscbean.se_num}" readonly="readonly">
					</div>
					글 제목
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomscbean.se_title}" readonly="readonly">
					</div>
					글 내용
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomscbean.se_content}" readonly="readonly">
					</div>
					작성 날짜
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomscbean.se_date}" readonly="readonly">
					</div>
					글 내용
					<div class="control-group">
						<input type="text" class="login-field"
							value="${pcroomscbean.se_cate}" readonly="readonly">
					</div>
					<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>댓글달기</h6>
				</div>
				<div class="login-form">
					작성자
					<div class="control-group">
						<input type="text" class="login-field"
							value="${id}" readonly="readonly">
					</div>
					내용
					<form id="rFrm">
						<div class="control-group">
							<input type="text" class="login-field"
								value="" name="r_content" id="comment">
						</div>
						<button type="button" 
							onclick="replyInsert(${pcroomscbean.se_num})"
							class="btn btn-primary btn-large btn-block">
						저장
						</button>
					</form>
				</div>
			</div>
		</div>
		<!-- 여기부터 댓글 출력 -->
		<table>
			<tr align="center" height="30" bgcolor="#3498DB">
				<th width="100">작성자</td>
				<th width="200">내용</td>
				<th width="200">작성일시</td>
			</tr>
		</table>
		<table id="rTable">
		<c:forEach var="r" items="${rList}">
			<tr height="25" align="center">
				<td width="100">${r.r_id}</td>
				<td width="200">${r.r_contents}</td>
				<td width="200">${r.r_date}</td>
			</tr>
		</c:forEach>
		</table>
					
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<script>
function replyInsert(se_num){
	//form의 데이터를 javascript 객체화.
	// == json 객체
	var obj=$("#rFrm").serializeObject();
	obj.r_se_num=se_num;
	console.log(obj);
	
	$.ajax({
		type: 'post',
		url: 'replyInsert',
		data: obj,
		dataType: 'json',
		success: function(data, status, xhr){
			console.log(status);
			console.log(xhr);
			//XMLHttpRequest(객체의 폼형식 관련 API)
			console.log(data);
			
			var rlist='';
			for(var i = 0; i < data.rList.length; i++){
				rlist += '<tr height="25" align="center">'
					+'<td width="100">'+data.cList[i].r_id+'</td>'
					+'<td width="200">'+data.cList[i].r_contents+'</td>'
					+'<td width="200">'+data.cList[i].r_date +'</td></tr>';
			}
			$('#rTable').html(rlist);
		},
		error: function(xhr, status){
			alert("댓글 저장 실패");
			console.log(xhr);
			console.log(status);
		}
	});
}
</script>

</html>