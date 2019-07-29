<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 
	href="resources/css/Style_login.css" 
	type="text/css">
<link rel="stylesheet" 
	href="resources/css/Style.css" 
	type="text/css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="./resources/image/dd.png" width="200" height="140">

<div>
	<button>월별 매출</button><br>
	<button>카테고리별 매출</button><br>
	<button>충전시간 매출</button>
</div>

<table>
	<tr>
		<td><select name="pcselectyear">
		<option value="2018" selected>2018년</option>
		<option value="2019" selected>2019년</option>
		</select>
		</td>
		
		<td><select name="pcselectmonth">
		<option value="1" selected>1월</option>
		<option value="2" selected>2월</option>
		<option value="3" selected>3월</option>
		<option value="4" selected>4월</option>
		<option value="5" selected>5월</option>
		<option value="6" selected>6월</option>
		<option value="7" selected>7월</option>
		<option value="8" selected>8월</option>
		<option value="9" selected>9월</option>
		<option value="10" selected>10월</option>
		<option value="11" selected>11월</option>
		<option value="12" selected>12월</option>
	
		
		</select>
		
		<button>검색</button>
	</tr>
</table>


</body>
</html>