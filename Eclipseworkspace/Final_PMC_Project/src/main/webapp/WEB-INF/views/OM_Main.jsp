<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피모씨 운영관리자</title>
  <style>
        input{
            width: 150px;
            height: 100px;
        }
        table{
            width:60%;
            height: 100%;
            margin: auto;
            text-align: center;
            margin-top: 
        }
    </style>
</head>
<body>
    <br><br>
	<center>
	   <h1>운영관리자</h1>
	   <hr style="border: solid;1px; width:70%; margin-bottom: 200px;">
	</center>
    <table>
        <tr>
            <th><input type="submit" value="승인 관리" style=""></th>
            <th><input type="submit" value="고객센터 관리" style=""></th>
            <th><input type="submit" value="공지사항 관리" style=""></th>
        </tr>
        
    </table>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</html>