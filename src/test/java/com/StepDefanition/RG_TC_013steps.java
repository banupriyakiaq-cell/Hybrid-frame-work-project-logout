package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_013steps {
Register register;
	@Given("user is on the register account page for mandatory fields")
	public void user_is_on_the_register_account_page_for_mandatory_fields() {
	    register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();
	}

	@Then("user should verify all mandatory fields are marked with red color star symbol")
	public void user_should_verify_all_mandatory_fields_are_marked_with_red_color_star_symbol() {
	     Assert.assertTrue(register.areMandatoryFieldsMarked(),"Mandatory fields are not marked properly");
	}



}
