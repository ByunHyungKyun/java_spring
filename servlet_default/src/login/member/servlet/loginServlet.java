package login.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.member.service.IMemberService;
import login.member.service.MemberServiceImpl;
import login.member.vo.memberVO;


@WebServlet("/login")
public class loginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>login 연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/servlet_default/login\" method=\"post\">");
		out.println("<h1>로그인 화면</h1>");
		out.println("<input type=\"text\" placeholder=\"ID를 입력하시오\" id=\"memId\" name=\"memId\"/>");
		out.println("<input type=\"password\" placeholder=\"Password를 입력하시오\" id=\"memPass\" name=\"memPass\"/>");
		out.println("<button type='submit'>로그인</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");

		memberVO memberVo = new memberVO();
		memberVo.setId(memId);
		memberVo.setPass(memPass);
		IMemberService memberService = MemberServiceImpl.getInstance();
		String result = memberService.loginMember(memberVo);
		
		if(result.equals("비밀번호가 틀렸습니다!!")) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(result);
		}else if(result.equals("아이디가 틀렸습니다!!")) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println(result);
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"Login Complete\");");
			out.print("location.href = '/servlet_default/list';");
			out.println("</script>");
			out.println("</head>");
			out.println("<body></body>");
			out.println("</html>");
		}
		
	}
	
}
