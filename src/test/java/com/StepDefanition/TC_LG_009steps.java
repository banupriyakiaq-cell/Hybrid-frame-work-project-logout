package com.StepDefanition;

import javax.security.auth.login.LoginContext;

import org.testng.Assert;

import com.Pages.Logout;
import com.Pages.login;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_LG_009steps {
	Logout logoutpage;
	login loginpage;

	@Given("logged in login page")
	public void logged_in_login_page() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		loginpage = new login(DriverFactory.getDriver());
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
		loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
		loginpage = new login(DriverFactory.getDriver());

		logoutpage = new Logout(DriverFactory.getDriver());

	}

	@When("click on  my account dropdown")
	public void click_on_my_account_dropdown() {
		logoutpage.clickDropdownbutton();
	}

	@When("user clicks on Logout")
	public void user_clicks_on_logout() {
		logoutpage.clicklogoutbutton();
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		logoutpage.clickcontinuebutton();
	}

	@When("account logout page title should be displayed")
	public void account_logout_page_title_should_be_displayed() {
		String actualTitle = logoutpage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store", "Account logout page title is incorrect");
	}

	@Then("Account logout page URL should be display")
	public void account_logout_page_url_should_be_display() {
		String actualURL = DriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(actualURL.contains("common/home"), "Account logout page URL is incorrect");

	}
}