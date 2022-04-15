package org.zerock.mapper;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	import lombok.extern.log4j.Log4j;
	import org.zerock.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestMapperTests {
	
		@Autowired
		private TestMapper testMapper;//testMapper가 정상적으로 사용이 가능한지를 알아보기위한 테스트 코드
		
	 	@Test
		public void testGetTime() { //어노테이션 sql실행
			log.info("testMapper.getClass().getName()="+testMapper.getClass().getName());
			//정상적으로 동작한다면 스프링 내부에는 TimeMapper인터페이스 타입으로 만들어진 스프링 객체(빈)가 존재한다는 뜻
			//실행 결과 확인시 인터페이스만 만들어 주었음에도 내부적으로 적당한 클래스가 만들어진게 확인된다.
			log.info("testMapper.getTime()="+ testMapper.getTime());
		}
	 	
	 	@Test
		public void testGetTime2() {//xml sql실행
	 		log.info("testMapper.getTime2()="+ testMapper.getTime2());
	 	}
}


	


