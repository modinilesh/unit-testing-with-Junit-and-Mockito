package com.springboot.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.unittesting.model.Item;

@RestController
public class ItemController {
	
	@GetMapping("/dummy-items")
	public Item helloWorld(){
		return new Item(12, "Water gun", 400, 10);
	}

}
