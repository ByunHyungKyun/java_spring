package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dao.MemberDAOImpl;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;

public class MemberServiceImpl implements MemberService {
	
	private SqlSessionFactory sqlSessionFactory;
	private MemberDAO memberDAO;
	

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	

	@Override
	public void login(String id, String pwd) 
			throws SQLException,InvalidPasswordException, NotFoundIDException {
		
		SqlSession session=sqlSessionFactory.openSession();
		try {
		MemberVO member=memberDAO.selectMemberById(session, id);
		
		if(member == null)
			throw new NotFoundIDException();
		if(!pwd.equals(member.getPwd()))
			throw new InvalidPasswordException();
		
		}finally {
			session.close();
		}
		
	}
	

	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		SqlSession session=sqlSessionFactory.openSession();
		try {
			
			MemberVO member = memberDAO.selectMemberById(session, id);
			return member;
		}finally {
			session.close();
		}
		
	}

	@Override
	public int updateMemberInfo(MemberVO memberVo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = memberDAO.updateMemberInfo(session, memberVo);
		
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = memberDAO.deleteMember(session, id);
		
		session.close();
		
		return cnt;
	}

	@Override
	public int signUpMember(MemberVO memberVo) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		cnt = memberDAO.signUpMember(session, memberVo);
		
		session.close();
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		 List<MemberVO>memberList=memberDAO.getAllMemberList(session);
		session.close();
		return memberList;
	}
	@Override
	public Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException {
		
		SqlSession session = sqlSessionFactory.openSession();
		
		Map<String, Object> dataMap = new HashMap<String,Object>();
		
		try {
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberDAO.selectMemberListCount(session, cri));
		
		List<MemberVO> memberList = memberDAO.selectMemberList(session, cri);
		
		dataMap.put("memberList", memberList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
		
		}finally {
			session.close();
		}
		
	}

}
























