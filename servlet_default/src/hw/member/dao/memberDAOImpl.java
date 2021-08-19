package hw.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import hw.member.dto.memberVO;

public class memberDAOImpl implements IMemberDAO {
	
	private static IMemberDAO memberDao;
	
	public static IMemberDAO getInstance() {
		if(memberDao==null) {
			memberDao = new memberDAOImpl();
		}
		return memberDao;
	}
	
	@Override
	public memberVO loginMemberById(SqlMapClient smc, String id) throws SQLException {
		memberVO memberVo = (memberVO)smc.queryForObject("member.login",id);
		return memberVo;
	}

	@Override
	public Object updateMemberInfo(SqlMapClient smc, memberVO memberVo) throws SQLException {
		return smc.update("member.update",memberVo);
	}
	@Override
	public Object deleteMember(SqlMapClient smc, String id) throws SQLException {
		return smc.update("member.delete",id);
	}

	@Override
	public Object signUpMember(SqlMapClient smc, memberVO memberVo) throws SQLException {
		return smc.insert("member.signup", memberVo);
	}

	@Override
	public List<memberVO> getAllMemberList(SqlMapClient smc) throws SQLException {
		 List<memberVO>memberList =smc.queryForList("member.allListMember");
		return memberList;
	}

}
