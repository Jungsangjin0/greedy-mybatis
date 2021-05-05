package com.kh.section01.xmlconfig;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	//sqlSessionFactory는 어플리케이션을 실해하는 동안 존재해야한다.
	//어플리케이션이 실행되는 동안 여러 차례 sqlsesionfactory를 다시 빌드하지 않는 것이 가장 좋다
	// 어플리케이션 스코프로 관리하기 윟나가장 간단한 방법은 싱글톤 패턴
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			//팩토리 인스턴스 생성 기본 레퍼런스 값은 null
			String resource = "com/kh/section01/xmlconfig/mybatis-config.xml";
			InputStream in;
			try {
				in = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//sqlSession은 요청 시 마다 생성
		// sqlSesion은 스레드에 안전하지 않고 공유되지 않아야 한다
		// 요청 시 생성하고 요청이 만료되면 close하는 http 요청과 유사한 스코프에 두는것이 올바른 방법
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		
		System.out.println("sqlsessionFactory hascode() : " + sqlSessionFactory.hashCode());
		System.out.println("sqlSession의 hashcode() : " + sqlSession.hashCode() );
		
		return sqlSession;
	}

}
