package hw.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;

import hw.member.dao.IMemberDAO;
import hw.member.dao.memberDAOImpl;
import hw.member.dto.memberVO;
import util.SqlMapClientUtil;

public class memberServiceImpl implements IMemberService {
	
	private static IMemberService memberService;
	private IMemberDAO memberDao;
	private SqlMapClient smc;
	
	private memberServiceImpl() {
		memberDao = memberDAOImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memberService == null) {
			memberService = new memberServiceImpl();
		}
		return memberService;
	}
	
	
	@Override
	public memberVO loginMemberById(String id,String pass) throws NotFoundIDException, InvalidPasswordException, SQLException {
		memberVO member = null;
		try {
		member = memberDao.loginMemberById(smc, id);
		
		}catch(SQLException e) {
			//exception에 대한 처리문 구문 필요
			e.printStackTrace();
			throw e;
		}
		
		if(member != null){
			if(pass.equals(member.getPass())) {//로그인 성공
				return member;
			}else {//비밀번호 불일치
				throw new InvalidPasswordException();//return의 기능을 수행하기 떄문에 에러가 나지않는다.
			}
		}else {//아이디 불일치
			throw new NotFoundIDException();
		}
		
	}

	@Override
	public int updateMemberInfo(memberVO memberVo) throws SQLException {
		int cnt = 0;
		
		Object object = memberDao.updateMemberInfo(smc, memberVo);
		
		if(object == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String id) throws SQLException {
	int cnt = 0;
		
		Object object = memberDao.deleteMember(smc, id);
		
		if(object == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int signUpMember(memberVO memberVo) throws SQLException {
		int cnt = 0;
		
		Object object = memberDao.signUpMember(smc, memberVo);
		
		if(object == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<memberVO> getAllMemberList() throws SQLException {
		
		
		 List<memberVO>memberList = new ArrayList<>(); 
		
		
		 memberList = memberDao.getAllMemberList(smc);
		
		
		
		
		return  memberList;
	}

	@Override
	public memberVO getMemberInfo(String id) throws SQLException {
		memberVO member = null;
		try {
		member = memberDao.loginMemberById(smc, id);
		
		}catch(SQLException e) {
			//exception에 대한 처리문 구문 필요
			e.printStackTrace();
			throw e;
		}
		
		return member;
		
	}

	
	
	
	
	
	
	
}
