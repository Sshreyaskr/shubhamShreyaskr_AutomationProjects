package CucumberFrameworkKSRTC.stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CucumberFrameworkKSRTC.utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusSearchSteps extends DriverFactory{
	
	@Given("User navigates to the {string} website")
	public void user_navigates_to_the_website(String string) {
	   getDriver().get(string);
	}

	

	@When("User enter the {string} from city")
	public void user_enter_the_from_city(String string) throws Exception {
		busSearchPage.sourceCitySelection(string);
	}

	

	@When("User selects the {string} destination city")
	public void user_selects_the_destination_city(String string) throws Exception {
		     busSearchPage.destinationCitySelection(string);
	    	}

	

	@When("User selects the departure date")
	public void user_selects_the_departure_date() throws Exception {
		busSearchPage.departureDateSelection();
	}

	

	@When("User selects the return date")
	public void user_selects_the_return_date() throws Exception {
       busSearchPage.returnDateSelection();	    
	}

	

	@When("User clicks on the search button")
	public void user_clicks_on_the_search_button() throws Exception {
	   busSearchPage.busAvailability();
	}


	@Then("he should be displayed with a successful search result")
	public void he_should_be_displayed_with_a_successful_search_result() throws Exception {
			busSearchPage.confirmSearchPageFormSubmissionWasSuccessful();
	}

}
