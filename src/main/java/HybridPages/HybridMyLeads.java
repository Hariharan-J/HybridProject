package HybridPages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridMyLeads extends HybridProjectSpecificMethods{
	
	public HybridMyLeads(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public HybridCreateLead clickCreateLeadoption() {
		//driver.findElementByXPath("//a[text()='Create Lead']").click();
		click("xpath", "//a[text()='Create Lead']");
		return new HybridCreateLead(driver);
	}
	
	public HybridFindLead clickFindLeadsOption() {
		//driver.findElementByLinkText("Find Leads").click();
		click("linktext", "Find Leads");
		return new HybridFindLead(driver);
	}
	
	public HybridMergeLeads clickMergeLeadsOption( ) {
		//driver.findElementByXPath("//a[text()='Merge Leads']").click();
		click("xpath", "//a[text()='Merge Leads']");
		return new HybridMergeLeads(driver);
	}

}
