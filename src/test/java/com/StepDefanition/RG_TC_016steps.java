package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_016steps {
Register register;
	@Given("user is on the register account page in password field verification")
	public void user_is_on_the_register_account_page_in_password_field_verification() {
		register=new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	}

	@When("user enter valid firstname in the field")
	public void user_enter_valid_firstname_in_the_field() {
	     register.enterFirstname("Banu");
	}

	@When("user enter valid lastname in the field")
	public void user_enter_valid_lastname_in_the_field() {
	    register.enterlastname("priya");
	}

	@When("user enter valid mail in the field")
	public void user_enter_valid_mail_in_the_field() {
	     register.enterMailid("banu"+System.currentTimeMillis()+"@gmail.com");
	}

	@When("user enter valid telephone number in the field")
	public void user_enter_valid_telephone_number_in_the_field() {
	    register.enterMobileno("9878787898");
	}

	@When("user enter simple password in the field")
	public void user_enter_simple_password_in_the_field() {
	     register.enterPassword("12345");
	}

	@When("user enter simple confirm password in the field")
	public void user_enter_simple_confirm_password_in_the_field() {
	   register.enterconfirmPassword("12345");
	}

	@When("user clik the privacy policy agree checkbox")
	public void user_clik_the_privacy_policy_agree_checkbox() {
	     register.clickradiobuttonAgree();
	}

	@When("user click the continue button in simple password verification")
	public void user_click_the_continue_button_in_simple_password_verification() {
	     register.clickContinuebutton();
	}

	@Then("user navigate the account suceess page")
	public void user_navigate_the_account_suceess_page() {
	    String url=register.getCurrentUrl();
	    Assert.assertFalse(url.contains("route=account/success"),"Simple password is accepted without password complexity warning");
	}

}
