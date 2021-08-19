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

@WebServlet("/hwDelete")
public class delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		IMemberService memberService = memberServiceImpl.getInstance();
		List<memberVO> memberList;
				try {
					int result = memberService.deleteMember(id);
					if(result == 1) {
						memberList = memberService.getAllMemberList();
						request.setAttribute("memberList", memberList);
						request.setAttribute("re", "회원을 삭제 실패하였습니다");
						request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
					}else {
						memberList = memberService.getAllMemberList();
						request.setAttribute("memberList", memberList);
						request.setAttribute("re", "회원을 삭제 완료하였습니다");
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

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request,response);
		
	}

	
	
	
	
	
}
