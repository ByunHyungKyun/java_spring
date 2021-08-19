package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.dao.MenuDAO;
import kr.or.ddit.dto.MenuVO;

public class MenuServiceImpl implements MenuService{
	
	//인터페이스 = 임플
	private MenuDAO menuDAO;// = new MenuDAOImpl();
	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}
	
	private SqlSessionFactory sqlSessionFactory;// = new OracleMyBatisSqlSessionFactory();
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	
	@Override
	public List<MenuVO> getMainMenuList() throws SQLException {
		List<MenuVO> menuList = null;
		SqlSession session = sqlSessionFactory.openSession(false);
		//false을 주는 이유는 커밋권과 롤백권을 내가 가져와야하기 때문이다
		
		//menuList = menuDAO.selectMainMenu(session);
		//아이바티스에서는 이렇게 했어야 했다,이제 마이바티스에서는 인셉션이 터지면 자동 롤백이다 안해도된다
		try {
			menuList = menuDAO.selectMainMenu(session);
			session.commit();
		}catch(SQLException e) {
			session.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			session.close();
		}
		return menuList;
	}

	
	
	
	@Override
	public List<MenuVO> getSubMenuList(String mCode) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		//근데 false을 안주는 이유는 자동으로 에러가 났을때 롤백이 되기 때문이다
		List<MenuVO> menuList = menuDAO.selectSubMenu(session, mCode);
		session.close();
		return menuList;
	}

	
	
	
	@Override
	public MenuVO getMenuByMcode(String mCode) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		MenuVO menu = menuDAO.selectMenuByMcode(session, mCode);
		session.close();
		return menu;
	}

	
	
	
	
	
	
}




















