package com.test.parabank;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class PracticeClass extends BaseClass 
{
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	@BeforeTest
	public void test1() 
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"extentReports/testExtentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS",System.getProperty("os.name"));
		extent.setSystemInfo("browser", p.getProperty("browser"));
		//htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
       // htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		System.out.println("this is done");
	}
    @Test
    public void test2()
    {
    	test = extent.createTest("TC#1 PASS", "test case 1 passed");
    	Assert.assertEquals(true, true);
    }
    @Test
    public void test3()
    {
    	test = extent.createTest("TC#2 Fail", "TC#2 is failed");
    	Assert.assertEquals(true, false);
    }
    
    @AfterMethod
    public void aftermethod(ITestResult result)
    {
    	if(result.getStatus() == ITestResult.FAILURE)
    	{
    		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
    	}
    	else if(result.getStatus() == ITestResult.SUCCESS)
    	{
    		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.CYAN));
    	}
    }
    
    @AfterTest
    public void teraDown()
    {
    	extent.flush();
    	//https://www.seleniumeasy.com/selenium-tutorials/creating-extent-reports-in-selenium-example
    }
    
    
}
