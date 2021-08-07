package stepdefinitions.common;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import utilities.Browser;

public class Driver {
	
	 

	public WebDriver instantiateDriver(Browser browser) {
		WebDriver driver = null;
		switch (browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		return driver;

	}
	
	public DesiredCapabilities getDefaultCapabilities(Browser browser) {
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                return DesiredCapabilities.chrome();
            default:
                throw new IllegalStateException("Browser is not supported");
        }
    }
	
	public WebDriver instantiateDriver(Browser browser,String extension) {
		WebDriver driver = null;
		switch (browser) {
		case CHROME:
			DesiredCapabilities capabilities = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			switch(extension) {
			case "VPN":
			options.addExtensions(new File("src/test/resources/extensions/SetupVPN - Lifetime Free VPN.crx"));
			break;
			}
			driver = new ChromeDriver(options);
			break;
		}
		driver.manage().window().maximize();
		return driver;

	}
    
    public DesiredCapabilities addChromeOptions(WebDriver driver,Browser browser) {
    	
        switch (browser) {
            case CHROME:            	
            	
            	
            default:
                throw new IllegalStateException("Browser is not supported");
        }
       
    }
}