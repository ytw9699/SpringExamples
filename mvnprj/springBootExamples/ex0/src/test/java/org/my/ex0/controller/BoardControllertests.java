package org.my.ex0.controller;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.springframework.beans.factory.annotation.Autowired;w
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.test.context.junit.jupiter.SpringExtension;
    import org.springframework.test.web.servlet.MockMvc;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)//스프링부트와 JUNIT 사이에 연결자 역할을 한다.
@WebMvcTest(controllers = BoardController.class)//WEB에 집중할수 있는 어노테이션,
public class BoardControllertests {

    @Autowired
    private MockMvc mvc;//주입되었는데도 인텔리제이 오류발생할수있다. 테스트 코드 동과되니까 무시해도됨
    //MockMvc는 웹 API를 사용할때 사용한다.. 스프링 MVC테스트의 시작점
    @Test
    public void returnHello(){

        System.out.println("mvc");
        System.out.println(mvc.getClass().getName());
        System.out.println("mvc");
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())//status 200 검증
                .andExpect(content().string(hello));//응답 검증

    }
}
