package com.kh.section02.provider;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import com.kh.common.MenuDTO;

public interface SqlBuilderMapper {
	
	@InsertProvider(type=SqlBuilderProvider.class, method="registMenu")
	int registMenu(MenuDTO menu);
	
	@UpdateProvider(type=SqlBuilderProvider.class, method="modifyMenu")
	int modifyMenu(MenuDTO menu);
	
	@DeleteProvider(type=SqlBuilderProvider.class, method="deleteMenu")
	int deleteMenu(@Param("code") int code);

}
