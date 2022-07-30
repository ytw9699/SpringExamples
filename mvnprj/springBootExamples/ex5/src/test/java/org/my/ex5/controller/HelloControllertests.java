package org.my.ex5.controller;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.test.context.junit.jupiter.SpringExtension;
    import org.springframework.test.web.servlet.MockMvc;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
    import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloContoller.class)
public class HelloControllertests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception {

        System.out.println(mvc.getClass().getName());
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void returnHelloDto() throws Exception {

        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/helloDto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))//string 만 허용해서 변경이필요
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))//json응답값 필드별 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}


