package com.kh.section02.provider;

import org.apache.ibatis.jdbc.SQL;

import com.kh.common.SearchCriteria;

public class SelectBuilderProvider {
	
	/* SQL문을 문자열 형태로 반환하도록 반환 타입을 지정한다. */
	public String selectAllMenu() {
		
		return new SQL()
				.SELECT("A.MENU_CODE")
				.SELECT("A.MENU_NAME")
				.SELECT("A.MENU_PRICE")
				.SELECT("A.CATEGORY_CODE")
				.SELECT("A.ORDERABLE_STATUS")
				.FROM("TBL_MENU A")
				.WHERE("A.ORDERABLE_STATUS = 'Y'")
				.toString();
	}
	
	public String searchMenuByCondition(SearchCriteria searchCriteria) {
		
		SQL sql = new SQL();
		
		sql.SELECT("A.MENU_CODE")
			.SELECT("A.MENU_NAME")
			.SELECT("A.MENU_PRICE")
			.SELECT("A.CATEGORY_CODE")
			.SELECT("A.ORDERABLE_STATUS")
			.FROM("TBL_MENU A");
		
		if("category".equals(searchCriteria.getCondition())) {
			sql.JOIN("TBL_CATEGORY B ON (A.CATEGORY_CODE = B.CATEGORY_CODE)")
				.WHERE("A.ORDERABLE_STATUS = 'Y'")
				.AND()
				.WHERE("B.CATEGORY_NAME = #{ value }");
		} else if("name".equals(searchCriteria.getCondition())) {
			/* 가변인자를 이용하면 AND로 처리하기 때문에 OR를 사용하는 경우 .OR를 이용해야 한다. */
			sql.WHERE("A.ORDERABLE_STATUS = 'Y'"
					, "A.MENU_NAME LIKE '%' || #{ value } || '%'");
		}
		
		return sql.toString();
	}
}

