<%@page import="hw.member.dto.memberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/signUp.css">
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
			<a class="navbar-brand" href="${pageContext.request.contextPath}/hwList">JSP 회원 CRUD 과제</a>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<form action="${pageContext.request.contextPath}/hwUpdate" method="post" class="loginForm">
				<h2>회원 정보 수정</h2>
					<input type="hidden" class="id" placeholder="" name="id" value="${memberVo.id }">
				<div class="idForm">
					 <input type="text" class="id" placeholder="비밀번호:${memberVo.pass }" name="pass" value=""> 
				</div>
				<div class="idForm">
					<input type="text" class="id" placeholder="Email: ${memberVo.email }" name="email" value="">
				</div>
				<div class="idForm">
					<input type="text" class="id" placeholder="Phone: ${memberVo.phone }" name="phone" value="">
					</div>
			      <button type="submit" class="btn">
			        	완료
			      </button>
			      <button type="button" class="btn" onclick="changeMain()">
					리스트 돌아가기</button>
				<script>
					 function changeMain(){
			    	  location.href = '${pageContext.request.contextPath}/hwList';
					}
				</script>
			</form>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>