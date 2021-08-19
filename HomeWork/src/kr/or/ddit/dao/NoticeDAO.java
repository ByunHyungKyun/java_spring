package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.noticeVO;


public interface NoticeDAO {
	
	noticeVO selectNotice(SqlSession session,int nno)throws SQLException;
	

	int updateNotice(SqlSession session,noticeVO noticeVo)throws SQLException;

	
	int deleteNotice(SqlSession session,int nno)throws SQLException;
	
	
	int writeNotice(SqlSession session,noticeVO noticeVo)throws SQLException;
	
	
	List<noticeVO> allListNotice(SqlSession session)throws SQLException;
	
	
	
	
}
