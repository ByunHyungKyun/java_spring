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


@WebServlet("/main")
public class mainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>login 연습</title>");
		out.println("<script type=\"text/javascript\">");
		out.println("function changePage() {");
		out.println("window.location.href = \"/servlet_default/login\";");
		out.println("}");
		out.println("function changePage2() {");
		out.println("window.location.href = \"/servlet_default/signup\";");
		out.println("}");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>원하는 메뉴를 선택하시오</h1>");
		out.println("<button type='button' onclick='changePage()'>로그인</button>");
		out.println("<button type='button' onclick='changePage2()'>회원가입</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
	
	
	
	
	
}
