package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;


public class Steps extends BaseClass {
	
	//public WebDriver driver;
	//public LoginPage lp;
	
	
	@Given("^User Launch chrome browser$")
	public void user_Launch_chrome_browser() throws Exception {
		String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",currentDir + "//Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		lp=new LoginPage(driver);
		
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Exception {
	   driver.get(url);
		
	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String email, String pwd) throws Exception {
	   lp.setUserName(email);
	   lp.setPassword(pwd);
	}

	@When("^Click on Login$")
	public void click_on_Login() throws Exception {
		lp.clickLogin();
		Thread.sleep(3000);
	    
	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String title) throws Exception {
	    if(driver.getPageSource().contains("Login was unsuccessful.")){
	    	driver.close();
	    	Assert.assertTrue(false);
	    }else{
	    	Assert.assertEquals(title, driver.getTitle());
	    	
	    }
	    Thread.sleep(3000);
	}

	@When("^User click on Log out link$")
	public void user_click_on_Log_out_link() throws Exception {
	  lp.clickLogOut();
	  Thread.sleep(3000);
		
	}

	@Then("^close browser$")
	public void close_browser() throws Exception {
	    driver.quit();
	}
	//Customers feature step definition....................

	@Then("^User can view Dashboard$")
	public void user_can_view_Dashboard() throws Exception {
	   
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("^User click on customers Menu$")
	public void user_click_on_customers_Menu() throws Exception {
	    Thread.sleep(3000);
	    addCust.clickOnCustomersMenu();
		
	}

	@When("^click on customers Menu Item$")
	public void click_on_customers_Menu_Item() throws Exception {
		Thread.sleep(2000);
		addCust.clickOnCustomersMenuItem();
	}

	@When("^click on Add new button$")
	public void click_on_Add_new_button() throws Exception {
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("^User can view Add new customer page$")
	public void user_can_view_Add_new_customer_page() throws Exception {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	    
	}

	@When("^User enter customer info$")
	public void user_enter_customer_info() throws Exception {
	   
		String email = randomstring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		 //Registered default
		//The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guest' or 'Registered' customer role
		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);
		
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Basant");
		addCust.setLastName("Chaudhary");
		addCust.setDob("1/08/1994");
		addCust.setCompanyName("QA");
		addCust.setAdminContent("This is for Testing....");
		
	}

	@When("^click on Save button$")
	public void click_on_Save_button() throws Exception {
		addCust.clickOnSave();
		Thread.sleep(3000);
	}

	@Then("^User can view confirmation message \"([^\"]*)\"$")
	public void user_can_view_confirmation_message(String msg) throws Exception {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
	    		    .contains("The new customer has been added successfully."));
		
	}

}
