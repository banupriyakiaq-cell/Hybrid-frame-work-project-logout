package com.StepDefanition;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.Logout;
import com.Pages.login;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_LG_003steps {
	@Given("user is logged in loginpage")
	public void user_is_logged_in_loginpage() {
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		 

		login loginpage = new login(DriverFactory.getDriver());
	   
		loginpage.clickdropdownbutton();
		loginpage.clickdropdownloginbutton();
		loginpage.doLogin(ConstantUtils.EMAILID, ConstantUtils.PASSWORD);
	}

	@When("user closes the browser without logging out")
	public void user_closes_the_browser_without_logging_out() {
	    DriverFactory.getDriver().close();
	}

	@When("user opens the browser and navigates to application")
	public void user_opens_the_browser_and_navigates_to_application() {
	    DriverFactory driverFactory=new DriverFactory();
	    driverFactory.init_driver(ConfigReader.getProperty("browser"));
	    DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
	}

	@Then("user should be remain logged in")
	public void user_should_be_remain_logged_in() {
	     Logout logoutpage=new Logout(DriverFactory.getDriver());
	     logoutpage.clickDropdownbutton();
	     
	     Assert.assertTrue(logoutpage.isloginDisplayed(),"User is logged out after reopening browser");
	}


}
