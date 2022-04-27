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

  @Before( "execution(* org.zerock.service.SampleService*.*(..))")
  public void logBefore() {

    log.info("========================");
  }
  
  @Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
  public void logBeforeWithParam(String str1, String str2) {

    log.info("str1: " + str1);
    log.info("str2: " + str2);
  }  

  @AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
  public void logException(Exception exception) {
    
    log.info("Exception....!!!!");
    log.info("exception: "+ exception);
  
  }
  
  
  @Around("execution(* org.zerock.service.SampleService*.*(..))")
  public Object logTime( ProceedingJoinPoint pjp) {
    
    long start = System.currentTimeMillis();
    
    log.info("Target: " + pjp.getTarget());
    log.info("Param: " + Arrays.toString(pjp.getArgs()));
    
    
    //invoke method 
    Object result = null;
    
    try {
      result = pjp.proceed();
    } catch (Throwable e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    long end = System.currentTimeMillis();
    
    log.info("TIME: "  + (end - start));
    
    return result;
  }
}
