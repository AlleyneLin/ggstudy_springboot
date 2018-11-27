package com.alleyne.ggstudy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class UserControllerTest {
    //模拟http发送请求的测试类
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserControllerTest()).build();
    }
    @Test
    public void TestUserController() throws Exception{
        RequestBuilder requestBuider = null;
        // 1、get查一下user列表，应该为空
        requestBuider = get("/");
        //mvc.perform(requestBuider).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
        mvc.perform(requestBuider).andExpect(status().isOk());

        // 2、post提交一个user
        requestBuider = put("/users/").param("id", "1")
                                                    .param("name", "测试人")
                                                    .param("age", "17");
        mvc.perform(requestBuider).andExpect(content().string(equalTo("success")));

        // 4、put修改id为1的user
        requestBuider = put("/users/1")
                .param("name", "测试终极大师")
                .param("age", "30");
        mvc.perform(requestBuider)
                .andExpect(content().string(equalTo("success")));

        // 5、get一个id为1的user
        requestBuider = get("/users/1");
        mvc.perform(requestBuider)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        // 6、del删除id为1的user
        requestBuider = delete("/users/1");
        mvc.perform(requestBuider)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下user列表，应该为空
        requestBuider = get("/users/");
        mvc.perform(requestBuider)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }
}
