package com.springboot.unittesting;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ListMockTest {
	
	@Mock
	List mockList ;

	@Test
	public void size_basic() {
		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mockList.size()).thenReturn(5).thenReturn(12); 	//first time will return 5 then second time 12
		assertEquals(5, mockList.size());	
		assertEquals(12, mockList.size());
	}
	
	@Test
	public void returnWithParameter() {
		when(mockList.get(1)).thenReturn("Nilesh Modi"); 	
		assertEquals("Nilesh Modi", mockList.get(1));
		assertEquals(null, mockList.get(0));
	}
	
	@Test
	public void returnWithGenericParameter() {
		when(mockList.get(anyInt())).thenReturn("Nilesh Modi"); 	
		assertEquals("Nilesh Modi", mockList.get(1));
		assertEquals("Nilesh Modi", mockList.get(0));
	}
	
	

}
