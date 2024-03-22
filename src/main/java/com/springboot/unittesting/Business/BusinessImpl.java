package com.springboot.unittesting.Business;

public class BusinessImpl {

    //demo logic
    public int calculateSum(int[] arr){
        int sum = 0;
        for(int val : arr){
            sum += val;
        }
        return sum;
    }

}