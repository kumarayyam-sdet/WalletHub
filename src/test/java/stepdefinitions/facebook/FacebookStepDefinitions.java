package stepdefinitions.facebook;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import page.facebook.FacebookPage;
import stepdefinitions.common.Hooks;
import utilities.Configuration;

public class FacebookStepDefinitions {
	
	private FacebookPage fbPage;
	private Configuration config=Hooks.configuration;

	@Given("^Login to Facebook as \"([^\"]*)\"$")
    public void login_to_facebook_as_something(String usertype) throws Throwable {
		fbPage = new FacebookPage();
		String url=config.getUrlproperty().getProperty("facebook.login");
		String username=config.getCredentialproperty().getProperty("facebook.username"+"."+usertype);
		String password=config.getCredentialproperty().getProperty("facebook.password"+"."+usertype);
        fbPage.fbLogin(url,username, password);
    }

    @Then("^Post a status message \"([^\"]*)\"$")
    public void post_a_status_message_something(String statusMessage) throws Throwable {
    	
        fbPage.postNewStatus(statusMessage);
       
    }
}
