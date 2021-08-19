package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.noticeVO;

public class NoticeDAOImpl implements NoticeDAO{

	@Override
	public noticeVO selectNotice(SqlSession session, int nno) throws SQLException {
		noticeVO noticeVo = session.selectOne("Notice-Mapper.selectNotice",nno);
				
		return noticeVo;
	}

	@Override
	public int updateNotice(SqlSession session, noticeVO noticeVo) throws SQLException {

		int cnt= session.update("Notice-Mapper.updateNotice", noticeVo);
		
		return cnt;
	}

	@Override
	public int deleteNotice(SqlSession session, int nno) throws SQLException {
		int cnt=session.delete("Notice-Mapper.deleteNotice",nno);
		return cnt;
	}

	@Override
	public int writeNotice(SqlSession session, noticeVO noticeVo) throws SQLException {
		int cnt=session.insert("Notice-Mapper.writeNotice", noticeVo);
		return cnt;
	}

	@Override
	public List<noticeVO> allListNotice(SqlSession session) throws SQLException {
		List<noticeVO>noticeList=session.selectList("Notice-Mapper.allListNotice");
		return noticeList;
	}

	
	
}
