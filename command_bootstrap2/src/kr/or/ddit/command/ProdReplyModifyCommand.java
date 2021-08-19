package kr.or.ddit.command;

import kr.or.ddit.dto.ProdReplyVO;

public class ProdReplyModifyCommand extends ProdReplyRegistCommand{

	private int prno;
	
	

	public int getPrno() {
		return prno;
	}

	public void setPrno(int prno) {
		this.prno = prno;
	}

	@Override
	public ProdReplyVO toProdReplyVO() {
		ProdReplyVO prodReply = super.toProdReplyVO();
		prodReply.setPrno(this.prno);
		
		return prodReply;
	}
	
	
	
	
	
	
	
	
	
	
	
}
