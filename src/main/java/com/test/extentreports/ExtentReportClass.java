package com.test.extentreports;

import java.util.Properties;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.parabank.BaseClass;

public class ExtentReportClass extends BaseClass
{
	
	static ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+p.getProperty("extent_location"));
	//static ExtentHtmlReporter reporter = new ExtentHtmlReporter(".//extentReports//htmlLog.html");
	static ExtentReports extent = new ExtentReports();
	static ExtentTest test = null;
	
	public static void extentOperations(ITestResult result)
	{
		extent.attachReporter(reporter);
		test = extent.createTest(result.getName());
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName()+" is failed");
			test.log(Status.FAIL, result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName()+" test is passed successfully");
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName()+" test is skipped");
		}
	//	else if(result.getStatus() == ITestResult.)		
	}
	
	public static void flushExtent()
	{
		extent.flush();
	}
}
