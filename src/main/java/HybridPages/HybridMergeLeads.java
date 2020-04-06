package HybridPages;

import org.openqa.selenium.remote.RemoteWebDriver;

import hybridProjectBase.HybridProjectSpecificMethods;

public class HybridMergeLeads extends HybridProjectSpecificMethods{
	
	public HybridMergeLeads(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public HybridMergeLeads clickFromImage() {
		//driver.findElementByXPath("//table[@class='twoColumnForm']//td[2]/a/img").click();
		click("xpath", "//table[@class='twoColumnForm']//td[2]/a/img");
		return this;
	}
	
	public HybridFindLead switchToFindLeadsFromMerge() throws InterruptedException {
		switchToWindows(1);
		sleep();
		return new HybridFindLead(driver);
	}
	
	public HybridMergeLeads switchFromFindLeadsFromMerge() throws InterruptedException {
		switchToWindows(0);
		sleep();
		return this;
	}
	
	public HybridMergeLeads clickToImage() {
		//driver.findElementByXPath("//table[@class='twoColumnForm']//tr[2]/td[2]/a/img").click();
		click("xpath", "//table[@class='twoColumnForm']//tr[2]/td[2]/a/img");
		return this;
	}
	
	public HybridFindLead switchToFindLeadsToMerge() throws InterruptedException {
		switchToWindows(1);
		sleep();
		return new HybridFindLead(driver);
	}
	
	public HybridMergeLeads switchFromFindLeadsToMerge() throws InterruptedException {
		switchToWindows(0);
		sleep();
		return this;
	}
	
	public HybridMergeLeads clickMerge() {
		//driver.findElementByXPath("//a[text()='Merge']").click();
		click("xpath", "//a[text()='Merge']");
		return this;
	}
	
	public HybridViewLead alertOk() throws InterruptedException {
		alertAccept();
		sleep();
		return new HybridViewLead(driver);
	}

}
