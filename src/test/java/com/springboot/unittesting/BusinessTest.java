package com.springboot.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.springboot.unittesting.Business.BusinessImpl;

public class BusinessTest {

    @Test
    void calculateSum_basic() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[] {1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void calculateSum_empty() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
    
    @Test
    void calculateSum_singleValue() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[] {1});
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }


}