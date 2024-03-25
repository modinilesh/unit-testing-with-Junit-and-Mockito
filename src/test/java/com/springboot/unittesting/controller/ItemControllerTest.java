package com.springboot.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.unittesting.Business.ItemBusinessImpl;
import com.springboot.unittesting.model.Item;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	//need to create a mockbean as this test is including only ItemController.clss and that class is using autowiring with ItemBusinessImpl
	//this object will be initialized as null so we need to use when and then method to invoke the data
	@MockBean
	ItemBusinessImpl itemBusinessImpl;
	
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
	
	//response coming from ItemBusinessImpl
	@Test
	public void basicResponse_from_ItemBusinessImpl_Test() throws Exception {
		
		//set data to mock
		when(itemBusinessImpl.retrieveHardcodedItem()).thenReturn(
				new Item(1, "Ball", 10, 100));
		
		//make request
		RequestBuilder rqst = MockMvcRequestBuilders.get("/dummy-items-from-service")
				.accept(MediaType.APPLICATION_JSON);
		
		//get result
		MvcResult result = mockMvc.perform(rqst)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:1, name:Ball,price:10,qty:100}"))
				.andReturn();
	}
	

}
