package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_019steps {
	Register register;
	@Given("user is on the register account page checkbox validation")
	public void user_is_on_the_register_account_page_checkbox_validation() {
		register=new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	}

	@Then("Privacy police checkbox should not be selected by default")
	public void privacy_police_checkbox_should_not_be_selected_by_default() {
	     Assert.assertFalse(register.radiobuttonAgree.isSelected(),"Privacy Policy checkbox is selected by default");
	     
	}

}
