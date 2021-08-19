<%@page import="hw.member.dto.memberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	       String result = (String)request.getAttribute("re");
			List<memberVO> memberList = (List<memberVO>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title></title>
<script type="text/javascript">
 <%
    	if(result != null){
    		%> 
    		alert("<%=result %>");
    		<%
    	}
 		
    %>
    </script>
</head>
<body>
	<nav class="navbar navbar-default"> 
		<div class="navbar-header"> 	
			<a class="navbar-brand" href="#">JSP 회원 CRUD 과제</a>
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
					 <%
      	for(int i = 0 ; i < memberList.size();i++){
      		%>
      			<tr>
	      			<td>
	      				<a href="<%=request.getContextPath() %>/hwSelect?id=<%=memberList.get(i).getId() %>"><%=memberList.get(i).getId() %></a>
	      			</td>
    	  			<td>
    	  				<%=memberList.get(i).getPass() %>
    	  			</td>
      				<td>
      					<%=memberList.get(i).getEmail() %>
      				</td>
      				<td>
      					<%=memberList.get(i).getPhone() %>
      				</td>
      			</tr>
      		<%
      	}
      %>
      </table>
			<a href="<%=request.getContextPath() %>/hwSignUp" class="btn btn-primary pull-right">회원 등록</a>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>