package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.noticeVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestNoticeDAOImpl {

	private SqlSession session;
	private NoticeDAO noticeDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		noticeDAO= new NoticeDAOImpl();
		
		System.out.println(session);
	}
	
	
	@Test
	public void testGetAllNoticeList()throws Exception{
		
		List<noticeVO>noticeList=noticeDAO.allListNotice(session);
		Assert.assertEquals(22, noticeList.size());
	}
	
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
	
	
	
	
	
}
