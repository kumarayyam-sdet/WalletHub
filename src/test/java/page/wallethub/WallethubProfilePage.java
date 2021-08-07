package page.wallethub;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.common.PageHelper;
import stepdefinitions.common.Hooks;

/**
 *
 */
public class WallethubProfilePage {

	WebDriver driver;
	PageHelper ph = new PageHelper();

	
	@FindBy(xpath = "//*/main//img[@class='avatar-img']")
	WebElement coverPhoto;
	
	@FindBy(xpath = "//*/main//img[@class='avatar-img']")
	WebElement recommendation;
	
	public WallethubProfilePage() {
		driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForOpen() {
		ph.elementVisiblityDisplayCheck(coverPhoto);
	}
	
	public boolean recommendationVisible() {
		WebElement receommendationElem=driver.findElement(By.xpath("//*/main//h2[contains(text(),'Recommendations')]"));
		return ph.elementVisiblityDisplayCheck(receommendationElem);
	}

	public int getTheReviewedStar() {
		driver.navigate().refresh();
		List<WebElement> stars = driver.findElements(By.xpath(
				"//*/main//h2[contains(text(),'I RECOMMEND')]/parent::div//div[@class='pr-rec-texts-container']/review-star//*[local-name()='svg']//*[local-name()='g']//*[local-name()='path'][@fill='#4ae0e1']"));

		return stars.size();
	}

}
