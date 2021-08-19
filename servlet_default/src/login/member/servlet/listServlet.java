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


@WebServlet("/list")
public class listServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IMemberService memberService = MemberServiceImpl.getInstance();
		List<memberVO> result = memberService.getAllMemberList();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>member list</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>회원 리스트</h1>");
		out.println("<table border='1' style='border-collapse: collapse;\"\r\n" + 
				"		+\"text-align: center;' width='700' >");
		out.println("<tr style='background-color: blue; color:white;'>");
		out.println("<th>id</th>");
		out.println("<th>pass</th>");
		out.println("<th>email</th>");
		out.println("<th>phone</th>");
		out.println("</tr>");
		for(int i = 0 ; i < result.size();i++) {
			out.println("<tr>");
			out.println("<td><a href='/servlet_default/delete?Id="+result.get(i).getId()+"'>"+result.get(i).getId()+"</a></td>");
			out.println("<td>"+result.get(i).getPass()+"</td>");
			out.println("<td>"+result.get(i).getEmail()+"</td>");
			out.println("<td>"+result.get(i).getPhone()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
	
}
