package login.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.member.service.IMemberService;
import login.member.service.MemberServiceImpl;
import login.member.vo.memberVO;


@WebServlet("/delete")
public class deleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*IMemberService memberService = MemberServiceImpl.getInstance();
		List<memberVO> result = memberService.getAllMemberList();
		*/
		
		String Id = req.getParameter("Id");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("입력하신"+Id+"님을 삭제할려했는데 아직 구현을 못해습니다.");
		out.println("<a href='/servlet_default/list'>리스트로 돌아가기</a>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
}
