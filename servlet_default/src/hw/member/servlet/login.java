package hw.member.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

import hw.member.dto.memberVO;
import hw.member.service.IMemberService;
import hw.member.service.memberServiceImpl;

/**
 * Servlet implementation class login
 */
@WebServlet("/hwLogin")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String result = request.getParameter("re");
		
		if(result==null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}else if(Integer.parseInt(result) == 1) {
			String re = "아이디를 잘못 입력하셨습니다";
			request.setAttribute("result", re);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}else if(Integer.parseInt(result) == 2){
			String re = "비밀번호를 잘못입력하셨습니다";
			request.setAttribute("result", re);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}else if(Integer.parseInt(result) == 3){
			String re = "서버의 문제로 실패하였습니다.관리자에게 문의해주세요";
			request.setAttribute("result", re);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("id");
		String memPass = request.getParameter("pass");
		
		IMemberService memberService = memberServiceImpl.getInstance();
		
		try {
			memberVO member = memberService.loginMemberById(memId,memPass);
			response.sendRedirect("/servlet_default/hwList?re=0");
		
		} catch (NotFoundIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/servlet_default/hwLogin?re=1");

		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/servlet_default/hwLogin?re=2");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("/servlet_default/hwLogin?re=3");
		
		}
		
		
		
		
		
		
	}

	
	
	
	
	
}
