package org.zerock.sample;
	import static org.junit.Assert.assertNotNull;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	import org.zerock.config.RootConfig;
	import lombok.Setter;
	import lombok.extern.log4j.Log4j;

//@ContextConfiguration은 스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지를 명시
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class SampleTests {
  
  @Setter(onMethod_ = { @Autowired })
  private Restaurant restaurant;  

  @Test //@Test는 junit에서 해당 메서드가 jUnit 상에서 단위 테스트의 대상인지 알려줌
  public void testExist() {
    
    assertNotNull(restaurant);
    
    log.info(restaurant);
    log.info("----------------------------------");
    log.info(restaurant.getChef());
    
  }
}
