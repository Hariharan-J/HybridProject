package Hybridutils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SimpleReport {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static void main(String[] args) {
		reporter = new ExtentHtmlReporter("./reports/thirdreport.html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		test=reports.createTest("Ragavi test case", "Ragavi test case description");
		
		System.out.println("1 - Hari");
		test.pass("Passed test case");
		
		System.out.println("2 - Ragavi");
		test.fail("failed test case");
		
		System.out.println("3 - dheepthi");
		test.skip("skipped test case");
		
		reports.flush();
	}

}
