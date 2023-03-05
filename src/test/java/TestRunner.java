
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import screenshot.Screenshot;

@CucumberOptions(features = "src/test/java/features", glue = {
		"stepDefinition" }, dryRun = false, monochrome = true, tags = "@test1 or @test2 or @test3 or @test4 or @test5 or @test6")

public class TestRunner extends AbstractTestNGCucumberTests {
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static AppiumDriverLocalService service;
	//public static Screenshot ss;
	//public static AppiumDriver<MobileElement> driver;

	@BeforeSuite
	public void setup() {
		extent = new ExtentReports("./reports/ExtentReport.html");
	}

	@BeforeMethod
	public void startTest(Method name) {
		String testname = name.getName();
		extentTest = extent.startTest(testname);
	}

	@AfterMethod
	public void testCaseResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, result.getThrowable());
			//String takess =  Screenshot.captureScreenshot(driver, "./ScreenShot/" + result.getName() + ".png");
			extentTest.log(LogStatus.FAIL, "Test Case Failed ");
		} else {
			if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test case passed ");
			}
		}

	}

	@AfterMethod
	public void endTest() {
		extent.endTest(extentTest);
	}

	@AfterSuite
	public void Teardown() {
		extent.flush();
		extent.close();
	}

}
