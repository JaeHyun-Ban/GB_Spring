package com.simple.basic;

import java.sql.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

//스프링 단위 테스트
//pom.xml에서 junit 4.12이상이 있어야 하며, Spring-test가 있어야 한다
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //해당파일을 스프링설정파일로 사용(오타주의)
public class JDBCBasic {
	
	//단위 테스트를 할 수 있도록 하는 아주 중요한 도구이다
	
	@Autowired //1.타입 2.이름 순으로 연결
	private HikariDataSource ds;
	
	@Autowired
	private JdbcTemplate jdbcTenplate;
	
	@Test //Test어노테이션: 해당 메서드만 테스트 실행
	public void test() {
//		System.out.println("JUnit테스트입니다 아아");
//		System.out.println("커넥션풀  객체: " + ds);
		
		try {
			Connection conn = (Connection) ds.getConnection();
			System.out.println(conn); //JDBC코드 작성이 가능!
			
			System.out.println("스프링템플릿 객체확인: " + jdbcTenplate);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}













































