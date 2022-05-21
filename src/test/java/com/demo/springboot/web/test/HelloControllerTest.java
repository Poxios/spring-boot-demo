package com.demo.springboot.web.test;

import com.demo.springboot.Application;
import com.demo.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // JUnit 이외의 실행자 - 여기서는 SpringRunner 스프링 실행자를 실행시킨다.
@WebMvcTest(controllers = HelloController.class) // 스프링 테스트 어노테이션 중, Web에 집중 할 수 있는 어노테이션이다.
@AutoConfigureMockMvc

public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_returns() throws Exception{
        String hello = "hello";
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void helloDto_returns() throws Exception{
        String name = "hello";
        int amount = 1000;
        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect( jsonPath("$.name", is(name))) // json 응답값을 필드별로 검증할 수 있는 메소드.
                .andExpect( jsonPath("$.amount",is(amount)));
    }
}
