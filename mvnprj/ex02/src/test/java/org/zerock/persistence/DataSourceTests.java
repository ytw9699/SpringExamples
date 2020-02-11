package org.zerock.persistence;
	import static org.junit.Assert.fail;
	import java.sql.Connection;
	import javax.sql.DataSource;
	import org.apache.ibatis.session.SqlSession;
	import org.apache.ibatis.session.SqlSessionFactory;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	import lombok.Setter;
	import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//Java 설정을 사용하는 경우 
//@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class DataSourceTests {

  @Setter(onMethod_ = { @Autowired })
  private DataSource dataSource;

  @Setter(onMethod_ = { @Autowired })
  private SqlSessionFactory sqlSessionFactory;

  @Test
  public void testMyBatis() {//SqlSessionFactoryBean을 이용해서 SqlSession을 사용해 보는 테스트는

    try (SqlSession session = sqlSessionFactory.openSession();
       Connection con = session.getConnection();
      ) {

      log.info(session);
      log.info(con);

    } catch (Exception e) {
      fail(e.getMessage());
    }

  }

  @Test
  public void testConnection() {//testConnection()을 실행해 보면 내부적으로 HikariCP가 시작되고，종료되는 로그를 확인
    
    try (Connection con = dataSource.getConnection()){

      log.info(con);      
      
    }catch(Exception e) {
      fail(e.getMessage());
    }
  }
}


