package madvirus.spring.chap06.common;

public class CommonLoggerImpl implements CommonLogger {
	@Override
	public void log(String message) {//�α׸� ����ִ� �޼ҵ�
		System.out.println("CommonLogger - " + message);
	}

}
