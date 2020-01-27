package com.test.parabank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass{
	public static WebDriver driver;
	public static Properties p= new Properties();
//	Actions act = new Actions(driver);
	public WebDriver initalizeDriver()throws FileNotFoundException, IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/resources/property.properties");
		System.out.println(System.getProperty("user.dir")+"/resources/property.properties");
		p.load(fis);
		String browser = p.getProperty("broswer");
		
		if(browser.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome");
			driver = new ChromeDriver();
		}
		
		else if(browser.equals("geco"))
		{
			driver = new FirefoxDriver();
		}
		else
			driver = new FirefoxDriver();
		return driver;
	}
	
	public void getWait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public Actions getAction()
	{
		Actions action = new Actions(driver);
		return action;
	}
	public void getSleep(int times)
	{
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}









