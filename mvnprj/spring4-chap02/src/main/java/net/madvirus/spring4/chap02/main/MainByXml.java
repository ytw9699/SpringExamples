package net.madvirus.spring4.chap02.main;

import net.madvirus.spring4.chap02.AuthException;
import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.UserNotFoundException;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config.xml");
		
		AuthenticationService authSvc = ctx.getBean("authenticationService", AuthenticationService.class);
		
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1111");//비밀번호가 일치하지않습니다 [userid=bkchoi, pw=1111]
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "11111");//비밀번호가 일치하지않습니다 [userid=bkchoi, pw=11111]
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "111111");//비밀번호가 일치하지않습니다 [userid=bkchoi, pw=111111]
		//3번이상 로그인 시도 실패
		try {
			authSvc.authenticate("bkchoi2", "1111");//id가 없습니다
		}catch (UserNotFoundException ex) {
		}
		
		authSvc.authenticate("bkchoi", "1234");//로그인에 성공했습니다
		
		PasswordChangeService pwChgSvc = ctx.getBean(PasswordChangeService.class);//이름 생략가능
		//getBean() 메서드를 호출할 때 빈의 이름을 지정하지 않고 타입만 전달하고 있는데,이경우 기술된 타입에 해당하는 빈을 구해서 리턴한다
		
		pwChgSvc.changePassword("bkchoi", "1234", "5678");//bkchoi아이디의 비밀번호를5678로 변경했습니다
		
		runAuthAndCatchAuthEx(authSvc, "bkchoi", "1234");//비밀번호가 일치하지않습니다 [userid=bkchoi, pw=1234]
		//3번이상 로그인 시도 실패
		authSvc.authenticate("bkchoi", "5678");//로그인에 성공했습니다
		
		ctx.close();
	}

	private static void runAuthAndCatchAuthEx(AuthenticationService authSvc, String userId, String password) {
		try {
			authSvc.authenticate(userId, password);
		} catch (AuthException ex) {
		}
	}
}
