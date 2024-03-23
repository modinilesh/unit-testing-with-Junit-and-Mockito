package com.springboot.unittesting;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
	
	
	//Argument Matchers
	@Test
	public void returnWithGenericParameter() {
		when(mockList.get(anyInt())).thenReturn("Nilesh Modi"); 	
		assertEquals("Nilesh Modi", mockList.get(1));
		assertEquals("Nilesh Modi", mockList.get(0));
	}
	
	
	//Verifying Methods -> verifying that if one mock is calling another mock/method
	@Test
	public void verificationBasic() {
		
		//suppose in below statements mock is calling another method .get()
		String value1 = (String) mockList.get(0);
		String value2 = (String) mockList.get(1);
		
		//now, verifying above, i.e. is mock calling to another method
		verify(mockList).get(0); //does mocklist call get(0) //true
		verify(mockList, times(2)).get(anyInt());	//does mocklist call get(integer) two times  //true
		verify(mockList, atLeast(1)).get(anyInt()); //does mocklist call get(integer) atleast one time //true
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);
		
	}
	
	

}
