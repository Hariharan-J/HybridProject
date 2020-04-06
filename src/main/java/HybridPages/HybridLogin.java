package HybridPages;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridLogin extends HybridProjectSpecificMethods {
	
	public HybridLogin(RemoteWebDriver driver) {
		this.driver = driver;
	}

	public HybridLogin typeUsername() {
		//driver.findElementById("username" ).sendKeys("demosalesmanager");
		clearandtype("id", "username", "demosalesmanager");
		return this;
	}
	
	public HybridLogin typePassword() {
		//driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		clearandtype("name", "PASSWORD", "crmsfa");
		return this;
	}
	
	public HybridHomePage clickLogin() {
		//driver.findElementByClassName("decorativeSubmit").click();
		click("classname", "decorativeSubmit");
		return new HybridHomePage(driver);
	}

}
