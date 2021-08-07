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
public class WallethubMainSection {

    WebDriver driver;
	PageHelper ph=new PageHelper();
	
	@FindBy(xpath = "//*/div[@class='top-header-nav']//nav[@class='burger-menu-right-menu']/div[contains(@class,'brgm-user')]")
    WebElement userDropDown;
	
    public WallethubMainSection() {
    	driver=Hooks.driver;
        PageFactory.initElements(driver, this);
    }
    
    public void launchProfileOfUser() {
    	Actions actiondriver=new Actions(driver);
    	actiondriver.moveToElement(userDropDown).perform();
    	WebElement profileelem=driver.findElement(By.xpath("//*/div[@class='top-header-nav']//nav[@class='burger-menu-right-menu']/div[contains(@class,'brgm-user')]/div/a[contains(text(),'Profile')]"));
    	actiondriver.moveToElement(profileelem).click().build().perform();
    	System.out.println(driver.getPageSource());
    }
    
    

	}
