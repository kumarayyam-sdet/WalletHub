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
public class WallethubTestCompanyPage {

	WebDriver driver;
	PageHelper ph = new PageHelper();

	private int randomStar = 0;

	@FindBy(xpath = "//*/main//h1[contains(text(),'Test Insurance Company')]")
	WebElement pageHeading;

	@FindBy(xpath = "//*/main//button[contains(text(),'Write a Review')]")
	WebElement writeReviewButton;

	@FindBy(xpath = "//*/div[@class='review-input-container']//textarea")
	WebElement commentArea;

	@FindBy(xpath = "//*/div[@class=\"review-input-submit\"]//span[contains(text(),'Submit')]")
	WebElement reviewSubmit;

	@FindBy(css = "[class='wh-rating rating_5']")
	WebElement fiveStars;

	@FindBy(xpath = "//*[@class=\"wh-rating-choices-holder\"]/a[5]")
	private WebElement nStar;

	public WallethubTestCompanyPage() {
		driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean launchPage(String url) {
		ph.openPage(url);
		waitForOpen();
		return pageHeading.isDisplayed();
	}

	public void waitForOpen() {
		ph.elementVisiblityDisplayCheck(pageHeading);
	}

	public void clickWriteReview() {
		writeReviewButton.click();
	}

	public void randomHoverOver() {
		List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);
		Random rand = new Random();
		randomStar = givenList.get(rand.nextInt(givenList.size()));
		try {
			clickOnReviewStar(String.valueOf(randomStar));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getTheReviewedStar() {

		List<WebElement> stars = driver.findElements(By.xpath(
				"//*/review-star[@class='rvs-svg']/div[@class='rating-box-wrapper']//*[local-name()='svg']//*[local-name()='g']//*[local-name()='path'][@fill='#4ae0e1']"));
		return stars.size();
	}

	public void clickOnReviewStar(String nStar) throws InterruptedException {
		Thread.sleep(1000);
		WebElement reviewStar = driver.findElement(
				By.xpath("//*/review-star[@class='rvs-svg']/div[@class='rating-box-wrapper']//*[local-name()='svg']["
						+ nStar + "]"));
		ph.elementVisiblityDisplayCheck(reviewStar);
		Actions builder = new Actions(driver);
		builder.moveToElement(reviewStar).click().perform();
		Thread.sleep(1000);
	}

	public boolean reviewStarChanged(String nStar) {
		List<WebElement> stars = driver.findElements(By.xpath(
				"//*/review-star[@class='rvs-svg']/div[@class='rating-box-wrapper']//*[local-name()='svg']//*[local-name()='g']//*[local-name()='path'][@fill='#4ae0e1']"));
		int size = stars.size();
		return String.valueOf(size).equalsIgnoreCase(nStar);

	}

	public void writeReviewComments(String reviewComments) {
		commentArea.sendKeys(reviewComments);
	}

	public void clickonReviewSubmit() {
		reviewSubmit.click();
	}

	public void launchProfile() {

		String profileHref = driver.findElement(By.xpath("//*[@id='burger-menu-popup']//div[@class='brgm-user-bts']/a"))
				.getAttribute("href");
		driver.get(profileHref);
	}

}
