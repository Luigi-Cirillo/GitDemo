package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
public WebDriver driver;
	
	
	
	
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(id="user_email")
	WebElement email;
	public WebElement getEmail() {
		return email;
	}
	
	
	@FindBy(id="user_password")
	WebElement password;
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(css="[value='Log In']")
	WebElement loginButton;
	
	public WebElement getLoginButton() {
		return loginButton;
	}
}
