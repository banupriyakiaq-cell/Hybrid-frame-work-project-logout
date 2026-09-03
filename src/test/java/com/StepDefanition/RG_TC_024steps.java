package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_024steps {
	Register register;
	@Given("user is on the register page verify UI")
	public void user_is_on_the_register_page_verify_ui() {
		register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton(); 
	}
	@Then("propre and good UI should be displayed on the register account page")
	public void propre_and_good_ui_should_be_displayed_on_the_register_account_page() {
	     Assert.assertTrue(register.isRegisterPageUIDisplayed(),"Register Account page UI is not displayed properly");
	}

}
