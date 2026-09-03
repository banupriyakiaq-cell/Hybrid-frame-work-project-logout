package com.StepDefanition;

import java.util.List;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_010steps {
	Register register;
	@Given("user is on the register account page for invalid Phone number")
	public void user_is_on_the_register_account_page_for_invalid_phone_number() {
		 register= new Register(DriverFactory.getDriver());
		    register.clickMyaccountbuton();
		    register.clickRegisterbutton();
	}

	@Given("user enter the  unique mail field")
	public void user_enter_the_unique_mail_field() {
		 register = new Register(DriverFactory.getDriver());

	     String email="banu"+System.currentTimeMillis()+"@gamil.com";
	     System.out.println("Unique Email:"+email);
	     register.enterMailid(email);
	}
	@Given("user enter the invalid {string} in mobileno field")
	public void user_enter_the_invalid_in_mobileno_field(String string) {
	    register.enterMobileno(string);
	}

	@Then("invalid  phone number warning message should be displayed")
	public void invalid_phone_number_warning_message_should_be_displayed() {
	     List<String>messages=register.getWarningMessage();
	     System.out.println("Phone Validation Message:"+messages);
	     Assert.assertFalse(messages.isEmpty(),"invalid phone number message is not displayed");
	}


	 

}
