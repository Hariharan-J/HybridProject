package Hybridtestcases;

import org.testng.annotations.Test;

import HybridPages.HybridLogin;
import hybridProjectBase.HybridProjectSpecificMethods;

public class Hybrid_TC005_DeleteLead extends HybridProjectSpecificMethods {
	
	@Test(dataProvider="getdata")
	public void deleteLead_TestCase(String cn,String fn,String ln) throws InterruptedException {
		new HybridLogin(driver)
		.typeUsername()
		.typePassword()
		.clickLogin()
		.clickCRMSFA()
		.clickLeadsTab()
		.clickFindLeadsOption()
		.typeSearchFirstName(fn)
		.clickFindLeadsButton()
		.getGridLeadID()
		.clickLeadOnGrid()
		.clickDeleteButton()
		.clickFindLeadsOption()
		.typeSearchLeadID()
		.clickFindLeadsButton()
		.verifyNoRecordsText();		
	}

}
