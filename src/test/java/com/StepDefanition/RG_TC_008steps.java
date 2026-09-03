package com.StepDefanition;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_008steps {
Register register;
	@Given("user is on the register account page for existing mail")
	public void user_is_on_the_register_account_page_for_existing_mail() {
	    register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();
	}
	@When("user enter the  existing mail field")
	public void user_enter_the_existing_mail_field() {
	     register.enterMailid("banupriya.kiaq@gamil.com");
	}
	@Then("exciding email warning message should be displayed")
	public void exciding_email_warning_message_should_be_displayed() {
	    String emailerrormsg=register.getEmailerrorMessage();
	    System.out.println("Email Error Message:"+emailerrormsg);
	    register.getEmailerrorMessage();
	}


}
