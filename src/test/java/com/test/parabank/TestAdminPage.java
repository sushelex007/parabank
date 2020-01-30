package com.test.parabank;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class TestAdminPage extends BaseClass
{
	
	@Test
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
	
	@AfterSuite
	public void cleanUp()
	{
		driver.close();
	}
	
	
	
}
