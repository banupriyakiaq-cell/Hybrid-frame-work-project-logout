package com.StepDefanition;

import org.apache.commons.compress.archivers.sevenz.CLI;
import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RG_TC_006steps {
	Register register;
	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
	    register=new Register(DriverFactory.getDriver());
	}

	@When("user click on my account option")
	public void user_click_on_my_account_option() {
	    register.clickMyaccountbuton();
	}

	@When("user click on register option")
	public void user_click_on_register_option() {
	    register.clickRegisterbutton();
	}

	@When("user should be navigate to register page")
	public void user_should_be_navigate_to_register_page() {
		String title= register.getRegisterpagetitle();
	     System.out.println("Page Title:"+title);
	     Assert.assertEquals(title, "Register Account");
	}

	@When("user again click the my account option")
	public void user_again_click_the_my_account_option() {
	    register.clickMyaccountbuton();
	}

	@When("user click the login option")
	public void user_click_the_login_option() {
		register.clickLoginButton();
  	}

	@When("user should be navigate to login page")
	public void user_should_be_navigate_to_login_page() {
		String title=register.getLoginpagetitle();
	     System.out.println("Page Title:"+title);
	     Assert.assertEquals(title, "New Customer");
 	}

	@When("user click the new customer option")
	public void user_click_the_new_customer_option() {
	     register.ClickNewcustomercontinuebutton();
	}

	@When("user correctly navigate to register page")
	public void user_correctly_navigate_to_register_page() {
		String title= register.getRegisterpagetitle();
	     System.out.println("Page Title:"+title);
	     Assert.assertEquals(title, "Register Account");
	}

	@When("user click the Myaccount page again")
	public void user_click_the_myaccount_page_again() {
	     register.clickMyaccountbuton();
	}

	@When("user click login option again")
	public void user_click_login_option_again() {
	     register.clickLoginButton();
	}

	@When("user navigate to login page")
	public void user_navigate_to_login_page() {
		String title=register.getLoginpagetitle();
	     System.out.println("Page Title:"+title);
	     Assert.assertEquals(title, "New Customer");
	}

	@When("user click the right side column in register button")
	public void user_click_the_right_side_column_in_register_button() {
	     register.clickloginregisterpage();
	}



}
