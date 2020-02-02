package com.test.parabank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.utilities.BasicUtilities;





public class BaseClass{
	public static WebDriver driver;
	public static Properties p= new Properties();
	BasicUtilities utility = new BasicUtilities();
	static Logger log = LogManager.getLogger(BaseClass.class);
	public WebDriver initalizeDriver()
	{
		String os = System.getProperty("os.name");
		FileInputStream fis = null;
		os = os.toLowerCase();
		if(os.contains("window"))
		{
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\properties\\property.properties");
			} catch (FileNotFoundException e) {
				
				log.error(e.getMessage());
			}
		}
		
		else if(os.contains("mac"))
		{
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"/properties/property.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
			System.out.println(System.getProperty("user.dir")+"/properties/property.properties");
		}
		
		else
		{
			throw new RuntimeException("do not support except mac os and windows");
		}
		
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
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
	
	public Iterator<WebElement> getIterators(List<WebElement> elements)
	{
		Iterator<WebElement> itr = elements.iterator();
		return itr;
	}
	
	public void waitNow(int duration)
	{
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
}









