package HybridPages;

import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridEditLead extends HybridProjectSpecificMethods{
	
	public HybridEditLead(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public HybridEditLead updateCompanyName(String cn) {
		//driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").sendKeys("Flexorbits");
		clearandtype("xpath", "//input[@id='updateLeadForm_companyName']", cn);
		return this;
	}
	
	public HybridViewLead clickUpdateButton() {
		//driver.findElementByXPath("//input[@name='submitButton']").click();
		click("xpath", "//input[@name='submitButton']");
		return new HybridViewLead(driver);
	}
	

}
