<%@page import="java.util.List"%>
<%@page import="hw.member.dto.memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	       String result = (String)request.getAttribute("result");
			List<memberVO> memberList = (List<memberVO>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="./style.css">
 <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/list.css">
 <script type="text/javascript">
    <%
    	if(result != null){
    		%> 
    		alert("<%=result %>");
    		<%
    	}
    %>
    </script>
    <style type="text/css">
    	table {
    		margin-left:auto; 
    		margin-right:auto;
    	}
    </style>
</head>
  <body width="100%" height="100%">
    <form action="index.html" method="post" class="loginForm">
      <h2>회원 리스트</h2>
      <table border="1" style="border-collapse: collapse; text-align: center; width: '700'">
      	<tr>
      		<th>아이디</th>
      		<th>비밀번호</th>
      		<th>이메일</th>
      		<th>핸드폰 번호</th>
      	</tr>
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
      <button type="button" class="btn" onclick="changeMain()">
        LOG OUT
      </button>
       <script>
      function changeMain(){
    	  location.href = '<%=request.getContextPath() %>/hwMain';
      }
      </script>
    </form>
  </body>
</html>