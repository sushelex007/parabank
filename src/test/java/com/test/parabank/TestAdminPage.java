package com.test.parabank;
import java.lang.String;
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
	Class<?> className = TestAdminPage.class;
	@Test(enabled=true)
	public void triggerBrowser() throws Exception, IOException {
		WebDriver driver = initalizeDriver();
		driver.get(p.getProperty("url"));
		HomePage home = new HomePage(driver);
		home.getAdminPage().click();
		
	}
	@Test(enabled=true)
	public void adminTest() throws Exception
	{
		WebDriver driver = initalizeDriver();
		driver.get(p.getProperty("url"));
		logging(className).info("url "+p.getProperty("url"+" is triggered"));
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
	
	@Test(dependsOnMethods= {"triggerBrowser"}, enabled=true)
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
			//Thread.sleep(1000);
			System.out.println("Hi.."+ele.getText());
			waitNow(10);
			ele.click();
		}
	}
	@Test(dependsOnMethods= {"triggerBrowser"}, enabled=false)
	public void testWebService()
	{
		AdminPage admin = new AdminPage(driver);
		
		String link = admin.getWsdl().getAttribute("href");
		boolean linkStatus = utility.checkBrokenLink(link);
		System.out.println(link);
		Assert.assertEquals(linkStatus, true, "link is broken");
	}
	@Test(dependsOnMethods= {"triggerBrowser"})
	public void applicationSettings()
	{
		AdminPage admin = new AdminPage(driver);
		try
		{
			Assert.assertTrue(admin.getInitialBalance().getAttribute("value").equals(p.getProperty("inbal")), "inital value mismatch");
			logging(className).info("initialBalance is-"+admin.getInitialBalance().getAttribute("value"));
		}
		catch(Exception e)
		{
			System.out.println("in catch block");
			logging(className).error(e.getMessage());
		}
		try
		{
			Assert.assertTrue(admin.getMinimumBalance().getAttribute("value").equals(p.getProperty("minbal")), "balance value mismatch");
			logging(className).info("minimum balance-"+admin.getMinimumBalance().getAttribute("value"));
		}
		catch(Exception e)
		{
			logging(className).info(e.getMessage());
		}
	}
	
	@AfterSuite
	public void cleanUp()
	{
		driver.close();
	}
	
	
	
}
