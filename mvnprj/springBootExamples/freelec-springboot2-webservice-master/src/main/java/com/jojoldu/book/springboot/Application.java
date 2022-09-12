package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing//JPA Auditing 활성화는 JpaConfig로 이동
//프로젝트의 메인 클래스다.
@SpringBootApplication//스프링 부트의 자동 설정 , 스프링 Bean 읽기와 생성 을 모두 자동으로 설정
//@SpringBootApplication 이 있는 위치부터 설정을 읽어 가기 때문에 이 클래스는 항상 프로 젝트의 최상단에 위치 해야만한다.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);// SpringApplication.run 으로 인해 내장 WAS를 실행한다.
        //별도로 외부에 WAS 를 두 지 않고 애 플 리케이션 을 실행할 때 내부에서 WAS 를 실행하는 것을 이야기한다.
        //이렇게 되면 항상 서버에 톰캣Tomcat 을 설치할 필요가 없게 되고 , 스프링 부트로 만들어진 Jar 파일(실행 가능한 Java 패키징 파일)로 실행하면 된다.
    }
}

