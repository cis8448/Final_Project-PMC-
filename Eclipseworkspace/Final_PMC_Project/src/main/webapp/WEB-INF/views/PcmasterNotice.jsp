<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
	margin-top:250px;
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

.mainmenu:last-child {
	background-color: azure;
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
	background-color:;
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
	width: 150px;
	height: 200px;
	padding: 10px;
}

table {
	width: 80%;
	text-align: center
}

.button {
	border: 1px solid skyblue;
	background-color: dodgerblue;
	color: white;
	padding: 3px;
	margin-left: 30px;
	margin-bottom: 200px;
}
.table{
	margin-bottom: 200px;
}
.lastbutton{
    border: 1px solid skyblue;
	background-color: dodgerblue;
	color: white;
	padding: 3px;
    margin-right: 320px;
    float: right;
    }
</style>
<body>
<header>
	
		<div>
			<img src="./resources/image/dd.png">
		</div>
		<ul id="Menu">
			<li class="mainmenu"><a href="#">�¼�</a></li>
			<li class="mainmenu"><a href="#">��ǰ</a></li>
			<li class="mainmenu"><a href="#">ȸ��</a></li>
			<li class="mainmenu"><a href="#">����</a></li>
			<li class="mainmenu"><a href="./MasterNotice">��Ÿ</a></li>
		</ul>


    </header>
	<aside>
	  
    <ul id="SubMenu">
    	<li class="Submenu"><a href="./MasterNotice">������ڿ� ��������</a></li>
    	<li class="Submenu"><a href="./PcmasterNotice">PC������ڿ� ��������</a></li>
    	<li class="Submenu"><a href="./CustomerSc">���� ������</a></li>
    	<li class="Submenu"><a href="./PcmasterSc">PC������ڿ� ������</a></li>
    </ul>

	</aside>

	<section>
		<table border="1px solid black" class="table">
			<tr class="Notice">
				<td colspan="6">��������</td>
			</tr>

			<tr class="NoticeNum">
				<td>No</td>
				<td>����</td>
				<td>�ۼ���¥</td>
				<td>�۳���</td>
				<td>ī�װ�</td>
                <td>���</td>
			</tr>
			
			<c:forEach var="pcroomnoticebean" items="${nList}">
				<tr>
					<td align="center">${pcroomnoticebean.no_num}</td>
<<<<<<< HEAD
					<td align="center">${pcroomnoticebean.no_title}</td>
					<td align="center">${pcroomnoticebean.no_date}</td>
					<td align="center">${pcroomnoticebean.no_content}</td>
					<td align="center">${pcroomnoticebean.no_cate}</td>
					<td><a href="./NoticeDetail" class="button">�󼼺���</a></td>
=======
					<td align="center">
					<a href="./contents?no_num=${pcroomnoticebean.no_num}">${pcroomnoticebean.no_title}</a></td>
					<td align="center">${pcroomnoticebean.no_date}</td>
>>>>>>> 153bc5334a2388642aeda43aafb131dda8d94840
				</tr>
			</c:forEach>
		</table>
		<a href="./PcNoticeWrite" class="button">�۾���</a>
	</section>
			
	<footer>
		
		<h1>ICIA Pc Project</h1>
	</footer>

	<br>
	<br>
	
	<div align="center">${paging}</div>
</body>

</html>