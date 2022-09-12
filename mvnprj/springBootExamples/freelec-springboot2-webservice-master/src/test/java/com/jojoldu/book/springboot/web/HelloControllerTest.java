package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
/*테스트를 진행할 때 JUnit 에 내장된 실행자 외에 다른 실행자를 실행시킨다.
여기서는 SpringRunner라는 스프링 실행자를 사용한다
즉,스프링 부트 테스트와 JUnit 사이에 연결자 역할을한다*/
@WebMvcTest(controllers = HelloController.class, excludeFilters = {
@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
}
)
/*WebMvcTest는 여러 스프링 테스트 어노테이션 중, Web (Spring MVC)에 집증할 수 있는 어노테이션이다.
선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다. 단, @Service, @Component, @Repository 등은 사용할 수 없다
WebMvcTest의 경우 JPA 기능이 작동하지 않음,JPA 기능까지 한번에 테스트할 때는 @SpringBootTest와 TesrResrTemp lare을 사용하면 됨
*/
public class HelloControllerTest {

    @Autowired//스프링이 관리하는 빈을 주입 받는다
    private MockMvc mvc;//웹 API 를 테스트할 때 사용, 스프링 MVC 테스트의 시작점, 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())//HTTP Header의 Status 를 검증,OK 즉, 2 00 인지 아닌지를 검증
                .andExpect(content().string(hello));//응답 본문의 내용을 검증
    }

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                    get("/hello/dto")
                            .param("name", name)//param은 String 만 허용, 숫자 날짜 등의 데이터 도 등록할 때는 문자열로 변경 해야만 가능
                            .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath는 JSON 응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));//$를 기준으로 필드명을 명시
    }
}
