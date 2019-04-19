package net.madvirus.spring4.chap02.main;

import net.madvirus.spring4.chap02.AuthException;
import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.UserNotFoundException;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:config.xml");
		AuthenticationService authSvc = 
				ctx.getBean("authenticationService", AuthenticationService.class);
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1111");//비밀번호 불일치
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "11111");//비밀번호 불일치
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "111111");//비밀번호 불일치
		try {
			authSvc.authenticate("bkchoi2", "1111");//아이디가 없습니다
		} catch (UserNotFoundException ex) {
		}
		authSvc.authenticate("bkchoi", "1234");//로그인에 성공했습니다
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);//이름 생략가능
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1234");//비밀번호가 일치하지않습니다
		authSvc.authenticate("bkchoi", "5678");//로그인에 성공했습니다
		ctx.close();
	}

	private static void runAuthAndCatchAuthEx(
			AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		} catch (AuthException ex) {
		}
	}
}
