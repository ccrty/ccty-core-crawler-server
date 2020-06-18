package com.ccty.noah;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

    @Rule
    public ContiPerfRule contiPerfRule = new ContiPerfRule();


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;


    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @PerfTest(threads = 1000, duration = 10000)
    public void test() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test/user/123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(123))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("test"))
                .andDo(MockMvcResultHandlers.print());
    }

}
