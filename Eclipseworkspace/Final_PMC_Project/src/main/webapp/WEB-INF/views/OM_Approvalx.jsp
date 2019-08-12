<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button {
	width: 150px;
	height: 50px;
}

table {
	width: 60%;
	height: 100%;
	margin: auto;
	text-align: center;
	border: solid;;
}
</style>
</head>
<body>

	<table border="1">
		<tr bgcolor="aqua" height="30">
			<th width="7%" bgcolor="black"
				style="color: white; text-align: center;">PC방 ID</th>
			<th width="20%" bgcolor="black"
				style="color: white; text-align: center;">PC방 업체명</th>
			<th width="7%" bgcolor="black"
				style="color: white; text-align: center;">비고</th>
		</tr>
		<c:forEach var="PcRoomBean" items="${sbpclist}">
			<tr>
				<td align="center"><a href="#"
					onclick="btn1('${PcRoomBean.p_id}');">${PcRoomBean.p_id}</a></td>
				<td align="center">${PcRoomBean.p_name}</td>
				<td><button id="${PcRoomBean.p_id}" style="text-align: center;" onclick="approval(this);"
						value="${PcRoomBean.p_id}/${PcRoomBean.p_holiday}">${ '3' eq PcRoomBean.p_holiday ? '해제': '블락'}</button>
						<button id="${PcRoomBean.p_id}" style="text-align: center;" onclick="seat(this);"
						value="${PcRoomBean.p_id}">좌석확인</button></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function approval(obj) {
		var id = 'param='+$(obj).val();
		
		console.log(id);				

		$.ajax({
			type : 'post',
			url : 'approvalx',
			data : id,
			dataType : 'json',
			success : function(data) {
				location.href = './OM_Approvalx'    
			},
			error : function(error) {
				
			}
		});
	}
	
	

	function btn1(obj) {
		var id = $(obj).val()
		console.log(obj);
		var url = "OM_PCDetail?param="+obj+"/2";
		var name = "popup112";
		var option = "width=700 , height=600";
		window.open(url, name, option);
	}
	
	function seat(obj) {
		var id = $(obj).val()
		console.log(obj);
		var url = "OM_SeatState?p_id="+id
		var name = "popup112";
		var option = "width=1000 , height=700";
		window.open(url, name, option);
	}
	
</script>
</html>