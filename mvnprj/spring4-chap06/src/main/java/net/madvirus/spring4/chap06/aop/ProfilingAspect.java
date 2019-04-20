package net.madvirus.spring4.chap06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect//내가만드는 클래스가 aspect다 
public class ProfilingAspect {

@Pointcut("execution(public * net.madvirus.spring4.chap06.board..*(..))")
					//패키지 밑에 클래스 아무거나상관없고 메소드도 상관없다
private void profileTarget() {//profileTarget이 이름이 @Pointcut이름
}

@Around("profileTarget()")
public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
	String signatureString = joinPoint.getSignature().toShortString();
	System.out.println(signatureString + " 시작");
	long start = System.currentTimeMillis();
	try {
		Object result = joinPoint.proceed();
		return result;
	} finally {
		long finish = System.currentTimeMillis();
		System.out.println(signatureString + " 종료");
		System.out.println(signatureString + " 실행 시간 : " + 
				(finish - start) + "ms");
	}
}
}
