package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.ProdDAO;
import kr.or.ddit.dto.ProdVO;

public class ProdServiceImpl implements ProdService {

	
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	private ProdDAO prodDAO;
	public void setProdDAO(ProdDAO prodDAO) {
		this.prodDAO = prodDAO;
	}



	@Override
	public Map<String, Object> getProdList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String , Object> dataMap = new HashMap<String,Object>();

		try {
			List<ProdVO> prodList = prodDAO.selectSearchProdList(session, cri);
			
			int totalCount = prodDAO.selectProdListCount(session, cri);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);
			
			dataMap.put("prodList", prodList);
			dataMap.put("pageMaker", pageMaker);
			
			
			return dataMap;
		}finally {
			session.close();
			
		}
	}



	@Override
	public ProdVO getProdDetail(int prodCode) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		ProdVO prod=null;
		
		try {
			
			
			prod = prodDAO.selectProdDetail(session, prodCode);
			
			return prod;

		} finally {
			
			session.close();
			
		}
		
		
	}



	@Override
	public void insert(ProdVO prod) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		

		try {
			
			int code = prodDAO.selectProdSeqNextValue(session);
			prod.setCode(code);
			prodDAO.insertProd(session, prod);
			
		}finally {
			session.close();
		}
		
		
	}
	
	
	
	
	
	
	
	
}
