package login.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import login.member.vo.memberVO;

public interface IMemberDao {
	
	
	public String loginMember(SqlMapClient smc,memberVO memberVo) throws SQLException;
	
	public int signupMember(SqlMapClient smc,memberVO memberVo) throws SQLException;
	
	public List<memberVO> getAllMemberList(SqlMapClient smc)throws SQLException;
	
	
}
