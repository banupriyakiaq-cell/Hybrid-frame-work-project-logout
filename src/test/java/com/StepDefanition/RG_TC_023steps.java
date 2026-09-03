package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_023steps {
Register register;
	@Given("user is on the register page verify breadcrumb")
	public void user_is_on_the_register_page_verify_breadcrumb() {
		register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();
	}
	@Given("proper breadcrumb should be displayed")
	public void proper_breadcrumb_should_be_displayed() {
	    Assert.assertTrue(register.isRegisterBreadcrumbDisplayed(),"Register page breadcrumb is not displayed");
	}
	@When("proper page headind should be display")
	public void proper_page_headind_should_be_display() {
	    Assert.assertEquals(register.getRegisterpagetitle(),"Register Account","Page heading is not correct");
	}
	 @When("proper page URL should be displayed")
	public void proper_page_url_should_be_displayed() {
	    String url=register.getCurrentUrl();
	    Assert.assertTrue(url.contains("route=account/register"),"Register page Url is not correct");
	}
	@Then("proper page title should be displayed")
	public void proper_page_title_should_be_displayed() {
	    String title = register.getRegisterpagetitle();
	    Assert.assertTrue(title != null && ! title.trim().isEmpty(),"Page title is not displayed");
	}

}
