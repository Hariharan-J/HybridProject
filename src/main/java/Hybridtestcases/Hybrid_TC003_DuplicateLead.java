package Hybridtestcases;

import org.testng.annotations.Test;

import HybridPages.HybridLogin;
import hybridProjectBase.HybridProjectSpecificMethods;

public class Hybrid_TC003_DuplicateLead extends HybridProjectSpecificMethods {
	
	@Test (dataProvider="getdata")
	public void duplicateLead_TestCase(String cn,String fn,String ln) throws InterruptedException {
		new HybridLogin(driver)
		.typeUsername()
		.typePassword()
		.clickLogin()
		.clickCRMSFA()
		.clickLeadsTab()
		.clickFindLeadsOption()
		.typeSearchFirstName(fn)
		.clickFindLeadsButton()
		.clickLeadOnGrid()
		.getBeforeCompanyNameText()
		.clickDuplicateLeadButton()
		.getDuplicateLeadPageTitle()
		.clickCreateDuplicateLeadButton()
		.duplicateCompanyCompare();
	}
}
