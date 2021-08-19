package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdReplyVO;

public interface ProdReplyDAO {
	
	
	void insertProdReply(SqlSession session,ProdReplyVO prodReply)throws SQLException;
	
	void updateProdReply(SqlSession session,ProdReplyVO prodReply)throws SQLException;
	
	void deleteProdReply(SqlSession session,int prno)throws SQLException;
	
	int selectProdReplySeqNextValue(SqlSession session)throws SQLException;
	
	List<ProdReplyVO> selectProdReplyListPage(SqlSession session,int pno,SearchCriteria cri)throws SQLException;
	
	int countProdReply(SqlSession session,int pno)throws SQLException;
	
	
	
}
