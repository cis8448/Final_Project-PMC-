<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운영관리자 전체회원</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
</head>
    <style>
        html,body,ul{margin: 0;padding: 0;}
        div{display: inline-block;}
        ul{list-style: none}
        #Menu{list-style: none;display: inline-block;background-color: white;margin-bottom: 30px; width: 1100px; margin-left: 300px}
        #SubMenu{height: 100px}
        a{text-decoration: none; color: inherit;}
        .mainmenu{float: left;; line-height: 100px; width: 33%; text-align: center;border: 1px solid black; font-size: 30px}
        .mainmenu:nth-child(2){background-color: azure}
        .SubMenu{margin-bottom: 50px; margin-left: 20px}
        .SubMenu:first-child{margin-top: 200px;text-decoration: underline}
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
        .MemberInfo{width: 100px; height: 100%; background: #1b5ac2; color: #ffffff}
    </style>

<body>
    <header>
        <div>
        <img src="./resources/img/pmc1.jpg">
        </div> 
        <ul id="Menu">
            <li class="mainmenu"><a href="./OM_Approval">PC방업주관리</a></li>
            <li class="mainmenu"><a href="./OM_MemberList">PC방전체회원</a></li>
            
        </ul>    
    </header>
    <aside>
    <ul id="SubMenu">
        <li class="SubMenu"><a href="./OM_MemberList">전체회원</a></li>
    </ul>
    </aside>
    <section>
    <div class="Search">
    	<input type="text" placeholder="회원 아이디  OR 회원 이름" id="SearchArea" value="">
    	<button type="button" onclick="OMMemberSearch()">검색</button>
    </div><br>
   <table border="1" bordercolor="#3D3D3D" width ="1200" height="100" align = "center" >
   			<tr bgcolor="blue" align ="center">
				<p><td colspan = "6" span style="color:white">전체 회원</td></p>
    		</tr>
    	<tr align="center" bgcolor="skybule">
    		<td>회원아이디</td>
    		<td>회원이름</td>
    		<td>생년월일</td>
    		<td>보유시간</td>
    		<td>비고</td>
    	</tr>
    	<tbody id="resultSearch" align="center"> 
    	<c:forEach var="OMmember" items="${omList}">
    	<tr align="center" >
    		<td id="Search">${OMmember.m_id}</td>
    		<td>${OMmember.m_name}</td>
    		<td>${OMmember.m_birthday}</td>
    		<td>${OMmember.m_time}</td>
    		<td><a href="./OM_MemberInfo?m_id=${OMmember.m_id}" class="MemberInfo">상세보기</a></td>
    	</tr>
    	</c:forEach>
    	</tbody>
    </table>
    <div align="center">${paging}</div>
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
function OMMemberSearch() {
	
	var res = $('#SearchArea').val();//입력한 값 받아오기
	
	console.log(res);
	
	$.ajax({
		type:'post',
		url:'OMMemberSearch',
		data:res,
		dataType:'json',
		contentType : "application/json; charset=UTF-8",
		success: function(data){
			console.log(data)
			var tbl = document.getElementById('resultSearch');
			var result = "";
			for(var i=0;i<data.length;i++){
				result += '<td id="Search">'+data[i].m_id+'</td>'
				result += '<td>'+data[i].m_name+'</td>'
				result += '<td>'+data[i].m_birthday+'</td>'
				result += '<td>'+data[i].m_time+'</td>'
				result += '<td><a href="./OM_MemberInfo?m_id='+data[i].m_id+'" class="MemberInfo">상세보기</a></td>'
		}		
				
				tbl.innerHTML = result;
		
		}
	});
	
};
</script>

</html>