package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.google.common.io.Files;

public class Base {
	
	//static saves memory but does not allow parallel execution
	//public static WebDriver driver;
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		//choose webdriver based upon the browser passed in a data.properties file
		prop=new Properties();
		//FileInputStream file=new FileInputStream("D:\\Projects\\Selenium\\Project\\src\\test\\java\\Academy\\data.properties");
		//avoid hardcoded paths
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Academy\\data.properties");
		
		prop.load(file);
		
		
		file.close();
		//String browserName=prop.getProperty("browser");
		System.out.println("GIT test");
		System.out.println("GIT test in develop branch");
		//mvn test -Dbrowser=chrome writes in System.properties the browser name
		String browserName=System.getProperty("browser");
		String isHeadless=System.getProperty("headless");
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Development\\Corso_Selenium\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (isHeadless.equalsIgnoreCase("true")) options.addArguments("headless");
			
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\Development\\Corso_Selenium\\geckodriver.exe");
			FirefoxOptions ffoptions= new FirefoxOptions();
			if (isHeadless.equalsIgnoreCase("true")) ffoptions.addArguments("headless");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "D:\\Development\\Corso_Selenium\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		
		}
		//default timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenshot(String testName) throws IOException {
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss") ;
		String screenshotFileName="D:\\Projects\\Selenium\\Project\\src\\screenshots\\"+dateFormat.format(today)+testName+".png";
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File(screenshotFileName));
		
	}
	
	
}
