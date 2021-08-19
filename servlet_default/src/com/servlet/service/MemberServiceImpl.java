package com.servlet.service;

import java.sql.SQLException;

import com.servlet.dao.MemberDAO;
import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;//=MemberDAOImpl.getInstance(); 싱글톤패턴제작
	
	
	@Override
	public MemberVO login(String id, String pwd) throws NotFoundIDException, InvalidPasswordException, SQLException {
		MemberVO member = null;
		
		try {
		member = memberDAO.selectMemberByID(id);
		}catch(SQLException e) {
			//exception에 대한 처리문 구문 필요
			e.printStackTrace();
			throw e;
		}
		
		
		if(member != null){
			if(pwd.equals(member.getPwd())) {//로그인 성공
				return member;
			}else {//비밀번호 불일치
				throw new InvalidPasswordException();//return의 기능을 수행하기 떄문에 에러가 나지않는다.
			}
		}else {//아이디 불일치
			throw new NotFoundIDException();
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
