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
	
	/*
	 * Verify the About us functionality is working and when click the icon, it shows the right message
	 */
	@Test
	public void testAboutUs() throws Exception
	{
		String msg = "ParaBank is a demo site used for demonstration ";
		if(driver==null)
		{
			WebDriver driver = initalizeDriver();
			driver.get(p.getProperty("url"));
			HomePage home = new HomePage(driver);
			home.getAbout().click();
			String displayedTexts = home.getDisplayedMsg().getText();
			Assert.assertTrue(displayedTexts.contains(msg));
			
		}
	}


@AfterSuite
public void quiteBrowser()
{
	System.out.println("suite completed, closing the browser");
	driver.close();
}

}