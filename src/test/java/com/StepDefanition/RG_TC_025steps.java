package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_025steps {

Register register;
	@Given("user is on the register page verify functionality environment")
	public void user_is_on_the_register_page_verify_functionality_environment() {
		register=new Register(DriverFactory.getDriver());
	    register.clickMyaccountbuton();
	    register.clickRegisterbutton();   
	}
	@Then("Register account functionality should work in all supported envirnment")
	public void register_account_functionality_should_work_in_all_supported_envirnment() {
	     Assert.assertTrue(register.isRegisterFunctionalityWorking(),"Register Account functionality is not working properly");
	}

}
