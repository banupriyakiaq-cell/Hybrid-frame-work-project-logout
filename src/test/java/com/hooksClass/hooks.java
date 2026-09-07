package com.hooksClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driverFactory.BrowserContext;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class hooks {
	private DriverFactory driverFactory;

	@Before(order = 0)
	public void loadConfig() {
		new ConfigReader().init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		driverFactory.init_driver(BrowserContext.getBrowser());
		String browser = BrowserContext.getBrowser().toString();
		Allure.label("browser", browser);
		Allure.parameter("Browser", browser);
		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
		DriverFactory.getDriver().manage().window().maximize();
	}

	@After()
	public void tearDown(Scenario scenario) {
		WebDriver driver = driverFactory.getDriver();
		if (scenario.isFailed() && driver != null) {
			byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "Failed Screenhot");
		}
		if (driver != null) {
			driver.quit();
			DriverFactory.unload();
			BrowserContext.removeBrowser();
		}

	}

}