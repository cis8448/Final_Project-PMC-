<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>��ǰ �߰�</title>
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
			<li class="mainmenu"><a href="./">�¼�</a></li>
			<li class="mainmenu"><a href="./Product">��ǰ</a></li>
			<li class="mainmenu"><a href="#">ȸ��</a></li>
			<li class="mainmenu"><a href="#">����</a></li>
			<li class="mainmenu"><a href="#">��Ÿ</a></li>
		</ul>
	</header>
	<aside>
		<ul id="SubMenu">
			<li class="SubMenu"><a href="#">��ü</a></li>
			<li class="SubMenu"><a href="#">���</a></li>
			<li class="SubMenu"><a href="#">�Ļ�</a></li>
			<li class="SubMenu"><a href="#">����</a></li>
			<li class="SubMenu"><a href="#">Ŀ��</a></li>
			<li class="SubMenu"><a href="#">�����߰�</a></li>
			<li class="SubMenu"><a href="#">ī�װ� �߰�</a></li>
		</ul>
	</aside>
	<section>
		<h1 class="add">��ǰ �߰�</h1>
		<input type='file' id='upload' name='upload' />
		<div id='preview'>
			<!-- �������°�  -->
		</div>
		<table border="1">
			<tr>
				<td>ī�װ�</td>
				<td><select class="select">
						<option class = "btnfont" value="��ü" selected>��ü</option>
						<option class = "btnfont" value="���" selected>���</option>
						<option class = "btnfont" value="�Ļ�" selected>�Ļ�</option>
						<option class = "btnfont" value="����" selected>����</option>
						<option class = "btnfont" value="Ŀ��" selected>Ŀ��</option>
				</select></td>
			</tr>
			<tr>
				<td>��ǰ��</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text"></td>
			</tr>

		</table>
		<div class="margin">
			<button class="btnfont">���</button>
			<button class="btnfont">�߰�</button>
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

		/* FileReader ��ü ���� */
		var reader = new FileReader();
		/* reader ���۽� �Լ� ���� */
		reader.onload = (function(aImg) {
			console.log(1);

			return function(e) {
				console.log(3);
				/* base64 ���ڵ� �� ��Ʈ�� ������ */
				aImg.src = e.target.result
			}
		})(image)

		if (get_file) {
			/* 
			    get_file[0] �� �о read ������ ����Ǹ� loadend �̺�Ʈ�� Ʈ���� �ǰ� 
			    onload �� �����ߴ� return ���� �Ѿ��.
			    �̿� �԰� base64 ���ڵ� �� ��Ʈ�� �����Ͱ� result �Ӽ��� �������.
			 */
			reader.readAsDataURL(get_file[0]);
			console.log(2);
		}
		preview.appendChild(image);

	})
</script>
</html>