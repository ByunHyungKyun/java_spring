package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.ProdReplyDAO;
import kr.or.ddit.dto.ProdReplyVO;

public class ProdReplyServiceImpl implements ProdReplyService {

	private SqlSessionFactory sqlSessionFactory;
	private ProdReplyDAO prodReplyDAO;
	

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public void setProdReplyDAO(ProdReplyDAO prodReplyDAO) {
		this.prodReplyDAO = prodReplyDAO;
	}

	
	@Override
	public Map<String, Object> getProdReplyList(int pno, SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			Map<String ,Object>dataMap = new HashMap<String,Object>();
			
			List<ProdReplyVO> prodReplyList = prodReplyDAO.selectProdReplyListPage(session, pno, cri);
			
			int count = prodReplyDAO.countProdReply(session, pno);
			
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(count);
			
			dataMap.put("prodReplyList", prodReplyList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		} finally {

			session.close();
			
		}
	}

	@Override
	public int getProdReplyListCount(int pno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			int count = prodReplyDAO.countProdReply(session, pno);
			return count;
			
		}finally {
			session.close();
		}
	}

	@Override
	public void registProdReply(ProdReplyVO prodReply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int prno= prodReplyDAO.selectProdReplySeqNextValue(session);
			prodReply.setPrno(prno);
			
			prodReplyDAO.insertProdReply(session, prodReply);
		}finally {
			
			session.close();
		}
	}

	@Override
	public void modifyProdReply(ProdReplyVO prodReply) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			prodReplyDAO.updateProdReply(session, prodReply);
		}finally {
			
			session.close();
		}
	}

	@Override
	public void removeProdReply(int prno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			prodReplyDAO.deleteProdReply(session, prno);
		}finally {
			
			session.close();
		}
	}

}
