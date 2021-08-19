package kr.or.ddit.handler.member;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MainMemberHandler implements Handler {
	
	
	private MemberService memberService;
	public void setMenuService(MemberService memberService) {
		this.memberService = memberService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/member_main";
		
		try {
			List<MemberVO> memberList = memberService.getAllMemberList();
			
			request.setAttribute("memberList", memberList);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url =null;
		}
		
	return url;
		}
	}
