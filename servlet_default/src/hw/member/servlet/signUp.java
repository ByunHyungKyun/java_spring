package hw.member.servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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

@WebServlet("/hwSignUp")
public class signUp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/signUp.jsp");

		dispatcher.forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("id");
		String Pass = request.getParameter("pass");
		String Email = request.getParameter("email");
		String Phone = request.getParameter("phone");
		
		memberVO memberVo = new memberVO();
		memberVo.setId(Id);
		memberVo.setPass(Pass);
		memberVo.setEmail(Email);
		memberVo.setPhone(Phone);
		
		IMemberService memberService = memberServiceImpl.getInstance();
		List<memberVO> memberList;
		try {
			int result = memberService.signUpMember(memberVo);
			
			if(result == 1) {
				memberList = memberService.getAllMemberList();
				request.setAttribute("memberList", memberList);
				request.setAttribute("re", "회원등록을 성공하였습니다");
				request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
			}else {
				memberList = memberService.getAllMemberList();
				request.setAttribute("memberList", memberList);
				request.setAttribute("re", "회원등록이 실패하였습니다");
				request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				memberList = memberService.getAllMemberList();
				request.setAttribute("memberList", memberList);
				request.setAttribute("re", "서버의 문제로 실패하였습니다.관리자에게 문의해주세요");
				request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
