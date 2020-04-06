package HybridPages;

import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridDuplicateLead extends HybridProjectSpecificMethods {
	
	public String beforeComp;
	
	public HybridDuplicateLead(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public HybridDuplicateLead getDuplicateLeadPageTitle() {
		//driver.findElementByXPath("//div[@id='sectionHeaderTitle_leads']").getText();
		beforeComp = fetchText("xpath", "//div[@id='sectionHeaderTitle_leads']");
		return this;
	}
	
	public HybridViewLead clickCreateDuplicateLeadButton() {
		//driver.findElementByXPath("//input[@value='Create Lead']").click();
		click("xpath", "//input[@value='Create Lead']");
		return new HybridViewLead(driver);
	}

}
