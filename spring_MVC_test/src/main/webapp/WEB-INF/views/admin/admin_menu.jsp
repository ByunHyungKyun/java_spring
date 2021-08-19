<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- core태그를 사용하기 위해 taglib를 사용 -->
 
<!-- 관리자로그인한 상태에서만 보이는 메뉴 -->
 
<!-- 메뉴 링크를 추가하고 PDF리스트로 갈수있는 링크도 추가 -->
<a href="${path}/shop/product/list.do">상품목록</a>
ㅣ
<a href="${path}/shop/product/write.do">상품등록</a>
ㅣ
<a href="${path}/pdf/list.do">PDF</a>
ㅣ
 
<c:choose>
 
    <c:when test="${sessionScope.admin_userid == null }">
        <a href="${path }/admin/login.do">관리자 로그인</a>
        <!-- 세션에 관리자 아이디의 값이 NULL일때 (즉 로그인 되어있지 않은 상태일때) -->
        <!-- 관리자 로그인 링크를 표시 -->
    </c:when>
 
 
    <c:otherwise>
${sessionScope.admin_name}님이 로그인중입니다.
<a href="${path}/admin/logout.do">로그아웃</a>
        <!-- 관리자가 로그인한 상태일때는 로그아웃 링크를 표시 -->
    </c:otherwise>
 
</c:choose>
<hr>
