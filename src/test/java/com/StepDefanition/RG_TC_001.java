package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.Pages.login;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_001 {
	private static String title;
	private  Register rg =new Register(DriverFactory.getDriver());
	
	@Given("user lanuch the application")
	public void user_lanuch_the_application() {
	    rg =new Register(DriverFactory.getDriver());
	    DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	}

	@Then("user click the Myaccount option")
	public void user_click_the_myaccount_option() {
	     rg.clickMyaccountbuton();
	}
	@Then("user click the register option button")
	public void user_click_the_register_option_button() {
		 rg.clickRegisterbutton();
		
	}

	@Then("is should be naviagte to register form page")
	public void is_should_be_naviagte_to_register_form_page() {
	     String title=rg.getRegisterpagetitle();
	     System.out.println("Page Title:"+title);
	     Assert.assertEquals(title, "Register Account");
		
		String URL=DriverFactory.getDriver().getCurrentUrl();
		System.out.println("Current URL:"+URL);
		
	}

	@Then("user enter the {string} in firstname field")
	public void user_enter_the_in_firstname_field(String firstNamevalue) {
	    rg.enterFirstname(firstNamevalue);
	}

	@Then("user enter the {string} in lastname field")
	public void user_enter_the_in_lastname_field(String lastNamevalue) {
	     rg.enterlastname(lastNamevalue);
	}

	@Then("user enter the {string} in mail field")
	public void user_enter_the_in_mail_field(String mailIdvalue) {
	     rg.enterMailid(mailIdvalue);
	}

	@Then("user enter the {string} in mobileno field")
	public void user_enter_the_in_mobileno_field(String mobileNovalue) {
	    rg.enterMobileno(mobileNovalue);
	}

	@Then("user enter the {string} in password field")
	public void user_enter_the_in_password_field(String Passwordvalue) {
	     rg.enterPassword(Passwordvalue);
	}

	@Then("user enter the {string} in confirmpassword field")
	public void user_enter_the_in_confirmpassword_field(String confirmPassword) {
	    rg.enterconfirmPassword(confirmPassword);
	}

	@Then("user click the scbscribe checkbox")
	public void user_click_the_scbscribe_checkbox() {
	    rg.clickradiobuttonNO();
	}

	@Then("user click the privacypolice checkbox")
	public void user_click_the_privacypolice_checkbox() {
	     rg.clickradiobuttonAgree();
	}

	@Then("user click the continue button")
	public void user_click_the_continue_button() {
	    rg.clickContinuebutton();
	}


}
