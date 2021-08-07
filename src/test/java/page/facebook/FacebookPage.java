package page.facebook;

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
public class FacebookPage  {
	
	WebDriver driver;
	PageHelper ph=new PageHelper();
	int pagewaittime;
	public FacebookPage() {
        driver=Hooks.driver;
        PageFactory.initElements(driver, this);
        pagewaittime= Integer.parseInt(Hooks.configuration.getTestproperty().get("facebook.waittime").toString());
    }


    

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='pass']")
    private WebElement passInput;

    @FindBy(xpath = "//*[@data-testid='royal_login_button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//*/span[contains(text(),\"What's on your mind\")]")
    private WebElement postInput;
    
    @FindBy(xpath="//*/div[contains(@aria-label,'on your mind')]")
    private WebElement messageInput;

    @FindBy(xpath = "//*/span[(text()='Post')]")
    private WebElement postBtn;

    
    
    

    
    public boolean isPageOpened() {
        return emailInput.isDisplayed();
    }
    
    public void waitForOpen() {
    	ph.elementVisiblityDisplayCheck(emailInput);
    }

    public void fbLogin(String url,String login, String pass) {
    	ph.openPage(url);
    	waitForOpen();
        emailInput.sendKeys(login);
        passInput.sendKeys(pass);
        loginBtn.click();
    }

    public void postNewStatus(String msg) {
    	ph.elementVisiblityDisplayCheck(postInput);
    	postInput.click();
    	ph.elementVisiblityDisplayCheck(messageInput);
    	messageInput.sendKeys(msg);
        ph.waitForElementVisible(postBtn,pagewaittime);
        Actions builder = new Actions(driver);
        builder.moveToElement(postBtn).click().perform();
   }
}
