package com.kh.section01.xml;

import java.util.List;
import java.util.Map;

import com.kh.common.MenuDTO;
import com.kh.common.SearchCriteria;

public interface DynamicSqlMapper {

	List<MenuDTO> selectMenuByPrice(Map<String, Integer> map);

	List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

//	List<MenuDTO> searchMenuByRandomMenuCode(Map<String, List<Integer>> criteria);
	List<MenuDTO> searchMenuByRandomMenuCode();

	List<MenuDTO> searchMenuByCodeSearchAll(SearchCriteria searchCriteria);

	List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> criteria);

	int modifyMenu(Map<String, Object> criteria);

}
