package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Logout;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_LG_006steps {
Logout logoutpage;
	@Given("user is not loggedi in")
	public void user_is_not_loggedi_in() {
	   DriverFactory.getDriver().get(ConfigReader.getProperty("url")); 
		logoutpage=new Logout(DriverFactory.getDriver());

	}

	@When("user click the myaccount dropdown")
	public void user_click_the_myaccount_dropdown() {
	    logoutpage. clickDropdownbutton();
	}

	@When("user click the register button")
	public void user_click_the_register_button() {
	    logoutpage.clickRegisterbutton();
	}

	@When("user checks the right column options")
	public void user_checks_the_right_column_options() {
	    Assert.assertTrue(logoutpage.isregistertitleDisplayed());
	}

	@Then("logout option should not be displayed in the Right column")
	public void logout_option_should_not_be_displayed_in_the_right_column() {
	     Assert.assertFalse(logoutpage.isRightcoloumLogoutbuttonisDisplayed(),"Logout option is displayed in right column");
	}



}
