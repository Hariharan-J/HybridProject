package HybridPages;

import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridFindLead extends HybridProjectSpecificMethods {
	public static String leadId;
	public HybridFindLead(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public HybridFindLead typeSearchFirstName(String data) {
		//driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Babu");
		clearandtype("xpath", "(//input[@name='firstName'])[3]", data);
		return this;
	}
	
	public HybridFindLead clickFindLeadsButton() throws InterruptedException {
		//driver.findElementByXPath("//button[text()='Find Leads']").click();
		click("xpath", "//button[text()='Find Leads']");
		sleep();
		return this;
	}
	
	public HybridViewLead clickLeadOnGrid() {
		//driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))).click();
		click("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		return new HybridViewLead(driver);
	}
	
	public HybridMergeLeads selectFindLeadFromMerge() {
		//driver.findElementByXPath("//table[@class='x-grid3-row-table']//td/div/a").click();
		click("xpath", "//table[@class='x-grid3-row-table']//td/div/a");
		return new HybridMergeLeads(driver);
	}
	
	public HybridMergeLeads selectFindLeadToMerge() {
		//driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[2]//tr/td/div/a").click();
		click("xpath", "(//table[@class='x-grid3-row-table'])[2]//tr/td/div/a");
		return new HybridMergeLeads(driver);
	}
	
	public HybridFindLead getGridLeadID() {
		//driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		leadId = fetchText("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		return this;
	}
	
	public HybridFindLead typeSearchLeadID() {
		//driver.findElementByXPath("//input[@name='id']")
		clearandtype("xpath", "//input[@name='id']", leadId);
		return this;
	}
	
	public HybridFindLead verifyNoRecordsText() {
		//driver.findElementByXPath("//div[text()='No records to display']");
		fetchText("xpath", "//div[text()='No records to display']");
		return this;
	}
	
	
}
