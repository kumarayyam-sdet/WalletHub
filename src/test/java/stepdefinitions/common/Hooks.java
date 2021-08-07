package stepdefinitions.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.Browser;
import utilities.Configuration;


public class Hooks {

	public static WebDriver driver;
	public static Scenario scenario;
	public static Configuration configuration;

	@Before
	public void beforeScenario(Scenario scenario) {
		configuration=new Configuration().initializeConfigFiles();
	}

	@After
	public void afterScenario(Scenario scenario) {

	}

	@Before(value = "@ui", order = 1)
	public void beforeUIScenario(Scenario scenario) {
		driver = new Driver().instantiateDriver(Browser.CHROME);
		this.scenario=scenario;

	}

	@After(value = "@ui", order = 1)
	public void afterUIScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			byte[] SrcFile = scrShot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(SrcFile, "image/png");
		}
		//driver.quit();
	}
	
	@Before(value = "@uiChromeVPN", order = 2)
	public void beforeUiChromeVPNUIScenario(Scenario scenario) {
		driver = new Driver().instantiateDriver(Browser.CHROME);
		this.scenario=scenario;

	}

	@After(value = "@uiChromeVPN", order = 2)
	public void afterUiChromeVPN(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			byte[] SrcFile = scrShot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(SrcFile, "image/png");
		}
		driver.quit();
	}
	
	public static void attachScreenshot() {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		byte[] SrcFile = scrShot.getScreenshotAs(OutputType.BYTES);
		scenario.embed(SrcFile, "image/png");
	}

}