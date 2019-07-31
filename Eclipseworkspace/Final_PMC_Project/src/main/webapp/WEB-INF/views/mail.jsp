<%@page import="com.pmc.final_project.util.MailUtil"%>
<%@page import="com.pmc.final_project.util.FindUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%			
			String keyCode = FindUtil.createKey();
			session.setAttribute("keyCode", keyCode);

			String subject = "임시 비밀번호 발송 안내";

			String msg = "";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>임시 비밀번호 입니다.</h3>";
			msg += "<div style='font-size: 130%'>";
			msg += "비밀번호가 임시 비밀번호로 변경 되었습니다! 로그인 후 비밀번호 변경 부탁드립니다! <strong>";
			msg += keyCode + "</strong> 를 입력해주세요.</div><br/>";

			String cid = request.getParameter("cid");
			session.setAttribute("cid", cid);
			MailUtil.sendMail("dkfwlq78@naver.com", subject, msg);
%>
</head>
<body>
	<script>
	location.href="./pwsearch";
	</script>

</body>
</html>