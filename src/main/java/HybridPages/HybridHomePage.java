package HybridPages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridHomePage extends HybridProjectSpecificMethods {
	
	public HybridHomePage(RemoteWebDriver driver) {
		this.driver = driver;		
	}
	
	public HybridMyHomePage clickCRMSFA() {
		//driver.findElementByLinkText("CRM/SFA").click();
		click("linktext", "CRM/SFA");
		return new HybridMyHomePage(driver);
	}

}
