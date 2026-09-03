package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_015steps {
Register register;
	@Given("user is on the register page")
	public void user_is_on_the_register_page() {
		register=new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	}

	@Given("user enter spaces in the firstname field")
	public void user_enter_spaces_in_the_firstname_field() {
 	   register.enterFirstname("  ");
	}

	@Given("user enter spaces in lastname field")
	public void user_enter_spaces_in_lastname_field() {
	    register.enterlastname("  ");
	}

	@Given("user enter spaces in the email field")
	public void user_enter_spaces_in_the_email_field() {
	     register.enterMailid("  ");
	}

	@Given("user enter space in the telephone field")
	public void user_enter_space_in_the_telephone_field() {
	     register.enterMobileno( "  ");
	}

	@Given("user enter space in password field")
	public void user_enter_space_in_password_field() {
	     register.enterPassword("  ");
	}

	@Given("user enter space in confirm password field")
	public void user_enter_space_in_confirm_password_field() {
	    register.enterconfirmPassword("  ");
	}

	@Given("user select the privacy policy agree checkbox in register page")
	public void user_select_the_privacy_policy_agree_checkbox_in_register_page() {
	    register.clickradiobuttonAgree();
	}

	@Given("user click the continue button in register page again")
	public void user_click_the_continue_button_in_register_page_again() {
	    register.clickContinuebutton();
	}

	@Then("warning message should be displayed for the mandatory field")
	public void warning_message_should_be_displayed_for_the_mandatory_field() {
		String telephonevalue=register.getTelephoneValue();
		Assert.assertFalse(telephonevalue.trim().isEmpty(),"Telephone field is accepting only space");
 	}



}
