package net.madvirus.spring4.chap02.main;

import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.conf.ConfigWithXmlImport;
import net.madvirus.spring4.chap02.sensor.Sensor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXmlAndJava {

	public static void main(String[] args) {
		useBean(new GenericXmlApplicationContext("classpath:config-with-java.xml"));//xml이설정이 주고 자바코드가 부일때
		useBean(new AnnotationConfigApplicationContext(ConfigWithXmlImport.class));//자바코드가 주고 xml설정이 부일때
	}

	private static void useBean(AbstractApplicationContext ctx) {
		AuthenticationService authSvc =
				ctx.getBean("authenticationService", AuthenticationService.class);
		authSvc.authenticate("bkchoi", "1234");

		PasswordChangeService pwChgSvc =
				ctx.getBean(PasswordChangeService.class);
		pwChgSvc.changePassword("bkchoi", "1234", "5678");

		Sensor sensor1 = ctx.getBean("sensor1", Sensor.class);
		System.out.println(sensor1);

		ctx.close();
	}

}
