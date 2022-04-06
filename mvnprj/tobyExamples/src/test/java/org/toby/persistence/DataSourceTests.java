package org.toby.persistence;
	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.fail;
	import java.sql.Connection;
	import javax.sql.DataSource;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	import lombok.Setter;
	import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	  @Setter(onMethod_ = { @Autowired })
	  private DataSource dataSource;
	
	  @Test//스프링 에 빈(Bean)으로 등록된 DataSource를 이 용해서 Connection을 제대로 처리할 수 있는지를 확인해 보는 용도
	  public void testConnection() {//testConnection()을 실행해 보면 내부적으로 HikariCP가 시작되고，종료되는 로그를 확인
	    
	    try (Connection con = dataSource.getConnection()){
	
	      log.info(con);    
	      assertNotNull(con);
	      
	    }catch(Exception e) {
	      fail(e.getMessage());
	    }
	  }
}


