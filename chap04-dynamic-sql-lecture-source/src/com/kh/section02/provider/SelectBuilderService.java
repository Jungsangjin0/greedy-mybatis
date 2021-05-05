package com.kh.section02.provider;

import static com.kh.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.MenuDTO;
import com.kh.common.SearchCriteria;

public class SelectBuilderService {

	public void testSimpleStatement() {
		
		SqlSession sqlSession = getSqlSession();
		SelectBuilderMapper mapper = sqlSession.getMapper(SelectBuilderMapper.class);
		
		List<MenuDTO> menuList = mapper.selectAllMenu();
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
	}

	public void testDynamicStatement(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		SelectBuilderMapper mapper = sqlSession.getMapper(SelectBuilderMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuByCondition(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
	}
	
	
}
