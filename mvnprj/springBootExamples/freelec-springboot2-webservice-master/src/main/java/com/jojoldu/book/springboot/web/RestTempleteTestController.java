package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class RestTempleteTestController {

    @GetMapping("/around-hub")
    public String getTest1() {
        log.info("getTest1 호출");
        return "hello around hub";
    }

    @GetMapping("/name")
    public String getTest2(@RequestParam("name") String name) {
        log.info("getTest2 호출");
        return "name = " + name;
    }

    @GetMapping("/path-variables/name")
    public String getTest3(@PathVariable("name") String name) {
        log.info("getTest3 호출");
        return "name = " + name;
    }

    @PostMapping("/member")
    public ResponseEntity<MemberDTO> getMember(@RequestBody MemberDTO dto,
                                                @RequestParam String name,
                                                @RequestParam String email,
                                                @RequestParam String organization ) {
        log.info("getMember 호출");
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/add-header")
    public ResponseEntity<MemberDTO> addheader(@RequestHeader("around-header") String header, @RequestBody MemberDTO dto) {
        log.info("addheader 호출");
        log.info("header =" + header);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }


}
