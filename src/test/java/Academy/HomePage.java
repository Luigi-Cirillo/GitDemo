package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;


public class HomePage extends Base{
	public static org.apache.logging.log4j.Logger  log = LogManager.getLogger(Base.class);
	@BeforeTest
	public void initialize() throws IOException {
		driver =initializeDriver();
		log.info("driver is initialized");
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password,String description) throws IOException {
		
		
		driver.get(prop.getProperty("url"));
		
		LandingPage lpage=new LandingPage(driver);
		lpage.getLogin().click();
		log.info("Clicked on login button");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginButton().click();
		log.info(description);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData() {
		//rows stands for how many different data types test should run
		//so 2 for 2 different test cases
		//and columns stands for how many variables for each test cases
		//so 3 for 3 values
		Object[][] data =new Object[2][3];
		data[0][0]="asd@sss.com";
		data[0][1]="password";
		data[0][2]="Non restricted user";
		
		data[1][0]="badGuy@sss.com";
		data[1][1]="123456";
		data[1][2]="Restricted user";
		return data;
	}
	
	
}
