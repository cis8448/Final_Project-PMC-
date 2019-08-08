<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>상품 추가</title>
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
	list-style: none;
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

.mainmenu:nth-child(2) {
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
	position: relative;
	top: 180px;
	float: left;
	width: 10%;
	left: 70px
}

section {
	background-color: white;
	position: relative;
	top: 250px;
	float: right;
	width: 80%
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

img {
	width: 300px;
	height: 200px;
	padding: 10px;
}

input:-ms-input-placeholder {
	color: #a8a8a8;
}

input::-webkit-input-placeholer {
	color: a8a8a8;
}

input::-moz-placeholder {
	color: a8a8a8;
}

.Search {
	height: 40px;
	width: 400px;
	border: 1px solid #1b5ac2;
	background: #ffffff;
	margin-left: 830px;
}

input {
	font-size: 16px;
	width: 305px;
	padding: 10px;
	border: 0px;
	outline: none;
	float: left;
}

button {
	width: 50px;
	height: 100%;
	border: 1px solid;
	background: #1b5ac2;
	outline: none;
	float: right;
	color: #ffffff
}

.my-box {
	margin-top: 20px;
	border: 1px solid;
	width: 1100px;
	height: 500px;
	padding: 10px;
}

.margin {
	margin-top: 20px;
	margin-left: 462px;
}

.btnfont {
	font-size: 20px;
	width: 100px;
	height: 40px;
}

.img {
	width: 300px;
	height: 300px;
}

#preview>img {
	width: 200px;
	height: 200px;
}

.add {
	margin-left: 512px;
	font-size: 25px;
}

.select {
	width: 400px;
	height: 40px;
	font-size: 20px;
	text-align: center;
}

.ii {
	margin-left: 10%;
}

.a1 {
	width: 400px;
	height: 20px;
	font-size: 20px;
}

.a2 {
	margin-left: 300px
}

.center {
	text-align: center;
}
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
			<li class="SubMenu"><a href="#">전체</a></li>
			<li class="SubMenu"><a href="#">라면</a></li>
			<li class="SubMenu"><a href="#">식사</a></li>
			<li class="SubMenu"><a href="#">음료</a></li>
			<li class="SubMenu"><a href="#">커피</a></li>
			<li class="SubMenu"><a href="#">토핑추가</a></li>
			<li class="SubMenu"><a href="#">카테고리 추가</a></li>
		</ul>
	</aside>
	<section>
		<h1 class="add">상품 수정</h1>
		<table border="1px solid black" class="ii">
			<tr align="center">
				<td>
					<table class="a2">
						<tr>
							<td>
								<div id="imgbix">
									<img align="left"
										src="./resources/file/${product.pr_img}"
										alt="pc방 배치도" id="img"> <input type="file" name="files"
										id="files" value="이미지를 등록해주세요" multiple>
								</div>

							</td>
							<td>
						</tr>
					</table>


					<table border="1" class="center">
						<tr>
							<td class="a1">카테고리</td>
							<td><select class="select" id="name0">
									<c:forEach var="pr" items="${cateList}">
										<option id="pc_name" value="${pr.pc_id}">${pr.pc_name}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="a1">제품명</td>
							<td><input type="text" value="${product.pr_name}" id ="name1"></td>
						</tr>
						<tr>
							<td class="a1">가격</td>
							<td><input type="text" value="${product.pr_price}" id ="name2"></td>
						</tr>
						<tr>
							<td class="a1">수량</td>
							<td><input type="text" value="${product.pr_qty}" id ="name3"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<div class="margin">
			<table>
				<tr>
					<td>
						<button type="button" class="btnfont" value="추가" onclick="add()">수정</button>
					</td>
					<td>
						<form action="./Product">
							<button class="btnfont">취소</button>
						</form>
				</tr>
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
	var upload = document.getElementById('files');
	var imgsrc = '${product.pr_img}';
	var num = 0;
	console.log(img.src)
	upload.addEventListener('change', function(e) {
		var name = upload.value.substring(upload.value.indexOf('.'));
		if (name == '.jpg' || name == '.png' || name == '.gif'
				|| name == '.JPG' || name == '.PNG' || name == '.GIF') {
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
			num = 1;
		} else {
			upload.value = '';
			alert("'jpg, png, gif 파일만 가능합니다'");
		}
	});

	function add() {
		var $obj = $('#files');
		var fData = new FormData();
		fData.append("p_id", '${sessionScope.id}')
		fData.append("num", num)
		fData.append("pr_name", $("#name1").val());
		fData.append("pr_id",'${param.pr_id}')
		fData.append("pr_price", $("#name2").val());
		fData.append("pr_qty", $("#name3").val());
		fData.append("pr_pc_id", $("#name0 option:selected").val());
		
		fData.append("src", imgsrc)
		console.log(fData);
		var files = $obj[0].files;
		for (var i = 0; i < files.length; i++) {	
			fData.append("files" + i, files[i])
			console.log("files" + i + "///" + files[i]);
		}
		;

		$.ajax({
			type : 'post',
			url : 'productUp',
			data : fData,
			processData : false,
			contentType : false,
			dataType : "json",
			success : function(data) {
				if (data.success == "1") {
					location.href = "./Product";
				} else {
					alert("정보가 바뀌지 않았습니다.")
				}

			},
			error : function(error) {
				alert("파일 업로드에 실패했습니다.");
			}

		})
	}
</script>
</html>
