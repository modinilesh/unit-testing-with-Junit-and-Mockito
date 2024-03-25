package com.springboot.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void basicResponseTest() throws Exception {
		//make request
		RequestBuilder rqst = MockMvcRequestBuilders.get("/dummy-items")
				.accept(MediaType.APPLICATION_JSON);
		
		//get result
		MvcResult result = mockMvc.perform(rqst)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":12,\"name\":\"Water gun\",\"price\":400,\"qty\":10}"))
				.andReturn();
	}
	

}
