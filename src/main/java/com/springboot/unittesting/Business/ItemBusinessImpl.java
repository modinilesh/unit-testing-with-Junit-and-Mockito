package com.springboot.unittesting.Business;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.unittesting.model.Item;

@Component
public class ItemBusinessImpl {

	public Item retrieveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	

}
