package hw.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import hw.member.dto.memberVO;

public interface IMemberDAO {
	
	memberVO loginMemberById(SqlMapClient smc,String id)throws SQLException;
	
	Object updateMemberInfo(SqlMapClient smc,memberVO memberVo)throws SQLException;
	
	Object deleteMember(SqlMapClient smc,String id)throws SQLException;
	
	Object signUpMember(SqlMapClient smc,memberVO memberVo)throws SQLException;
	
	List<memberVO> getAllMemberList(SqlMapClient smc)throws SQLException;
	
}
