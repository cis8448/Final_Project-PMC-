<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/Style_login.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/Style.css" type="text/css">
</head>
<body>
	<div class="helloId">
		<h1 id="title"></h1>
	</div>
	<br>
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>PMC PictureUpdate</h6>
				</div>
				<div class="login-form">
					<div class="control-group">
						<input type="file" name="files" value="*(필수)사업자 등록 (click)*"
							onchange="fileChk(this)" multiple="multiple" id="files">
						<input type="hidden" id="fileCheck" value="0" name="fileCheck">
						<input type="button" name="button2" value="등록확인"
							style="background-color: #5AD2FF;" onclick="formData()">
					</div>
					<div class="control-group">
						<input type="file" name="files" value="*(필수)사업자 등록 (click)*"
							onchange="fileChk(this)" multiple="multiple" id="files">
						<input type="hidden" id="fileCheck" value="0" name="fileCheck">
						<input type="button" name="button2" value="등록확인"
							style="background-color: #5AD2FF;" onclick="formData()">
					</div>
					<div class="control-group">
						<input type="file" name="files" value="*(필수)사업자 등록 (click)*"
							onchange="fileChk(this)" multiple="multiple" id="files">
						<input type="hidden" id="fileCheck" value="0" name="fileCheck">
						<input type="button" name="button2" value="등록확인"
							style="background-color: #5AD2FF;" onclick="formData()">
					</div>
				</div>
			</div>
		</div>
	</center>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

	function fileChk(elem) {
		console.dir(elem.value);
		if (elem.value == "") {
			console.log("empty");
			$("#fileCheck").val(0);//파일첨부 안함

		} else {
			console.log("not empty");
			$("#fileCheck").val(1);

		}
	}

	function formData() {
		var button_joinus = document.getElementById('signup');
		var $obj = $("#files");//배열형태로 넘어옴.
		console.log($obj[0]);
		console.log($obj[0].files);
		console.log($obj[0].files.length);
		console.log($obj[0].files[0]);

		//form 데이터 가져오기
		var fData = new FormData();
		fData.append("fileCheck", $("#fileCheck").val());
		fData.append("_id", <%=(String)request.getAttribute("id")%>);
		console.log(<%=(String)request.getAttribute("id")%>);
		var files = $obj[0].files;
		for (var i = 0; i < files.length; i++) {
			fData.append("files" + i, files[i]);
		}

		//ajax전송 
		$.ajax({
			type : "post",//multpart 전송은 post로
			url : "fileupload?cnt=" + files.length,
			data : fData,
			processData : false,
			//application/x-www-form-urlencoded 형식으로
			//처리되지 않게 막는 속성(쿼리스트링)
			contentType : false,
			//multipart 일 경우 false
			dataType : "html",//생략가능 기본타입(html)
			success : function(data) {
				alert("성공");
				console.log(data);
				button_joinus.disabled = false;

	
			},
			error : function(error) {
				alert("실패");
				console.log(error);
			}
		});

	}


</script>
</html>