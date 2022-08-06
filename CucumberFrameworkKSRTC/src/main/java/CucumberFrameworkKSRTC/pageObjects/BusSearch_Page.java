package CucumberFrameworkKSRTC.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BusSearch_Page extends BasePage{

	public BusSearch_Page() throws IOException {
		super();
	}
	
	public @FindBy(id = "fromPlaceName") WebElement textField_fromPlace;
	public @FindBy(xpath = "//*[text()='BENGALURU']") WebElement fromPlace;
	
	public @FindBy(id = "toPlaceName") WebElement textField_toPlace;
	public @FindBy(xpath = "//*[text()='TRICHY']") WebElement toPlace;
	
	public @FindBy(id = "txtJourneyDate") WebElement button_toJourney;
	public @FindBy(xpath = "//*[text()='20']") WebElement field_toJourneyDate;
	
	public @FindBy(id = "txtReturnJourneyDate") WebElement button_fromJourney;
	public @FindBy(xpath = "//*[text()='25']") WebElement field_fromJourneyDate;
	
	public @FindBy(css = "button[class='btn btn-primary btn-lg btn-block btn-booking']") WebElement button_SearchPage;
	
	public BusSearch_Page sourceCitySelection(String string) throws Exception {
		sendKeysToWebElement(textField_fromPlace, string);
		waitAndClickElement(fromPlace);
		return new BusSearch_Page();
	}
	
	public BusSearch_Page destinationCitySelection(String string) throws Exception {
//		WaitUntilWebElementIsVisible(textField_toPlace);
//		sendKeysToWebElement(textField_toPlace, string);
//		waitAndClickElement(toPlace);
		
		getDriver().findElement(By.id("toPlaceName")).sendKeys(string);
		getDriver().findElement(By.xpath("//*[text()='TRICHY']")).click();
		return new BusSearch_Page();
	}
	
	public BusSearch_Page departureDateSelection() throws Exception {
		waitAndClickElement(button_toJourney);
		waitAndClickElement(field_toJourneyDate);
		return new BusSearch_Page();
	}
	
	public BusSearch_Page returnDateSelection() throws Exception {
		waitAndClickElement(button_fromJourney);
		waitAndClickElement(field_fromJourneyDate);
		return new BusSearch_Page();
	}
	
	public BusSearch_Page busAvailability() throws Exception {
		waitAndClickElement(button_SearchPage);
		return new BusSearch_Page();
	}
	
	public BusSearch_Page confirmSearchPageFormSubmissionWasSuccessful() throws Exception {
		
		WebElement modifySearch=driver.findElement(By.cssSelector("button[class='search-modify-btn']"));
		
		String text=modifySearch.getText();
		WaitUntilWebElementIsVisible(modifySearch);
		Assert.assertEquals("modifysearch", text.toLowerCase().replaceAll("[ ()0-9]", ""));
		waitAndClickElement(modifySearch);
		return new BusSearch_Page();
	}
	
	
	
}
