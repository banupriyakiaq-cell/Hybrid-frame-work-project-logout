package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_021steps {
Register register;
	@Given("user is on the register page verified other link in right coloumn")
	public void user_is_on_the_register_page_verified_other_link_in_right_coloumn() {
		register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();
	}
	@When("user click login option for right coloumn")
	public void user_click_login_option_for_right_coloumn() {
	     register.clickLoginRightColunm();
	}
	@Then("user should be navigate to respective page")
	public void user_should_be_navigate_to_respective_page() {
	     String url=register.getCurrentUrl();
	     
		    Assert.assertTrue(url.contains("route=account/login"),"Leading and trailling sapces are not trimmed/account creation failed");
	}

}
