package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_009steps {
Register register;
	@Given("user is on the register account page for invalid mail")
	public void user_is_on_the_register_account_page_for_invalid_mail() {
	    register= new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();
	}

	@Given("user enter the {string} mail field")
	public void user_enter_the_mail_field(String string) {
	     register.enterMailid(string);
	}

	@Then("invalid email warning message should be displayed")
	public void invalid_email_warning_message_should_be_displayed() {
		 String message=register.getEmailValidationMessage();
	     System.out.println("Email Validation Message:"+message);
	     Assert.assertTrue(message !=null && !message.trim().isEmpty(),"invalid email validation message is not displayed");
	}


}
