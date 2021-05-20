package com.qa.freecrm.Listerns;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalzer implements IRetryAnalyzer {
	
	int count = 0;
	int retrylimit = 3;

	
	public boolean retry(ITestResult result) {
		if (count < retrylimit ) {
			count++;
			return true;
		}
		return false;
	}

}
