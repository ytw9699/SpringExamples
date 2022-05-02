package org.zerock.service;
	import static org.junit.Assert.assertEquals;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	import lombok.Setter;
	import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SampleServiceTests {

  @Setter(onMethod_ = @Autowired)
  private SampleService service;
  
  @Test
  public void testClass() {
    log.info(service);//단순히 service 변수를 출력했을 때는 기존에 사용하듯이 SampleServiceimpl 클래스의 인스턴스처럼 보인다.
    log.info(service.getClass().getName());//하지만 세밀히 파악해보면 Proxy 클래스의 인스턴스를 생성한다.
    //com.sun.proxy. $Proxy는 JDK의 다이나믹 프록시 (dynamic Proxy) 기법이 적용된 결과
    //AOP 설정을 한 Target에 대해서 Proxy 객체가 정상적으로 만들어졌는지를 확인
  }
  
  @Test
  public void testAdd() throws Exception {
	  
    int result = service.doAdd("100", "200");

    assertEquals(result, 300);
  }
  
  @Test
  public void testAddError() throws Exception {
    log.info(service.doAdd("123", "ABC"));//고의적으로 예외 발생
  }
  
}

