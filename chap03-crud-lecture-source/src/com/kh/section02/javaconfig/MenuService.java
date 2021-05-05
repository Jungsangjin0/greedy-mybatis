package com.kh.section02.javaconfig;

import java.util.List;
import static com.kh.section02.javaconfig.Template.getSqlSession;
import org.apache.ibatis.session.SqlSession;

public class MenuService {

	
	
	public List<MenuDTO> selectAllMenu() {
		
		SqlSession sqlSession = getSqlSession();
		
		
		//type을 가지고 매퍼를 가져온다
		//interface대신 수행할 수 있는 객체를 생성하여 
		//메소드 호출 후 쿼리문을 동작시키는 구문을 자동으로 생성
		MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
		List<MenuDTO> menuList = menuMapper.selectAllMenu();
		sqlSession.close();
		
		return menuList;
	}

	public MenuDTO selectMenuByCode(int code) {
		
		SqlSession sqlSession = getSqlSession();
		
		MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
		MenuDTO menu = menuMapper.selectMenuByCode(code);
		
		sqlSession.close();
		
		return menu;
	}

}
