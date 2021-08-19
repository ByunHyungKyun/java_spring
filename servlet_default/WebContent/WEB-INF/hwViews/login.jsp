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
 <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
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
    <form action="<%=request.getContextPath() %>/hwLogin" method="post" class="loginForm">
      <h2>Login</h2>
      <div class="idForm">
        <input type="text" class="id" placeholder="ID" name="id">
      </div>
      <div class="passForm">
        <input type="password" class="pw" placeholder="PW" name="pass">
      </div>
      <button type="submit" class="btn">
        LOG IN
      </button>
    </form>
  </body>
</html>