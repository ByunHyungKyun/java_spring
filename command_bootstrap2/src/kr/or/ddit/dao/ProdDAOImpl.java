package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdVO;

public class ProdDAOImpl implements ProdDAO {

	
	@Override
	public List<ProdVO> selectSearchProdList(SqlSession session, SearchCriteria cri) throws SQLException {

		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<ProdVO> prodList = session.selectList("Prod-Mapper.selectSearchProdList", cri,rowBounds);
		return prodList;
	}

	
	
	@Override
	public int selectProdListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count=0;		
		count=session.selectOne("Prod-Mapper.selectSearchProdListCount",cri);
		return count;
		
	}



	@Override
	public ProdVO selectProdDetail(SqlSession session, int prodCode) throws SQLException {
		ProdVO prod = session.selectOne("Prod-Mapper.selectSearchProdDetail", prodCode);
		
		return prod;
	}



	@Override
	public void insertProd(SqlSession session, ProdVO prod) throws SQLException {

		session.update("Prod-Mapper.insertProd",prod);
		
	}


	@Override
	public int selectProdSeqNextValue(SqlSession session) throws SQLException {
		
		int seq_num = session.selectOne("Prod-Mapper.selectBoardSequenceNextValue");
		
		return seq_num;
		
		
	}

	
	
	
	
	
	
	
}













