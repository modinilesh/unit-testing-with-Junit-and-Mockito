package com.springboot.unittesting.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(HelloWorldController.class)	//this will ensure that these unit testcases are only for HelloWorldController
public class HelloWorldControllerTest {
	
	//creating mockMvc
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception{
		//will call GET "/hello-world" and expect application/json
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		
		//perform request and store response/result
		MvcResult result = mockMvc.perform(request).andReturn();
		
		//verify response
		assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
