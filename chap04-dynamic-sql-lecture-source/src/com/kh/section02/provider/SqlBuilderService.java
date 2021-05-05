package com.kh.section02.provider;

import static com.kh.common.Template.getSqlSession;
import org.apache.ibatis.session.SqlSession;
import com.kh.common.MenuDTO;
public class SqlBuilderService {


	public void registMenu(MenuDTO menu) {

		SqlSession sqlSession = getSqlSession();
		SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);

		int result = mapper.registMenu(menu);

		if(result > 0) {
			System.out.println("신규 메뉴 등록에 성공하셨습니다.");
			sqlSession.commit();
		} else {
			System.out.println("신규 메뉴 등록에 실패하셨습니다.");
			sqlSession.rollback();
		}

		sqlSession.close();
	}

	public void modifyMenu(MenuDTO menu) {

		SqlSession sqlSession = getSqlSession();
		SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);

		int result = mapper.modifyMenu(menu);

		if(result > 0) {
			System.out.println("메뉴 정보 수정에 성공하셨습니다.");
			sqlSession.commit();
		} else {
			System.out.println("메뉴 정보 수정에 실패하셨습니다.");
			sqlSession.rollback();
		}

		sqlSession.close();
	}

	public void deleteMenu(int code) {

		SqlSession sqlSession = getSqlSession();
		SqlBuilderMapper mapper = sqlSession.getMapper(SqlBuilderMapper.class);

		int result = mapper.deleteMenu(code);

		if(result > 0) {
			System.out.println("메뉴 삭제에 성공하셨습니다.");
			sqlSession.commit();
		} else {
			System.out.println("메뉴 삭제에 실패하셨습니다.");
			sqlSession.rollback();
		}

		sqlSession.close();
	}



}
