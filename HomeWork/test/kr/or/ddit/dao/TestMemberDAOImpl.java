package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class TestMemberDAOImpl {

	private SqlSession session;
	private MemberDAO memberDAO;
	
	@Before
	public void init() {
		session = new OracleMyBatisSqlSessionFactory().openSession(false);
		memberDAO= new MemberDAOImpl();
		
		System.out.println(session);
	}
	
	
	@Test
	public void testGetAllMemberList()throws Exception{
		
		List<MemberVO>memberList=memberDAO.getAllMemberList(session);
		Assert.assertEquals(7, memberList.size());
	}
	
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
	
	
	
	
	
}
