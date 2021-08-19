package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.dto.noticeVO;



public interface NoticeService {

	noticeVO selectNotice(int nno)throws SQLException;
	
	int updateNotice(noticeVO noticeVo)throws SQLException;
	
	int deleteNotice(int nno)throws SQLException;
	
	int writeNotice(noticeVO noticeVo)throws SQLException;
	
	List<noticeVO>allListNotice()throws SQLException;
	
	
	
	
	
	
	
}
