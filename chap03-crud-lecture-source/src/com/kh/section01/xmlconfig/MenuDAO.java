package com.kh.section01.xmlconfig;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MenuDAO {

	public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
		
		return sqlSession.selectList("menu.selectAllMenu");
	}

	public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
		
		return sqlSession.selectOne("menu.selectMenuByCode", code);
	}

	public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
		
		return sqlSession.insert("menu.insertMenu", menu);
	}
	
	public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
		
		return sqlSession.update("menu.updateMenu", menu);
	}

	public int deleteMenu(SqlSession sqlSession, int code) {
		
		return sqlSession.delete("menu.deleteMenu", code);
	}
}
