package Hybridutils;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public abstract class BasicReporter extends AbstractTestNGCucumberTests {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public String testcasename, testcasedescription, author, category;
	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/firstreport.html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	@BeforeClass
	public void startTest() {
		test = reports.createTest(testcasename, testcasedescription);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	MediaEntityModelProvider img;
	public abstract long takeSnap();
	public void reportStep(String description, String status, boolean snap) {
		if(snap && !status.equalsIgnoreCase("Info")) {
			long snapnumber = 100000L;
			snapnumber = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/screenshots/"+snapnumber+".jpg").build();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(status.equalsIgnoreCase("pass"))
			test.pass(description, img);
		else if(status.equalsIgnoreCase("fail"))
			test.fail(description, img);
	}
	
	public void reportStep(String description, String status) {
		reportStep(description, status, true);
	}
	@AfterSuite
	public void endReport() {
		reports.flush();
	}
	
	
}