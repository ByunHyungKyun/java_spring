<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="./style.css">
 <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/signUp.css">
</head>
  <body width="100%" height="100%">
    <form action="<%=request.getContextPath() %>/hwSignUp" method="post" class="loginForm">
      <h2>회원가입</h2>
      <div class="idForm">
        <input type="text" class="id" placeholder="Id" name="id">
      </div>
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