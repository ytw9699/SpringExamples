package org.zerock.aop;
	import java.util.Arrays;
	import org.aspectj.lang.ProceedingJoinPoint;
	import org.aspectj.lang.annotation.AfterThrowing;
	import org.aspectj.lang.annotation.Around;
	import org.aspectj.lang.annotation.Aspect;
	import org.aspectj.lang.annotation.Before;
	import org.springframework.stereotype.Component;
	import lombok.extern.log4j.Log4j;

@Aspect//@Aspect는 해당 클래 스의 객체가 Aspect를 구현한 것임으로 나타내기 위해서 사용
@Log4j
@Component//@Component는 AOP와는 관계가 없지만 스프링에서 빈(bean)으로 인식하기 위해서 사용
public class LogAdvice {

  @Before( "execution(* org.zerock.service.SampleService*.*(..))")//execution으로 Pointcut 설정
  public void logBefore() {
    log.info("========================");
  }
  
  @Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
  public void logBeforeWithParam(String str1, String str2) {
	  //이렇게 Pointcut 설정하면 파라미터가 다른 여러 종류의 메서드에 적용하는 데에는 간단하지 않다는 단점
	  //그래서 @Around와 ProceedingJoinPoint를 통해 해결할수 있다.
    log.info("str1: " + str1);
    log.info("str2: " + str2);
  }  

  @AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")//'throwing'속성을 지정
  public void logException(Exception exception) {//파라미터의 값이 잘못되어서 예외가 발생하는 경우
    
    log.info("Exception....!!!!");
    log.info("exception: "+ exception);
  }
  
  @Around("execution(* org.zerock.service.SampleService*.*(..))")
  public Object logTime( ProceedingJoinPoint pjp) {
	 //ProceedingJoinPoint는 AOP 의 대상이 되는 Target이나 파라미터 등을 파악할 뿐만 아니라, 직접 실행을 결정할 수도 있다
    long start = System.currentTimeMillis();
    
    log.info("Target: " + pjp.getTarget());
    log.info("Param: " + Arrays.toString(pjp.getArgs()));
    
    Object result = null;
    
    try {
    	result = pjp.proceed();
    } catch (Throwable e) {
    	e.printStackTrace();
    }
    
    long end = System.currentTimeMillis();
    
    log.info("TIME: "  + (end - start));
    
    return result;
  }
  
}
