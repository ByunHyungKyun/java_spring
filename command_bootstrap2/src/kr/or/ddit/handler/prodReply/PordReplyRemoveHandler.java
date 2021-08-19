package kr.or.ddit.handler.prodReply;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdReplyService;

public class PordReplyRemoveHandler implements Handler {

	private ProdReplyService prodReplyService;

	public void setProdReplyService(ProdReplyService prodReplyService) {
		this.prodReplyService = prodReplyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rul=null;
		
		
		int prno=Integer.parseInt((String)request.getParameter("prno"));
		int page=Integer.parseInt((String)request.getParameter("page"));
		int pno=Integer.parseInt((String)request.getParameter("pno"));
		
		
		try {
			
			prodReplyService.removeProdReply(prno);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(new SearchCriteria());
			pageMaker.setTotalCount(prodReplyService.getProdReplyListCount(pno));
			
			
			int reqlEndPage = pageMaker.getRealEndPage();
			
			if(page>reqlEndPage) {
				page=reqlEndPage;
			}
			
			PrintWriter out = response.getWriter();
			out.print(page);
			out.close();
			
		}catch (SQLException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		
		return rul;
	}

}
