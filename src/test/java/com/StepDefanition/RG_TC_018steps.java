package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_018steps {
Register register;
	@Given("user is on the register account page field are trimmed")
	public void user_is_on_the_register_account_page_field_are_trimmed() {
		register=new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	}

	@Given("user enter first name with leading and trailling spaces")
	public void user_enter_first_name_with_leading_and_trailling_spaces() {
	    register.enterFirstname(" Banu ");
	}

	@Given("user enter last name with leading and trailling spaces")
	public void user_enter_last_name_with_leading_and_trailling_spaces() {
	     register.enterlastname(" priya ");
	}

	@Given("user enter email with leading and trailling spaces")
	public void user_enter_email_with_leading_and_trailling_spaces() {
	    register.enterMailid(" banu"+System.currentTimeMillis()+"@gmail.com");
	}

	@Given("user enter telephone number with leading and trailling spaces")
	public void user_enter_telephone_number_with_leading_and_trailling_spaces() {
	    register.enterMobileno(" 9965678687 ");
	}

	@Given("user enter password with leading and trailling spaces")
	public void user_enter_password_with_leading_and_trailling_spaces() {
	    register.enterPassword(" Banu@12345 ");
	}

	@Given("user enter  confirm password with leading and trailling spaces")
	public void user_enter_confirm_password_with_leading_and_trailling_spaces() {
	     register.enterconfirmPassword(" Banu@12345 ");
	}

	@Given("user select the privacy policy agree checkbox in register page again")
	public void user_select_the_privacy_policy_agree_checkbox_in_register_page_again() {
	    register.clickradiobuttonAgree();
	}

	@Then("leading and trilling spaces should be trimmed from the entered fields")
	public void leading_and_trilling_spaces_should_be_trimmed_from_the_entered_fields() {
	    String url=register.getCurrentUrl();
	    Assert.assertTrue(url.contains("route=account/success"),"Leading and trailling sapces are not trimmed/account creation failed");
	}



}
