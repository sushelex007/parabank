package com.test.parabank;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class TestAdminPage extends BaseClass
{
	
	@Test(enabled=true)
	public void triggerBrowser() throws Exception, IOException {
		WebDriver driver = initalizeDriver();
		driver.get(p.getProperty("url"));
		HomePage home = new HomePage(driver);
		home.getAdminPage().click();
		
	}
	@Test(enabled=false)
	public void adminTest() throws Exception
	{
		WebDriver driver = initalizeDriver();
		driver.get(p.getProperty("url"));
//		log.info("url "+p.getProperty("url"+" is triggered"));
		HomePage home = new HomePage(driver);
		home.getAdminPage().click();
		AdminPage admin = new AdminPage(driver);
		admin.getInitialize().click();
		String initalMessage=admin.getInitialMessage().getText();
		initalMessage = initalMessage.trim();
		Assert.assertEquals(initalMessage, p.getProperty("initial_message").trim());
		System.out.println(initalMessage);
		admin.getClean().click();
		String clean_message = admin.getInitialMessage().getText().trim();
		Assert.assertEquals(clean_message, p.getProperty("clean_message"),"clean message is not correct");
		admin.getStartup().click();
		String startup = admin.getJmsStatus().getText().trim();
		Assert.assertEquals(startup, p.getProperty("startup_status"));
		admin.getStartup().click();
		startup = admin.getJmsStatus().getText().trim();
		Assert.assertEquals(startup, p.getProperty("shutdown_status"), "startup button is not working");
	}
	
	@Test(dependsOnMethods= {"triggerBrowser"}, enabled=false)
	public void testAccessMode() throws InterruptedException 
	{
		WebElement ele;
		AdminPage admin = new AdminPage(driver);
		List<WebElement> radios = admin.getRadios();
		Iterator<WebElement> element= getIterators(radios);
		while(element.hasNext())
		{
			ele = element.next();
			//Thread.sleep(1000);
			System.out.println("Hi.."+ele.getText());
			waitNow(10);
			ele.click();
		}
	}
	@Test(dependsOnMethods= {"triggerBrowser"})
	public void testWebService()
	{
		AdminPage admin = new AdminPage(driver);
		String link = admin.getWsdl().getAttribute("href");
		boolean linkStatus = utility.checkBrokenLink(link);
		System.out.println(link);
		Assert.assertEquals(linkStatus, true, "link is broken");
	}
	
	@AfterSuite
	public void cleanUp()
	{
		driver.close();
	}
	
	
	
}
