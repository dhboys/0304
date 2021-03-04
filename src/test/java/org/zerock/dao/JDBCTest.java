package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	
	@Test
	public void testConnection() throws Exception{
		
		// mySQL driver 이름 조심
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		log.info("1-------------------------");
		
		// connection 연결
		String url = "jdbc:mysql://localhost:3306/dclass?serverTimezone=UTC";
		String username = "springuser";
		String password = "springuser";
		
		Connection con = DriverManager.getConnection(url , username , password);
	
		log.info(con);
		
		con.close();
		// jdbc 연결 1단계 종료
		
	}
}
