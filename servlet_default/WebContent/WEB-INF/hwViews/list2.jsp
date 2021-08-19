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
<title></title>
<script type="text/javascript">
	<c:if test="${not empty re}">
		alert("${re}");
	</c:if>
    </script>
</head>
<body>
	<nav class="navbar navbar-default"> 
		<div class="navbar-header"> 	
			<a class="navbar-brand" href="${pageContext.request.contextPath}/hwList">JSP 회원 CRUD 과제</a>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">아이디</th>
						<th style="background-color: #eeeeee; text-align: center;">비밀번호</th>
						<th style="background-color: #eeeeee; text-align: center;">이메일</th>
						<th style="background-color: #eeeeee; text-align: center;">핸드폰 번호</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${not empty memberList }">
				<c:forEach items="${memberList }" var="member">
      			<tr>
	      			<td>
	      				<a href="${pageContext.request.contextPath}/hwSelect?id=${member.id }">${member.id }</a>
	      			</td>
    	  			<td>
    	  				${member.pass }
    	  			</td>
      				<td>
      					${member.email }
      				</td>
      				<td>
      					${member.phone }
      				</td>
      			</tr>
      			</c:forEach>
      			</c:if>
      			<c:if test="${empty memberList }">
      				<tr>
	      			<td>
	      				회원리스트가 없습니다
	      			</td>
    	  			<td>
    	  				회원리스트가 없습니다
    	  			</td>
      				<td>
      					회원리스트가 없습니다
      				</td>
      				<td>
      					회원리스트가 없습니다
      				</td>
      			</tr>
      			</c:if>
      </table>
			<a href="${pageContext.request.contextPath}/hwSignUp" class="btn btn-primary pull-right">회원 등록</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>