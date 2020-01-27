package com.test.parabank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='headerPanel']/ul[2]/li[1]/a[1]")
	WebElement homeIcon;
	
	@FindBy(xpath="//li[@class='contact']/a")
	WebElement customerCare;
	
	@FindBy(xpath="//div[@id='headerPanel']/ul[2]/li[3]/a[1]")
	WebElement mail;
	
	//@FindBy(css="//table[@class='form2']/tbody/tr[1]/td[2]/input[1]")
	@FindBy(xpath="//*[@id=\"name\"]")
	WebElement ccName;
	
	@FindBy(css="#email")
	WebElement ccEmail;
	
	@FindBy(css="#phone")
	WebElement ccPhone;
	
	@FindBy(css="#message")
	WebElement ccMessage;
	
	@FindBy(css="input[value='Send to Customer Care']")
	WebElement sendBtn;
	
	@FindBy(xpath="//li[@class='aboutus']/a[1]")
	WebElement about;
	
	public WebElement getAbout()
	{
		return about;
	}
	
	public WebElement getSendBtn()
	{
		return sendBtn;
	}
	
	public WebElement getccMessage()
	{
		return ccMessage;
	}
	public WebElement getccPhone()
	{
		return ccPhone;
	}
	
	public WebElement getccEmail()
	{
		return ccEmail;
	}
	
	public WebElement getccName()
	{
		return ccName;
	}
	
	public WebElement getHome()
	{
		return homeIcon;
	}
	
	public WebElement getCustomerCare()
	{
		return customerCare;
	}
	
	public WebElement getMail()
	{
		return mail;
	}
}
