package com.test.parabank;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.test.extentreports.ExtentReportClass;

public class PracticeClass2 extends BaseClass 
{
	Class<?> className = TestAdminPage.class;
	@Test(enabled=true)
	public void triggerBrowser() throws Exception, IOException {
		WebDriver driver = initalizeDriver();
		driver.get(p.getProperty("url"));
		HomePage home = new HomePage(driver);
		home.getAdminPage().click();
		
	}
	
	@Test(dependsOnMethods= {"triggerBrowser"}, enabled=true)
	//@Test
	public void testAccessMode() throws InterruptedException 
	{
		WebElement ele;
		AdminPage admin = new AdminPage(driver);
		List<WebElement> radios = admin.getRadios();
		Iterator<WebElement> element= getIterators(radios);
		logging(className).info("radio buttons extracted as a List and iterator is defined");
		while(element.hasNext())
		{
			ele = element.next();
			waitNow(10);
			ele.click();
		}
	}
	
	@AfterMethod
	public void extentOperations(ITestResult result) throws Exception
	{
		
		ExtentReportClass.extentOperations(result);
		ExtentReportClass.flushExtent();
	}
}
