<%@page import="hw.member.dto.memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	       String result = (String)request.getAttribute("result");
		memberVO memberInfo = (memberVO)request.getAttribute("memberInfo");
%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="./style.css">
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/select.css"> 
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
  <body width="100%" height="100%">
    <form action="index.html" method="post" class="loginForm">
      <h2>main</h2>
      <div class="idForm">
        <input type="text" class="id" placeholder="<%=memberInfo.getId() %>" name="id" readonly="readonly">
      </div>
      <div class="passForm">
        <input type="password" class="pw" placeholder="<%=memberInfo.getPass() %>" name="pass" readonly="readonly"> 
      </div>
      <div class="idForm">
        <input type="text" class="id" placeholder="<%=memberInfo.getEmail() %>" name="email" readonly="readonly">
      </div>
      <div class="idForm">
        <input type="text" class="id" placeholder="<%=memberInfo.getPhone() %>" name="phone" readonly="readonly">
      </div>
      <button type="button" class="btn" onclick="changeLogin()">
        	회원정보 수정
      </button>
      <button type="button" class="btn" onclick="changeSignUp()">
        	회원 탈퇴
      </button>
      <script>
      function changeLogin(){
    	  location.href = '<%=request.getContextPath() %>/hwUpdate?id=<%=memberInfo.getId() %>';
      }
      function changeSignUp(){
    	  location.href = '<%=request.getContextPath() %>/hwDelete?id=<%=memberInfo.getId() %>';
      }
      </script>
    </form>
  </body>
</html>


