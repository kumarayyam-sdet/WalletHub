package page.wallethub;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.common.PageHelper;
import stepdefinitions.common.Hooks;


/**
 *
 */
public class WallethubLoginPage {

	WebDriver driver;
	PageHelper ph=new PageHelper();
    

    @FindBy(css ="[ng-model=\"fields.email\"]")
    private WebElement userInput;

    @FindBy(css ="[ng-model=\"fields.password\"]")
    private WebElement passInput;

    @FindBy(css = "[data-hm-tap=\"doLogin($event);\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*//main//button[contains(text(),\"Edit Profile\")]")
    WebElement editProfile;

    public WallethubLoginPage() {
    	driver=Hooks.driver;
        PageFactory.initElements(driver, this);
    }

    
    
    
    public boolean isPageOpened() {
        return userInput.isDisplayed();
    }
    
    public void waitForOpen() {
    	ph.elementVisiblityDisplayCheck(userInput);
    }

    public void login(String url,String login, String pass) {
    	ph.openPage(url);
    	waitForOpen();
        userInput.sendKeys(login);
        passInput.sendKeys(pass);
        loginBtn.click();
        ph.waitForElementVisible(editProfile);
    }
}
