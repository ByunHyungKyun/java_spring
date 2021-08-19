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

@WebServlet("/hwMain")
public class main extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMemberService memberService = memberServiceImpl.getInstance();
		List<memberVO> memberList;
		try {
			memberList = memberService.getAllMemberList();
			request.setAttribute("memberList", memberList);
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/starter.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	
	
	
	
}
