package com.test.parabank;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class PracticeClass extends BaseClass 
{
	ExtentHtmlReporter reporter = new ExtentHtmlReporter(".//extentReports//htmlLog.html");
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	@Test
	public void test1()
	{
		extent.attachReporter(reporter);
		test = extent.createTest("test1");
		test.log(Status.PASS, "Test is passed");
		
	}
	
	@Test
	public void test2()
	{
		extent.attachReporter(reporter);
		test = extent.createTest("test2");
		test.log(Status.FAIL, "test2 is failed");
	}
	
	@Test
	public void test3()
	{
		extent.attachReporter(reporter);
		test = extent.createTest("test3");
		test.log(Status.ERROR, "error occured");
	}
	
	@Test
	public void test4()
	{
		extent.attachReporter(reporter);
		test = extent.createTest("test4");
		test.log(Status.FATAL, "Fatal error occured");
	}
	@AfterTest
	public void finish()
	{
		extent.flush();
	}
    
}
