package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.BoardDAO;
import kr.or.ddit.dao.ReplyDAO;
import kr.or.ddit.dto.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	private BoardDAO boardDAO;
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	private ReplyDAO replyDAO;
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	

	@Override
	public Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			
			Map<String, Object> dataMap = new HashMap<String,Object>();
			
			//현재 page번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기
			List<BoardVO> boardList = boardDAO.selectSearchBoardList(session, cri);
			
			//reply count 입력
			for(BoardVO board : boardList ) {
				int replycnt = replyDAO.countReply(session, board.getBno());
				board.setReplycnt(replycnt);
				
			}
			
			//전체 board개수
			int totalCount = boardDAO.selectSearchBoardListCount(session, cri);
			
			//PageMaker생성
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);
			
			dataMap.put("boardList", boardList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
			
		} finally {
			session.close();
			
		}
	}

	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			BoardVO board = boardDAO.selectBoardByBno(session, bno);
			boardDAO.increaseViewCount(session, bno);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			BoardVO board = boardDAO.selectBoardByBno(session, bno);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(BoardVO board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			int bno = boardDAO.selectBoardSequenceNextValue(session);
			board.setBno(bno);
			boardDAO.insertBoard(session, board);
			
		}finally {
			session.close();
		}

	}

	@Override
	public void update(BoardVO Board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			
			boardDAO.updateBoard(session, Board);
			
		}finally {
			session.close();
		}

	}

	@Override
	public void delete(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			boardDAO.deleteBoard(session, bno);
		}finally {
			session.close();
		}

	}

}
