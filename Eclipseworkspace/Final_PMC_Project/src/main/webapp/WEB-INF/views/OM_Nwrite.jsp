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

	<div class="login" style="width: 1000px;">
		<div class="login-screen" style="width: 1000px;">
			<div class="app-title" style="width: 1000px;">
				<h6>PMC Write</h6>
			</div>
			<div class="login-form">
				<form action="./OM_NInsert" method="post" name="frm" id="frm">
					<div class="login-form">
						<select id="no_cate" name="no_cate">
							<option value="0">운영->PC방 (공지)</option>
							<option value="1">PC방->앱 (공지)</option>
							<option value="2">운영 ->앱 (공지)</option>
						</select>
					</div>
					<div class="login-form">
						<input type="text" class="login-field" value="" placeholder="제목"
							required="required" maxlength="20" size="20" name="no_title">
					</div>
					<div class="control-group">
						<textarea rows="30" cols="50" class="login-field"
							style="border: dashed;" name="no_content"></textarea>
					</div>


					<input type="submit" value="작성">
				</form>
				<div class="login-form">
					<input type="button" value="돌아가기" onclick="back()"
						style="margin-top: 10px;">
				</div>
			</div>
		</div>
	</div>

</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function back() {
		history.back()
	}
</script>
</html>