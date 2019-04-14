package madvirus.spring.chap06.service;

public interface Authenticator {//인터페이스

	void authenticate(LoginCommand loginCommand)throws AuthenticationException;
//추상메소드
}
