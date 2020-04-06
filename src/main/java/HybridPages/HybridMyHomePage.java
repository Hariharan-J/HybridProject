package HybridPages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridMyHomePage extends HybridProjectSpecificMethods{
	
	public HybridMyHomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public HybridMyLeads clickLeadsTab() {
		//driver.findElementByLinkText("Leads").click();
		click("linktext", "Leads");
		return new HybridMyLeads(driver);
	}

}
