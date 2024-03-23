package com.springboot.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.unittesting.Business.BusinessImpl;
import com.springboot.unittesting.service.DataService;

@ExtendWith(MockitoExtension.class)
public class BusinessDataServiceMockitoTest {

	// To reduce the redundant code
	@InjectMocks
	BusinessImpl business;
	
	@Mock //if we are using this annotation then no need to separately set the DataService to business
	DataService mockDataService;

	@Test
	void calculateSumUsingDataService_basic() {

		// return data based on requirements
		when(mockDataService.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	void calculateSumUsingDataService_empty() {
		// return data based on requirements
		when(mockDataService.retrieveAllData()).thenReturn(new int[] { });
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	void calculateSumUsingDataService_singleValue() {
		// return data based on requirements
		when(mockDataService.retrieveAllData()).thenReturn(new int[] { 1 });
		assertEquals(1, business.calculateSumUsingDataService());
	}

}