package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//컨트롤러를 JSON 을 반환하는 컨트롤러로 만둘어 준다. @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다고 생각하면 된다.
public class HelloController {

    @GetMapping("/hello")//GetMapping은 HTTP Method 인 Get 의 요청을 받을 수 있는 API 를 만들어 준다.
    public String hello() {

        return "hello";
    }

    @GetMapping("/hello/dto")//RequestParam은 외 부에서 API 로 넘긴 파라미터를 가져오는 어노테이션
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {

        return new HelloResponseDto(name, amount);
    }

}
