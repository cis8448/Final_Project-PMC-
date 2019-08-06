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
}
</style>
</head>
<body>
	<center>
		<table style="border: solid;1px">
			<tr bgcolor="aqua" height="30">
				<td width="7%" bgcolor="black"
					style="color: white; text-align: center;">PC방 ID</td>
				<td width="7%" bgcolor="black"
					style="color: white; text-align: center;">비고</td>
			</tr>
			<c:forEach var="PcRoomBean" items="${sbpclist}">
				<tr>
					<td align="center" name="pc_id"><a href="#"
						onclick="btn1('${PcRoomBean.p_id}');">${PcRoomBean.p_id}</a></td>
					<td><button style="text-align: center;"
							onclick="approval(this);" value="${PcRoomBean.p_id}">승인</button>
						<button style="text-align: center;" onclick="negative(this);"
							value="${PcRoomBean.p_id}">거절</button> <input type="hidden"
						value="${PcRoomBean.p_id}"></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
	function approval(obj) {
		var tr = $(obj).parent().parent();
		var id = $(obj).val();
		console.log(id)

		$.ajax({
			type : 'post',
			url : 'approval',
			data : id,
			dataType : 'json',
			success : function(data) {
				tr.remove();
			},
			error : function(error) {
				console.log(error)
			}
		});
	}

	function negative(obj) {
		var tr = $(obj).parent().parent();
		var id = $(obj).val();
		console.log(id)

		$.ajax({
			type : 'post',
			url : 'negative',
			data : id,
			dataType : 'json',
			success : function(data) {
				tr.remove();
			},
			error : function(error) {
				console.log(error)
			}
		});
	}
	function btn1(obj) {
		
		console.log(obj);
		var url = "OM_PCDetail?param="+obj;
		var name = "popup11";
		var option = "width=700 , height=600";
		window.open(url, name, option);
	}
</script>

</html>