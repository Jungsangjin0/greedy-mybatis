package com.kh.section03.remix;

import static com.kh.section03.remix.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MenuService {

	private MenuMapper menuMapper;
	
	public List<MenuDTO> selectAllMenu() {
		
		SqlSession sqlSession = getSqlSession();
		menuMapper = sqlSession.getMapper(MenuMapper.class);
		
		List<MenuDTO> menuList = menuMapper.selectAllMenu();
		
		sqlSession.close();
		
		return menuList;
	}

}
