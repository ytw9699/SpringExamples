package madvirus.spring.chap06.service;

import madvirus.spring.chap06.common.CommonLogger;

public class MockAuthenticator implements Authenticator {//인터페이스 구현
	private CommonLogger commonLogger;//선언
	@Override
	public void authenticate(LoginCommand loginCommand)//오버라이드
			throws AuthenticationException {
		if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			//전달되는 자바빈에서 패스워드랑 아이디꺼내서 같으면
			commonLogger.log("인증 에러 -아이디=" 
			+ loginCommand.getUserId()+
					" 비밀번호="
			+loginCommand.getPassword()+
					" 일치하지않습니다");
			throw new AuthenticationException();
		}
	}
	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;//dispatcher-servlet설정해줌
	}
}
/*
package madvirus.spring.chap06.service;

public interface Authenticator {//인터페이스

	void authenticate(LoginCommand loginCommand)throws AuthenticationException;
//추상메소드
}*/
/*package madvirus.spring.chap06.common;

public interface CommonLogger {

	void log(String message);
}
*/
