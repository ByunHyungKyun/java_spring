package hw.member.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hw.member.dto.memberVO;
import hw.member.service.IMemberService;
import hw.member.service.memberServiceImpl;

@WebServlet("/hwSelect")
public class select extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		IMemberService memberService = memberServiceImpl.getInstance();
		
			try {
				memberVO memberInfo = memberService.getMemberInfo(id);
				request.setAttribute("memberInfo", memberInfo);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/select.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		doGet(request, response);
	}

	
	
	
	
	
}
