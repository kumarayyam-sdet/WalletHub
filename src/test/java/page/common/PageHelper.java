package page.common;

import java.time.Duration;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import stepdefinitions.common.Hooks;

public class PageHelper {
	
	public PageHelper() {
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	
	
	
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
	
}