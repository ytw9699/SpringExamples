package net.madvirus.spring4.chap01;
	import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
	import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBySpring {//스프링으로 객체조립하고 실행하는방법
	//스프링 기초 예제 : 스프링의 가장 기본적인 기능 - 객체를 생성/조립/사용/관리에 대해
	
	public static void main(String[] args){
		
		String configLocation = "classpath:applicationContext.xml";//resources가
		//메이븐의 구조상 clsspath의 경로임
		//클래스패스에 위치한 "applicationContext.xml" 파일을 설정 파일로 사용한다는 의미를 갖는다
		//1.스프링이 사용할 설정 정보를 만들었으니, 
		//조립기에서생성할 객체가 무엇이고，각 객체를 어떻게 연결하는지에 대한 정보는 XML 파일에 정의되어 있다.
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//AbstractApplicationContext이게 스프링컨테이너를 만들어줌,xml에있는걸 로딩해서 객체생성함
		//2. XML 설정 파일로부터 스프링 컨테이너를 생성하고
		//XML 설정 파일로부터 스프링 컨테이너를 생성할 때에는 GenericXmlApplicationContext 클래스를 사용하면 된다.
		//GenericXmiApplicationContext 객체를 생성하고 있는데，이 코드에서 생성된 객체가 바로 스프링 컨테이너 역할을 수행한다.
		//GenericXmlApplicationContext가 조립기 기능을 구현한 클래스다. 즉 조립기다
		//GenericXmlApplicationContext 클래스는 이 XML 파일에 정의된 설정 정보를 읽어와 객체를 생성하고 각각의 객체를 연결한 뒤에 내부적으로 보관한다
		//이렇게 생성한 객체를 보관하기 때문에 스프링을 객체 컨테이너 라고도 부른다
		
		Project project = ctx.getBean("sampleProject", Project.class);//아이디에해당되는 객체를꺼내서  
		//3. 필요한 객체를 컨테이너로부터 가져와 사용하는 것이다.
		//4. 스프링은 설정 정보로부터 생성한 스프링 빈 객체를 생성/조립/관리하는 기능을 제공하는데，이 기능을 제공하는 객체를 컨테이너라고 부른다
		
		project.build();//메소드호출
		
		ctx.close();//AbstractApplicationContext는 컨테이너 종료와 같은 관리 기능을 제공하고 있다.
	}
}

/*스프링은 ApplicationContext라는 인터페이스를 통해 컨테이너가 제공해야 할 기본 기능을
정의하고 있다. (ApplicationContext 인터페이스 상위에 BeanFactory라는 인터페이스
가 더 있다.) AbstractApplicationContext은 ApplicationContext를 구현하고있다.



스프링 컨테이너의 생성과 종료
스프링 컨테이너는 크게 다음의 주기를 갖는다.
1. 컨테이너 생성
2. 빈 메타 정보(XML이나 자바 기반 설정)를 이용해서 빈 객체 생성
3. 컨테이너 사용
4. 컨테이너 종료 (빈 객체 제거)

컨테이너를 더 이상 사용할 필요가 없다면, 예를 들어 프로그램을 종료하기 직전이라면，
컨테이너를 종료해야 한다. 컨테이너를 종료할 때에는 close() 메서드를 사용한다.

스프링 빈은 생성 - 사용 - 소멸의 라이프사이클을 갖고 있
고, 소멸 과정에서 별도 작업을 수행해야 하는 경우가 있다. 그런데, 빈의 소멸 절차는
스프링 컨테이너를 종료할 때 실행되기 때문어I，스프링 컨테이너를 알맞게 종료하지 않
으면，프로그램이 비정상 상태가 될 수도 있다. 따라서，컨테이너의 사용이 끝나면 컨테
이너를 종료시키는 것이 좋다


*/