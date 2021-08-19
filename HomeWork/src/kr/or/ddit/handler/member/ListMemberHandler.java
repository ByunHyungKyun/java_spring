package kr.or.ddit.handler.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class ListMemberHandler implements Handler {

	
	private MemberService memberService;
	public void setMenuService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "member/member_list";

		
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setSearchType(searchType);
		cri.setKeyword(keyword);
		
		Map<String,Object> dataMap = memberService.getMemberList(cri);
		
		request.setAttribute("memberList",dataMap.get("memberList"));
		request.setAttribute("pageMaker",dataMap.get("pageMaker"));
		
		return url;
	
		}
	
	}

	
	
