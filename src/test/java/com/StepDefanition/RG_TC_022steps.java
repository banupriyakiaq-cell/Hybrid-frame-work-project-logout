package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_022steps {
	Register register;
	
	@Given("user is on register page verified confirm password field")
	public void user_is_on_register_page_verified_confirm_password_field() {
		register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();
	}
	@Then("user confirm password field not enter details")
	public void user_confirm_password_field_not_enter_details() {
	   register.enterconfirmPassword("");
	}
	@Then("the warning message should be display")
	public void the_warning_message_should_be_display() {
	     String actualMessage  = register.getwarningconfirmmessage();
	     Assert.assertEquals(actualMessage,"Password cinfirmation does not match password!","Warning message is not displayed correctly");
	}

}
 