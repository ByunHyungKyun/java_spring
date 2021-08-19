<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<MemberVO> memberList = new ArrayList<MemberVO>();
for(int i = 0 ; i <11;i++){
	MemberVO member = new MemberVO("mimi"+i,"mimi","mimi2@naver.com","010-1234-1234");
	memberList.add(member);
}
	pageContext.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>전화번호</th>
		</tr>
	<%--
		for(int i = 0 ; i < memberList.size();i++){
			pageContext.setAttribute("member", memberList.get(i));
			
		}
	--%>
	<%--
	if(memberList != null) for(MemberVO member : memberList){
		pageContext.setAttribute("member", member);
		
		--%>
		<c:forEach items="${memberList }" var="member" >
			<tr>
				<td>${member.id }</td>
				<td>${member.pwd }</td>
				<td>${member.email }</td>
				<td>${member.phone }</td>
			</tr>
		</c:forEach>
		<%--	
	}
	--%>
	</table>
</body>
</html>



