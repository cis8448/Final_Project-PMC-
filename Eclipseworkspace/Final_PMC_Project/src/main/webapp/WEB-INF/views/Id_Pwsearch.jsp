<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.buttons {
	color: #fff;
	background: #3232FF;
	font-size: 1.5em;
	padding: 5px 20px;
	border-radius: 0.5em;
	width: 250px;
	height: 90px;
}

input {
	margin-top: 20px;
}
</style>
</head>
<body>

	<header>
		<center>
			<pre>
        <h1 style="color: cornflowerblue; font-size: 40px">관리자
아이디/비밀번호 찾기</h1>
        </pre>
		</center>
	</header>
	<section>
		<center>
			<div>
				<button class="buttons" id="button1" onclick="colorchange1()">아이디
					찾기</button>
				<button class="buttons" style="margin-left: 50px" id="button2"
					onclick="colorchange2()">비밀번호 찾기</button>
			</div>


		</center>
	</section>
</body>
<script>
	var a = document.getElementById("button1");
	var b = document.getElementById("button2");
	function colorchange1() {
		a.style.backgroundColor = "#6EE0FF";
		b.style.backgroundColor = "#3232FF";
	
	}
	function colorchange2() {
		a.style.backgroundColor = "#3232FF";
		b.style.backgroundColor = "#6EE0FF";

	}
</script>
</html>
