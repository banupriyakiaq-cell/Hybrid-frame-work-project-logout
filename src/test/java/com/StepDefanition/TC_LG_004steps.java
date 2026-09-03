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

public class TC_LG_004steps {
	Logout logoutpage;
	@Given("user is on logged in")
	public void user_is_on_logged_in() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		 

		login loginpage = new login(DriverFactory.getDriver());
	   
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
		loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);  
		logoutpage=new Logout(DriverFactory.getDriver());
	}

	@When("user clicks on my account dropdown option")
	public void user_clicks_on_my_account_dropdown_option() {
		logoutpage.clickDropdownbutton();  
	}

	@When("user clicks on Logout option again")
	public void user_clicks_on_logout_option_again() {
	    logoutpage.clicklogoutbutton();
	}

	@When("user click on browser back button")
	public void user_click_on_browser_back_button() {
	     DriverFactory.getDriver().navigate().back();
	}

	@Then("user should not be logged in")
	public void user_should_not_be_logged_in() {
	    Assert.assertFalse(logoutpage.MyaccounttittleisDisplayed(),"user is still logged in after browse back");
	}



}
