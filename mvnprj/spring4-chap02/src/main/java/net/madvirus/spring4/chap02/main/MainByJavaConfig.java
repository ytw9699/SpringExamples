package net.madvirus.spring4.chap02.main;

import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.conf.Config;
import net.madvirus.spring4.chap02.conf.Config1;
import net.madvirus.spring4.chap02.conf.Config2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class MainByJavaConfig {

	public static void main(String[] args) {
		useSingleClass();
		useMultipleClass();
	}

	private static void useSingleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config.class);//Config.java 
		//AnnotationConfigApplicationContext 클래스의 생성자는 설정 정보로 사용할 클래스를 파라미터로 전달받는다.
		//new AnnotationConfigApplicationContext(Config.class, ConfigSensor.class);//이렇게 2개도설정가능
		//new AnnotationConfigApplicationContext(net.madvirus.spring4.chap02.conf);
		//이렇게 하면 이 패키지에 @Configuration이 붙은 클래스는 전부 설정가능 , 전부로딩
		
		useBean(ctx);
		ctx.close();
	}

	private static void useBean(AnnotationConfigApplicationContext ctx) {
		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");

		PasswordChangeService pwChgSvc =
				ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");
	}

	private static void useMultipleClass() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(Config1.class, Config2.class);
		useBean(ctx);
		ctx.close();
	}
}
