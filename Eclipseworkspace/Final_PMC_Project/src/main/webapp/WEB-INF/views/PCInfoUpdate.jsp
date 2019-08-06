<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/Style_login.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/Style.css" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div class="helloId">
		<h1 id="title"></h1>
	</div>
	<br />
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>PMC InfoUpdate</h6>
				</div>
				<div class="login-form">
					<form action="InfoUpdate" method="post" name="frm" id="frm">
						<div class="control-group">
							<input type="text" name="p_id" class="login-field"
								value="${pr.p_id }" readonly="readonly" id="_id"
								style="background-color: black; color: white;">
						</div>
						<div class="control-group">
							<input type="text" name="p_name" class="login-field"
								value="" placeholder="${pr.p_name }" maxlength="20" size="20"
								id="_name">
						</div>
						<div class="control-group">
							<input type="text" name="p_phone" class="login-field"
								value="" placeholder="${pr.p_phone }" maxlength="20"
								size="20" id="_name">
						</div>
						<input type="button" value="비밀번호 변경" onclick="changepw()">
						<table>
						<tr>
						<th>
						<input type="submit" value="변경" 
						class="btn btn-primary btn-large btn-block" style="width:100px;height: 50px;margin-left: 80px;">
						</th><td>
						<input type="button" value="취소" onclick="close2()" style="width:100px;height: 50px;">
						</td>
						</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</center>


</body>
<script>
window.onload = function() {
	var chk = '${param.iu}';
	
	if (chk == 1) {
		alert("변경완료!");
		self.close();
	}

}

</script>
<script type="text/javascript">
function changepw(){
		var url = "changepw";
		var name = "popup33";
		var option = "width=700 , height=600";
		window.open(url, name, option);
	
}
</script>
<script>
	function close2() {
		self.close();
	}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

</html>