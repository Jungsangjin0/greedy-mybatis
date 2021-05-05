package com.kh.section03.remix;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:log4jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "greedy";
	private static String PASSWORD = "greedy";
	
	
	
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			Environment environment = new Environment("dev"
									, new JdbcTransactionFactory()
									, new PooledDataSource(DRIVER, URL, USER, PASSWORD));
			
			Configuration configuration = new Configuration(environment);
			//mapper 등록 MapperRegistry에 등록 map형식으로 등록
			configuration.addMapper(MenuMapper.class);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		}
		
		return sqlSessionFactory.openSession(false);
	}
}
