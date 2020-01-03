package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import Resources.Base;

public class ValidateNavBar extends Base{
	public static org.apache.logging.log4j.Logger  log = LogManager.getLogger(Base.class);
	@BeforeTest
	public void initialize() throws IOException {
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test()
	public void basePageNavigation() throws IOException {
		
		
		
		LandingPage lpage=new LandingPage(driver);
		Assert.assertTrue(lpage.getNavBar().isDisplayed());
		log.info("Checked the Nav Bar");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver=null;
	}
	
}
