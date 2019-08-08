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
            <li class="mainmenu"><a href="./SeatState">좌석</a></li>
            <li class="mainmenu"><a href="#">상품</a></li>
            <li class="mainmenu"><a href="./MemberList">회원</a></li>
            <li class="mainmenu"><a href="./MemberPayList">매출</a></li>
            <li class="mainmenu"><a href="./NoticeList?cate=0">기타</a></li>
        </ul>    
    </header>
    <aside>
    <ul id="SubMenu">
        <li class="SubMenu"><a href="./Product">전체</a></li>
        <c:forEach var="productcate" items="${catelist}">
        <li class="SubMenu">
        <a href="./cateinfo?pc_id=${productcate.pc_id}" id="${productcate.pc_id}">${productcate.pc_name}</a>
        <button type="button" onclick="catedel('${productcate.pc_id}')">X</button>
        <button type="button" onclick="cateupdate('${productcate.pc_id}')" >수정</button>
        </li>
        </c:forEach>
        
    </ul>
    </aside>
    <section>
        <div class="Search">
       <input type="text" placeholder="상품 이름 검색" id="SearchArea" value="">
    <button type="button" onclick="ProductSearch()">검색</button>
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
       <tbody id="resultSearch">
       	<c:forEach var="ProductBean" items="${prList}">
       	<tr align="center">
          <td id="Search">${ProductBean.pc_name}</td>
          <td>${ProductBean.pr_name}</td>
          <td>${ProductBean.pr_qty}</td>
          <td>${ProductBean.pr_price}</td>
          <td align="center"><a href="./ProductDetail?pr_id=${ProductBean.pr_id}">상세보기</a></td>
       </tr>
       </c:forEach>
      </tbody>
    </table>
	</div><br>
	<div class="margin">
	<button class="btnfont"><a href="./ProductAdd">상품 추가</a></button>
	<button class="btnfont" type="button" onclick="cateadd()">카테고리 추가</button>
	</div>
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
    
    function cateadd(){
	var inputString = prompt('추가할 카테고리를 입력해주세요', '');
        $.ajax({
        type : 'post',
        url  : 'productcateadd',
        data : inputString,
        contentType : "application/json; charset=UTF-8" ,
        dataType : "json",
        success : function(data){
        if(data.ttt == "성공"){
            $("#SubMenu").append('<li class="SubMenu"><a href="./cateinfo?pc_id='+data.pc_id+'" id="${productcate.pc_id}">'+data.name+'</a><button type="button" onclick="catedel('+data.pc_id+')">X</button><button type="button" onclick="cateupdate('+data.pc_id+')" >수정</button></li>');
            
        }
        
    }         
	});
}
        
    function catedel(elem){
    	$.ajax({
            type : 'post',
            url  : 'productcateDelete',
            data : elem,
            contentType : "application/json; charset=UTF-8" ,
            dataType : "json",
            success : function(data){
            	if(data.success == "0"){
                    document.getElementById(elem).parentNode .remove();
            }else{
            	alert("실패")
            }
            
        }         
    })
    }
    	 function cateupdate(elem){
    	    	var inputString = prompt('변경하실 카테고리를 입력하세요','');
    	    	var param = 'pc_id='+elem+'&pc_name='+inputString
    	    	console.log(param)
    	    	$.ajax({
    	            type : 'post',
    	            url  : 'productcateupdate',
    	            data : param,
    	            //contentType : "application/json; charset=UTF-8" ,
    	            dataType : "json",
    	            success : function(data){
    	            	if(data.success == "0"){
    	                    document.getElementById(elem).innerHTML = data.pc_name
    	            }else{
    	            	alert("실패")
    	            }
    	            
    	        }         
    	    });    	
    	
};
	function ProductSearch() {
	
	var res = $('#SearchArea').val();//입력한 값 받아오기
	
	console.log(res);
	
	$.ajax({
		type:'post',
		url:'ProductSearch',
		data:res,
		dataType:'json',
		contentType : "application/json; charset=UTF-8",
		success: function(data){
			console.log(data)
			var tbl = document.getElementById('resultSearch');
			var result = "";
			for(var i=0;i<data.length;i++){
				result += '<tr align="center">'
				result += '<td id="Search">'+data[i].pc_name+'</td>'
				result += '<td>'+data[i].pr_name+'</td>'
				result += '<td>'+data[i].pr_qty+'</td>'
				result += '<td>'+data[i].pr_price+'</td>'
				result += '<td><a href="./ProductDetail?pr_id='+data[i].pr_id+'">상세보기</a></td>'
				result += '</tr>'
						
		}		
				
				tbl.innerHTML = result;
		
		}
	});
	
};
</script>
</html>