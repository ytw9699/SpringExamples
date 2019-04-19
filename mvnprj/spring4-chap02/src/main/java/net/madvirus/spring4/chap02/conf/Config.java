package net.madvirus.spring4.chap02.conf;

import java.util.Arrays;

import net.madvirus.spring4.chap02.AuthFailLogger;
import net.madvirus.spring4.chap02.AuthenticationService;
import net.madvirus.spring4.chap02.PasswordChangeService;
import net.madvirus.spring4.chap02.User;
import net.madvirus.spring4.chap02.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration//이 어노테이션은 스프링 설정문서다라고 하는것   Configuration=환경 설정
//@Import(ConfigSensor.class)//이런식으로 다른 설정문서 임포트가능
//@Import({ConfigSensor.class,ConfigDashboard.class})//이런식으로 다른 설정문서 여러개 임포트가능

public class Config {

	@Bean
	public User user1() {//id="user1"
		return new User("bkchoi", "1234");
	}
	/*<bean id="user1" class="net.madvirus.spring4.chap02.User">
	<constructor-arg value="bkchoi" />
	<constructor-arg value="1234" />
	</bean>*/

	@Bean(name = "user2")//id가 user2로 new User객체가 영역에저장
	public User user() {
		return new User("madvirus", "qwer");
	}
	/*<bean id="user2" class="net.madvirus.spring4.chap02.User">
	<constructor-arg value="madvirus" />
	<constructor-arg value="qwer" />
	</bean>*/

	@Bean
	public UserRepository userRepository() {//id=userRepository
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		/*Arrays.asList메소드는 new arraylist를 리턴*/
		//http://hardlearner.tistory.com/272
		return userRepo;
	}

	@Bean
	public PasswordChangeService pwChangeSvc() {//id=pwChangeSvc
		return new PasswordChangeService(userRepository());
	}

	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}

	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}

}
