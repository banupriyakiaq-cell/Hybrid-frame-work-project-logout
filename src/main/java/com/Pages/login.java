package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

public class login {
	private final WebDriver driver;
	private ElementUtils elementUtils;

	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}
	@FindBy(xpath = "//*[@class='caret']")
	public WebElement dropdownbutton;
	
	@FindBy(xpath = " (//a[text()='Login'])[1]")
	public WebElement dropdownloginbutton;
	
	@FindBy(id = "input-email")
	public WebElement emailfield;
	
	@FindBy(id="input-password")
	public WebElement passwordfield;
	
	@FindBy(xpath = "//*[@value='Login']")
	public WebElement loginbutton;
	
	
	public void clickdropdownbutton() {
		elementUtils.Click(dropdownbutton);
	}
	public void clickdropdownloginbutton() {
		elementUtils.Click(dropdownloginbutton);
	}

	public String getHomePageTitle() { 
		return driver.getTitle();

	}
	public String getAccountLoginPageTitle() { 
		return driver.getTitle();

	}
	
	public void entermailid(String emailValue) {
		elementUtils.sendKeys(emailfield, emailValue);
	}
	public void entrepassword(String passwordValue) {
		elementUtils.sendKeys(passwordfield, passwordValue);
	}
	
	public Logout clicklogin() {
		elementUtils.Click(loginbutton);
		return new Logout(driver);
	}
	public  Logout doLogin(String  emailValue, String passwordValue) {
		elementUtils.sendKeys(emailfield,emailValue);
		elementUtils.sendKeys(passwordfield, passwordValue);
		elementUtils.Click(loginbutton);
		
		 
		return new Logout(driver);
		
	}
}
