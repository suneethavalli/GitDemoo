package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener{
	public WebDriver driver;
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getName()+" execution started");
		extentTestThread.set(extentTest);
	}

	public void onTestSuccess(ITestResult result) {
		//extentTest.log(Status.PASS,"Test Passed");
		extentTestThread.get().log(Status.PASS,"Test Passed");
		
	}
	public void onTestFailure(ITestResult result) {

		 driver = null;
		
		 //extentTest.fail(result.getThrowable());
		 extentTestThread.get().fail(result.getThrowable());
			
			String testMethodName = result.getName();
			
			try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				String screenshotFilepath = takeScreenshot(testMethodName,driver);
				extentTestThread.get().addScreenCaptureFromPath(screenshotFilepath,testMethodName);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
