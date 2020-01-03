package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Resources.Base;

public class Listeners implements ITestListener {
	public org.apache.logging.log4j.Logger log = LogManager.getLogger(Base.class);
	Base b = new Base();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
