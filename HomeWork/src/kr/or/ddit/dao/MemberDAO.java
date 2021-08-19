package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;



public interface MemberDAO {

	
	
	
	MemberVO selectMemberById(SqlSession session,String id)throws SQLException;
	

	int updateMemberInfo(SqlSession session,MemberVO memberVo)throws SQLException;

	
	int deleteMember(SqlSession session,String id)throws SQLException;
	
	
	int signUpMember(SqlSession session,MemberVO memberVo)throws SQLException;
	
	
	List<MemberVO> getAllMemberList(SqlSession session)throws SQLException;
	
	List<MemberVO> selectMemberList(SqlSession session,SearchCriteria cri) throws SQLException;
	
	
	int selectMemberListCount(SqlSession session,SearchCriteria cri) throws SQLException;
	
	
	
	
	
	
	
	
	
	
}
