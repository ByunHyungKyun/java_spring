<%@page import="hw.member.dto.memberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%
		memberVO memberInfo = (memberVO)request.getAttribute("memberInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
 <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/signUp.css">
 <style type="text/css">
 	body{
 		background-color: #F2F2F2;
 	}
 </style>
<title></title>
</head>
<body>
	<nav class="navbar navbar-default"> 
		<div class="navbar-header"> 	
			</button>
			<a class="navbar-brand" href="#">JSP 회원 CRUD 과제</a>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<form action="<%=request.getContextPath()%>/hwSignUp" method="post" class="loginForm">
				<h2>회원 정보</h2>
				<div class="idForm">
					<input type="text" class="id" placeholder="아이디: <%=memberInfo.getId() %>" name="id" readonly="readonly">
				</div>
				<div class="passForm">
					 <input type="password" class="pw" placeholder="비밀번호: <%=memberInfo.getPass() %>" name="pass" readonly="readonly"> 
				</div>
				<div class="idForm">
					<input type="text" class="id" placeholder="Email: <%=memberInfo.getEmail() %>" name="email" readonly="readonly">
				</div>
				<div class="idForm">
					<input type="text" class="id" placeholder="Phone: <%=memberInfo.getPhone() %>" name="phone" readonly="readonly">
				</div>
				<button type="button" class="btn" onclick="changeLogin()">
					회원정보 수정</button>
				<button type="button" class="btn" onclick="changeSignUp()">
					회원 탈퇴</button>
				<button type="button" class="btn" onclick="changeMain()">
					리스트 돌아가기</button>
				<script>
			      function changeLogin(){
			    	  location.href = '<%=request.getContextPath()%>/hwUpdate?id=<%=memberInfo.getId()%>';
			      }
			      function changeSignUp(){
			    	  location.href = '<%=request.getContextPath()%>/hwDelete?id=<%=memberInfo.getId()%>';
					}
			      function changeMain(){
			    	  location.href = '<%=request.getContextPath()%>/hwList';
					}
				</script>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>