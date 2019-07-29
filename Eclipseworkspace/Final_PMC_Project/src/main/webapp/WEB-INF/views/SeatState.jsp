<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%session.setAttribute("P_id", "eodud9603"); %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>�Ǹ� ������</title>
<!-- �������� �ּ�ȭ�� �ֽ� CSS -->
</head>
    <style>
        html,body,ul{margin: 0;padding: 0;}
        div{display: inline-block;}
        ul{list-style: none}
        #Menu{display: inline-block;background-color: gainsboro;margin-bottom: 30px; width: 1200px; margin-left: 130px}
        #SubMenu{height: 100px}
        a{text-decoration: none; color: inherit;}
        .mainmenu{float: left;; line-height: 100px; width: 19.8%; text-align: center;border: 1px solid black; font-size: 50px}
        .mainmenu:first-child{background-color: azure}
        .SubMenu{margin-bottom: 50px; margin-left: 20px}
        .SubMenu:first-child{margin-top: 200px;text-decoration: underline}
        header{position: fixed; z-index: 999;background-color: white;width: 100%}
        aside{position:  fixed; top: 180px;float: left;width: 10%; left: 70px}
        section{position: relative; top: 180px;float: right;width: 80%;}
        footer{background-color: antiquewhite;display: block;content: '';clear: both;text-align: center;position: fixed;bottom: 0px;width: 100%}
        .SubMenu:hover{text-decoration: underline}
        .mainmenu:hover{background-color: azure}
        .Pc_roomImg{text-align: center;}
        .Img{display: block; margin: auto; width: 30%;}
        button{width: 50%; margin: auto; display: block}
        table{width: 81%; margin-top: 30px; text-align: center}
        .AddMenu{display: inline-block; width: 1200px}
        .AddMenu > li{float: left; margin-left: 90%}
        .AddMenu > li:last-child{margin: 0}
        li:after{display: block;content: '';clear: both;}
        .addbtn{font-size: 30px; width: 100%}
        #imgbix{width: 81%}
        input{display:block;magin: auto;}
    </style>
    

<body>
    <header>
        <div>
        <img src="./resources/img/dd.png" id="pcimg">
        </div> 
        <ul id="Menu">
            <li class="mainmenu"><a href="#">�¼�</a></li>
            <li class="mainmenu"><a href="#">ȸ��</a></li>
            <li class="mainmenu"><a href="#">��ǰ</a></li>
            <li class="mainmenu"><a href="#">����</a></li>
            <li class="mainmenu"><a href="#">��Ÿ</a></li>
        </ul>    
    </header>
    <aside>
    <ul id="SubMenu">
        <li class="SubMenu"><a href="#">�¼�����</a></li>
        <li class="SubMenu"><a href="#">�¼� �󼼺��� / ����</a></li>
        <li class="SubMenu"><a href="#">�¼� ��ġ ����</a></li>
    </ul>
    </aside>
    <section>
        <div id="imgbix">
            <img src="./resources/img/No_image.png" class="Pc_roomImg Img" alt="pc�� ��ġ��">
            <input type="file" name="files" id="files" onchange="fileChk(this)" value="�̹����� ������ּ���">
        </div>
        <table border="1px solid black">
            <tr>
                <td>Pc��ȣ</td>
                <td>��� ����</td>
                <td>����� ���̵�</td>
                <td>�����ð�</td>
            </tr>
        </table>
        
        
            <ul class="AddMenu">
                <li><button class="addbtn">+</button></li>
                <li><button class="addbtn">-</button></li>
            </ul>
        
    </section>
    <footer>
        <h1>ICIA Pc Project</h1>
    </footer>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
    	function fileChk(elem){
		var name = elem.value.substring(elem.value.indexOf('.'))
		var p_id =  '${sessionScope.P_id}';
		console.log(name)
            
            name.remove
        if(name == '.jpg' || name == '.png'){
            var $obj = $("#files");//�迭���·� �Ѿ��.
            console.log($obj[0]);
            console.log($obj[0].files);
            console.log($obj[0].files.length);
            console.log($obj[0].files[0]);

		//form ������ ��������
            var fData = new FormData();
            fData.append("p_id",p_id);
            var files = $obj[0].files;
            
            for (var i = 0; i < files.length; i++) {
                fData.append("files" + i, files[i]);
            }
        	$.ajax({
                type : "post",
                url:"imgsave?cnt="+files.length,
                date : fData,
                processData:false,
                contentType : false,
                success: function(data){
                    alert("����");
                    var img = document.querySelector('.Img')
                    img.src = data.src;
                },
                error: function(error){
                    alert("����");
                    console.log(error);
                }
            })
        	
        }else{
        	elem.value = ''
        	alert('jpg�����̳� png������ �÷��ּ���');
        }
		
	}		
    </script>
</html>