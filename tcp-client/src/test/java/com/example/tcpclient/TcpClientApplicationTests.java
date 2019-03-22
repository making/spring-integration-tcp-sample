package com.example.tcpclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TcpClientApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HelloGateway helloGateway;

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        given(this.helloGateway.hello("World")).willReturn("Hello World!");

        this.mockMvc.perform(get("/World")).andDo(print()).andExpect(status().isOk())
            .andExpect(content().string(containsString("Hello World!")));
    }

}
