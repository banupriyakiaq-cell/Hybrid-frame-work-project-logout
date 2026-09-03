package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_007steps {
	Register register;
	@Given("user is on register form page")
	public void user_is_on_register_form_page() {
	    register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();

	}
	@Then("password confirmation warning message should be displayed")
	public void password_confirmation_warning_message_should_be_displayed() {
		String message=register.getEmailValidationMessage();
	     System.out.println("Email Validation Message:"+message);
	     Assert.assertTrue(message.isEmpty(),"invalid email validation message is not displayed");
 
}
}