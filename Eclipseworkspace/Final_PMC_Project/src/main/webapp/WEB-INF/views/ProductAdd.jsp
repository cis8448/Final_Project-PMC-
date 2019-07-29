<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	width: 325px;
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
	width: 1200px;
	height: 500px;
	padding: 10px;
}

.margin {
	margin-top : 20px;
	margin-left: 650px;
}

.btnfont {
	font-size: 18px
}

.img {
	width: 1000px;
	height: 300px;
}

#preview>img {
	width: 200px;
	height: 200px;
}

.add {
	margin-left: 300px;
}

.select {
	width: 350px;
	height: 30px;
}
</style>
<body>
	<header>
		<div>
			<img src="./resources/img/pmc1.jpg">

		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="./">좌석</a></li>
			<li class="mainmenu"><a href="./Product">상품</a></li>
			<li class="mainmenu"><a href="#">회원</a></li>
			<li class="mainmenu"><a href="#">매출</a></li>
			<li class="mainmenu"><a href="#">기타</a></li>
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
		<h1 class="add">상품 추가</h1>
		<input type='file' id='upload' name='upload' />
		<div id='preview'>
			<!-- 사진들어가는곳  -->
		</div>
		<table border="1">
			<tr>
				<td>카테고리</td>
				<td><select class="select">
						<option class = "btnfont" value="전체" selected>전체</option>
						<option class = "btnfont" value="라면" selected>라면</option>
						<option class = "btnfont" value="식사" selected>식사</option>
						<option class = "btnfont" value="음료" selected>음료</option>
						<option class = "btnfont" value="커피" selected>커피</option>
				</select></td>
			</tr>
			<tr>
				<td>제품명</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="text"></td>
			</tr>

		</table>
		<div class="margin">
			<button class="btnfont">취소</button>
			<button class="btnfont">추가</button>
		</div>
	</section>
	<footer>
		<h1>ICIA Pc Project</h1>
	</footer>
</body>
<script>
	var upload = document.querySelector('#upload');
	var preview = document.querySelector('#preview');

	upload.addEventListener('change', function(e) {

		var image = document.querySelector('#preview>img');
		if (image == null) {
			image = document.createElement('img');
		}
		var get_file = e.target.files;

		/* FileReader 객체 생성 */
		var reader = new FileReader();
		/* reader 시작시 함수 구현 */
		reader.onload = (function(aImg) {
			console.log(1);

			return function(e) {
				console.log(3);
				/* base64 인코딩 된 스트링 데이터 */
				aImg.src = e.target.result
			}
		})(image)

		if (get_file) {
			/* 
			    get_file[0] 을 읽어서 read 행위가 종료되면 loadend 이벤트가 트리거 되고 
			    onload 에 설정했던 return 으로 넘어간다.
			    이와 함게 base64 인코딩 된 스트링 데이터가 result 속성에 담겨진다.
			 */
			reader.readAsDataURL(get_file[0]);
			console.log(2);
		}
		preview.appendChild(image);

	})
</script>
</html>