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
html, body, ul {
	margin: 0;
	padding: 0;
}

div {
	display: inline-block;
}

ul {
	list-style: none
}

#Menu {
	display: inline-block;
	background-color: gainsboro;
	margin-bottom: 30px;
	width: 1200px;
	margin-left: 130px
}

#SubMenu {
	height: 100px
}

a {
	text-decoration: none;
	color: inherit;
}

.mainmenu {
	float: left;;
	line-height: 100px;
	width: 19.8%;
	text-align: center;
	border: 1px solid black;
	font-size: 50px
}

.mainmenu:first-child {
	background-color: azure
}

.SubMenu {
	margin-bottom: 50px;
	margin-left: 20px
}

.SubMenu:first-child {
	margin-top: 200px;
}
.SubMenu:last_child{
	text-decoration: underline
}

header {
	position: fixed;
	z-index: 999;
	background-color: white;
	width: 100%
}

aside {
	position: fixed;
	top: 180px;
	float: left;
	width: 10%;
	left: 70px
}

section {
	position: relative;
	top: 180px;
	float: right;
	width: 80%;
}

footer {
	background-color: antiquewhite;
	display: block;
	content: '';
	clear: both;
	text-align: center;
	position: fixed;
	bottom: 0px;
	width: 100%
}

.SubMenu:hover {
	text-decoration: underline
}

.mainmenu:hover {
	background-color: azure
}

.Pc_roomImg {
	text-align: center;
}

.Img {
	display: block;
	margin: auto;
	width: 30%;
	height: 200px
}


table {
	width: 81%;
	margin-top: 30px;
	text-align: center
}

.AddMenu {
	display: inline-block;
	width: 1200px
}

.AddMenu>li {
	float: left;
	margin-left: 90%
}

.AddMenu>li:last-child {
	margin: 0
}

li:after {
	display: block;
	content: '';
	clear: both;
}

.addbtn {
	font-size: 30px;
	width: 100%
}

#imgbix {
	width: 81%;
}

input {
	display: block;
	magin: auto;
}

#enbtn {
	margin-left: 75%;
}
</style>


<body>
	<header>
		<div>
			<img src="./resources/img/dd.png" id="pcimg">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="#">좌석</a></li>
			<li class="mainmenu"><a href="./MemberList">회원</a></li>
			<li class="mainmenu"><a href="./product">상품</a></li>
			<li class="mainmenu"><a href="./MemberPayList">매출</a></li>
			<li class="mainmenu"><a href="./pcmasternotice">기타</a></li>
		</ul>
	</header>
	<aside>

		<div>
			<a href=#>'${id}'님 안녕하세요</a>
			<p />
			<form action="#">
				<input type="submit" value="정보 수정">
			</form>

			<form action="#">
			<input type="button" onclick="btn1()" id="button1" value="" style="width: 70px;height: 30px;">
			</form>
		</div>

		<ul id="SubMenu">
			<li class="SubMenu"><a href="./SeatState">좌석정보</a></li>
			<li class="SubMenu"><a href="./SeatDetail">좌석 상세보기 / 수정</a></li>
			<li class="SubMenu"><a href="./SeatUpdate">좌석 배치 변경</a></li>
		</ul>
	</aside>
	<section>
		<div id="imgbix">
			<img src="./resources/${(not empty Sfile) ?    Sfile.c_content: 'img/No_image.png'}" class="Pc_roomImg Img"
				alt="pc방 배치도" id="img"> <input type="file" name="files"
				id="files" value="이미지를 등록해주세요" multiple>
		</div>
		<table border="1px solid black" id="tb1">
			<tr>
				<td>Pc번호</td>
				<td>사용 상태</td>
				<td>사용자 아이디</td>
				<td>남은시간</td>
			</tr>
			<c:forEach var="SeatBean" items="${Slist}">
			<tr>
				<td name = "seatIds">${SeatBean.s_id}</td>
				<td>${SeatBean.s_state}</td>
				<td>${SeatBean.m_id}</td>
				<td>${SeatBean.m_time}</td>
			</tr>
			</c:forEach>
		</table>


		<ul class="AddMenu">
			<li><button type="button" class="addbtn" onclick="AddSeat()">+</button></li>
			<li><button type="button" class="addbtn" onclick="SubSeat()">-</button></li>
		</ul>
		<button type="button" id="enbtn"  onclick="updateSeat()" >완료</button>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
        var upload = document.getElementById('files');
        var img = document.getElementById('img')
        var num = 0;
        var imgsrc = img.src;
        console.log(imgsrc);
          
        upload.addEventListener('change',function(e){
            var name = upload.value.substring(upload.value.indexOf('.'));
            if(name == '.jpg' || name == '.png'){
            	 var get_file = e.target.files;
            	var reader = new FileReader();
            	reader.onload = (function(aImg) {
                    console.log(1);
                    return function(e) {
                       console.log(3);
                       aImg.src = e.target.result
                       num = 1;
                    }
                 })(img)
                 if (get_file) {
                     reader.readAsDataURL(get_file[0]);
                     console.log(2);
                  }      
            }else{
            	upload.value = '';
                alert("'jpg파일이나 png파일을 올려주세요'");
            }
            
        });
        
        var number = ${(not empty cnt ? cnt : '0')} ;
        function AddSeat(){
            var tb = document.getElementById('tb1');
            var Addtr = document.createElement('tr');
            tb.appendChild(Addtr);
            for(var i=0;i<4;i++){
                var Addtd = document.createElement('td');
                if(i==0){Addtd.innerHTML = number; Addtd.setAttribute("name","seatIds");}
                if(i==1){Addtd.innerHTML = '추가대기'}
                if(i==2){Addtd.innerHTML = ''}
                if(i==3){Addtd.innerHTML = ''}
                Addtr.appendChild(Addtd)
            }
            number++;
        };
        
        
        function SubSeat(){
            if(number > 0){
            
            	var tb = document.getElementById('tb1');
            	tb.deleteRow(tb.rows.length-1);
            	number--;
            }else{
            	alert("더 삭제할 좌석이 없습니다.")
            }
        };
        
        function updateSeat(){
            var $obj = $('#files');
           

            var filevalue = $("td[name='seatIds']").length;
            var fileData = new Array(filevalue);
            var fData = new FormData();
            fData.append("p_id", '${sessionScope.id}')
            fData.append("num", num);
            fData.append("src",imgsrc);
            for(var i = 0; i <= fileData.length -1;i++){
                fileData[i] = $("td[name='seatIds']")[i].innerHTML;
                 fData.append("seatId"+i , fileData[i]);
            };
            console.log(fileData);
            console.log(fData);
            var files = $obj[0].files;
            for(var i = 0; i<files.length;i++){
                fData.append("files" + i,files[i])
                console.log("files"+i+"///"+files[i]);
            };
            
            $.ajax({
                type : 'post',
                url  : 'seatInsert',
                data : fData,
                processData : false,
                contentType : false,
                dataType : "json",
                success : function(data){
                	console.log(data);
                    if(data.success == "1"){
                    	location.href = "./SeatState";
                    }else{
                    	alert("파일 업로드에 실패했습니다.!!")              
                    }
                    
                },
                error : function(error){
                    alert("파일 업로드에 실패했습니다.");
                }
                   
            })    
        }
    	
    </script>
<script>


function btn1() {
	
	var userid ='<%=(String)session.getAttribute("id")%>'
	console.log(userid)
	$.ajax({
		type : 'POST',
		data : userid,
		url : 'accept',
		dataType : 'json',
		contentType : "application/json; charset=UTF-8",
		success : function(data) {
			console.log(data)
			if (data.cnt > 0) {
			document.getElementById("button1").value = "승인 완료";	
			} else {
			document.getElementById("button1").value = "미승인 아이디";					
				//아이디가 중복하지 않으면  idck = 1 
				
				
			}

		},
		error : function(error) {
			alert("error : " + error);
		}

	});
};

window.onload = function() {
	

}

</script>
</html>