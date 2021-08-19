package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public interface BoardService {
	//목록조회
		Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException;
		
		//상세보기
		BoardVO getBoard(int bno)throws SQLException;
		
		//수정화면 상세
		BoardVO getBoardForModify(int bno)throws SQLException;
		
		//등록
		void regist(BoardVO Board)throws SQLException;
		
		//수정
		void update(BoardVO Board)throws SQLException;
		
		//삭제
		void delete(int bno)throws SQLException;
}
