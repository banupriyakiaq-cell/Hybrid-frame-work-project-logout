package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Logout;
import com.Pages.login;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_LG_011steps {
	login loginpage;
	Logout logoutpage;
	@Given("user is logged in valid credentials")
	public void user_is_logged_in_valid_credentials() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		loginpage = new login(DriverFactory.getDriver());
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
		loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
		loginpage = new login(DriverFactory.getDriver());
        logoutpage = new Logout(DriverFactory.getDriver());

	}

	@When("user click on my account dropdown method")
	public void user_click_on_my_account_dropdown_method() {
	    logoutpage.clickDropdownbutton();
	}

	@When("click on logout")
	public void click_on_logout() {
	    logoutpage.clicklogoutbutton();
	}

	@When("click on continue button")
	public void click_on_continue_button() {
	   logoutpage.clickcontinuebutton();
	}

	@Then("user should be logged out successfully")
	public void user_should_be_logged_out_successfully() {
	     Assert.assertTrue(logoutpage.isloginDisplayed(),"User is not logged out successfully");
	}

}
