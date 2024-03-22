package com.springboot.unittesting.Business;

import com.springboot.unittesting.service.DataService;

public class BusinessImpl {

	// declaring object of data service
	private DataService dataService;

	// creating setters for data service
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	// demo logic
	public int calculateSum(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		return sum;
	}

	// using the data service
	public int calculateSumUsingDataService() {
		int sum = 0;
		int arr[] = dataService.retrieveAllData();
		for (int val : arr) {
			sum += val;
		}
		return sum;
	}

}