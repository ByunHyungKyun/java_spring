package login.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import login.member.dao.IMemberDao;
import login.member.dao.MemberDaoImpl;
import login.member.vo.memberVO;
import util.SqlMapClientUtil;

public class MemberServiceImpl implements IMemberService{

	private IMemberDao memberDao;
	private SqlMapClient smc;
	
	private static IMemberService memberService;
	 
	private MemberServiceImpl() {
		memberDao = MemberDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(memberService==null) {
			memberService = new MemberServiceImpl();
		}
		return memberService;
	}
	
	@Override
	public String loginMember(memberVO memberVo) {
		
		String result = null;
		try {
			result = (String)memberDao.loginMember(smc, memberVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public int signupMember(memberVO memberVo) {
		
		int cnt = 0;
		
		try {
			
			cnt = (int)memberDao.signupMember(smc, memberVo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<memberVO> getAllMemberList() {
		
		List<memberVO> memberList = new ArrayList<>();
		
		try {
			memberList = memberDao.getAllMemberList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
		
		
		
	}

}
