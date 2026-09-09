package com.TestRunner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

 import com.driverFactory.BrowserContext;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/com.Feature"},
		glue = {"com.StepDefanition","com.hooksClass"},
		plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestRunner extends AbstractTestNGCucumberTests {
		@Parameters("browser")
		@BeforeMethod
		public void setBrowser(@Optional("chrome")String browser) {
			BrowserContext.setBrowser(browser);
		}
	 @Override
	 @DataProvider(parallel =true)
	 public Object[][] scenarios(){
	 return super.scenarios();
	 }
	 

}
