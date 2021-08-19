package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.NoticeDAO;
import kr.or.ddit.dto.noticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDAO noticeDAO;// = new MemberDAOImpl();
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	private SqlSessionFactory sqlSessionFactory;// = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	@Override
	public noticeVO selectNotice(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		noticeVO notice = noticeDAO.selectNotice(session, nno);
		session.close();
		return notice;
	}
	@Override
	public int updateNotice(noticeVO noticeVo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = noticeDAO.updateNotice(session, noticeVo);
		
		session.close();
		
		return cnt;
	}
	@Override
	public int deleteNotice(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = noticeDAO.deleteNotice(session, nno);
		
		session.close();
		
		return cnt;
	}
	@Override
	public int writeNotice(noticeVO noticeVo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = noticeDAO.writeNotice(session, noticeVo);
		
		session.close();
		
		return cnt;
	}
	@Override
	public List<noticeVO> allListNotice() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		 List<noticeVO>noticeList=noticeDAO.allListNotice(session);
		session.close();
		return noticeList;
	}
	
	
	

	
	
	
	
	
	

}
