package CucumberFrameworkKSRTC.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import CucumberFrameworkKSRTC.pageObjects.BusSearch_Page;
import CucumberFrameworkKSRTC.pageObjects.Login_Page;



public class DriverFactory {
	public static WebDriver driver;
	public static Login_Page loginPage;
	public static BusSearch_Page busSearchPage;
	
	public WebDriver getDriver() {
	try {
		///* We are not using the below two line as the program won't run if we try running it from the command prompts
		
//		ReadConfigFile file=new ReadConfigFile();
//		String browserName=file.getBrowser();
		
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\CucumberFrameworkKSRTC\\properties\\config.properties");
		p.load(fi);
		String browserName = p.getProperty("browser");
		
		switch(browserName) {
		   
		case "firefox":
			//code
			if(null==driver) {
				System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
				DesiredCapabilities capabilities=DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver=new FirefoxDriver();
			}
		    break;
		 
		case "chrome":
			//code
			if(null==driver) {
				System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
				//Chrome options
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			}
		    break;
		 }		
	}catch(Exception e)
	{
		System.out.println("Unable to load the browser"+e.getMessage());
	}finally {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		busSearchPage = PageFactory.initElements(driver, BusSearch_Page.class);
		loginPage = PageFactory.initElements(driver, Login_Page.class);
	}
	return driver;
	
	}
}
