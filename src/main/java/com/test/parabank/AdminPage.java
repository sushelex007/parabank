package com.test.parabank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage 
{
	WebDriver driver;
	AdminPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(d, this);		
	}
	
	@FindBy(xpath="//button[@value='INIT']")
	WebElement initialize;
	
	@FindBy(xpath="//button[@value='CLEAN']")
	WebElement clean;
	
	@FindBy(xpath="//input[@value='Startup']")
	WebElement startup;
	
	@FindBy(xpath="//table[@class='form']/tbody/tr/td/input")
	WebElement accessMode;
	
	@FindBy(xpath="//tr/td/a[2]/preceding-sibling::a")
	WebElement wsdl;
	
	@FindBy(xpath="//tr/td/a[2]")
	WebElement wadl;
	
	@FindBy(xpath="//tr/td/a[3]")
	WebElement swagger;
	
	@FindBy(css="#loanProvider")
	WebElement loanProvider;
	
	@FindBy(css="#loanProcessor")
	WebElement loanProcessor;
	
	@FindBy(css="#loanProcessorThreshold")
	WebElement threshold;
	
	@FindBy(xpath="//div/p/b")
	WebElement initialMessage;
	
	public WebElement getInitialMessage()
	{
		return initialMessage;
	}
	
	public WebElement getThreshold()
	{
		return threshold;
	}
	
	public WebElement getLoanProvider()
	{
		return loanProvider;
	}
	
	public WebElement getLoanProcessor()
	{
		return loanProcessor;
	}
	
	public WebElement getSwagger()
	{
		return swagger;
	}
	
	public WebElement getWadl() {
		return wadl;
	}
	
	public WebElement getWsdl()
	{
		return wsdl;
	}
	
	public WebElement getStartup()
	{
		return startup;
	}
	
	public WebElement getClean()
	{
		return clean;
	}
	public WebElement getInitialize()
	{
		return initialize;
	}
}