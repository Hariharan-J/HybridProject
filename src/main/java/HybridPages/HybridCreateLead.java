package HybridPages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridCreateLead extends HybridProjectSpecificMethods {
	
	public HybridCreateLead(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public HybridCreateLead typeCompanyName(String data) {
		//driver.findElementById("createLeadForm_companyName").sendKeys(data);
		clearandtype("id", "createLeadForm_companyName", data);
		return this;
	}
	
	public HybridCreateLead typeFirstName(String data) {
		//driver.findElementById("createLeadForm_firstName").sendKeys(data);
		clearandtype("id", "createLeadForm_firstName", data);
		return this;
	}
	
	public HybridCreateLead typeLastName(String data) {
		//driver.findElementById("createLeadForm_lastName").sendKeys(data);
		clearandtype("id", "createLeadForm_lastName", data);
		return this;
	}
	
	public HybridViewLead clickCreateLeadButton() {
		//driver.findElementByXPath("//input[@name='submitButton']").click();
		click("xpath", "//input[@name='submitButton']");
		return new HybridViewLead(driver);
	} 
	
	
	

}
