package org.my.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//스프링이 빈 팩토리를 위한 오브젝트 설정을 담당하는 클래스라고 인식
public class DaoFactory {
	
	@Bean//오브젝트를 만들어 주는 메소드에는 @Bean
	public UserDao3 userDao3() {
		UserDao3 dao = new UserDao3(connectionMaker());
		return dao;
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
