package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	
	
	
	public LandingPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(css="a[href*='sign_in']")
	private WebElement signIn;
	public WebElement getLogin() {
		return signIn;
	}
	
	@FindBy(xpath="//div[@class='container']//div[@class='text-center']")
	private WebElement courseLabel;
	public WebElement getCourseLabel() {
		return courseLabel;
	}
	
	@FindBy(css=".text-center>h2")
	private WebElement navBar;
	public WebElement getNavBar() {
		return navBar;
	}
	
	@FindBy(css="div[class*='video-banner'] h3")
	WebElement videoBanner;
	public WebElement getVideoBanner() {
		return videoBanner;
	}
	
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	WebElement noThanks;
	public WebElement getnoThanksLink() {
		return noThanks;
	}
	
	
	
	/*
	By signIn=By.cssSelector("a[href*='sign_in']");
	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	*/
}
