package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	
	// created for generating random string for email
	public static String randomstring(){
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
		
	}

}
