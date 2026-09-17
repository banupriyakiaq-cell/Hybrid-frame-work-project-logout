package com.StepDefanition;

import org.testng.Assert;

import com.Pages.login;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstep {
	private static String title;
	private login lg =new login(DriverFactory.getDriver());
		
	 

	@Given("user is on homepage")
	public void user_is_on_homepage() {
	     String actualTitle=lg.getHomePageTitle();
	     Assert.assertEquals(actualTitle,"Your Store","user is not home page");
	}

	@When("user click on my account dropdown")
	public void user_click_on_my_account_dropdown() {
	    lg.clickdropdownbutton(); 
	}

	@When("user click the login button in dropdown")
	public void user_click_the_login_button_in_dropdown(){
	    lg.clickdropdownloginbutton();
	}

	@When("home page navigate to login page")
	public void home_page_navigate_to_login_page() {
	     String actualTitle=lg.getAccountLoginPageTitle();
	     Assert.assertEquals(actualTitle, "Account Login",  "user not navigate to loginpage");
	}

	@When("user enter the emailid {string}")
	public void user_enter_the_emailid(String emailfield) {
	   lg.entermailid(emailfield);
	}

	@When("user enter the password {string}")
	public void user_enter_the_password(String passwordfield) {
	    lg.entrepassword(passwordfield);
	}

	@Then("user click the login button")
	public void user_click_the_login_button() {
	   lg.clicklogin();
	}


}
