package net.example10;

public class MockAuthenticator implements Authenticator {//인터페이스 구현
private CommonLogger commonLogger;//선언
@Override//오버라이드
public void authenticate(LoginCommand loginCommand)throws AuthenticationException {
	if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
		//전달되는 자바빈에서 패스워드랑 아이디꺼내서 같지 않으면
		commonLogger.log("인증 에러 -아이디=" + loginCommand.getUserId()+
				" 비밀번호="+loginCommand.getPassword()+" 일치하지않습니다");
		throw new AuthenticationException();
	}
}
public void setCommonLogger(CommonLogger commonLogger) {
	this.commonLogger = commonLogger;//dispatcher-servlet설정해줌
}
}

