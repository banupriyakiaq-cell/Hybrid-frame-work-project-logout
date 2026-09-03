package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_014steps {
Register register;

	@Given("user is on register form page validate database")
	public void user_is_on_register_form_page_validate_database() {
	     register=new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	}
	@When("user enter all account details")
	public void user_enter_all_account_details() {
	     register.enterFirstname("banu");
	     register.enterlastname("priya");
	     register.enterMailid("banu"+System.currentTimeMillis()+"@gmail.com");
	     register.enterMobileno("9965678687");
	     register.enterPassword("Banu@12345");
	     register.enterconfirmPassword("Banu@12345");
	     
	}
	@When("user select the privacy policy agree checkbox")
	public void user_select_the_privacy_policy_agree_checkbox() {
	 register. selectPrivacyPoliceUsingKeyboard();
	}
	
	@When("user click the continue button in register page")
	public void user_click_the_continue_button_in_register_page() {
	     register.clickContinueUsingKeyboared();
	}
	@Then("user should navigate to account success page")
	public void user_should_navigate_to_account_success_page() {
	    String currentUrl =register.getCurrentUrl();
	    System.out.println("Current URL:"+currentUrl);
	    Assert.assertTrue(currentUrl.contains("route=account/success"),"User is not navigate to account page");
	}
	@Then("account details should be stored in the database")
	public void account_details_should_be_stored_in_the_database() {
		 String currentUrl =register.getCurrentUrl();
		    System.out.println("Current URL:"+currentUrl);
		    Assert.assertTrue(currentUrl.contains("route=account/success"),"Account registration was not successfull");
		    System.out.println("Account registration succesfull");
		    System.out.println("Account details have been submitted successfully");
	}


}
