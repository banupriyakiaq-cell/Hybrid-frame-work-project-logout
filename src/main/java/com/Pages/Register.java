package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.ElementUtils;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class Register {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public Register(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// homepage
	@FindBy(xpath = "(//*[normalize-space()='My Account'])[1]")
	public WebElement Myaccountbutton;

	@FindBy(xpath = "//a[text()='Register']")
	public WebElement Registerbutton;

	// Registerpaged

	@FindBy(xpath = "//*[text()='New Customer']")
	public WebElement loginPagetitle;

	@FindBy(xpath = "//h1[text()='Register Account']")
	public WebElement Registerpagetitle;

	@FindBy(id = "input-firstname")
	public WebElement firstname;

	@FindBy(id = "input-lastname")
	public WebElement lastname;

	@FindBy(id = "input-email")
	public WebElement mailid;

	@FindBy(id = "input-telephone")
	public WebElement telephone;

	@FindBy(id = "input-password")
	public WebElement password;

	@FindBy(id = "input-confirm")
	public WebElement confirmpassword;

	@FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	public WebElement radiobuttonNo;

	@FindBy(xpath = "//*[@name='agree']")
	public WebElement radiobuttonAgree;

	@FindBy(xpath = "//*[@value='Continue']")
	public WebElement continuebutton;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	public WebElement accountsuccesspagetitle;

	@FindBy(xpath = "//a[text()='Continue']")
	public WebElement AcSuccesscontinuebutton;

	@FindBy(xpath = "//*[@class='text-danger']")
	public List<WebElement> errormessage;

	@FindBy(xpath = "//*[text()='Yes']")
	public WebElement radiobuttonyes;

	@FindBy(xpath = "(//*[text()='Login'])[1]")
	public WebElement loginbutton;

	@FindBy(xpath = "//*[text()='Continue']")
	public WebElement newcustomercontinuebutton;

	@FindBy(xpath = "(//a[text()='Register'])[2]")
	public WebElement loginpageregisterpage; 
	
	@FindBy(xpath = "//*[text()='Password confirmation does not match password!']")
	public WebElement passworderrormessage;
	
	@FindBy(xpath = "//*[text()='Warning: E-Mail Address is already registered!']")
	public WebElement EmailErorrMessage;
	
	@FindBy(xpath = "//div[contains(@class,'form-group') and contains(@class,'required')]")
	public List<WebElement> mandatoryfield;
	
	@FindBy(xpath = " //*[@name='telephone']/following-sibling::div[contains(@class,'text-danger')]")
	public List<WebElement> telephoneerror;
	
	@FindBy(xpath = "(//*[text()='Login'])[2]")
	public WebElement loginrightcolunm;
	
	@FindBy(xpath = "//*[text()='Password confirmation does not match password!']")
	public WebElement confirmpassworderror;
	
	@FindBy(xpath = "//ul[@class='breadcrumb']")
	public WebElement registerBreadcrumb;
	
	// homepage
	public void clickLoginButton() {
		elementUtils.Click(loginbutton);
	}

	public void clickMyaccountbuton() {
		elementUtils.Click(Myaccountbutton);
	}

	public void clickRegisterbutton() {
		elementUtils.Click(Registerbutton);
	}

	public String getHomePageTitle() {
		return driver.getTitle();

	}

	// Registerpage
	public String getLoginpagetitle() {
		return loginPagetitle.getText();
	}

	public String getRegisterpagetitle() {
		return Registerpagetitle.getText();
	}

	public void enterFirstname(String firstNamevalue) {
		elementUtils.sendKeys(firstname, firstNamevalue);
	}

	public void enterlastname(String lastNamevalue) {
		elementUtils.sendKeys(lastname, lastNamevalue);
	}

	public void enterMailid(String mailIdvalue) {
		elementUtils.sendKeys(mailid, mailIdvalue);
	}

	public void enterMobileno(String mobileNovalue) {
		elementUtils.sendKeys(telephone, mobileNovalue);
	}

	public void enterPassword(String Passwordvalue) {
		elementUtils.sendKeys(password, Passwordvalue);
	}

	public void enterconfirmPassword(String confirmPassword) {
		elementUtils.sendKeys(confirmpassword, confirmPassword);
	}

	public void clickradiobuttonNO() {
		elementUtils.Click(radiobuttonNo);

	}

	public void clickradiobuttonAgree() {
		elementUtils.Click(radiobuttonAgree);

	}

	public void clickContinuebutton() {
		elementUtils.Click(continuebutton);
	}

	public boolean isAccountsuccesspageDisplayed() {
		return accountsuccesspagetitle.isDisplayed();
	}

	public void clickAcsuccesscontinuebutton() {
		elementUtils.Click(AcSuccesscontinuebutton);
	}

	public List<String> getWarningMessage() {
		List<String> messages = new ArrayList<>();
		for (WebElement element : errormessage) {
			messages.add(element.getText());
		}
		return messages;
	}

	public void ClickRadiobuttonYes() {
		elementUtils.Click(radiobuttonyes);
	}

	public void ClickNewcustomercontinuebutton() {
		elementUtils.Click(newcustomercontinuebutton);
	}

	public void clickloginregisterpage() {
		elementUtils.Click(loginpageregisterpage);

	}

	public String getPassworderrorMessage() {
		return elementUtils.getText(passworderrormessage);
	}

	public String getEmailerrorMessage() {
		return elementUtils.getText(EmailErorrMessage);
	}

	public String getEmailValidationMessage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].validationMessage;", mailid);

	}

	public void selectSubscribeUsingKeyboard() {
		radiobuttonNo.sendKeys(Keys.SPACE);
	}

	public void selectPrivacyPoliceUsingKeyboard() {
		radiobuttonAgree.sendKeys(Keys.SPACE);
	}

	public void clickContinueUsingKeyboared() {
		continuebutton.sendKeys(Keys.ENTER);
	}

	public   void enterAllAccountDetailsUsingKeyboard() {
		firstname.sendKeys("banu");
		lastname.sendKeys("priya");
		mailid.sendKeys("banu" + System.currentTimeMillis() + "@gmail.com");
		telephone.sendKeys("9965678687");
		password.sendKeys("Banu@12345");
		confirmpassword.sendKeys("Banu@12345");
	}
	public boolean verifyRegisterFieldPlaceholders() {
		String firstName=firstname.getAttribute("placeholder");
		String lastName=lastname.getAttribute("placeholder");
		String email=mailid.getAttribute("placeholder");
		String telephoneValue=telephone.getAttribute("placeholder");
		String passwordValue=password.getAttribute("placeholder");
		String confirmPassword=confirmpassword.getAttribute("placeholder");
		System.out.println("First Name:"+firstName);
		System.out.println("Last Name:"+lastName);
		System.out.println("E-Mail:"+email);
		System.out.println("Telephone:"+telephoneValue);
		System.out.println("Password:"+passwordValue);
		System.out.println("Confirm Password:"+confirmPassword);
		return firstName.equals("First Name")&&lastName.equals("Last Name")&&email.equals("E-Mail")&&telephoneValue
				.equals("Telephone")&&passwordValue.equals("Password")&&confirmPassword.equals("Password Confirm");}

		public boolean areMandatoryFieldsMarked() {
			return  mandatoryfield.size()==7;
 		}
		public String getCurrentUrl() {
			return driver.getCurrentUrl();
		}
		public boolean isTelephoneErrorisDisplayed  () {
			return !telephoneerror.isEmpty();
		}
		public String getTelephoneValue() {
			return telephone.getAttribute("value");
			}
		public boolean verifyRegisterFieldRequirements() {
			return firstname.isDisplayed()&&lastname.isDisplayed()&&
				mailid.isDisplayed()&&telephone.isDisplayed()&&password.isDisplayed()&&
				confirmpassword.isDisplayed();
		}
		public boolean isPrivacyPolicySelected() {
			return radiobuttonAgree.isSelected();
		}
		public String getPasswordfieldType() {
			return password.getAttribute("type");
		}
		public String getConfirmPasswordfieldType() {
			return  confirmpassword.getAttribute("type");
		}
		public void  clickLoginRightColunm() {
			elementUtils.Click(loginrightcolunm);
		}
		public String getwarningconfirmmessage() {
			return confirmpassworderror.getText();
		}
		public boolean isRegisterBreadcrumbDisplayed() {
			return registerBreadcrumb.isDisplayed();
		}
		public boolean isRegisterPageUIDisplayed() {
			return Registerpagetitle.isDisplayed()
					&&firstname.isDisplayed()
					&&lastname.isDisplayed()
					&&mailid.isDisplayed()
					&&telephone.isDisplayed()
					&&password.isDisplayed()
					&&confirmpassword.isDisplayed()
					&&radiobuttonNo.isDisplayed()
					&&continuebutton.isDisplayed();
		}
		public boolean isRegisterFunctionalityWorking() {
			return Registerpagetitle.isDisplayed()
					&&firstname.isDisplayed()
					&&lastname.isDisplayed()
					&&mailid.isDisplayed()
					&&telephone.isDisplayed()
					&&password.isDisplayed()
					&&confirmpassword.isDisplayed()
					&&radiobuttonNo.isDisplayed()
					&&continuebutton.isDisplayed();
		}
 
}

