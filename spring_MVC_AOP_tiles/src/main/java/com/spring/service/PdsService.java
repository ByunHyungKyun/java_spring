package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;

public interface PdsService {
	//목록조회
		Map<String, Object> getPdsList(SearchCriteria cri) throws SQLException;
		
		//글 읽기(조회수 증가)
		PdsVO read(int pno)throws SQLException;
		
		//글 일기
		PdsVO getPds(int pno)throws SQLException;
		
		//등록
		void regist(PdsVO pds)throws SQLException;
		
		//수정
		void update(PdsVO pds)throws SQLException;
		
		//삭제
		void delete(int pno)throws SQLException;
		
		//첨부파일 조회
		AttachVO getAttachByAno(int ano)throws SQLException;
		
		//파일정보 삭제
		void removeAttachByAno(int ano)throws SQLException;
		
		
		
		
		
		
		
}
