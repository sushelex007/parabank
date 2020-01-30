package com.test.parabank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;




public class BaseClass{
	public static WebDriver driver;
	public static Properties p= new Properties();
//	public static Logger log = Logger.getLogger(BaseClass.class.getName());
//	Actions act = new Actions(driver);
//	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	public WebDriver initalizeDriver()throws FileNotFoundException, IOException
	{
		String os = System.getProperty("os.name");
		FileInputStream fis;
		os = os.toLowerCase();
		if(os.contains("window"))
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\property.properties");
		}
		
		else if(os.contains("mac"))
		{
			fis = new FileInputStream(System.getProperty("user.dir")+"/resources/property.properties");
		}
		
		else
		{
			throw new RuntimeException("do not support except mac os and windows");
		}
		
		p.load(fis);
		String browser = p.getProperty("broswer");
		
		if(browser.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chrome");
			if(os.contains("window"))
			{
				if(driver==null)
				{
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
					driver = new ChromeDriver();
				}
			}
			else if(os.contains("mac"))
			{
				if(driver==null)
				{
					driver = new ChromeDriver();
				}
			}
			
			else
			{
				throw new RuntimeException("do not support except mac os and windows");
			}
			
		}
		
		else if(browser.equals("geco"))
		{
			if(os.contains("mac"))
			{
				if(driver==null)
				{
					driver = new FirefoxDriver();
				}
			}
			else if(os.contains("window"))
			{
				if(driver==null)
				{
					System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}
		}
		
		else if(browser.equals("internet explorar"))
		{
			if(os.contains("window"))
			{
				if(driver==null)
				{
					System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\drivers\\MicrosoftWebDriver.exe");
					driver = new EdgeDriver();
				}
			}
			else if(os.contains("mac"))
			{
				if(driver == null)
				{
					driver = new EdgeDriver();
				}
			}
		}
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









