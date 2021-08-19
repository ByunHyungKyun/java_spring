package kr.or.ddit.handler.prodReply;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.command.ProdReplyModifyCommand;
import kr.or.ddit.dto.ProdReplyVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdReplyService;

public class PordReplyModifyHandler implements Handler {
	
	private ProdReplyService prodReplyService;

	public void setProdReplyService(ProdReplyService prodReplyService) {
		this.prodReplyService = prodReplyService;
	}


	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		ProdReplyModifyCommand prodReplyReq = mapper.readValue(request.getReader(),ProdReplyModifyCommand.class );
		
		ProdReplyVO prodReply = prodReplyReq.toProdReplyVO();
		
		
		try {
			
			prodReplyService.modifyProdReply(prodReply);
			
		} catch (SQLException e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			
		}
		
		
		return url;
	}

}
