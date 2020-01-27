package com.test.parabank;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestHomePage extends BaseClass
{
	@Test
	public void testCustomerCare() throws IOException
	{
		WebDriver driver = initalizeDriver();
		driver.get(p.getProperty("url"));
		
		HomePage home = new HomePage(driver);
		getWait(home.getCustomerCare());
		home.getCustomerCare().click();
		home.getccName().sendKeys("sushil");
		home.getccEmail().sendKeys("sushelex");
		home.getccPhone().sendKeys("8871776327");
		home.getccMessage().sendKeys("hi hello how are you!!!!");
		getAction().moveToElement(home.getSendBtn()).build().perform();
		getSleep(3);
		home.getSendBtn().click();
	}
	
	@Test
	public void testAboutUs() throws Exception
	{
		String msg = "ParaBank is a demo site used for demonstration of Parasoft software solutions. \nAll materials herein are used solely for simulating a realistic online banking website.";
		if(driver==null)
		{
			WebDriver driver = initalizeDriver();
			driver.get(p.getProperty("url"));
			HomePage home = new HomePage(driver);
			home.getAbout().click();
			String displayedTexts = home.getDisplayedMsg().getText();
			System.out.println("msg"+ msg);
			System.out.println("displayedTexts"+displayedTexts.trim());
			Assert.assertEquals(msg.trim(), displayedTexts);
			
		}
	}


@AfterSuite
public void quiteBrowser()
{
	System.out.println("suite completed, closing the browser");
	driver.close();
}

}