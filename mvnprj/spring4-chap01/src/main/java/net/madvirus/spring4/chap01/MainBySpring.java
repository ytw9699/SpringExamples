package net.madvirus.spring4.chap01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainBySpring {//스프링이하는방법
	public static void main(String[] args){
		String configLocation = "classpath:applicationContext.xml";//resources가
		//메이븐의 구조상 clsspath의 경로임
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		//AbstractApplicationContext이게 스프링컨테이너를 만들어줌,xml에있는걸 로딩해서 객체생성함
		Project project = ctx.getBean("sampleProject", Project.class);//아이디에해당되는 객체를꺼내서  
		project.build();//메소드호출
		ctx.close();
	}
}
