package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			String source = "mybatis-config.xml";
			try {
				InputStream in = Resources.getResourceAsStream(source);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
						
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory.openSession(false);
	}

}
