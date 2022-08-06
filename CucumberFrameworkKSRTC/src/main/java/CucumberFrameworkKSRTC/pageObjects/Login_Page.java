package CucumberFrameworkKSRTC.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login_Page extends BasePage{
	
	public @FindBy(xpath = "//a[contains(text(),' Sign In')]") WebElement button_SignIn;
	public @FindBy(id = "userName") WebElement textField_username;
	public @FindBy(id = "password") WebElement textField_password;
	public @FindBy(id = "submitBtn") WebElement button_Login;
	public @FindBy(xpath = "//span[contains(text(),'Shubbham Shreyaskr')]") WebElement login_username;
	
  
	public Login_Page() throws IOException {
		super();
	}
	
	public Login_Page clickOnSignIn_button1() throws IOException, InterruptedException {
		waitAndClickElement(button_SignIn);
		return new Login_Page();
	}
	
	public Login_Page readFromfileAndEnter(String string, Integer int1) throws IOException, InterruptedException, InvalidFormatException {
		CucumberFrameworkKSRTC.utils.ExcelReader reader = new CucumberFrameworkKSRTC.utils.ExcelReader();
        List<Map<String,String>> testData = reader.getData(System.getProperty("user.dir")+"\\src\\main\\java\\CucumberFrameworkKSRTC\\testData\\controller.xlsx", string);
		
		String loginid = testData.get(int1).get("UserName");
		String pass = testData.get(int1).get("Password");
		
		getDriver().findElement(By.id("userName")).sendKeys(loginid);
		getDriver().findElement(By.id("password")).sendKeys(pass);
		return new Login_Page();
	}
	
	public Login_Page clickOnLogin_button() throws IOException, InterruptedException {
		waitAndClickElement(button_Login);
		return new Login_Page();
	}
	
	public Login_Page signInVerification() throws IOException, InterruptedException {
	   //System.out.println(login_username.isDisplayed());
		
		String text=login_username.getText();
		WaitUntilWebElementIsVisible(login_username);
		Assert.assertEquals("shubbhamshreyaskr", text.toLowerCase().replaceAll("[ ()0-9]", ""));
		waitAndClickElement(login_username);
		return new Login_Page();
	}
	
	
}
