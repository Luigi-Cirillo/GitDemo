package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.PortalHomePAge;
import Resources.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base{
	
	public static org.apache.logging.log4j.Logger  log = LogManager.getLogger(Base.class);
	
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		System.setProperty("browser", "chrome");
		System.setProperty("headless", "false");
		driver =initializeDriver();
		log.info("driver is initialized");
    }

    @When("^User enters (.*) and (.*)$")
    public void user_enters_something_and_something(String username, String password) throws Throwable {
    	LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginButton().click();
    }

    @Then("^Verify that user is succesfully logged in$")
    public void verify_that_user_is_succesfully_logged_in() throws Throwable {
        PortalHomePAge portalPage = new PortalHomePAge(driver);
        Assert.assertTrue(portalPage.getSearch().isDisplayed());
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1 );
    }

    @And("^Click on login link$")
    public void click_on_login_link() throws Throwable {
    	LandingPage lpage=new LandingPage(driver);
    	if (lpage.getnoThanksLink().isDisplayed()) {
    		lpage.getnoThanksLink().click();
    	}
		lpage.getLogin().click();
		log.info("Clicked on login button");
    }
    
    @And("Closes browser")
    public void closes_browser() {
    	driver.close();
    	driver=null;
    }
}
