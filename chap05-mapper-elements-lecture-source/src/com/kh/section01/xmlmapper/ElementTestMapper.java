package com.kh.section01.xmlmapper;

import java.util.List;

import com.kh.common.CategoryAndMenuDTO;
import com.kh.common.MenuAndCategoryDTO;
import com.kh.common.MenuDTO;

public interface ElementTestMapper {
	
	List<String> selectCacheTest();

	List<MenuDTO> selectResultMapTest();

	List<MenuDTO> selectResultMapConstructorTest();
	
	List<MenuAndCategoryDTO> selectResultMapAssociationTest();
	
	List<CategoryAndMenuDTO> selectResultMapCollectionTest();

	List<MenuDTO> selectSqlTest();

	int insertMenuTest(MenuDTO menu);

	int insertNewCategory(MenuAndCategoryDTO menuAndCategory);

	int insertNewMenu(MenuAndCategoryDTO menuAndCategory);
	
}
