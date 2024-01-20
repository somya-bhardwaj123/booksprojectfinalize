package step_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.Testbase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcasestep extends Testbase { 
	private static final Logger logger = LogManager.getLogger(Testcasestep.class);
	
	WebDriver driver;
	@Before
	public void setUp()
	{ 
		WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    }
	
	@After
public  void tearDown(io.cucumber.java.Scenario scn) {
		if(scn.isFailed())
		{
			byte[] screenshotBytes= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scn.attach(screenshotBytes, "image/png", "screenshot");
		}
		if(driver !=null)
		{
			driver.quit();
		}
		}
    	
	
    
	
	@Given("user navigates to the book website")
	public void user_navigates_to_the_book_website() {
		logger.info("T am on Book website page");
	   
	    driver.get("https://www.bookswagon.com/");
	    driver.manage().window().maximize();
	}

	@When("^user enters the \"([^\"]*)\" and \"([^\"]*)\" credentials$")
	public void user_enters_the_credentials(String Email,String Password) {
		logger.info("Sign in Successfully");
		driver.findElement(By.xpath("//*[@id=\"ctl00_lblUser\"]")).click();
		
		//WebElement form=driver.findElement(By.id("ctl00_phBody_SignIn_plnLoginPassword"));
		driver.findElement(By.id("ctl00_phBody_SignIn_txtEmail")).sendKeys(Email); 
		driver.findElement(By.id("ctl00_phBody_SignIn_txtPassword")).sendKeys(Password);
		driver.findElement(By.id("ctl00_phBody_SignIn_btnLogin")).click();
	}
	@Then("user navigates to the home page")
	public void user_navigates_to_the_home_page() {
		logger.info("I am on the same page");
		String actualtext=driver.getTitle();
		String expectedtext="Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
		Assert.assertEquals(actualtext, expectedtext);
	}
	@When("user clicks on search bar and enter the book name") 
	
	public void user_clicks_on_search_bar() {
		logger.info("I click on search bar");
	    driver.findElement(By.id("inputbar")).sendKeys("Harry potter");
	}
	
	@When("user click on search button")
	public void user_click_on_button() {
		logger.info("T click on search button");
		driver.findElement(By.id("btnTopSearch")).click();
	    
	}
	@When("user refine your search based on title on the books")
	public void user_refine_your_search_based_on_title_on_the_books() {
		logger.info("I click on the title on the books");
		driver.findElement(By.xpath("//a[contains(text(), 'By Title (2884)')]")).click();
	    
	    
	}
	@When("user refine your search based on price on the books")
	public void user_refine_your_search_based_on_price_on_the_books() {
		logger.info("I click on the price on the books");
		driver.findElement(By.xpath("//a[contains(text(), 'Rs.1000 - Rs.2000  ')]")).click();
	    
	    
	}
	@When("user refine your search based on discount on the books")
	public void user_refine_your_search_based_on_discount_on_the_books() {
		logger.info("I click on the discount on the books");
		driver.findElement(By.xpath("//a[contains(text(), '11% - 20% ')]")).click();
	    
	    
	}
	@When("user refine your search based on shipping on the books")
	public void user_refine_your_search_based_on_shipping_on_the_books() {
		logger.info("I click on the shipping on the books");
		try {
			driver.findElement(By.xpath("//*[@id=\"site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[5]/li[2]/a")).click();
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			driver.navigate().refresh();
		}
	}
	
	@Then("user see list of the books")
	public void user_see_list_of_the_books() {
		logger.info(" List of the books ");
	    
	}

}
