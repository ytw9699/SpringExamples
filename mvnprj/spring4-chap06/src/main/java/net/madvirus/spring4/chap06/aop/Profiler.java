package net.madvirus.spring4.chap06.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Profiler {//공통모듈임//로그찍어보는것

public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {//ProceedingJoinPoint을 첫마라미터로 꼭 넣어야함..
	String signatureString = joinPoint.getSignature().toShortString();//호출되는 메소드에 대한 정보를 구한다
	System.out.println(signatureString + " 시작1");
	long start = System.currentTimeMillis(); 
	try {
		Object result = joinPoint.proceed();//핵심모듈을 실행//around advice랑 연관되기때문 //메소드 실행전후
		return result;
	} finally {
		long finish = System.currentTimeMillis();
		System.out.println(signatureString + " 종료3");
		System.out.println(signatureString + " 실행 시간3 : " +
				(finish - start) + "ms1");
	}
}
}
