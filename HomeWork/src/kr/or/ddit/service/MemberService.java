package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.InvalidPasswordException;
import kr.or.ddit.exception.NotFoundIDException;



public interface MemberService {

	//로그인
		void login(String id,String pwd)
				throws SQLException,NotFoundIDException,InvalidPasswordException;
	
	//회원정보 조회
	MemberVO getMember(String id )throws SQLException;
	
	int updateMemberInfo(MemberVO memberVo)throws SQLException;
	
	int deleteMember(String id)throws SQLException;
	
	int signUpMember(MemberVO memberVo)throws SQLException;
	
	List<MemberVO>getAllMemberList()throws SQLException;
	
	
	Map<String,Object> getMemberList(SearchCriteria cri)throws SQLException;
	
	
	
	
}
