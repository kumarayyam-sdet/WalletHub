package page.common;

import java.time.Duration;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefinitions.common.Hooks;
import utilities.TimeUtils;


public class PageHelper {
	
	
	public static final int WAIT_FOR_PAGE_LOAD_IN_SECONDS = 120;
	
	public PageHelper() {
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	public void openPage(String url) {
    	driver.get(url);
    }
	
	public Map<String, String> getWebFormValues(String tableXpath, Map<String, String> conditions) {

		return conditions;
	}
	
	
	
	
	public boolean elementVisiblityCheck(WebElement element,String text) {

		boolean passed=false;
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(90)) 
			       .pollingEvery(Duration.ofSeconds(10))
			       .ignoring(NoSuchElementException.class);
		
		WebElement validationElement=wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				
				String getTextOnPage = element.getText();
				
				if(getTextOnPage.equals(text)){
					System.out.println(getTextOnPage);
					
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
				
			}
			
		});
		passed=validationElement.getText().equalsIgnoreCase(text);
		return passed;

	}
	
	public boolean elementVisiblityDisplayCheck(WebElement element) {

		boolean passed=false;
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(90)) 
			       .pollingEvery(Duration.ofSeconds(10))
			       .ignoring(NoSuchElementException.class);
		
		WebElement validationElement=wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				
				
				
				if(element.isDisplayed()){
				
					
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
				
			}
			
		});
		passed=validationElement.isDisplayed();
		return passed;

	}
	
	

	   

	    public void waitForElementVisible(WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_PAGE_LOAD_IN_SECONDS);
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitForElementIsNotVisible(WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, 3);
	        try {
	            wait.until(ExpectedConditions.invisibilityOf(element));
	        } catch (Exception e) {

	        }
	    }

	    public String getPageSource() {
	        return driver.getPageSource();
	    }
	
}