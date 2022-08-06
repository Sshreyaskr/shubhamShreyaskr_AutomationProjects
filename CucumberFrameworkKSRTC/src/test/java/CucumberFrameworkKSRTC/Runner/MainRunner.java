package CucumberFrameworkKSRTC.Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		//feature file locations
		features = {"src/test/java/CucumberFrameworkKSRTC/features/"},
		
		//step file location
		glue={"CucumberFrameworkKSRTC.stepDefinations"},
		tags= "",
		
		//monochrome makes the console messages readable
		monochrome=true,
		publish=true,
		
		//if we want only the step file to run w/o the selenium code inside it to perform it's task then dryRun=true
		dryRun=false,
		//For maven project - "cucumber-java & cucumber-JUnit" dependencies version should below v6 or 5.7.0
		plugin = {"pretty","html:target/index.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
)
public class MainRunner extends AbstractTestNGCucumberTests {
      
	
	}


//We can have multiple runner classes also for various feature files
//The plugin to get cucumber-reports->
//de.monochromata.cucumber.report.PrettyReports:target/report.html
