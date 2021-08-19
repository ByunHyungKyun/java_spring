package hw.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hwMain2")
public class main2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("re");
		
		if(result==null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
			dispatcher.forward(request, response);
		}else if(Integer.parseInt(result) == 1) {
			String re = "회원가입을 성공하였습니다";
			request.setAttribute("result", re);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
			dispatcher.forward(request, response);
		}else if(Integer.parseInt(result) == 0){
			String re = "회원가입이 실패하였습니다";
			request.setAttribute("result", re);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
			dispatcher.forward(request, response);
		}else if(Integer.parseInt(result) == 2){
			String re = "서버의 문제로 실패하였습니다.관리자에게 문의해주세요";
			request.setAttribute("result", re);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

	
	
	
	
	
}
