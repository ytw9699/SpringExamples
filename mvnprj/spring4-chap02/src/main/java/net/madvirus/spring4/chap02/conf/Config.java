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

@Configuration//이 어노테이션은 클래스를 스프링 설정으로 사용함을 의미   Configuration=환경 설정
//@Import(ConfigSensor.class)//이런식으로 다른 설정문서 임포트가능
//@Import({ConfigSensor.class,ConfigDashboard.class})//이런식으로 다른 설정문서 여러개 임포트가능
public class Config {

	@Bean//메서드의 리턴 값을 빈 객체로 사용함을 의미
	public User user1() {//id="user1" 메서드의 이름을 빈 객체 식별자로 사용
		return new User("bkchoi", "1234");
	}
	/*<bean id="user1" class="net.madvirus.spring4.chap02.User">
	<constructor-arg value="bkchoi" />
	<constructor-arg value="1234" />
	</bean>*/

	/*빈 객체의 식별값으로 메서드 이름이 아닌 다른 이름을 사용하고 싶다면 @Bean 애노테
	이션의 name 속성을 사용하면 된다*/
	@Bean(name = "user2")//id가 user2로 new User객체가 영역에저장
	public User user() {
		return new User("madvirus", "qwer");
	}
	/*<bean id="user2" class="net.madvirus.spring4.chap02.User">
	<constructor-arg value="madvirus" />
	<constructor-arg value="qwer" />
	</bean>*/

	//다른 빈 객체를 참조해야 할 때에는，참조할 빈 객체를 생성하는 메서드를 호출해서 빈 객체를 구하면 된다.
	@Bean
	public UserRepository userRepository() {//id=userRepository
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		/*Arrays.asList메소드는 new arraylist를 리턴*/
		return userRepo;
	}
	
	@Bean
	public AuthFailLogger authFailLogger() {
		AuthFailLogger logger = new AuthFailLogger();
		logger.setThreshold(2);
		return logger;
	}
	
	@Bean
	public PasswordChangeService pwChangeSvc() {//id=pwChangeSvc
		return new PasswordChangeService(userRepository());
	}
	/*일반적인 상식으로는 위아래의 코드에서 사용되는 두 객체는 서로 달라야 한
	다. 하지만，실제로 스프링에 의해 userRepository메서드가 리턴하는 객체는 항상 동
	일한 객체를 리턴한다. 즉，위아래의 코드에서 사용하는 객체는 동일한 객체이다.
	이는 스프링이 @Configuration 클래스를 상속 받은 새로운 클래스를 만들어내기 때문*/
	@Bean
	public AuthenticationService authenticationService() {
		AuthenticationService authSvc = new AuthenticationService();
		authSvc.setFailLogger(authFailLogger());
		authSvc.setUserRepository(userRepository());
		return authSvc;
	}

}
