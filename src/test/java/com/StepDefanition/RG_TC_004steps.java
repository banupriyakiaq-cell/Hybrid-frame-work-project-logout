package com.StepDefanition;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;

public class RG_TC_004steps {
	 Register register;
	@Given("user is on the registeraccount page")
	public void user_is_on_the_registeraccount_page() {
		register = new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	}

	@Given("user click the scbscribe checkbox yes option")
	public void user_click_the_scbscribe_checkbox_yes_option() {
	    register.ClickRadiobuttonYes();
	}

}
