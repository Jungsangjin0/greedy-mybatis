package com.kh.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

//xml대체 interface 
public interface Mapper {

	@Select("SELECT SYSDATE FROM DUAL")//메소드에 작성 가능한 어노테이션
	java.util.Date selectSysdate(); //default 메소드를 제외하고 추상메소드만 작성가능
	
//<select id="selectSysdate" resultType="java.util.Date">
// SELECT SYSDATE FROM DUAL
//	</select>
}
