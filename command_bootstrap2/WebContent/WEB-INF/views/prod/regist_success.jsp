<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<body>
<script>
	alert("상품등록에 성공했습니다.\n 상품리스트 페이지로 이동합니다.");
	
	
	window.onload=function(){
		
		$.ajax({
			
			url:"/getMcode.do?mName=공지목록",
			type:"get",
			
			success:function(menu){
				window.opener.parent.location.href="/index.do?mCode="+menu.mcode;
				window.close();				
		
			}
			
		});	
		
	}
</script>
</body>