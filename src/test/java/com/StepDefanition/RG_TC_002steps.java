package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_002steps {
	Register register;
	
	@Given("user is on the register account page")
	public void user_is_on_the_register_account_page() {
	     register = new Register(DriverFactory.getDriver());
         register.clickMyaccountbuton();
	     register.clickRegisterbutton();
 	}
	@When("user enter the unique mail field")
	public void user_enter_the_unique_mail_field() {
	     register = new Register(DriverFactory.getDriver());

	     String email="banu"+System.currentTimeMillis()+"@gamil.com";
	     System.out.println("Unique Email:"+email);
	     register.enterMailid(email);
	}



	@Then("usershould be navigate to account success page")
	public void usershould_be_navigate_to_account_success_page() {
		String URL=DriverFactory.getDriver().getCurrentUrl();
		System.out.println("Current URL:"+URL);
	    Assert.assertTrue(register.isAccountsuccesspageDisplayed(),"Account success page is not displayed");
	}

	@Then("user click the account success page continue button")
	public void user_click_the_account_success_page_continue_button() {
	     register.clickAcsuccesscontinuebutton();
	}

	@Then("user should be navigate to account page")
	public void user_should_be_navigate_to_account_page() {
		String URL=DriverFactory.getDriver().getCurrentUrl();
		System.out.println("Current URL:"+URL);
	}
		 

}
