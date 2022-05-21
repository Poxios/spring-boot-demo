package com.demo.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 변환하는 컨트롤러로 만들어준다.
public class HelloController {
    @GetMapping("/hello") // Get 요청을 받을 수 있는 API를 만든다.
    public String hello(){
        return "hello";
    }

}
