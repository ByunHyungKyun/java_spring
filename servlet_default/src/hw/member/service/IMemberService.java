package hw.member.service;

import java.sql.SQLException;
import java.util.List;

import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

import hw.member.dto.memberVO;

public interface IMemberService {

	memberVO loginMemberById(String id, String pwd)
			throws NotFoundIDException,InvalidPasswordException,SQLException;
	
	memberVO getMemberInfo(String id)
			throws SQLException;
	
	
	int updateMemberInfo(memberVO memberVo)throws SQLException;
	
	int deleteMember(String id)throws SQLException;
	
	int signUpMember(memberVO memberVo)throws SQLException;
	
	List<memberVO>getAllMemberList()throws SQLException;
	
	
}
