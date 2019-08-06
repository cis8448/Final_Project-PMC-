<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="resources/css/Style_login.css"
	type="text/css">
<link rel="stylesheet" href="resources/css/Style.css" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<body>
	<div class="helloId">
		<h1 id="title"></h1>
	</div>
	<br />
	<center>
		<div class="login">
			<div class="login-screen">
				<div class="app-title">
					<h6>PMC SignUp</h6>
				</div>
				<div class="login-form">
					<form action="JSPSignUp" method="post" name="frm" id="frm"
						onsubmit="return check()">
						<div class="control-group">
							<table>
								<tr>
									<th><input type="text" name="p_id" class="login-field"
										value="" placeholder="아이디" id="userid" required="required"
										maxlength="20" size="20" id="_id"></th>
									<td><button type="button" onclick="btn1()"
											style="width: 80px; height: 40px">중복확인</button></td>
								</tr>
							</table>
						</div>
						<div class="control-group">
							<input type="password" name="p_pass" class="login-field" value=""
								placeholder="비밀번호" required="required" maxlength="20" size="20"
								id="_pass">
						</div>
						<div class="control-group">
							<input type="password" name="p_pass2" class="login-field"
								value="" placeholder="비밀번호 확인" required="required"
								maxlength="20" size="20" id="_pass2">
						</div>
						<div class="control-group">
							<input type="text" name="p_name" class="login-field" value=""
								placeholder="업체명" required="required" id="_name">
						</div>
						<div class="control-group">
							<input type="button" onclick="sample4_execDaumPostcode()"
								value="우편번호 찾기" style="background-color:#5AD2FF;"><br> 
								<input type="text" id="p_sido" placeholder="시/도" name="p_sido" required="required">  
								<input type="text" id="p_gugun" placeholder="구/군" name="p_gugun" required="required">
							<span id="guide" style="color: #999; display: none"></span> <input
								type="text" placeholder="동/리" id="p_dong" name="p_dong" required="required"> <input
								type="text" name="p_addr" class="login-field" value=""
								placeholder="상세주소" required="required" id="p_addr">
						</div>
						<div class="control-group">
							<input type="text" name="p_phone" class="login-field" value=""
								placeholder="전화번호(숫자만입력하세요!)" required="required" maxlength="11"
								size="11" id="_phone">
						</div>
						<div class="control-group">
							<input type="text" name="p_email" class="login-field" value=""
								placeholder="이메일" required="required" id="_email">
						</div>
						<div class="control-group">
							<input type="file" name="files" value="*(필수)사업자 등록 (click)*"
								onchange="fileChk(this)" multiple="multiple" id="files">
							<input type="hidden" id="fileCheck" value="0" name="fileCheck">
							<textarea rows="1" cols="32" class="Login-field"
								placeholder="등록된 파일이 없습니다">
							</textarea>
							<input type="button" name="button2" value="등록확인" style="background-color:#5AD2FF;"
								onclick="formData()">
						</div>

						<input type="submit" value="Sign Up!" onclick="sign_check()"
							class="btn btn-primary btn-large btn-block" id="signup" disabled>
						<a class="login-link" href="./"> 돌아가기 </a>
					</form>
				</div>
			</div>
		</div>

	</center>
</body>
<script>
window.onload = function() {
	var chk = ${param.ck};
	
	if (chk == 1) {
		alert("비밀번호가 서로 다릅니다!");
	}

}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.sido; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
               
                document.getElementById("p_sido").value = roadAddr;
                document.getElementById("p_gugun").value = data.sigungu;
                //data.sigungu = 구 /data.sido = 시/
                
               
          
                    document.getElementById("p_dong").value = data.bname;
               
                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<script>
	function check() {
		var frm = document.SignUp;
		var length = frm.length - 1;
		for (var i = 0; i < length; i++) {
			if (frm[i].value == "" || frm[i].value == null) {
				alert(frm[i].name + "을 입력하세요!!");
				frm[i].focus();
				return false;
			}
		}

		return true;
	}
</script>
<script>
	var idck = 0;

	function btn1() {
		//userid 를 param.
		var userid = $("#userid").val();
		console.log(userid)
		$.ajax({
			type : 'POST',
			data : userid,
			url : "PCIdCheck",
			dataType : 'json',
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				console.log(data)
				if (data.cnt > 0) {
					alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
				} else {
					alert("사용가능한 아이디입니다.");
					//아이디가 중복하지 않으면  idck = 1 
					document.all.userid.readOnly=true;
					idck = 1;
				}

			},
			error : function(error) {
				alert("error : " + error);
			}

		});
	};

	function sign_check() {
		if (confirm("회원가입을 하시겠습니까?")) {
			if (idck == 0) {
				alert('아이디 중복체크를 해주세요');
				return false;
			}
		}
	}
</script>
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
		fData.append("_id", $("#userid").val());
		console.log($("#userid").val());
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







