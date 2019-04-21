package net.example10;

public class CommonLoggerImpl implements CommonLogger {
	@Override
	public void log(String message) {//로그를 찍어주는 메소드
		System.out.println("CommonLogger - " + message);
	}

}
