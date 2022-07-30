package org.my.ex5.controller;
    import org.my.ex5.dto.HelloResponseDto;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @GetMapping("/helloDto")
    public HelloResponseDto readHelloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {

        return new HelloResponseDto(name, amount);
    }
}





