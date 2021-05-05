package com.kh.section01.xml;

import static com.kh.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.MenuDTO;
import com.kh.common.SearchCriteria;
public class MenuService {

	public void selectMenuByPrice(int price) {
		
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		//기본자료형 값은 조건식으로 비교할 수 없음 (동적쿼리에서)
		//hashmap의 key값 dto의 getter로 이용하여 조건에 들어가는 값을 확인하기 때문에
		//dto hashmap 사용해야함
		
		Map<String, Integer> map = new HashMap<>();
		map.put("price", price);
		
		List<MenuDTO> menuList = mapper.selectMenuByPrice(map);
		
		//검색결과가 0 이상일 경우
		//null이 true인 경우에만 뒤에 size 조건을 체크할 수 있도록 동작
		//그래서 런타임시 널포인터 방지
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu :  menuList) {
				System.out.println(menu);
			}
		}else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
	}

	public void searchMenu(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper =sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		}else {
			System.out.println("검색 결과가 존재하지 않습니다");
		}
		sqlSession.close();
		
	}

	public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		sqlSession.close();
		
	}

	public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {
		
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		Map<String, List<Integer>> criteria = new HashMap<>();
		criteria.put("randomMenuCodeList", randomMenuCodeList);
		
//		List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(criteria);
		List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode();
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다");
		}
		sqlSession.close();
	}

	public void searchMenuBycodeOrSearchAll(SearchCriteria searchCriteria) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuByCodeSearchAll(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		}else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		sqlSession.close();
		
	}

	public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);
		
		if(menuList != null && menuList.size() > 0 ) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		}else {
			System.out.println("검색 결과가 없습니다");
		}
		sqlSession.close();
		
	}

	public void modifyMenu(Map<String, Object> criteria) {
		SqlSession sqlSession = getSqlSession();
		DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		int result = mapper.modifyMenu(criteria);
		
		if(result > 0) {
			System.out.println("메뉴 정보 변경에 성공하셨습니다.");
			sqlSession.commit();
		}else {
			System.out.println("메뉴 정보 변경에 실패");
			sqlSession.rollback();
		}
		sqlSession.close();
	}

}
