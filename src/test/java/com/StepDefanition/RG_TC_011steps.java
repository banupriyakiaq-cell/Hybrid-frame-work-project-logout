package com.StepDefanition;

import org.testng.Assert;

import com.Pages.Register;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RG_TC_011steps {
	Register register;

	@Given("user is on register form page nad using keyboard keys")
	public void user_is_on_register_form_page_nad_using_keyboard_keys() {
		register = new Register(DriverFactory.getDriver());
		register.clickMyaccountbuton();
		register.clickRegisterbutton();

	}
	@Given("user enter all account details using keyboared keys")
	public void user_enter_all_account_details_using_keyboared_keys() {
	    register.enterAllAccountDetailsUsingKeyboard();
	}

	@When("user select the subscribe checkbox No using Space key")
	public void user_select_the_subscribe_checkbox_no_using_space_key() {
		register.selectSubscribeUsingKeyboard();
	}

	@When("user select the privacy policy agree checkbox using space key")
	public void user_select_the_privacy_policy_agree_checkbox_using_space_key() {
		register.selectPrivacyPoliceUsingKeyboard();
	}

	@When("user click the continue button using Enter key")
	public void user_click_the_continue_button_using_enter_key() {
		register.clickContinueUsingKeyboared();
	}

	@Then("user should be navigate to account success page")
	public void user_should_be_navigate_to_account_success_page() {
		 
		String URL=DriverFactory.getDriver().getCurrentUrl();
		System.out.println("Current URL:"+URL);
		Assert.assertTrue(URL.contains("account/success"),"user is not navigate to account success page");
		}
}
