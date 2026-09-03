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

public class TC_LG_010steps {
	Logout logoutpage;
	login loginpage;
	@Given("user logged in login page")
	public void user_logged_in_login_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		loginpage = new login(DriverFactory.getDriver());
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
		loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
		loginpage = new login(DriverFactory.getDriver());
        logoutpage = new Logout(DriverFactory.getDriver());

	}

	@When("user clicks on my account dropdown button")
	public void user_clicks_on_my_account_dropdown_button() {
	     logoutpage.clickDropdownbutton();
	}

	@When("clicks on Logout option")
	public void clicks_on_logout_option() {
	    logoutpage.clicklogoutbutton();
	}

	@Then("logout option UI should be dispaly correctly")
	public void logout_option_ui_should_be_dispaly_correctly() {
	     Assert.assertTrue(logoutpage.MyaccountlogoutpageisDisplayed(),"Logout option UI sholud not display");
	}

}
