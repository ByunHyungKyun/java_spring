package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdReplyVO;

public interface ProdReplyService {

	
	
	Map<String,Object> getProdReplyList(int pno,SearchCriteria cri) throws SQLException;
	
	int getProdReplyListCount(int pno) throws SQLException;
	
	void registProdReply(ProdReplyVO prodReply) throws SQLException;

	void modifyProdReply(ProdReplyVO prodReply) throws SQLException;
	
	void removeProdReply(int prno) throws SQLException;
	
	
	
	
	
	
	
	
	
	
}
