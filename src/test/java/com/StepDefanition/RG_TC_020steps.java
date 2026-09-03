package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_020steps {
	Register register;
	@Given("user is on the register account page verified password masking")
	public void user_is_on_the_register_account_page_verified_password_masking() {
		register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();
	}
	@When("user enter password in password field")
	public void user_enter_password_in_password_field() {
	     register.enterPassword("Banu@12345");
	}
	@When("user enter confirm password in confirm password field")
	public void user_enter_confirm_password_in_confirm_password_field() {
	     register.enterconfirmPassword("Banu@12345");
	}
	@Then("password text should be hidden in the password field")
	public void password_text_should_be_hidden_in_the_password_field() {
	     Assert.assertEquals(register.getPasswordfieldType(),"password","password field is not hidden");
	}
	@Then("password text should be hidden in the confirm password field")
	public void password_text_should_be_hidden_in_the_confirm_password_field() {
	     Assert.assertEquals(register. getConfirmPasswordfieldType(),"password","password field is not hidden");

	}

}
