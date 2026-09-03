package com.StepDefanition;

import java.util.List;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_003steps {
	Register register;
	@Given("user is on the register account")
	public void user_is_on_the_register_account() {
	     register = new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	     
	}

	@When("user leaves all mandatory fields empty")
	public void user_leaves_all_mandatory_fields_empty() {
	    
	}

	@When("user click on continue button")
	public void user_click_on_continue_button() {
	     register.clickContinuebutton();
	}

	@Then("warning message should be displayed")
	public void warning_message_should_be_displayed() {
	     List<String> messages = register.getWarningMessage();
	     for(String message : messages) {
	    	 System.out.println("Warning Message:"+message);
	     }
	}

}