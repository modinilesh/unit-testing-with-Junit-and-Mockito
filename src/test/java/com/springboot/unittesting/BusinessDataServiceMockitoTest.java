package com.springboot.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import com.springboot.unittesting.Business.BusinessImpl;
import com.springboot.unittesting.service.DataService;



public class BusinessDataServiceMockitoTest {

    @Test
    void calculateSumUsingDataService_basic() {
        BusinessImpl business = new BusinessImpl();
        
        //let's mock the Data Service
        DataService mockDataService = mock(DataService.class);
        
        //return data based on requirements
        when(mockDataService.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        
        //setting data service
        business.setDataService(mockDataService);
        
        //getting actual results
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }
    

    @Test
    void calculateSumUsingDataService_empty() {
        BusinessImpl business = new BusinessImpl();
        
        //let's mock the Data Service
        DataService mockDataService = mock(DataService.class);
        
        //return data based on requirements
        when(mockDataService.retrieveAllData()).thenReturn(new int[] {});
        
        //setting data service
        business.setDataService(mockDataService);
        
        //getting actual results
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void calculateSumUsingDataService_singleValue() {
        BusinessImpl business = new BusinessImpl();

        //let's mock the Data Service
        DataService mockDataService = mock(DataService.class);
        
        //return data based on requirements
        when(mockDataService.retrieveAllData()).thenReturn(new int[] {1});
        
        //setting data service
        business.setDataService(mockDataService);
        
        //getting actual results
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

}