package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;
import kr.or.ddit.dto.PdsVO;

public interface PdsDAO {

	
	List<PdsVO> selectSearchPdsList(SqlSession session,SearchCriteria cri)
			throws SQLException;
	
	int selectSearchPdsListCount(SqlSession session,SearchCriteria cri)
			throws SQLException;
	
	PdsVO selectPdsByPno(SqlSession session,int pno)
			throws SQLException;

	
	//viewcnt 증가
	void increaseViewCount(SqlSession session,int pno)
			throws SQLException;
	
	
	//Board_seq.nextVal 가져오기
	int selectPdsSequenceNextValue(SqlSession session)
			throws SQLException;
	
	
	void insertPds(SqlSession session,PdsVO pds)
			throws SQLException;
	
	
	void updatePds(SqlSession session,PdsVO pds)
			throws SQLException;
	
	void deletePds(SqlSession session,int pno)
			throws SQLException;
	
	
	
	
}
