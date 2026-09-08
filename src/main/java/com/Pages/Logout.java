package com.Pages;

import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class Logout {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public Logout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}
	@FindBy(xpath = "(//*[normalize-space()='My Account'])[1]")
	public WebElement myaccountdropdown;
	
	@FindBy(xpath = "(//a[text()='Login'])[1]")
	public WebElement Myaccountlogin;
	
	@FindBy(xpath=" //a[text()='Login']")
	public WebElement loginbutton;

	@FindBy(xpath = " //h2[text()='My Account']")
	public WebElement myaccounttittle;

	@FindBy(xpath = " //h1[text()='Account Logout']")
	public WebElement accountlogoutpage;

	@FindBy(xpath = "//*[@class='caret']")
	public WebElement dropdownbutton;

	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	public WebElement logoutbutton;

	@FindBy(xpath = " //a[text()='Continue']")
	public WebElement continuebutton;
	
	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	public WebElement Rightcoloumlogout;
	
	@FindBy(xpath = "(//a[text()='Register'])[1]")
	public WebElement registerbutton;
	
	@FindBy(xpath = "//h1[text()='Register Account']")
    public WebElement registertitle;
	
	public boolean isregistertitleDisplayed() {
		return elementUtils.isDisplayed(registertitle);
	}
	public boolean MyaccounttittleisDisplayed() {
		return elementUtils.isDisplayed(myaccounttittle);
	}
	 

	public boolean MyaccountlogoutpageisDisplayed() {
		return elementUtils.isDisplayed(accountlogoutpage);
	}

	public void clickDropdownbutton() {
		elementUtils.Click(dropdownbutton);
	}

	public void clicklogoutbutton() {
		elementUtils.Click(logoutbutton);
	}

	public String getHomePageTitle() {
		return driver.getTitle();

	}
	public void clickMyaccountdropdown() {
		elementUtils.Click(myaccountdropdown);
	}
	public void clickmyaccountloginbutton() {
		elementUtils.Click(Myaccountlogin);
	}

	public void clickcontinuebutton() {
		elementUtils.Click(continuebutton);
	}
	public void  ClickRightcoloumlogout() {
		elementUtils.Click(Rightcoloumlogout);
	}
	public boolean isloginDisplayed() {
		return driver.findElements(By.xpath("//a[text()='Login']")).size()>0;
	}
	public boolean isLogoutbuttonisDisplayed() {
		return driver.findElements(By.xpath("(//a[text()='Logout'])[1]")).size()>0;
	}
	public void clickRegisterbutton() {
		elementUtils.Click(registerbutton);
	}
	public boolean isRightcoloumLogoutbuttonisDisplayed() {
		return driver.findElements(By.xpath("(//a[text()='Logout'])[2]")).size()>0;
	}
}