package com.kh.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USER = "greedy";
	private static String PASSWORD = "greedy";
	
	public static void main(String[] args) {
		
		// 환경 // 환경설정을 담고 있는 객체
		
		//DB 접속에 관한 환경 설정 정보
		// JdbcTransactionFactory : 수동 커밋
		// ManagedTransactionFactory : 자동 커밋
		// PooledataSource : ConnectionPool 사용
		// unPooleddataSource : connectionPool 미사용
		Environment environment = new Environment("dev", //환경정보 이름
				new JdbcTransactionFactory(), //트랜잭션 매니저 종류 결정(JDBC or MANAGED)
				new PooledDataSource(DRIVER, URL, USER, PASSWORD)); //ConnectionPool 사용 유무 (Pooled or Unpooled)

		//생성한 환경 설정 정보를 가지고 마이바티스 설정 객체 생성
		Configuration configuration = new Configuration(environment); //마이바티스 설정을 위한 객체
		
		//설정 객체에 매퍼 등록
		configuration.addMapper(Mapper.class); //interface정보전달
		
		//sqlSessionfactory  : SqlSession 객체를 생성하기 위한 팩토리 역할을 수행하는 인터페이스
		//SqlSessionFactoryBuilder : sqlsessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한 빌드 역할 수행
		//build() : 설정에 대한 정보를 담고 있는 Configuration 타입의 객체 혹은 외부 설정 파일과 연결된 스트림을 매개변수로 전달하면
		// sqlSessionFacorty 인터페이스 타입의 객체를 반환하는 메소드
		SqlSessionFactory sqlSesssionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		//openSession() : SqlSession 인터페이스 타입의 객체를 반환하는메소드, boolean 타입을 인자로 전달
		//false : Connetion 인터페이스 타입 객체로 DML 수행 후 auto commit에 대한 옵션을 false로 지정(권장)
		// true : Connteion 인터페이스 타입 객체로 DML 수행후 auto commit엗 ㅐ한 옵션을 true로 지정
		SqlSession sqlSession = sqlSesssionFactory.openSession(false);
				
		System.out.println(sqlSession);
		
		//getMapper() : configuration에 등록된 매퍼를 동일 타입에 대해 변환하는 메소드
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		
		java.util.Date date = mapper.selectSysdate();
		System.out.println(date);
		
		sqlSession.close(); 
	}
	
}
