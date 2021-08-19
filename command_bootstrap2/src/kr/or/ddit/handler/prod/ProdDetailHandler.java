package kr.or.ddit.handler.prod;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.ProdService;

public class ProdDetailHandler implements Handler {

	
	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}

	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String url = "prod/detail";
		
		int prodCode = Integer.parseInt(request.getParameter("prodCode"));
		
		try {
			ProdVO prod= prodService.getProdDetail(prodCode);
			
			request.setAttribute("prod", prod);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		
		return url;
		
		
		
	}

	
	
	
}
