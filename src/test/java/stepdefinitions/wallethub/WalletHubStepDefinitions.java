package stepdefinitions.wallethub;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.wallethub.WallethubLoginPage;
import page.wallethub.WallethubMainSection;
import page.wallethub.WallethubProfilePage;
import page.wallethub.WallethubTestCompanyPage;
import stepdefinitions.common.Hooks;
import utilities.Configuration;

public class WalletHubStepDefinitions {
	
	private WallethubLoginPage wallethubLoginPage=new WallethubLoginPage();
	private WallethubProfilePage wallethubProfilePage=new WallethubProfilePage();
	private WallethubMainSection wallethubMainSection=new WallethubMainSection();
	private WallethubTestCompanyPage wallethubTestCompanyPage=new WallethubTestCompanyPage();
	private Configuration config=Hooks.configuration;
	
	@Given("^User launch WalletHub (Test Insurance Company|Pend) site$")
    public void user_launch_wallethub_something(String pageToLaunch) throws Throwable {
		String url=config.getUrlproperty().getProperty("wallethub.login");
		String username=config.getCredentialproperty().getProperty("wallethub.username");
		String password=config.getCredentialproperty().getProperty("wallethub.password");
        wallethubLoginPage.login(url,username,password);
		switch(pageToLaunch) {
		case "Test Insurance Company":
		url=config.getUrlproperty().getProperty("wallethub.TestInsuranceCompany");
		wallethubTestCompanyPage.launchPage(url);
		break;
		}
    }

	@When("^User click on Write a review$")
    public void user_click_on_write_a_review() throws Throwable {
		wallethubTestCompanyPage.clickWriteReview();
    }

    @When("^User click on the (First|Second|Third|Fourth|Fifth) star$")
    public void user_click_on_the_fourth_star(String nStar) throws Throwable {
    	String iStar="";
    	Map<String,String> numberToNumeralMap=new HashMap<String,String>();
    	numberToNumeralMap.put("First", "1");
    	numberToNumeralMap.put("Second", "2");
    	numberToNumeralMap.put("Third", "3");
    	numberToNumeralMap.put("Fourth", "4");
    	numberToNumeralMap.put("Fifth", "5");
    	wallethubTestCompanyPage.clickOnReviewStar(numberToNumeralMap.get(nStar));
    	boolean passed=wallethubTestCompanyPage.reviewStarChanged(numberToNumeralMap.get(nStar));
    	Assert.assertTrue("Review Star did not changed", passed);
    }
    
    @And("^User write below review comments$")
    public void user_write_review_comments(String reviewComments) throws Throwable {
    	
    	//String reviewComments="You can check the profile page of each professional or company to determine whether they are a paying advertiser (indicated by the word sponsored). Regardless of advertiser status, none of the listings, reviews, or other information on Wallet Hub constitutes, in any way, a referral or endorsement by us of the respective financial company or professional, or vice versa. Furthermore, it is important to note that the inclusion of a financial company or professional on Wallet Hub does not necessarily indicate their involvement with the site or control over the information that we display. Information is displayed first and foremost for the benefit of consumers.";
    	wallethubTestCompanyPage.writeReviewComments(reviewComments);
    }
    
    @And("^User press submit$")
    public void user_press_submit() throws Throwable {
    	wallethubTestCompanyPage.clickonReviewSubmit();
    }

    @When("^User go to profile from test company page$")
    public void user_go_to_profile() throws Throwable {
    	
    	wallethubTestCompanyPage.launchProfile();
    }


    @Then("^User can see that the review feed got updated$")
    public void user_can_see_that_the_review_feed_got_updated() throws Throwable {
        boolean passed=wallethubProfilePage.recommendationVisible();
        Assert.assertTrue("User unable to see the review got updated", passed);
    }
    
    @And("^User can see that the review starred as (One|Two|Three|Four|Five)$")
    public void user_can_see_that_the_review_starred_as_four(String rating) throws Throwable {
    	int actualRating=wallethubProfilePage.getTheReviewedStar();
    	Map<String,String> numberToNumeralMap=new HashMap<String,String>();
    	numberToNumeralMap.put("One", "1");
    	numberToNumeralMap.put("Two", "2");
    	numberToNumeralMap.put("Three", "3");
    	numberToNumeralMap.put("Four", "4");
    	numberToNumeralMap.put("Five", "5");
    	String expectedRating=numberToNumeralMap.get(rating);
    	Assert.assertTrue("User cannot see that the review starred as " + rating, String.valueOf(actualRating).equalsIgnoreCase(expectedRating));
    }

    @And("^User hover over the stars on the reviews section of the page$")
    public void user_hover_over_the_stars_on_the_reviews_section_of_the_page() throws Throwable {
        throw new PendingException();
    }
    

    @Then("^User should see the stars inside it get lit up$")
    public void user_should_see_the_stars_inside_it_get_lit_up() throws Throwable {
        throw new PendingException();
    }

    @Then("^a confirmation screen with message \"([^\"]*)\" should be displayed$")
    public void a_confirmation_screen_with_message_something_should_be_displayed(String strArg1) throws Throwable {
        throw new PendingException();
    }

    

    

}
