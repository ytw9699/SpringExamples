package madvirus.spring.chap06.common;

public class CommonLoggerImpl implements CommonLogger {
	@Override
	public void log(String message) {//로그를 찍어주는 메소드
		System.out.println("CommonLogger - " + message);
	}

}
