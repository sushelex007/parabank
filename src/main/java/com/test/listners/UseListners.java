package com.test.listners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.*;
import org.apache.commons.io.FileUtils;

import com.test.parabank.BaseClass;

public class UseListners implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("in onTestFailure method");
		BaseClass base = (BaseClass)result.getInstance();
		WebDriver driver = base.driver;
		String method = result.getName().toString().trim();
		takeScreenshot(driver, method);
		
	}

	public void takeScreenshot(WebDriver driver, String method) {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+method+".png"));
		} catch (IOException e) {
			System.out.println("unable to take screenshot");
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("this is start of method");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
