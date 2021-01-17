package org.toby.persistence;
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.fail;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import org.junit.Test;
	import lombok.extern.log4j.Log4j;
	
@Log4j
public class JDBCTests {
	//JDBC 드라이버만으로 구현해서 먼저 테스트
	static{//클래스 초기화 블럭 , 생성자보다 먼저 호출
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {

		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "toby_ex",
				"toby_ex")) {

			log.info(con);
			assertNotNull(con);
			
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
	}
}
