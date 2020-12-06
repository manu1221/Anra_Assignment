package Assign;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportClass {

	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest() {

		report = new ExtentReports();
		test = report.startTest("ExtentDemo");
	}

	@Test
	public void extentReportsDemo() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/manu/Desktop/Eclipse/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		if (driver.getTitle().equals("Amazon")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
}