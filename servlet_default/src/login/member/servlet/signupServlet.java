package login.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.member.service.IMemberService;
import login.member.service.MemberServiceImpl;
import login.member.vo.memberVO;


@WebServlet("/signup")
public class signupServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>signUp 연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/servlet_default/signup\" method=\"post\">");
		out.println("<h1>회원가입 화면</h1>");
		out.println("<input type=\"text\" placeholder=\"ID를 입력하시오\" id=\"memId\" name=\"memId\"/>");
		out.println("<input type=\"text\" placeholder=\"Password를 입력하시오\" id=\"memPass\" name=\"memPass\"/>");
		out.println("<input type=\"text\" placeholder=\"휴대폰번호를 입력하시오\" id=\"memPh\" name=\"memPh\"/>");
		out.println("<input type=\"text\" placeholder=\"email를 입력하시오\" id=\"memEmail\" name=\"memEmail\"/>");
		out.println("<button type='submit'>회원가입</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memPh = req.getParameter("memPh");
		String memEmail = req.getParameter("memEmail");
		
		memberVO memberVo = new memberVO();
		memberVo.setId(memId);
		memberVo.setPass(memPass);
		memberVo.setPhone(memPh);
		memberVo.setEmail(memEmail);
		
		IMemberService memberService = MemberServiceImpl.getInstance();
		int result = memberService.signupMember(memberVo);
		
		if(result>0) {
			PrintWriter out=resp.getWriter();
			resp.setContentType("text/html; charset=utf-8");
			out.println("<html>");
			out.println("<head>");
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"signUp Complete\");");
			out.print("location.href = '/servlet_default/main';");
			out.println("</script>");
			out.println("</head>");
			out.println("<body></body>");
			out.println("</html>");
			//resp.sendRedirect("/servlet_default/main");
		}else {
			PrintWriter out=resp.getWriter();
			resp.setContentType("text/html; charset=utf-8");
			out.println("<html>");
			out.println("<head>");
			out.println("<script type=\"text/javascript\">");
			out.println("alert(\"signUp fail\");");
			out.print("location.href = '/servlet_default/main';");
			out.println("</script>");
			out.println("</head>");
			out.println("<body></body>");
			out.println("</html>");
			//resp.sendRedirect("/servlet_default/main");
		}
		
		
	}
	
}
