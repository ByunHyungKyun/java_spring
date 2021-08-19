<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	       String result = (String)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="./style.css">
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css"> 
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
      <button type="button" class="btn" onclick="changeLogin()">
        	로그인
      </button>
      <button type="button" class="btn" onclick="changeSignUp()">
        	회원가입
      </button>
      <script>
      function changeLogin(){
    	  location.href = '<%=request.getContextPath() %>/hwLogin';
      }
      function changeSignUp(){
    	  location.href = '<%=request.getContextPath() %>/hwSignUp';
      }
      </script>
    </form>
  </body>
</html>


