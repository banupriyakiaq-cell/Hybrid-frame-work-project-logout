package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_017steps {
Register register;
	@Given("user is on register page")
	public void user_is_on_register_page() {
		register=new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	}

	@Then("user should verify all the fields according to the client requirments")
	public void user_should_verify_all_the_fields_according_to_the_client_requirments() {
	    Assert.assertTrue(register.verifyRegisterFieldRequirements(),"Register Account fields are not according to client requirments");
	}


}
