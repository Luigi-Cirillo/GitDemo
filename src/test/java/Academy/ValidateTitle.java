package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;

import Resources.Base;

public class ValidateTitle extends Base{
	public static Logger log =LogManager.getLogger(Base.class);
	
	@BeforeTest
	public void initialize() throws IOException {
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test()
	public void validateTitleText() throws IOException {
		
		
		
		LandingPage lpage=new LandingPage(driver);
		Assert.assertEquals(lpage.getCourseLabel().getText(), "FEATURED COURSES");
		log.info("Validated the title text");
	}
	
	@Test()
	public void validateLabel() throws IOException {
		
		
		
		LandingPage lpage=new LandingPage(driver);
		Assert.assertEquals(lpage.getVideoBanner().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Validated the label");
	}
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver=null;
	}
}
