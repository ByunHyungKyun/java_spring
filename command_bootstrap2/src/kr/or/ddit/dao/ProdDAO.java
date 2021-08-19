package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.dto.ProdVO;

public interface ProdDAO {

	
	List<ProdVO> selectSearchProdList(SqlSession session,SearchCriteria cri)
			throws SQLException;
	
	int selectProdListCount(SqlSession session,SearchCriteria cri) throws SQLException;
	
	
	ProdVO selectProdDetail(SqlSession session,int prodCode) throws SQLException;
	
	public void insertProd(SqlSession session, ProdVO prod) throws SQLException;
	
	int selectProdSeqNextValue(SqlSession session)throws SQLException;
	
	
}
