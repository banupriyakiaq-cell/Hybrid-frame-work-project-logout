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

public class TC_LG_001steps {
	 
Logout lo;

	@Given("user is logged in")
	public void user_is_logged_in() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	 

		login loginpage = new login(DriverFactory.getDriver());
	   
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
	  lo=loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
	}

	@When("user clicks on my account dropdown")
	public void user_clicks_on_my_account_dropdown() {
	     lo.clickDropdownbutton();
	}

	@When("user clicks on Logout option")
	public void user_clicks_on_logout_option() {
	    lo.clicklogoutbutton();
	}

	@Then("user should be navigated to Account Logout page")
	public void user_should_be_navigated_to_account_logout_page() {
	     Assert.assertTrue(lo.MyaccountlogoutpageisDisplayed(),"Account Logout page is not displayed");
	}

	@When("user clicks on contionue button")
	public void user_clicks_on_contionue_button() {
	    lo.clickcontinuebutton();
	}

	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		String actualTitle=lo.getHomePageTitle();
	     Assert.assertEquals(actualTitle,"Your Store","user is not home page");
	}


}
