package CucumberFrameworkKSRTC.stepDefinations;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import CucumberFrameworkKSRTC.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class KSRTC_LoginSteps extends DriverFactory{
	
	@Given("User navigates to the KSRTC website")
	public void user_navigates_to_the_ksrtc_website() {
	    
		getDriver().get("https://ksrtc.in/oprs-web/");
	}

	@When("User clicks the Sign In button")
	public void user_clicks_the_sign_in_button() throws IOException, InterruptedException {
	    loginPage.clickOnSignIn_button1();
	}


	@When("fills the form with the given sheetname {string} and rownumber {int}")
	public void fills_the_form_with_the_given_sheetname_and_rownumber(String string, Integer int1) throws InvalidFormatException, IOException, InterruptedException {
	    loginPage.readFromfileAndEnter(string, int1);
	}

	
	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() throws IOException, InterruptedException {
	    loginPage.clickOnLogin_button();
	}

	

	@Then("the username will be visible on the website upon successful login otherwise not")
	public void the_username_will_be_visible_on_the_website_upon_successful_login_otherwise_not() throws IOException, InterruptedException {
	    loginPage.signInVerification();
	}

}
