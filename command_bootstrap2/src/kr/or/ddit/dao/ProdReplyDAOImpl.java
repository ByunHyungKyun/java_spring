package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdReplyVO;

public class ProdReplyDAOImpl implements ProdReplyDAO {

	@Override
	public void insertProdReply(SqlSession session, ProdReplyVO prodReply) throws SQLException {
		
		session.update("ProdReply-Mapper.insertPordReply", prodReply);
		

	}

	@Override
	public void updateProdReply(SqlSession session, ProdReplyVO prodReply) throws SQLException {
		session.update("ProdReply-Mapper.updatePordReply", prodReply);

	}

	@Override
	public void deleteProdReply(SqlSession session, int prno) throws SQLException {
		session.update("ProdReply-Mapper.deletePordReply", prno);

	}

	@Override
	public int selectProdReplySeqNextValue(SqlSession session) throws SQLException {
		int prno = (Integer)session.selectOne("ProdReply-Mapper.selectProdReplySeqNextValue");
		
		return prno;
	}

	@Override
	public List<ProdReplyVO> selectProdReplyListPage(SqlSession session, int pno, SearchCriteria cri)throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);		
		
		List<ProdReplyVO> prodReplyList = session.selectList("ProdReply-Mapper.selectProdReplyList", pno,rowBounds);
		
		return prodReplyList;
	}

	@Override
	public int countProdReply(SqlSession session, int pno) throws SQLException {
		int count = session.selectOne("ProdReply-Mapper.countProdReply",pno );
		
		return count;
	}

}
