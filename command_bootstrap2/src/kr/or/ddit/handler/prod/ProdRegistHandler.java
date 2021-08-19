package kr.or.ddit.handler.prod;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.MenuVO;
import kr.or.ddit.dto.ProdVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;
import kr.or.ddit.service.MenuService;
import kr.or.ddit.service.ProdService;

public class ProdRegistHandler implements Handler {

	private ProdService prodService;
	public void setProdService(ProdService prodService) {
		this.prodService = prodService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url="prod/regist_success";
		
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String price = request.getParameter("price");
		String delivery = request.getParameter("delivery");
		String deliveryprice = request.getParameter("deliveryprice");
		String img = request.getParameter("picture");
		String detailimg = request.getParameter("picture2");
		
		ProdVO prod= new ProdVO();
		prod.setName(name);
		prod.setDetail(detail);
		prod.setPrice(price);
		prod.setDelivery(delivery);
		prod.setDeliveryprice(deliveryprice);
		prod.setImg(img);
		prod.setDetailimg(detailimg);
		
		try {
			
			prodService.insert(prod);
			
		}catch (SQLException e) {
			e.printStackTrace();
			url="prod/regist_fail";
		}
		
		
		return url;
	}

}
