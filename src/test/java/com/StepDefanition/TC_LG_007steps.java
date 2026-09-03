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

public class TC_LG_007steps {
	Logout logoutpage;
	@Given("user is logged in loginpage again")
	public void user_is_logged_in_loginpage_again() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		 

		login loginpage = new login(DriverFactory.getDriver());
	   
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
	   loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
		logoutpage=new Logout(DriverFactory.getDriver());

	   Assert.assertTrue(logoutpage.MyaccounttittleisDisplayed(),"User is not logged in");
	}

	@When("user click on my account dropdown button again")
	public void user_click_on_my_account_dropdown_button_again() {
	    logoutpage. clickDropdownbutton();
	}

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() {
	     logoutpage.clickDropdownbutton();
	}

	@Then("user should be logged out")
	public void user_should_be_logged_out() {
	    Assert.assertTrue(logoutpage.isloginDisplayed(),"user is still logged in");
	}
}
