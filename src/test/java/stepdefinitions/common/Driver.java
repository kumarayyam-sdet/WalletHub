package stepdefinitions.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	 

	public WebDriver instantiateDriver(Browser season) {
		WebDriver driver = null;
		switch (season) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		return driver;

	}
}