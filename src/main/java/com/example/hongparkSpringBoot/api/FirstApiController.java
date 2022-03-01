package com.example.hongparkSpringBoot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//일반 @Controller는 view페이지를 반환하지만 @RestController는 JSON을 반환한다.
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world!";
    }
}
