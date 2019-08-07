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
<<<<<<< HEAD
            <th><input type="button" value="승인 관리" style="" onclick="btn1(1)"></th>
            <th><input type="button" value="공지사항 관리" style="" onclick="btn1(2)"></th>
            <th><input type="button" value="고객센터 관리" style="" onclick="btn1(3)"></th>
            <th><input type="button" value="전체회원 관리" style="" onclick="btn1(4)"></th>
        </tr>
        
=======
            <th><input type="button" value="미승인 피시방 관리" style="" onclick="btn1(1)"></th>
            <th><input type="button" value="승인  피시방관리" style="" onclick="btn1(2)"></th>
            <th><input type="button" value="좌석 관리" style="" onclick="btn1(3)"></th>
            <th><input type="button" value="승인 관리" style="" onclick="btn1(4)"></th>
            <th><input type="button" value="공지사항 관리" style="" onclick="btn1(5)"></th>
        </tr>   
>>>>>>> ec1fa806fd7262bb7083274868ca7d569aefb7b0
    </table>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	function btn1(a){
		if(a==1){
<<<<<<< HEAD
			location.href="OM_Approval"
		}if(a==2){
			
		}if(a==3){
=======
			location.href="OM_Approval";
		}else if(a==2){
			location.href="OM_Approvalx";
		}else if(a==3){
			location.href="OM_";
		}else if(a==4){
			
		}else if(a==5){
			
		}else if(a==6){
>>>>>>> ec1fa806fd7262bb7083274868ca7d569aefb7b0
			
		}if(a==4){
			location.href="OM_MemberList"
		}
		
		
	}
</script>
</html>