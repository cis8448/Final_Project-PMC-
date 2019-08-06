<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<% request.setCharacterEncoding("UTF-8"); %>

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
	margin-left: 100px;
	text-align: left;
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
section > div {width: 80%}
h2{display: inline-block;}
select { width: 100px;height: 30px}

#spec1, #spec2,#spec3,#re{display: inline-block;}

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
			<li class="SubMenu"><a href="#">좌석 상세보기 / 수정</a></li>
			<li class="SubMenu"><a href="./SeatUpdate">좌석 배치 변경</a></li>
		</ul>
	</aside>
	<section>	
				<div>
            <table >
                <tr>
                    <td><h2>Pc번호</h2>
                        <select name="seatnum" onchange="chagerSeat(this)" id="id">
		                  <c:forEach var="SeatBean" items="${SeatList}">
			                 <option>${SeatBean.s_id}번</option>
		                  </c:forEach>
                        </select></td>
				    <td colspan="2">
                        
                    </td>
                </tr>
                <tbody id="tbl">
                <tr>
                    <td><h3>PC 번호 : ${SeatSet.s_id}번 Pc</h3></td>
                    <td><h3>좌석 상태 : ${SeatSet.s_state}</h3></td>
                </tr>
                <tr>
                    <td><h3>사용자 : ${SeatSet.m_id}</h3></td>
                    <td><h3>남은 시간 : ${SeatSet.m_time}</h3></td>
                </tr>
                <tr>
                    <td><h3>생년월일 :${SeatSet.m_birthday}</h3></td>
                    <td>
                    	<h3>시간추가 :
                    		<select>
                    			<option>1</option>
                    			<option>2</option>
                    			<option>3</option>
                    			<option>5</option>
                    			<option>10</option>
                    			<option>12</option>
                    		</select>
                    		<button type="button" >충전</button>
                    	</h3>
                    </td>
                </tr>
                <tr>
                    <td><h3></h3></td>
                    <td><h3 id="re">예약 : <span id="state">${SeatSet.s_noreserve}</span> </h3><button type="button" onclick="chager()">변경</button></td>
                </tr>
                
                <tr>
                    <td><h3 id="spec1">그래픽카드 : ${fn:split(SeatSet.s_spec,'/')[0]}</h3><button type="button" onclick="specin(1)">수정하기</button></td>
                </tr>
                <tr>
                    <td><h3 id="spec2">CPU : ${fn:split(SeatSet.s_spec,'/')[1]}</h3><button type="button" onclick="specin(2)">수정하기</button></td>
                </tr>
                <tr>
                    <td><h3 id="spec3">모니터 : ${fn:split(SeatSet.s_spec,'/')[2]}</h3><button type="button" onclick="specin(3)">수정하기</button></td>
                </tr>
               
                </tbody>
            </table>
        </div>			
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

function chagerSeat(elem){
    var param = elem.value.substr(0, elem.value.length-1);
    console.log(param);
     $.ajax({
    type : 'post',
    url  : 'SeatIdDetail',
    data : param,
    contentType : "application/json; charset=UTF-8" ,
    dataType : "json",
    success : function(data){
    	var d = data.s_spec.replace(/"/gi, '');
        console.log(d);
        d = d.replace('{a:', '');
        d = d.replace('b:', '');
        d = d.replace('c:', '');
        d = d.replace('}', '');
        d = d.split(',');
        console.log(d);
        var tbl = document.getElementById('tbl');
        var result ='<tr><td><h3>PC 번호 : '+data.s_id+'번 Pc</h3></td><td><h3>좌석 상태 : '+data.s_state+'</h3></td></tr>'
        result +='<tr><td><h3>사용자 : '+data.m_id+'</h3></td><td><h3>남은 시간 :'+ data.m_time+'</h3></td></tr>'
        result +='<tr><td><h3>생년월일 :'+data.m_birthday+'</h3></td><td><h3>시간추가 :<select><option>1</option><option>2</option><option>3</option><option>5</option><option>10</option><option>12</option></select><button type="button" >충전</button></h3></td></tr>'
        result +='<tr><td><h3></h3></td><td><h3>예약 : <span id="state">'+data.s_noreserve+'</span></h3><button type="button" onclick="chager()">변경</button></td></tr>'
        result +='<tr><td><h3 id="spec1">그래픽카드 : '+d[0]+'</h3><button type="button" onclick="specin(1)">수정하기</button></td></tr>'
        result +='<tr><td><h3 id="spec2">CPU : '+d[1]+'</h3><button type="button" onclick="specin(2)">수정하기</button></td></tr>'
        result +='<tr><td><h3 id="spec3">모니터 : '+d[2]+'</h3><button type="button" onclick="specin(3)">수정하기</button></td></tr>'
        console.log(data);
        console.log(data.s_spec);
        
        	
        	tbl.innerHTML = result;
    },
    error : function(error){
        alert("실패");
    }
       
})
}

function specin(bnum){
var obj= document.getElementById('spec'+bnum);
var inputString = prompt('스펙을 입력해주세요', '');
var id = document.getElementById('id');
console.log(inputString);
var param = 'param1='+bnum+'&param2='+inputString+'&param3='+id.value;
if(inputString != ''){
		$.ajax({
	type: 'get',
	url: 'specUpdate',
	data: param,
	dataType: 'json',
	 contentType : "application/json; charset=UTF-8",
	success: function(data){
			if(bnum == 1){
				obj.innerHTML = '그래픽카드 : '
			}else if(bnum == 2){
				obj.innerHTML = 'CPU : '
			}else{
				obj.innerHTML = '모니터 : '
			}
		
		
            obj.innerHTML += inputString;
	},
	error: function(xhr, status){
		alert("스펙정보를 입력에 실패했습니다.");
	}
});
}
}
function chager(){
    var id = '${sessionScope.id}';
    var number = document.getElementById('id');
    var state= document.getElementById('state');
    var param = 'param1=pc'+id+number.value+'&param2='+state.innerHTML;
    console.log(param);
    console.log(state.innerHTML);
    $.ajax({
        type: 'get',
		url: 'reserveChage',
		data: param,
		dataType: 'json',
 		contentType : "application/json; charset=UTF-8",
		success: function(data){
       		state.innerHTML=data.reser;
		},
		error: function(data){
            alert("서버접속에 실패했습니다");
		}
    })
    
}
</script>
</html>