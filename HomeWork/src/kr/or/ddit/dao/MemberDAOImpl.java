package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	
	@Override
	public MemberVO selectMemberById(SqlSession session, String id) throws SQLException {
		MemberVO member=session.selectOne("Member-Mapper.selectMemberById", id);
		return member;
	}

	
	@Override
	public int updateMemberInfo(SqlSession session, MemberVO memberVo) throws SQLException {
		
		int cnt= session.update("Member-Mapper.update", memberVo);
		
		return cnt;
	}

	@Override
	public int deleteMember(SqlSession session, String id) throws SQLException {
		int cnt=session.delete("Member-Mapper.delete",id);
		return cnt;
	}

	@Override
	public int signUpMember(SqlSession session, MemberVO memberVo) throws SQLException {
		int cnt=session.insert("Member-Mapper.signup", memberVo);
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList(SqlSession session) throws SQLException {
		List<MemberVO>memberList =session.selectList("Member-Mapper.allListMember");
		return memberList;
	}


	@Override
	public List<MemberVO> selectMemberList(SqlSession session, SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectSearchMemberList", cri, rowBounds);
		
		return memberList;
	}


	@Override
	public int selectMemberListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		
		int count = 0;
		count = session.selectOne("Member-Mapper.selectSearchMemberListCount", cri);
		
		return count;
	}

	
}
