<%@page import="hw.member.dto.memberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%
	 String id = (String)request.getAttribute("id");
	memberVO memberVo = (memberVO)request.getAttribute("memberVo");
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
			<form action="<%=request.getContextPath()%>/hwUpdate" method="post" class="loginForm">
				<h2>회원 정보 수정</h2>
					<input type="hidden" class="id" placeholder="" name="id" value="<%=memberVo.getId() %>">
				<div class="idForm">
					 <input type="text" class="id" placeholder="비밀번호: <%=memberVo.getPass() %>" name="pass" value=""> 
				</div>
				<div class="idForm">
					<input type="text" class="id" placeholder="Email: <%=memberVo.getEmail() %>" name="email" value="">
				</div>
				<div class="idForm">
					<input type="text" class="id" placeholder="Phone: <%=memberVo.getPhone() %>" name="phone" value="">
					</div>
			      <button type="submit" class="btn">
			        	완료
			      </button>
			      <button type="button" class="btn" onclick="changeMain()">
					리스트 돌아가기</button>
				<script>
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