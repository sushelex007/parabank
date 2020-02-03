package com.test.parabank;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestHomePage extends BaseClass
{
	Class<?> className = TestHomePage.class;
	@Test
	public void testCustomerCare()
	{
		WebDriver driver = null;;
		driver = initalizeDriver();
		driver.get(p.getProperty("url"));
		logging(className).info(p.getProperty("url")+" is invoked");
		HomePage home = new HomePage(driver);
		getWait(home.getCustomerCare());
		logging(className).info("after wait");
		home.getCustomerCare().click();
		home.getccName().sendKeys("sushil");
		home.getccEmail().sendKeys("sushelex");
		home.getccPhone().sendKeys("8871776327");
		home.getccMessage().sendKeys("hi hello how are you!!!!");
		getAction().moveToElement(home.getSendBtn()).build().perform();
		logging(className).info("Action class action is used");
		getSleep(3);
		home.getSendBtn().click();
		logging(className).info("send button is clicked");
	}

	/*
	 * Verify the About us functionality is working and when click the icon, it shows the right message
	 */
	@Test(enabled = false)
	public void testAboutUs() throws Exception
	{
		String msg = "ParaBank is a demo site used for demonstration ";
		if(driver==null)
		{
			WebDriver driver = initalizeDriver();
			driver.get(p.getProperty("url"));
			logging(className).info(p.getProperty("url"));
			HomePage home = new HomePage(driver);
			home.getAbout().click();
			String displayedTexts = home.getDisplayedMsg().getText();
			logging(className).warn(displayedTexts);
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