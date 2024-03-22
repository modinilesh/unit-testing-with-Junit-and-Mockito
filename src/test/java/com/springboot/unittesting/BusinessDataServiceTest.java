package com.springboot.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.springboot.unittesting.Business.BusinessImpl;
import com.springboot.unittesting.service.DataService;

//creating stub class which will be giving dummy test data for first test case
class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1, 2, 3};
	}
	
}

//creating stub class which will be giving dummy test data for Second test case
class DataServiceStub2 implements DataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
	
}

//creating stub class which will be giving dummy test data for Third test case
class DataServiceStub3 implements DataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {3};
	}
	
}


public class BusinessDataServiceTest {

    @Test
    void calculateSumUsingDataService_basic() {
        BusinessImpl business = new BusinessImpl();
        
        //setting data service
        business.setDataService(new DataServiceStub());
        
        //getting actual results
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }
    

    @Test
    void calculateSumUsingDataService_empty() {
        BusinessImpl business = new BusinessImpl();
        
        //setting data service
        business.setDataService(new DataServiceStub2());
        
        //getting actual results
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void calculateSumUsingDataService_singleValue() {
        BusinessImpl business = new BusinessImpl();
        
        //setting data service
        business.setDataService(new DataServiceStub3());
        
        //getting actual results
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

}