package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Logout;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_LG_005steps {
Logout logoutpage;
	@Given("user is not loged in")
	public void user_is_not_loged_in() {
	    DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	    logoutpage=new Logout(DriverFactory.getDriver());
	}

	@When("user click on my account dropdown button")
	public void user_click_on_my_account_dropdown_button() {
	     logoutpage.clickDropdownbutton();
	}

	@Then("logout option should not be displayed")
	public void logout_option_should_not_be_displayed() {
	     Assert.assertFalse(logoutpage.isLogoutbuttonisDisplayed(),"Logout option is displayed under my account");
	}


}
