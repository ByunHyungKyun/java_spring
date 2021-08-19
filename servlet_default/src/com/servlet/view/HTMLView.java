package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class HTMLView {
	
	public static void html(HttpServletResponse response,String title,String css,String script,String body) 
														throws IOException,ServletException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>"+title+"</title>");
		out.println("<style>"+css+"</style>");
		out.println("<script>"+script+"</script>");
		out.println("</head>");
		out.println("<body>"+body+"</body>");
		out.println("</html>");
	}
	
	
	public static void html(HttpServletResponse response,String title,String body) 
													throws IOException,ServletException {
		
		html(response,title,null,null,body);
	}
	
	
	public static void html(HttpServletResponse response,String script) 
								throws IOException,ServletException {
		
		html(response,null,null,script,null);
	}
	
	
	public static void loginView(HttpServletResponse response)
					throws IOException,ServletException {
		
		String title = "login 연습";
		String body = "<form action='/servlet_default/login2' method='post'>"
				+ "<h1>로그인 화면</h1>"
				+ "<input type='text' placeholder='ID를 입력하시오' id='id' name='id'/>"
				+ "<input type='password' placeholder='Password를 입력하시오' id='pwd' name='pwd'/>"
				+ "<button type='submit'>로그인</button>"
				+ "</form>";
		html(response,title,null,null,body);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
