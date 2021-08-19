package kr.or.ddit.handler.prodReply;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.controller.JSONResolver;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdReplyService;

public class PordReplyListRestHandler implements Handler {

	
	private ProdReplyService prodReplyService;

	public void setProdReplyService(ProdReplyService prodReplyService) {
		this.prodReplyService = prodReplyService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=null;
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		
		Map<String, Object>dataMap =  prodReplyService.getProdReplyList(pno, cri);
		
		JSONResolver.view(response, dataMap);
		
		return url;
	}

}
