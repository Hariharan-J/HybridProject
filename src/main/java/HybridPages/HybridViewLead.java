package HybridPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;


public class HybridViewLead extends HybridProjectSpecificMethods {
	public static String beforecompany;
	public HybridViewLead(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyCompanyName(String cndata) {
	/*	WebElement company = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
		String companyname = company.getText();
		if(companyname.contains(cndata))
			System.out.println("Updated company name is " +companyname);*/
		verifyEleText("xpath", "//span[@id='viewLead_companyName_sp']", cndata);
	}
	
	public HybridEditLead clickEditLeadButton() {
		//driver.findElementByXPath("//a[text()[contains(.,'Edit')]]").click();
		click("xpath", "//a[text()[contains(.,'Edit')]]");
		return new HybridEditLead(driver);
	}
	
	public HybridViewLead getBeforeCompanyNameText() {
		//driver.findElementByXPath("//span[@id='viewLead_companyName_sp").getText();
		beforecompany = regexPickText(fetchText("xpath", "//span[@id='viewLead_companyName_sp']"));
		return this;
	}
	
	public HybridDuplicateLead clickDuplicateLeadButton() {
		//driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		click("xpath", "//a[text()='Duplicate Lead']");
		return new HybridDuplicateLead(driver);
	}
	
	public HybridViewLead duplicateCompanyCompare() {
		stringCompare(fetchText("xpath", "//span[@id='viewLead_companyName_sp']"), beforecompany);
		return this;
	}
	
	public HybridViewLead getCompanyName() {
		fetchText("xpath", "//span[@id='viewLead_companyName_sp']");
		return this;
	}
	
	public HybridMyLeads clickDeleteButton() {
		//driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
		click("xpath", "//a[@class='subMenuButtonDangerous']");
		return new HybridMyLeads(driver);
	}

}
