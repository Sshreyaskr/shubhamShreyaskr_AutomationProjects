package CucumberFrameworkKSRTC.stepDefinations;

//import cucumber.api.Scenario;

import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import CucumberFrameworkKSRTC.pageObjects.BasePage;
import CucumberFrameworkKSRTC.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
public class MasterHooks extends DriverFactory{
	
	@Before
	public void setup() {
		driver=getDriver();
	}
	

	@After
	public void tearDownAndScreenshotOnFailure(Scenario scenario) {
		try {
			if(driver != null && scenario.isFailed()) {
				//scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
				TakesScreenshot ts=((TakesScreenshot) driver);
				byte[] src=ts.getScreenshotAs(OutputType.BYTES);
				scenario.attach(src, "image/png", "screenshot");
//				
				
				
//				BasePage.captureScreenshot();
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
			if(driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
}

}
