<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>�Ǹ� ������</title>

<!-- �������� �ּ�ȭ�� �ֽ� CSS -->
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

button {
	width: 50%;
	margin: auto;
	display: block
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
	margin-left: 75%
}
</style>


<body>
	<header>
		<div>
			<img src="./resources/img/dd.png" id="pcimg">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="#">�¼�</a></li>
			<li class="mainmenu"><a href="#">ȸ��</a></li>
			<li class="mainmenu"><a href="#">��ǰ</a></li>
			<li class="mainmenu"><a href="#">����</a></li>
			<li class="mainmenu"><a href="#">��Ÿ</a></li>
		</ul>
	</header>
	<aside>

		<div>
			<a href=#>'${id}'�� �ȳ��ϼ���</a>
			<p />
			<form action=>
				<input type="button" value="���� ����" onclick="btn2()">
			</form>

			<form action="#">
			<input type="button" onclick="btn1()" id="button1" value="" style="width: 70px;height: 30px;">
			</form>
		</div>

		<ul id="SubMenu">
			<li class="SubMenu"><a href="#">�¼�����</a></li>
			<li class="SubMenu"><a href="#">�¼� �󼼺��� / ����</a></li>
			<li class="SubMenu"><a href="#">�¼� ��ġ ����</a></li>
		</ul>
	</aside>
	<section>
		<div id="imgbix">
			<img src="${not empty param.Sfile ? "${comment}" : "./resources/img/No_image.png"}" class="Pc_roomImg Img"
				alt="pc�� ��ġ��" id="img"> <input type="file" name="files"
				id="files" value="�̹����� ������ּ���" multiple>
		</div>
		<table border="1px solid black" id="tb1">
			<tr>
				<td>Pc��ȣ</td>
				<td>��� ����</td>
				<td>����� ���̵�</td>
				<td>�����ð�</td>
			</tr>
			<c:forEach var="SeatUpdate" items="${Slist}">
			<tr>
				<td name = "name='seatIds'">${s_id}</td>
				<td>${s_state}</td>
				<td>${m_id}</td>
				<td>${m_time}</td>
			</c:forEach>
		</table>


		<ul class="AddMenu">
			<li><button type="button" class="addbtn" onclick="AddSeat()">+</button></li>
			<li><button type="button" class="addbtn" onclick="SubSeat()">-</button></li>
		</ul>
		<button type="button" id="enbtn" value="�Ϸ�" onclick="updateSeat()" />
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
                    }
                 })(img)
                 if (get_file) {
                     reader.readAsDataURL(get_file[0]);
                     console.log(2);
                  }      
            }else{
            	upload.value = '';
                alert("'jpg�����̳� png������ �÷��ּ���'");
            }
            
        });
        
        var number = 0;
        function AddSeat(){
            var tb = document.getElementById('tb1');
            var Addtr = document.createElement('tr');
            tb.appendChild(Addtr);
            for(var i=0;i<4;i++){
                var Addtd = document.createElement('td');
                if(i==0){Addtd.innerHTML = number; Addtd.setAttribute("name","seatIds");}
                if(i==1){Addtd.innerHTML = '�߰����'}
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
            	alert("�� ������ �¼��� �����ϴ�.")
            }
        };
        
        function updateSeat(){
            var $obj = $('#files');
            

            var filevalue = $("td[name='seatIds']").length;
            var fileData = new Array(filevalue);
            var fData = new FormData();
            fData.append("p_id", '${sessionScope.id}')
            for(var i = 0; i < filevalue;i++){
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
                    if(data.success == "����"){
                    	location.href = "./";
                    }else{
                    	alert("���� ���ε忡 �����߽��ϴ�.")
                    }
                    
                },
                error : function(error){
                    alert("���� ���ε忡 �����߽��ϴ�.");
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
			document.getElementById("button1").value = "���� �Ϸ�";	
			} else {
			document.getElementById("button1").value = "�̽��� ���̵�";					
				//���̵� �ߺ����� ������  idck = 1 
				
				
			}

		},
		error : function(error) {
			alert("error : " + error);
		}

	});
};



</script>
<script type="text/javascript">
function btn2(){
	var url = "PCInfoUpdate";
	var name = "popup2222";
	var option = "width=700 , height=600"; 
	window.open(url,name,option);
	
	
}

</script>
</html>