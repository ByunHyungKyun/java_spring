package login.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import login.member.vo.memberVO;

public class MemberDaoImpl implements IMemberDao{

	private static IMemberDao memberDao;

	
	public static IMemberDao getInstance() { 
		if(memberDao == null) {
			memberDao = new MemberDaoImpl();
		}
		return memberDao;
	}

	@Override
	public String loginMember(SqlMapClient smc,memberVO memberVo) throws SQLException {
		
		String Id =  (String)smc.queryForObject("member.Id",memberVo);
		String Pass =  (String)smc.queryForObject("member.Pass",memberVo);
		
			if(Id == null){
				String login = "비밀번호가 틀렸습니다!!";
				return login;
			}else if(Pass == null){
				String login = "아이디가 틀렸습니다!!";
				return login;
			}
		
			String login = "!!로그인을 성공하였습니다!!";
			return login;
		
	}

	@Override
	public int signupMember(SqlMapClient smc, memberVO memberVo) throws SQLException {
		
		int cnt = 0;
		
		Object obj = smc.insert("member.signup",memberVo);
		
		if(obj == null) {
			cnt = 1;
		}
		
		
		return cnt;
	}

	@Override
	public List<memberVO> getAllMemberList(SqlMapClient smc) throws SQLException {
		List<memberVO> memList =smc.queryForList("member.allListMember");
	
		return memList;
	}

}
