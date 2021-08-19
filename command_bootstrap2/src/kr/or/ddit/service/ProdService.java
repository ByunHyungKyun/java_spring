package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.dto.ProdVO;

public interface ProdService {

	
	Map<String, Object> getProdList(SearchCriteria cri) throws SQLException;
	
	ProdVO getProdDetail(int prodCode) throws SQLException;
	
	void insert(ProdVO prod)throws SQLException;
	
	
}
