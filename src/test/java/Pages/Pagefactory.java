package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory {

	//private final WebDriver driver;

	@FindBy(xpath = "inputbar")
	private WebElement search;

	@FindBy(xpath = "site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a")
	private WebElement bytitle;

	@FindBy(xpath = "site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[2]/li[5]/a")
	private WebElement  price;

	@FindBy(xpath = "site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[3]/li[4]/a")
	private WebElement discount;
	
	@FindBy(xpath = "(site-wrapper\"]/div[1]/div[1]/div[2]/div[1]/ul[5]/li[2]/a")
	private WebElement shipping;

	

	public Pagefactory(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void search() {
		search.click();
		
	}
	public void bytitle() {
		bytitle.click();
		
	}
	public void price() {
		price.click();
	}
	public void discount() {
		discount.click();
	}
	public void shipping() {
		shipping.click();
	}
		
		
		

} 