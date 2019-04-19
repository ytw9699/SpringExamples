package net.madvirus.spring4.chap02.main;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXmlWithoutId {

public static void main(String[] args) {
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:config-without-id.xml");
	String[] beanNames = ctx.getBeanDefinitionNames();
	//config.xml에 아이디를 지정안했을때 이름을 불러와준다 //<bean id="user1"
	for (String bn : beanNames)
		System.out.println(bn);
	ctx.close();
}
}
