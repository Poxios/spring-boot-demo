package com.demo.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // JUnit 이외의 실행자 - 여기서는 SpringRunner이라는 스프링 실행자를 실행시킨다.
@WebMvcTest(controllers = HelloController.class) // 스프링 테스트 어노테이션 중, Web에 집중 할 수 있는 어노테이션이다.

public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_returns() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }
}
