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


  
public class TC_LG_002steps {
	 private Logout rc;

	@Given("user is logged in and is on account page")
	public void user_is_logged_in_and_is_on_account_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		 

		login loginpage = new login(DriverFactory.getDriver());
	   
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
 rc=loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
	}

	@When("user clicks on logout oprion from Right column")
	public void user_clicks_on_logout_oprion_from_right_column() {
	     rc.ClickRightcoloumlogout();
	}

	@Then("user should be navigate to account logout page")
	public void user_should_be_navigate_to_account_logout_page() {
		 Assert.assertTrue(rc.MyaccountlogoutpageisDisplayed(),"Account Logout page is not displayed");
	}

	@When("user click continue button")
	public void user_click_continue_button() {
	     rc.clickcontinuebutton();
	}

	@Then("user should be navigated to home pages")
	public void user_should_be_navigated_to_home_pages() {
		String actualTitle= rc.getHomePageTitle();
	     Assert.assertEquals(actualTitle,"Your Store","user is not home page");
	}



}
