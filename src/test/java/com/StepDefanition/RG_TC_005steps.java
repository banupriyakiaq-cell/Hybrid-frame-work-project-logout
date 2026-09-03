package com.StepDefanition;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RG_TC_005steps {
    Register register;
    
	@Given("user is on the register account page again")
	public void user_is_on_the_register_account_page_again() {
		register = new Register(DriverFactory.getDriver());
	     register.clickMyaccountbuton();
	     register.clickRegisterbutton();
	}

	@ Then("user click the scbscribe checkbox No option")
	public void user_click_the_scbscribe_checkbox_no_option() {
	if(register == null) {
		register=new Register(DriverFactory.getDriver());
	}
	register.clickradiobuttonNO();
	     
	     
	}



}
