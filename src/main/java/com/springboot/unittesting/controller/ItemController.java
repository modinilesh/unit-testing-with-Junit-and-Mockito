package com.springboot.unittesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.unittesting.Business.ItemBusinessImpl;
import com.springboot.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessImpl itemBusinessImpl;
	
	@GetMapping("/dummy-items")
	public Item dummy_items(){
		return new Item(12, "Water gun", 400, 10);
	}

	
	@GetMapping("/dummy-items-from-service")
	public Item dummy_items_from_ItemBusinessImpl(){
		return itemBusinessImpl.retrieveHardcodedItem();
	}

}
