package com.springboot.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

//This class is completely created to understand all ways of assert for verifying the JSON

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":12,\"name\":\"Watergun\",\"price\":400,\"qty\":10}";
	
	
	//JSONAssert.assertEquals(expectedResponse, actualResponse, strict)
	//where strict is how strictly you want to match the values of actual and expected 
	
	
	//let's take strict value as true
	@Test
	public void joinAssert_StrictTrue_ExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":12,\"name\":\"Watergun\",\"price\":400,\"qty\":10}";
		
		//if my values not in order or few values are missing then strict true will throw error
		//if extra spaces are given among values then it will neglify that and then match the responses
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
	}
	

	//let's take strict value as false
	@Test
	public void joinAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":12,\"name\":\"Watergun\"}";
		
		//if my values not in order or few values are missing then also will work fine as it just compare the present values
		//if extra spaces are given among values then it will neglify that and then match the responses
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
	}
	

	//let's take without escape characters
	@Test
	public void joinAssert_WithoutEscapeCharacter() throws JSONException {
		String expectedResponse = "{id:12, name:Watergun, price:400}";
		
		//this will not be working if values contains words with spacing
		//eg. will fail if "{id:12, name:Water gun, price:400}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
	}

}
