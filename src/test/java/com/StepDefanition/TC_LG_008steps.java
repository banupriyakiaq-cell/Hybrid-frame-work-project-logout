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

public class TC_LG_008steps {
	login loginpage;
	Logout logoutpage;
	@Given("user is logged in again")
	public void user_is_logged_in_again() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		 

	 loginpage = new login(DriverFactory.getDriver());
	   
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
	   loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
		 loginpage = new login(DriverFactory.getDriver());

		logoutpage=new Logout(DriverFactory.getDriver());
		
		Assert.assertTrue(logoutpage.MyaccounttittleisDisplayed(),"user is not logged in");
	}

	@When("the user clicks on my account dropdown")
	public void the_user_clicks_on_my_account_dropdown() {
	    logoutpage.clickDropdownbutton();
	}

	@When("again user clicks on contionue button")
	public void again_user_clicks_on_contionue_button() {
	     logoutpage.clicklogoutbutton();
	     logoutpage.clickcontinuebutton();
	}

	@Then("user should not be logged in again")
	public void user_should_not_be_logged_in_again() {
		Assert.assertTrue(logoutpage.isloginDisplayed(),"user is not logged out");
	}

	@When("user clicks on login dropdown")
	public void user_clicks_on_login_dropdown() {
	     logoutpage.clickMyaccountdropdown();
	}

	@When("user clicks on login option")
	public void user_clicks_on_login_option() {
 	     logoutpage.clickmyaccountloginbutton();
	}

	@When("user enters valid login credentials")
	public void user_enters_valid_login_credentials() {
		loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
	}

	@Then("user should be logged in")
	public void user_should_be_logged_in() {
	   Assert.assertTrue(logoutpage.MyaccounttittleisDisplayed(),"user is not logged in");  
	}



}
