package Hybridtestcases;

import org.testng.annotations.Test;

import HybridPages.HybridLogin;
import hybridProjectBase.HybridProjectSpecificMethods;

public class Hybrid_TC004_MergeLead extends HybridProjectSpecificMethods {
	
	@Test
	public void mergeLead_TestCase() throws InterruptedException {
		new HybridLogin(driver)
		.typeUsername()
		.typePassword()
		.clickLogin()
		.clickCRMSFA()
		.clickLeadsTab()
		.clickMergeLeadsOption()
		.clickFromImage()
		.switchToFindLeadsFromMerge()
		.selectFindLeadFromMerge()
		.switchFromFindLeadsFromMerge()
		.clickToImage()
		.switchToFindLeadsToMerge()
		.selectFindLeadToMerge()
		.switchFromFindLeadsToMerge()
		.clickMerge()
		.alertOk()
		.getCompanyName();
	}

}
