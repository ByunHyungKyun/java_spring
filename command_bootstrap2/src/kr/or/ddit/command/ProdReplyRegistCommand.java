package kr.or.ddit.command;

import java.util.Date;

import kr.or.ddit.dto.ProdReplyVO;

public class ProdReplyRegistCommand {
	
	private int pno;
	private String replyer;
	private String replytext;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	
	
	public ProdReplyVO toProdReplyVO() {
		ProdReplyVO prodReply = new ProdReplyVO();
		prodReply.setPno(pno);
		prodReply.setReplyer(replyer);
		prodReply.setReplytext(replytext);
		prodReply.setRegdate(new Date());
		prodReply.setUpdatedate(new Date());
		
		
		return prodReply;
	}
	
	
	
	
	
}
