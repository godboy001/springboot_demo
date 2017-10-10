package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	/**
	 * 测试controller
	 */
	private MockMvc mockMvc;
	@Autowired    
    private WebApplicationContext wac; // 注入WebApplicationContext   
	@Before // 在测试开始前初始化工作    
    public void setup() {    
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();    
    }   
	
	/**测试WebMvc返回页面**/
	@Test
	@Transactional  
	@Rollback(true)// 事务自动回滚，默认是true。可以不写  
    public void testWebMvc() throws Exception {    
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/test").
				accept(MediaType.TEXT_HTML)).
				andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
        System.out.println(result.getResponse().getContentAsString());    
    }
	
	/***测试json格式数据controller***/
	@Test
	@Transactional  
	@Rollback(true)// 事务自动回滚，默认是true。可以不写  
    public void testGetByName() throws Exception {    
		MvcResult result=mockMvc.perform(MockMvcRequestBuilders.get("/getByName?name=你好").
				accept(MediaType.APPLICATION_JSON_UTF8_VALUE)).
				andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
        System.out.println(result.getResponse().getContentAsString());    
    }
}
