package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_012steps {
Register register;
	@Given("user is on the register account page for placeholder")
	public void user_is_on_the_register_account_page_for_placeholder() {
		register = new Register(DriverFactory.getDriver());
		register.clickMyaccountbuton();
		register.clickRegisterbutton(); 
	}

	@Then("user should verify the proper placeholders in all register field")
	public void user_should_verify_the_proper_placeholders_in_all_register_field() {
	    Assert.assertTrue(register.verifyRegisterFieldPlaceholders(),"proper placeholder are not displayed");
	}

}
