package kr.or.ddit.handler.prodReply;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.ProdReplyRegistCommand;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdReplyService;

public class PordReplyRegistHandler implements Handler {

	private ProdReplyService prodReplyService;

	public void setProdReplyService(ProdReplyService prodReplyService) {
		this.prodReplyService = prodReplyService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	String url=null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		ProdReplyRegistCommand prodReplyReq = mapper.readValue(request.getReader(),ProdReplyRegistCommand.class);
		
		PrintWriter out = response.getWriter();
		
		try {
			prodReplyService.registProdReply(prodReplyReq.toProdReplyVO());
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(new SearchCriteria());
			pageMaker.setTotalCount(prodReplyService.getProdReplyListCount(prodReplyReq.toProdReplyVO().getPno()));
			
			int realEndPage = pageMaker.getRealEndPage();
			
			out.print("SUCCESS,"+realEndPage);
			
		} catch (SQLException e) {
			
			out.print("Fail");
			
		}finally {
			out.close();
		}
		
		
		
		return url;
	}

}
