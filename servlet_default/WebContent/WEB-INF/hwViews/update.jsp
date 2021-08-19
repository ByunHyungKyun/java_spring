<%@page import="hw.member.dto.memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	       String id = (String)request.getAttribute("id");
			memberVO memberVo = (memberVO)request.getAttribute("memberVo");
%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="./style.css">
 <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/update.css">
</head>
  <body width="100%" height="100%">
    <form action="<%=request.getContextPath() %>/hwUpdate" method="post" class="loginForm">
      <h2>회원수정</h2>
        <input type="hidden" class="id" placeholder="" name="id" value="<%=id %>" >
      <div class="passForm">
        <input type="password" class="pw" placeholder="Password" name="pass">
      </div>
      <div class="idForm">
        <input type="text" class="id" placeholder="Email" name="email">
      </div>
      <div class="idForm">
        <input type="text" class="id" placeholder="Phone" name="phone">
      </div>
      <button type="submit" class="btn">
        	완료
      </button>
    </form>
  </body>
</html>