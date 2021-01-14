package org.zerock.sample;
	import static org.junit.Assert.assertNotNull;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	import lombok.Setter;
	import lombok.extern.log4j.Log4j;
	
	/*SpringJUnit4ClassRunner 클래스는 JUnit의 Runner를 구현한 클래스로서，이 클래
	스는 @ContextConfiguration에 지정한 설정 정보를 이용해서 스프링 컨테이너를 생성
	한다. 그리고，@Autowired 등 자동 주입 기능을 이용해서 컨테이너가 생성한 빈 객체를
	테스트 클래스의 필드에 할당해준다. 따라서，테스트 코드에서 사용할 스프링 빈 객체는
	자동 주입 애노테이션을 이용해서 필드로 선언하면 된다.*/
	
//테스트 코드는 우선 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 것을 @Runwith 어노테이션으로 표시한다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@ContextConfiguration은 스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지를 명시
//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록(흔히 스프링의 빈으로 등록된다고 표현)

@Log4j//@Log를 클래스쪽에 붙여주면 내부적 으로 static final로 Logger 객체가 생성되므로 개발 시 별도의 로그를 설정할 필요 없이 필요한 코드를 만들어 낼 수 있다.
public class SampleTests {
//SampleTests 클래스는 spring-test 모듈을 이용해서 간단하게 스프링을 가동시키고, 위에서 설명된 동작들이 일어나게 한다.
  
	  @Setter(onMethod_ = { @Autowired })
	  private Restaurant restaurant;  
		  /*new Restaurant()와 같이 Restaurant 클래스에서 객체를 생성한 적이 없는데도 객체가 만들어졌다
			  는 점 - 스프링은 관리가 필요한 객체(Bean)를 어노테이션 등을 이용해서 객체를 생성하고 관리하는
			  일종의 컨테이너, 팩토리의 기능을 가지고 있다
			*/  
	
	  @Test//@Test는 junit에서 해당 메서드가 jUnit 상에서 단위 테스트의 대상인지 알려줌
	  public void testExist() {
		  
		    assertNotNull(restaurant);//restaurant 변수가 null이 아니어야만 테스트가 성공한다는 것을 의미
		    
		    log.info(restaurant);
		    log.info("----------------------------------");
		    log.info(restaurant.getChef());
		   /* Restaurant 객체의 Chef 인스턴스 변수(멤버 변수)에 Chef 타입의 객체가 주입되어 있다는 점 - 스
			프링은 @Autowired와 같은 어노테이션을 이용해서 개발자가 직접 객체들과의 관계를 관리하지 않
			고，자동으로 관리되도록 한다.
			
			테스트 결과가 의미하는 바는 스프링을 공부하는 데 있어서 가장 중요한 내용
			 1) 테스트 코드가 실행되기 위해서 스프링 프레임워크가 동작했고，
			 2) 동작하는 과정에서 필요한 객체들이 스프링에 등록되었고
			 3) 의존성 주입이 필요한 객체는 자동으로 주입이 이루어졌다는것
			*/
	  }
}
