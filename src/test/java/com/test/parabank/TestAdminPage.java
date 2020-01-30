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
	}
	
	@AfterSuite
	public void cleanUp()
	{
		driver.close();
	}
	
	
	
}
