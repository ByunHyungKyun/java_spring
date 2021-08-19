package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchCriteria;
import com.spring.dto.PdsVO;

public interface PdsDAO {

	
	List<PdsVO> selectSearchPdsList(SearchCriteria cri)
			throws SQLException;
	
	int selectSearchPdsListCount(SearchCriteria cri)
			throws SQLException;
	
	PdsVO selectPdsByPno(int pno)
			throws SQLException;

	
	//viewcnt 증가
	void increaseViewCount(int pno)
			throws SQLException;
	
	
	//Board_seq.nextVal 가져오기
	int selectPdsSequenceNextValue()
			throws SQLException;
	
	
	void insertPds(PdsVO pds)
			throws SQLException;
	
	
	void updatePds(PdsVO pds)
			throws SQLException;
	
	void deletePds(int pno)
			throws SQLException;
	
	
	
	
}
