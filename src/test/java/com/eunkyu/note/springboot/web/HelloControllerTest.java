package com.eunkyu.note.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    //테스트를 진행할 때 다른 실행자를 실행, SpringRunner는 스프링 부트 테스트와 junit 사이의 연결자
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired  //스프링이 관리하는 Bean을 주입받음
    private MockMvc mvc;    //웹 API를 테스트 할 때 사용, GET/POST에 대한 API 테스트를 할 수 있음

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "Hello";

        mvc.perform(get("/hello"))  //MockMvc를 통해 get요청
                .andExpect(status().isOk())     //mve.perform의 결과를 검증
               .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        );
    }
}
