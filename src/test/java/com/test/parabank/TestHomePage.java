package com.test.parabank;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

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
	public void testAbout()
	{
		
	}


@AfterSuite
public void quiteBrowser()
{
	System.out.println("suite completed, closing the browser");
	driver.close();
}

}